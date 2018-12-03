package com.cg.service;

import java.util.ArrayList;

import com.cg.bean.FeedbackMaster;
import com.cg.bean.ParticipantEnrollment;
import com.cg.bean.ParticipantStrength;
import com.cg.bean.TrainingProgram;
import com.cg.myException.FMSException;

public interface IServiceCoord {

	ArrayList<TrainingProgram> trainingMaintenance();

	void paticipantEnrollment();

	ArrayList<FeedbackMaster> viewFeedback() throws FMSException;
    Boolean validate(int id);

	
	Boolean validateCID(int id);

	Boolean validateFID(int fId);

	int updateProgram(TrainingProgram trainingProgram, int days);

	Boolean addProgram(TrainingProgram trainingProgram, int days);

	int removeProgram(int id);

	int enrollParticipant(ParticipantEnrollment enroll);

	Boolean isValidDate(String date);

	ArrayList<ParticipantEnrollment> getAllParticipant() throws FMSException;

	int getDays(int cId);

	ArrayList<ParticipantStrength> getParticipantsCount();
}
