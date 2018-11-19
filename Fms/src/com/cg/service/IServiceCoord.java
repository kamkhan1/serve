package com.cg.service;

import java.util.ArrayList;

import com.cg.bean.TrainingProgram;

public interface IServiceCoord {

	ArrayList<TrainingProgram> trainingMaintenance();

	void paticipantEnrollment();

	void viewFeedback();
    Boolean validate(int id);

	Boolean validateCID(int id);
}
