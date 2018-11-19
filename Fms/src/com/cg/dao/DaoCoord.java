package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.bean.TrainingProgram;
import com.cg.util.DBUtil;

public class DaoCoord implements IDaoCoord {
   Connection conn;
	public DaoCoord(){
		conn=DBUtil.getConnection();
	}
	
	ArrayList<TrainingProgram> al=new ArrayList<TrainingProgram>();
	@Override
	public ArrayList<TrainingProgram> trainingMaintenance() 
	{
	String query="select * from training_program";
	try
	{
		PreparedStatement statement=  conn.prepareStatement(query);
		ResultSet rset= statement.executeQuery();
		
		while(rset.next())
		{
			int trainingCode=rset.getInt(1);
			int courseCode=rset.getInt(2);
			int facultyCode=rset.getInt(3);
			String startdate=rset.getString(4);
			String endDate=rset.getString(5);
			TrainingProgram obj=new TrainingProgram(trainingCode,courseCode,facultyCode,startdate,endDate);
			al.add(obj);
			
		}
	}
	catch (SQLException e) {
		
		e.printStackTrace();
	}
	return al;
	}
	@Override
	public Boolean validate(int id) {
	String query="Select training_code from training_program where training_code=?";
	ResultSet resultSet=null;
	try {
		PreparedStatement stmt=conn.prepareStatement(query);
		stmt.setInt(1, id);
		resultSet=stmt.executeQuery();
	
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	if(resultSet==null)
	{
		return false;
	}
	else return true;
		
	}
	@Override
	public Boolean validateCID(int id) {
		String query="select course_ID from Course_master where Course_ID=?";
		ResultSet resultSet=null;
		try {
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setInt(1, id);
			resultSet=stmt.executeQuery();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	if(resultSet==null)
		{
			return false;
		}
		else return true;
	}

}
