package controller;


import model.model;

import java.sql.SQLException;

import View.View_Accueil;


public class MainMVC {
	private static model m;
	
	
	
	
	public static model getM() {
		return m;
	}
	
	
	
	
	public static void main (String[]args) throws  SQLException, ClassNotFoundException  {
		
		
		System.out.println("Main MVC");	
		m = new model();
		View_Accueil vA = new View_Accueil();
		
	}
	
}