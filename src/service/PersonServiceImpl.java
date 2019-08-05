package service;

import dao.PersonDAO;
import dao.PersonDAOImpl;
import model.Person;


public class PersonServiceImpl implements PersonService {


	PersonDAO refPersonDAO;
	
	
	@Override
	public void calladd(Person pRef){  //call or invoke
		// TODO Auto-generated method stub
		
		refPersonDAO = new PersonDAOImpl();
			refPersonDAO.addPerson(pRef);
		}


	@Override
	public void callUpdate(Person pRef) {
		// TODO Auto-generated method stub
		refPersonDAO = new PersonDAOImpl();
		refPersonDAO.updatePerson(pRef);
	}


	@Override
	public void callDisplayPerson()  {
		// TODO Auto-generated method stub
		refPersonDAO = new PersonDAOImpl();
		refPersonDAO.ListPerson();
	}


	@Override
	public void callPersonRecordByID(int id) {
		// TODO Auto-generated method stub
		refPersonDAO = new PersonDAOImpl();
		refPersonDAO.getPersonById(id);
		
		
	}


	@Override
	public void callRemovePerson(int id) {
		// TODO Auto-generated method stub
		refPersonDAO = new PersonDAOImpl();
		refPersonDAO.removePerson(id);;
	}
	}


