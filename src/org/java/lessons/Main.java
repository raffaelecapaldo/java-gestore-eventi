package org.java.lessons;

public class Main {

	public static void main(String[] args) {
		Evento event = null;
		try {
			event = new Evento("prova", "10/03/2024", 50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println(event);
		
	}
}
