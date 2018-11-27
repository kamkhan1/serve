package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.bean.EmployeeMaster;
import com.cg.bean.FacultySkill;
import com.cg.util.DBUtil;

public class DAO implements IDao {
	Connection conn;
	EmployeeMaster employee;
	FacultySkill fSkill;
	ArrayList<FacultySkill> list = new ArrayList<FacultySkill>();
	ArrayList<EmployeeMaster> eList = new ArrayList<EmployeeMaster>();
	Scanner kb = new Scanner(System.in);

	public DAO() {

		conn = DBUtil.getConnection();

	}

	@Override
	public String validate(int eid, String pass) {
		String query = "SELECT * FROM EMPLOYEE_MASTER WHERE Employee_ID =? AND Password=?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, eid);
			statement.setString(2, pass);
			ResultSet rSet = statement.executeQuery();
			if (rSet.next() == false) {
				return ("invalid Employee id or password \n try again");
			} else {
				if (rSet.getString(4).equalsIgnoreCase("admin")) {
					return "admin";
				} else if (rSet.getString(4).equalsIgnoreCase("coordinator")) {
					return "coordinator";
				} else // participant
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
	public Boolean validatePID(int pId) {

		String query = "select Employee_ID from Employee_master where Employee_ID=? and role= participant";
		ResultSet resultSet = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, pId);
			resultSet = stmt.executeQuery();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (resultSet == null) {
			return false;
		} else
			return true;
	}

	@Override
	public Boolean validateTID(int tId) {
		String query = "Select training_code from training_program where training_code=?";
		ResultSet resultSet = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, tId);
			resultSet = stmt.executeQuery();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (resultSet == null) {
			return false;
		} else
			return true;
	}

	public ArrayList<FacultySkill> showSkill() {
		String query = "select * from FACULTY_SKILL";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				int fId = res.getInt(1);
				String skill = res.getString(2);
				fSkill = new FacultySkill(fId, skill);
				list.add(fSkill);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Boolean validateFID(int fId) {

		String query = "select Employee_ID from Employee_master where Employee_ID=? and Role='Faculty'";
		ResultSet resultSet = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, fId);
			resultSet = stmt.executeQuery();

		
		if (resultSet.next() == false) {
			return false;
		} else
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}return null;
	}

	@Override
	public ArrayList<EmployeeMaster> showEmployees() {
		String query = "SELECT * FROM EMPLOYEE_MASTER";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);

			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				int eid = result.getInt(1);
				String name = result.getString(2);
				String pass = result.getString(3);
				String role = result.getString(4);
				employee = new EmployeeMaster(eid, name, pass, role);
				eList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eList;
	}

	@Override
	public Boolean validateCID(int cId) {
		String query = "select Course_ID from Course_master where Course_ID=?";
		ResultSet resultSet = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, cId);
			resultSet = stmt.executeQuery();
			if (resultSet.next() == false) {
				return false;
			} else
				return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	// @Override
	// public void show() {
	// String query = "select something2 from somewhere2";
	// try {
	// PreparedStatement statement= conn.prepareStatement(query);
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	//
	//
	//
	//
	// }

}