package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	@Override
	public Boolean validateFID(int fId) {
		
		String query="select Employee_ID from Employee_master where Employee_ID=? and role=faculty";
		ResultSet resultSet=null;
		try {
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setInt(1, fId);
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
	public int updateProgram(TrainingProgram trainingProgram) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sdf1.parse(trainingProgram.getStartdate());
		java.sql.Date startDate = new java.sql.Date(date.getTime());
		java.util.Date date2 = sdf1.parse(trainingProgram.getEndDate());
		java.sql.Date endDate = new java.sql.Date(date2.getTime());
		
		
		
		String query="update Training_Program Set course_code=?, Faculty_code=?,Start_Date=?,End_Date=? where Training_code=?"; 
		try {
			PreparedStatement stmt= conn.prepareStatement(query);
			stmt.setInt(1,trainingProgram.getCourseCode());
			stmt.setInt(2,trainingProgram.getFacultyCode());
			stmt.setDate(3, startDate);
			stmt.setDate(4, endDate);
			stmt.setInt(5, trainingProgram.getTrainingCode());
			int result=stmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 1;
	}

}
