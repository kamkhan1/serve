package com.cg.service;

import com.cg.bean.FeedbackMaster;
import com.cg.dao.DAOParticipant;
import com.cg.dao.IDAOParticipant;

public class ServiceParticipant implements IServiceParticipant {
 
	IDAOParticipant dao= new DAOParticipant();
	@Override
	public Boolean validate(int id) {
	
		return dao.validate(id);
	}
	@Override
	public int insertFeedback(FeedbackMaster fm) {
		
		return dao.insertFeedback(fm);
	}
	@Override
	public boolean rating(int overall) {

   if(overall>=1&&overall<=5)
	   return true;
		return false;
	}
	
	

}
