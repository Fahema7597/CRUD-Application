package controller;


import java.util.Scanner;

import model.Person;
import service.PersonService;
import service.PersonServiceImpl;

public class PersonController {


	Scanner sc = new Scanner(System.in);
	Person refPerson = new Person();
	PersonService refPersonService = new PersonServiceImpl();
	
	public void userPersonController()
	{
		 addUser();
		 
//		userUpdate();
//		removeRecordByID();
//		displayPersonRecords();
//		getRecordByID();
//	    removeRecordByID();
	}
	
	void addUser() 
	{
		System.out.println("Enter userID: ");
		int id = sc.nextInt();
		refPerson.setId(id);
		
	    System.out.println("Enter userName: ");
		String name = sc.next();
		refPerson.setName(name);
		
		System.out.println("Enter password: ");
		String password = sc.next();
		refPerson.setPassword(password);
		
		System.out.println("Enter Date Of Birth: ");
		String dob = sc.next();
		refPerson.setDob(dob);
		
		refPersonService.calladd(refPerson);
		
	}
	
	void userUpdate()
	{
		System.out.println("Enter userID to change: ");
		int id = sc.nextInt();
		refPerson.setId(id);
		

		System.out.println("Change name value to update: ");
		String name = sc.next();
		refPerson.setName(name);
		
		System.out.println("Change password value to update: ");
		String password = sc.next();
		refPerson.setPassword(password);;
		
		refPersonService.callUpdate(refPerson);
	}
	void displayPersonRecords()
	{
		refPersonService.callDisplayPerson();
	}
	void getRecordByID()
	{
		System.out.println("Enter ID to get the record of person: ");
		int id = sc.nextInt();
		refPerson.setId(id);
		
		refPersonService.callPersonRecordByID(id);
	}
	void  removeRecordByID() 
	{

		System.out.println("Enter ID to remove the record of person: ");
		int id = sc.nextInt();
		refPerson.setId(id);
		
		refPersonService.callRemovePerson(id);
	}
	
	
	
	
}
