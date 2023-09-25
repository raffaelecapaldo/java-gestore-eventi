package org.java.lessons;

public class Main {

	public static void main(String[] args) {
		try {
			Evento event = new Evento("prova", "10/03/2021", 50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
}
