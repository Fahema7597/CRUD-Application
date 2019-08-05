package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.MyConnection;
import model.Person;


public class PersonDAOImpl implements PersonDAO {

	
	Connection con1;
	PreparedStatement st1;
	
	void getConnection()
	{
	try{
		con1 = MyConnection.prepareConnection();
	}
	catch(ClassNotFoundException | SQLException e)
	{
		System.out.println("Database connection query..");
	}
	}
	
	@Override
	public void addPerson(Person pRef) {
		// TODO Auto-generated method stub
		
		getConnection();
		
		 try
		 {
		 st1 = con1.prepareStatement( "Insert into person (UserID,userName,DateOfBirth,password) VALUES(?,?,?,?)");
		 
		
		 st1.setInt(1, pRef.getId());
		 st1.setString(2, pRef.getName());
		 st1.setString(3, pRef.getDob());
		 st1.setString(4, pRef.getPassword());
		 
		 st1.executeUpdate();
		 System.out.println("Record added successfully");
		 }
		 catch(SQLException e)
		 {
			 System.out.println("Exception caught .. not able to add record");
		 }
		 finally
		 {
			 try
			 {
				 con1.close();
			 }
			 catch(SQLException e)
			 {
				 System.out.println("Exception caught not able to close connection..");
			 }
		 }
	}
	@Override
	public void updatePerson(Person pRef) {
		// TODO Auto-generated method stub
		getConnection();
		
		try
		{
			st1 = con1.prepareStatement("UPDATE person SET userName = ?, Password = ? WHERE userID = ?");
			
			 st1.setString(1, pRef.getName());
			 st1.setString(2, pRef.getPassword());
			 st1.setInt(3, pRef.getId());
			
			 st1.executeUpdate();
			System.out.println("updated successfully");
		}
		catch(SQLException e)
		{
			System.out.println("Exception caught not able to update record..");
		}
		 finally
		 {
			 try
			 {
				 con1.close();
			 }
			 catch(SQLException e)
			 {
				 System.out.println("Exception caught not able to close connection..");
			 }
		 }
	}

	@Override
	public List<Person> ListPerson() 
	{
		// TODO Auto-generated method stub
		getConnection();
		try
		{
		st1 = con1.prepareStatement("SELECT* from person");
	    st1.executeQuery();
	    
	    ResultSet rs =  st1.executeQuery();;
	    
	    List<Person> personRecords = new ArrayList<Person>();
	    {
	    	while(rs.next())
	    	{
	    Person refPerson = new Person();
	    
	    refPerson.setId(rs.getInt("UserID"));
	    refPerson.setName(rs.getString("userName"));
	    refPerson.setPassword(rs.getString("password"));
	    refPerson.setDob(rs.getString("dateOfBirth"));
	    
	    personRecords.add(refPerson);
	    
	    System.out.println("UserID: " + refPerson.getId());
	    System.out.println("UserName: " + refPerson.getName());
	    System.out.println("password: " + refPerson.getPassword());
	    System.out.println("DateOfBirth: " + refPerson.getDob());
	    
	    System.out.println();
	    
//	    System.out.println("UserID: " + rs.getInt("userID"));
//	    System.out.println("UserName: " + rs.getString("userName"));
//	    System.out.println("password: " + rs.getString("password"));
//	    System.out.println("DateOfBirth: " + rs.getString("dateOfBirth"));
	    
	    
	    	}    
	        
	   System.out.println("Records displayed successfully");
	   return personRecords;
	    }
		
		
		}
		catch(SQLException e)
		{
			System.out.println("Exception caught not able to display records..");
		}
		 finally
		 {
			 try
			 {
				 con1.close();
			 }
			 catch(SQLException e)
			 {
				 System.out.println("Exception caught not able to close connection..");
			 }
		 }
		return null;
		
	}
	@Override
	public void getPersonById(int id) {
		// TODO Auto-generated method stub
		getConnection();
		try
		{
			st1 = con1.prepareStatement("SELECT* from person WHERE userID = ?");
			
			st1.setInt(1, id);
			
			ResultSet rs = st1.executeQuery();
			
			rs.next();
			    System.out.println("UserID: " + rs.getInt("userID"));
			    System.out.println("UserName: " + rs.getString("userName"));
			    System.out.println("password: " + rs.getString("password"));
			    System.out.println("DateOfBirth: " + rs.getString("dateOfBirth"));
		}
		catch(SQLException e)
		{
			System.out.println("Exception caught not able to get record by ID..");
		}
		 finally
		 {
			 try
			 {
				 con1.close();
			 }
			 catch(SQLException e)
			 {
				 System.out.println("Exception caught not able to close connection..");
			 }
		 }
	}

	@Override
	public void removePerson(int id) 
	{
		// TODO Auto-generated method stub
		getConnection();
		try
		{
			st1 = con1.prepareStatement("DELETE from person WHERE userID = ?");
			st1.setInt(1, id);
	
		    st1.executeUpdate();
		    
		    System.out.println("Record removed Successfully");
		    
		    System.out.println();
			
		}
		catch(SQLException e)
		{
			System.out.println("Exception caught not able to remove record by ID..");
		}
		 finally
		 {
			 try
			 {
				 con1.close();
			 }
			 catch(SQLException e)
			 {
				 System.out.println("Exception caught not able to close connection..");
			 }
		 }

	}
}
