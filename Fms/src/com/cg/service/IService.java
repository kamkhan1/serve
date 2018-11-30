package com.cg.service;

import java.util.ArrayList;

import com.cg.bean.EmployeeMaster;
import com.cg.bean.FacultySkill;
import com.cg.myException.FMSException;

public interface IService {
public Boolean isValid(int eid,String pass);
public Boolean checkInt(String num);
public Boolean validatePID(int pId);

public String validate(int eid, String pass);
void show();
public Boolean validateTID(int tId) throws FMSException;
public ArrayList<FacultySkill> showSkill() throws FMSException;
public Boolean validateFID(int fId) throws FMSException;
public ArrayList<EmployeeMaster> showEmployees() throws FMSException;
public Boolean validateCID(int cId) throws FMSException;
}
