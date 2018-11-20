package com.cg.dao;

import java.util.ArrayList;

import com.cg.bean.TrainingProgram;

public interface IDaoCoord {

	ArrayList<TrainingProgram> trainingMaintenance();

	Boolean validate(int id);

	Boolean validateCID(int id);

	Boolean validateFID(int fId);

	int updateProgram(TrainingProgram trainingProgram);

}
