package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.util.DBUtil;





public class DAO implements IDao{
	Connection conn;
	Scanner kb=new Scanner(System.in);

	public DAO(){

		conn =DBUtil.getConnection();
		
	}

	@Override
	public String validate(int eid, String pass) {
		String query = "SELECT * FROM EMPLOYEE_MASTER WHERE Employee_ID =? AND Password=?";
		try {
			PreparedStatement statement=  conn.prepareStatement(query);
			statement.setInt(1, eid);
			statement.setString(2,pass);
			ResultSet rSet = statement.executeQuery();
			if(rSet==null){
				
				return ("invalid Employee id or password \n try again");
			}
			else{
				if(rSet.getString(4).equalsIgnoreCase("admin"))
				{
					return "admin";
				}
				else if(rSet.getString(4).equalsIgnoreCase("coordinator")){
					return "coordinator";
				}
				else  //participant
				{
					return "participant";
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
@Override
public Boolean validatePID(int pId)
{
	
	String query="select Employee_ID from Employee_master where Employee_ID=? and role= participant";
	ResultSet resultSet=null;
	try {
		PreparedStatement stmt=conn.prepareStatement(query);
		stmt.setInt(1, pId);
		resultSet=stmt.executeQuery();
	
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	if(resultSet==null)
	{
		return false;
	}
	else return true;}


//	@Override
//	public void show() {
//		  String query = "select something2 from somewhere2";
//		  try {
//			PreparedStatement statement=  conn.prepareStatement(query);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		  
//		  
//		
//	
//		
//	}
		
}