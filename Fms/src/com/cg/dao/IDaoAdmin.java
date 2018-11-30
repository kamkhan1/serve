package com.cg.dao;

import java.util.ArrayList;

import com.cg.bean.CourseMaster;
import com.cg.bean.FacultySkill;

public interface IDaoAdmin {

	/**
	 * @param id
	 * @return id
	 * validates admin
	 */
	Boolean validate(int id);

	/**
	 * @param facultySkill
	 * @return
	 * add faculty skills.
	 */
	int addFacultySkill(FacultySkill facultySkill);

	/**
	 * @return
	 * show course details
	 */
	ArrayList<CourseMaster> courseMaintenance();

	/**
	 * @param course
	 * @return
	 * allows to update course s
	 */
	int updateCourse(CourseMaster course);

	

}
