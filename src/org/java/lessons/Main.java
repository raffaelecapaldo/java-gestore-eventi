package org.java.lessons;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Evento evento = null;
		boolean error = false;
	
		do {
		try {
			error = false;
			System.out.print("Inserire nome evento: ");
			String titoloEvento = sc.nextLine();
			System.out.print("Inserire data evento (dd/mm/yyyy): ");
			String dataEvento = sc.nextLine();
			System.out.print("Quanti posti saranno disponibili? ");
			int numPosti = Integer.valueOf(sc.nextLine());
			evento = new Evento(titoloEvento, dataEvento, numPosti);
		 
		} catch (Exception e) {
			System.err.println("Errore: " + e.getMessage());
			error = true;
		}} while (error);
		
		String rispostaPrenotazione;
		boolean errorPrenotazione = false;
		do {
		do {
			errorPrenotazione = false;
			System.out.print("\nVuoi già prenotare dei posti?");
			rispostaPrenotazione = sc.nextLine().toLowerCase();
			error = !rispostaPrenotazione.equals("s") && !rispostaPrenotazione.equals("n");
			if (error) System.out.println("INSERIRE SOLO S O N");
			} while (error);
			
			if (rispostaPrenotazione.equals("s")) {
				System.out.print("Quanti posto vuoi prenotare? ");
				try {
					evento.prenota(Integer.valueOf(sc.nextLine()));
				}  catch (Exception e) {
					System.err.println("Errore : " + e.getMessage());
					errorPrenotazione = true;
				}
			}} while (errorPrenotazione);
		
		System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
		System.out.println("Posti disponibili: " + (evento.getPosti()-evento.getPostiPrenotati()));
		
		String rispostaDisdette;
		boolean erroreDisdette = false;
		do {
		do {
			erroreDisdette = false;
			System.out.print("\nVuoi disdire dei posti? ");
			rispostaDisdette = sc.nextLine().toLowerCase();
			error = !rispostaDisdette.equals("s") && !rispostaDisdette.equals("n");
			if (error) System.out.println("INSERIRE SOLO S O N");
			} while (error);
			
		if (rispostaDisdette.equals("s")) {
			System.out.print("Quanti posti vuoi disdire? ");
			try {
				evento.disdici(Integer.valueOf(sc.nextLine()));
			}  catch (Exception e) {
				System.err.print("Errore:" + e.getMessage());
				erroreDisdette = true;
			}
		}} while (erroreDisdette);
		
		sc.close();
		
		System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
		System.out.println("Posti disponibili: " + (evento.getPosti()-evento.getPostiPrenotati()));
//
//		
		
		// TEST MILESTONE 3
//		try {
//			Concerto concerto = new Concerto("Il concertone", "24/03/2025", 33, "09:00", 12.53);
//			System.out.println(concerto);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//TEST BONUS
//		try {
//			Evento ev1 = new Evento("titolone", "14/03/2025", 20);
//			Evento ev2 = new Evento("titoloneee", "14/03/2025", 20);
//			Evento ev3 = new Evento("titoloneea", "11/03/2025", 20);
//			Evento ev4 = new Evento("titoloneea", "05/03/2025", 10);
//
//			
//			ProgrammEventi prog = new ProgrammEventi("programmone");
//			
//			prog.aggiungiEvento(ev1);
//			prog.aggiungiEvento(ev2);
//			prog.aggiungiEvento(ev3);
//			prog.aggiungiEvento(ev4);
//
//			
//			
//			System.out.println(prog.numEventi());
//			System.out.println(prog);
//			
//			prog.cercaPerData("14/03/2025");
//			prog.cercaPerData("15/03/2025");
//
//
//
//			
//
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
}
