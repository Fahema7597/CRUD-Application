package service;

import model.Person;

public interface PersonService {

	void calladd(Person pRef);
	void callUpdate(Person pRef);
	void callDisplayPerson();
	void callPersonRecordByID(int id);
	void callRemovePerson(int id);
	
}
