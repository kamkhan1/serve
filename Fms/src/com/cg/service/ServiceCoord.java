package com.cg.service;

import java.util.ArrayList;

import com.cg.bean.TrainingProgram;
import com.cg.dao.DaoCoord;
import com.cg.dao.IDaoCoord;

public class ServiceCoord implements IServiceCoord{
	IDaoCoord dao=new DaoCoord();
    
	@Override
	public ArrayList<TrainingProgram> trainingMaintenance() {
		
		return dao.trainingMaintenance();
	}

	@Override
	public void paticipantEnrollment() {
		
		
	}

	@Override
	public void viewFeedback() {
		
		
		
	}

}
