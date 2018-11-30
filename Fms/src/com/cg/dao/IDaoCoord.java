package com.cg.dao;

import java.util.ArrayList;

import com.cg.bean.FeedbackMaster;
import com.cg.bean.ParticipantEnrollment;
import com.cg.bean.TrainingProgram;
import com.cg.myException.FMSException;

public interface IDaoCoord {

	/**
	 * @return arraylist
	 * shows active training program
	 */
	ArrayList<TrainingProgram> trainingMaintenance();

	/**
	 * @param id
	 * @return boolean(true/false)
	 * validates  datatype as int of id 
	 */
	Boolean validate(int id);

	/**
	 * @param id
	 * @return boolean(true/false)
	 * validates coordinator_id
	 */
	Boolean validateCID(int id);

	/**
	 * @param fId
	 * @return boolean(true/false)
	 * validates faculty_id
	 */
	Boolean validateFID(int fId);

	/**
	 * @param trainingProgram
	 * @return
	 * updates a progam in training.
	 */
	int updateProgram(TrainingProgram trainingProgram);

	/**
	 * @param trainingProgram
	 * @return
	 */
	Boolean addProgram(TrainingProgram trainingProgram);

	/**
	 * @param id
	 * @return
	 */
	int removeProgram(int id);

	/**
	 * @param enroll
	 * @return
	 */
	int enrollParticipant(ParticipantEnrollment enroll);

	/**
	 * @return
	 * @throws FMSException 
	 */
	ArrayList<FeedbackMaster> viewFeedback() throws FMSException;

	ArrayList<ParticipantEnrollment> getAllParticipant() throws FMSException;

}
