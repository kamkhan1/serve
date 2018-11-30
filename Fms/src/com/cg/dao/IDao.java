package com.cg.dao;

import java.util.ArrayList;

import com.cg.bean.EmployeeMaster;
import com.cg.bean.FacultySkill;
import com.cg.myException.FMSException;

public interface IDao {
	/**
	 * @param eid
	 * @param pass
	 * validates the result is not null 
	 *  validates the employee_id and password
	 *  and shows welcome message.
	 */ 
	public String validate(int eid,String pass);
	/**
	 * @param pId
	 * @return 
	 * validates participant_id and password
	 * 
	 */
	public Boolean validatePID(int pId);
	/**
	 * @param tId
	 * @return
	 * @throws FMSException
	 * validates training_code
	 */
	
	public Boolean validateTID(int tId) throws FMSException;
	/**
	 * @return arraylist
	 * @throws FMSException
	 * shows faculty skills.
	 */ 
	public ArrayList<FacultySkill> showSkill() throws FMSException;
	/**
	 * @param fId
	 * @return
	 * @throws FMSException
	 * validates faculty_id
	 */
	public Boolean validateFID(int fId) throws FMSException;
	/**
	 * @return arraylist
	 * @throws FMSException
	 * show employee details.
	 */
	public ArrayList<EmployeeMaster> showEmployees() throws FMSException;
	/**
	 * @param cId
	 * @return
	 * @throws FMSException
	 * validate course_code
	 */
	public Boolean validateCID(int cId) throws FMSException;


	
    
}
