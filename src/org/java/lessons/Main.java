package org.java.lessons;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("TEST BONUS 4");
		try {
			
			
		
			ProgrammEventi prog = new ProgrammEventi("Programmazione eventi inverno 2025");
			
			Spettacolo sp1 = new Spettacolo("Matrix", "28/03/2025", 20, 10.00);
			Spettacolo sp2 = new Spettacolo("La vita è bella", "26/03/2025", 20, 11.90);
			Spettacolo sp3 = new Spettacolo("Harry Potter", "25/03/2025", 20, 13.50);
			Concerto c1 = new Concerto("Ligabue", "28/03/2025", 30, "09:00", 35.50);
			Concerto c2 = new Concerto("Caparezza", "26/03/2025", 30, "11:00", 15.20);
			Concerto c3 = new Concerto("Kraftwerk", "25/03/2025", 30, "12:00", 17.00);
			
			prog.aggiungiEvento(sp1);
			prog.aggiungiEvento(sp2);
			prog.aggiungiEvento(sp3);
			prog.aggiungiEvento(c1);
			prog.aggiungiEvento(c2);
			prog.aggiungiEvento(c3);

			
			System.out.print("\nNUMERO EVENTI: ");
			System.out.println(prog.numEventi());
			System.out.println("\nPROGRAMMA INTERO");
			System.out.println(prog);
			
			System.out.println("RICERCA 1");
			prog.cercaPerData("26/03/2025");
			System.out.println("RICERCA 2");
			prog.cercaPerData("15/03/2023");
			System.out.println();
			
			System.out.println("\n MEDIE PREZZI");
			System.out.println("Media prezzo di tutti gli eventi: " + prog.mediaPrezzoEvento());
			System.out.println("Media prezzo dei concerti: " + prog.mediaPrezzoConcerto());
			System.out.println("Media prezzo degli spettacoli: " + prog.mediaPrezzoSpettacolo());
			
			System.out.println("\nPROGRAMMA INTERO");
			System.out.println(prog);
			
			


			
			System.out.println("GESTIONALE CREAZIONE EVENTO - START");



			


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//INIZIO PROGRAMMA ORIGINALE
		
		
		
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
			System.out.print("\nVuoi già prenotare dei posti? [S/N]");
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
			System.out.print("\nVuoi disdire dei posti? [S/N] ");
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
		
		
		
		
	}
}
