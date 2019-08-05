package dao;

import java.util.List;

import model.Person;



public interface PersonDAO {


	public void addPerson(Person pRef);
	public void updatePerson(Person pRef);
	public List<Person> ListPerson();
	public void getPersonById(int id);
	public void removePerson(int id);
	
	
	
}
