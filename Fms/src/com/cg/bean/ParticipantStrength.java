package com.cg.bean;

public class ParticipantStrength {
	int TrainingID;
	int participants;
	public int getTrainingID() {
		return TrainingID;
	}
	public void setTrainingID(int trainingID) {
		TrainingID = trainingID;
	}
	public int getParticipants() {
		return participants;
	}
	public void setParticipants(int participants) {
		this.participants = participants;
	}
	public ParticipantStrength(int trainingID, int participants) {
		super();
		TrainingID = trainingID;
		this.participants = participants;
	}
	@Override
	public String toString() {
		return "          " + TrainingID	+ "                " + participants + "";
	}
	

}
