package com.cg.ui;

import java.util.Scanner;

import com.cg.service.IService;
import com.cg.service.Service;

public class Fmsmain {

	public static void main(String[] args) {
		Scanner kb= new Scanner(System.in);
		IService service=new Service();
		String role="";
		do{
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
			System.out.println("1.	Faculty skill Maintenance");
			System.out.println("2.	Course Maintenance");
			System.out.println("3.	View Feedback Report");
			System.out.println("Enter your choice:");
			int choice=kb.nextInt();
			switch(choice){
			case 1:
			{
				service.show();
			}
			}
		}
		}

	}

}
