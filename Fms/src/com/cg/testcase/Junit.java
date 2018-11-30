package com.cg.testcase;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.cg.bean.CourseMaster;
import com.cg.bean.EmployeeMaster;
import com.cg.bean.FacultySkill;
import com.cg.bean.TrainingProgram;
import com.cg.dao.DAO;
import com.cg.dao.DaoAdmin;
import com.cg.dao.DaoCoord;
import com.cg.myException.FMSException;

public class Junit {							//Search For InValid PArticipantId
	
	@Test
	public void testSearchForInvalidParticipantID() {
		
		DAO daoTest = new DAO();
		boolean PartId = daoTest.validatePID(53008);
		Assert.assertTrue(PartId);
	
	
	
	}
	
	@Test
	public void testForNOTemptyFacultySkills() throws FMSException {				//Faculty Skill Not Empty 
		DAO daoTest = new DAO();
		ArrayList<FacultySkill> Skill = daoTest.showSkill();
		Assert.assertNotNull(Skill);
	
	
	
	}


	@Test
	public void testSearchForInvalidCourseID() throws FMSException {				//Search For InValid CourseId			
		
		DAO daoTest = new DAO();
		boolean CourseId = daoTest.validateCID(1);
		Assert.assertTrue(CourseId);
	
	
	}
	
	
	@Test
	public void testSearchForInvalidFacultyID() throws FMSException {				//Search For InValid FacultyId
		
		DAO daoTest = new DAO();
		boolean FacultyId = daoTest.validateFID(53007);
		Assert.assertTrue(FacultyId);
	
	
	}
	
	
	@Test
	public void testForNOTemptyTrainingProgram() {					//Training Program Not Empty 
		
		DaoCoord daoTest = new DaoCoord();
		ArrayList<TrainingProgram> Tprogram = daoTest.trainingMaintenance();
		Assert.assertNotNull(Tprogram);
	
	
	
	}
	
	@Test
	public void testForNOTemptyCourse() {							//Course Program Not Empty 
		
		DaoAdmin daoTest = new DaoAdmin();
		ArrayList<CourseMaster> Course = daoTest.courseMaintenance();
		Assert.assertNotNull(Course);
	
	
	
	}
	
	 
	 @Test
		public void testForNOTemptyEmployee() throws FMSException {						//Employee Availability In Training Program
			
			DAO daoTest = new DAO();
			ArrayList<EmployeeMaster> Employee = daoTest.showEmployees();
			Assert.assertNotNull(Employee);
		
		
		
		}

	
	
	
	
	
	
}
