package com.cg.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.cg.bean.TrainingProgram;
import com.cg.service.IService;
import com.cg.service.IServiceAdmin;
import com.cg.service.IServiceCoord;
import com.cg.service.Service;
import com.cg.service.ServiceAdmin;
import com.cg.service.ServiceCoord;

public class Fmsmain {

	public static void main(String[] args) {
		Scanner kb= new Scanner(System.in);
		IService service=new Service();
		IServiceAdmin admin=new ServiceAdmin();
		IServiceCoord coord=new ServiceCoord();
		String role="";
		TrainingProgram trainingProgram=new TrainingProgram();
		do
		{
		
		System.out.println("Employee ID: ");
		int eid=kb.nextInt();
		System.out.println("passsword: ");
		String pass=kb.nextLine();
		Boolean b= service.isValid(eid, pass);
		if(b==true)
		{
			 role=service.validate(eid,pass);
			 break;
		}
		else
		{
			System.out.println(role);
		}
		}while(true);
		
		
		switch(role)
		{
		case "admin":
		{  
			do
			{
			System.out.println("1.	Faculty skill Maintenance");
			System.out.println("2.	Course Maintenance");
			System.out.println("3.	View Feedback Report");
			System.out.println("4.  exit");
			System.out.println("Enter your choice:");
			int choice=kb.nextInt();
			
			switch(choice){
			case 1:
			{
				admin.facultySkillMaintenance();
			    	
			}
			case 2:
			{
				admin.courseMaintenance();
			}
			case 3:
			{
				admin.viewReport();
			}
			case 4:
			{
				break;
			}
			}
		}while(true);
		}
		case "coordinator" :
		{  
			do
			{
			System.out.println("1.	Training program Maintenance");
			System.out.println("2.	Participant Enrollment");
			System.out.println("3.	View Feedback Report");
			System.out.println("4.  exit");
			System.out.println("enter your choice");
			int choice=kb.nextInt();
			ArrayList<TrainingProgram> al=new ArrayList<TrainingProgram>();
			
			switch(choice){
			case 1:
			{   int fId,id,cId;
			//Date date1,date2;
				al=coord.trainingMaintenance();
				
				for(TrainingProgram obj: al){
					System.out.println("obj");}    //displaying the training_program table to the coordinator..
				Boolean b=false;
				 
			    do{
			    	System.out.println("which one to modify?");
			    	id=kb.nextInt();
					b=coord.validate(id);
			    }while(b==false);
			    b=false;
			    do{
			    System.out.println("enter new course code:");
			    cId=kb.nextInt();
			    b=coord.validateCID(cId);
			    }while(b==false);
			    do
			    {
			    	System.out.println("enter new faculty code:");
			    	fId=kb.nextInt();
			    	b=coord.validateFID(fId);
			    }while(b==false);
			    
			    
			    
			    System.out.println("enter new start date:");
			    String date=kb.nextLine();
			 
//			    try {
//					date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
//				} catch (ParseException e) {
//					
//					e.printStackTrace();
//				}
			    System.out.println("enter new end date");
			    String date2=kb.nextLine();
//				try {
//					date2=new SimpleDateFormat("dd/MM/yyyy").parse(date);
//				} 
//				catch (ParseException e) {
//				
//					e.printStackTrace();
//				}
			    trainingProgram.setTrainingCode(id);
				trainingProgram.setCourseCode(cId);
				trainingProgram.setStartdate(date);
                trainingProgram.setEndDate(date2);
                trainingProgram.setFacultyCode(fId);
               int result= coord.updateProgram(trainingProgram);
			}
			
			case 2:
			{
				coord.paticipantEnrollment();
			}
			case 3:
			{
				coord.viewFeedback();
			}
			case 4:
			{
				break;
			}
			default :
			{
				System.out.println("please enter correct choice");
			}
			}
		}while(true);
		}
		}

	}

}
