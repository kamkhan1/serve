package com.cg.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cg.bean.FeedbackMaster;
import com.cg.bean.ParticipantEnrollment;
import com.cg.bean.ParticipantStrength;
import com.cg.bean.TrainingProgram;
import com.cg.dao.DaoCoord;
import com.cg.dao.IDaoCoord;
import com.cg.myException.FMSException;

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
	public ArrayList<FeedbackMaster> viewFeedback() throws FMSException {
		
	return dao.viewFeedback();
		
	}

	@Override
	public Boolean validate(int id) {
	
		return dao.validate(id);
	}

	@Override
	public Boolean validateCID(int id) {
		
		return dao.validateCID(id);
	}

	@Override
	public Boolean validateFID(int fId) {
		
		return dao.validateFID(fId);
	}

	@Override
	public int updateProgram(TrainingProgram trainingProgram,int days) {
		
		return dao.updateProgram(trainingProgram,days);
	}

	@Override
	public Boolean addProgram(TrainingProgram trainingProgram,int days) {
		return dao.addProgram(trainingProgram,days);
		
	}

	@Override
	public int removeProgram(int id) {
		
		return dao.removeProgram(id);
	}

	@Override
	public int enrollParticipant(ParticipantEnrollment enroll) {
		
		return dao.enrollParticipant(enroll);
	}
	  @Override
	  public  Boolean isValidDate(String inDate) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        try {
	            dateFormat.parse(inDate.trim());
	        } catch (ParseException pe) {
	            return false;
	        }
	        return true;
	    }

	@Override
	public ArrayList<ParticipantEnrollment> getAllParticipant() throws FMSException {
		// TODO Auto-generated method stub
		return dao.getAllParticipant();
	}

	@Override
	public int getDays(int cId) {
		// TODO Auto-generated method stub
		return dao.getDays(cId);
	}

	@Override
	public ArrayList<ParticipantStrength> getParticipantsCount() {
		
		return dao.getParticipantsCount();
	}

}
