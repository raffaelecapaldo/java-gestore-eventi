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
			System.out.print("Inserire data evento: (dd/mm/yyyy)");
			String dataEvento = sc.nextLine();
			System.out.println("Quanti posti saranno disponibili?");
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
				System.out.println("Quanti posto vuoi prenotare?");
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
			System.out.print("Vuoi disdire dei posti?");
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
		
		System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
		System.out.println("Posti disponibili: " + (evento.getPosti()-evento.getPostiPrenotati()));

		
	}
}
