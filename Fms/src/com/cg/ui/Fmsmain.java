package com.cg.ui;



import java.util.ArrayList;

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
	   kb.nextLine();
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
		{  	int result,fId,id,cId;
		Boolean b=false;
		   Boolean insert;
		char again;
			do
			{
			System.out.println("1.	Training program Maintenance");
			System.out.println("2.	Participant Enrollment");
			System.out.println("3.	View Feedback Report");
			System.out.println("4.  exit");
			System.out.println("enter your choice");
			int choice=kb.nextInt();
			ArrayList<TrainingProgram> al=new ArrayList<TrainingProgram>();
			int maintain_choice;
			switch(choice){
			case 1:
			{   
                 al=coord.trainingMaintenance(); // getting training Program table from database
				
				for(TrainingProgram obj: al){
					System.out.println("obj");}    //displaying the training_program table to the coordinator..
				System.out.println("what do you want?");
				System.out.println("1. modify a program");
				System.out.println("2. Add a new program");
				System.out.println("3. Remove a program");
				System.out.println("4. exit");
				maintain_choice=kb.nextInt();
				switch(maintain_choice)
				{
				case 1:
				{
				
			//Date date1,date2;
				
			
			
				do{ 
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
                result= coord.updateProgram(trainingProgram);
               if(result>0)
               {
            	   System.out.println(result +" record successfully updated");
            	   
               }
               else 
               System.out.println("record not updated"); 
               System.out.println("do you want continue updation:");
               again= kb.next().trim().charAt(0);
				}while((result>0&&(again=='y'||again=='Y'))||(result<0&&(again=='y'||again=='Y')));
				
			    }
				case 2:
				{       do{
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
					    System.out.println("enter new end date");
					    String date2=kb.nextLine();
						trainingProgram.setCourseCode(cId);
						trainingProgram.setStartdate(date);
		                trainingProgram.setEndDate(date2);
		                trainingProgram.setFacultyCode(fId);
		                insert=coord.addProgram(trainingProgram);
		                if(insert==true)
		                {System.out.println("new program added");}
		                else
		                {System.out.println("not added");}
		                System.out.println("do you want continue adding program:");
		                again= kb.next().trim().charAt(0);
				}while((insert==true&&(again=='y'||again=='Y'))||(insert==false&&(again=='y'||again=='Y')));
				}
				case 3:
				{
					do{
					 do{
						 System.out.println("enter a training Program to remove");
					    	id=kb.nextInt();
							b=coord.validate(id);
							if(b==false)
								System.out.println("There is no program whith the training ID "+ id +" please enter correct ID:");
					    }while(b==false);
					result= coord.removeProgram(id);
					if(result>0)
					{System.out.println(result + "program deleted..");}
					else
					{System.out.println("deletion failed!!");}
					  System.out.println("do you want delete again:");
		                again= kb.next().trim().charAt(0);
					}while((result>0&&(again=='y'||again=='Y'))||(result<0&&(again=='y'||again=='Y')));
				}
				case 4:{
					break;
				}
				default:
				{System.out.println("enter correct choice.");}
				}
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
