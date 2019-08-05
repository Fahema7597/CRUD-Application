package application;


import java.sql.SQLException;

import controller.PersonController;

public class PersonApplication {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	PersonController refPersonController = new PersonController();
	refPersonController.userPersonController();	
	
}
}
