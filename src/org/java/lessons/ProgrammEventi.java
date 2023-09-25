package org.java.lessons;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {

	private String titolo;
	private List<Evento> eventi;
	
	ProgrammEventi(String titolo) {
		setTitolo(titolo);
		eventi = new ArrayList<>();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public void aggiungiEvento(Evento evento) {
		eventi.add(evento);
		System.out.println("Evento aggiunto");
	}
	
	public void cercaPerData(String dataString) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataCercata = LocalDate.parse(dataString, formatter);
		int trovate = 0;

		for (Evento evento: eventi) {
			if (evento.getRealDate().isEqual(dataCercata)) {
				System.out.println(evento);
				trovate++;
			}
			
			
		}
		
		if (trovate == 0) {
			System.out.println("Nessun evento per questa data");
		}

		
	}
	
	public int numEventi() {
		return eventi.size();
	}
	
	public void resetProgramma() {
		eventi.clear();
		System.out.println("Tutti gli eventi sono stati cancellati");
	}
	
	@Override 
	public String toString() {
		List<Evento> eventiOrdinata = new ArrayList<Evento>(eventi);
		eventiOrdinata.sort((d1,d2) -> d1.getRealDate().compareTo(d2.getRealDate()));
		String stampa = getTitolo() + "\n";
		for (Evento evento: eventiOrdinata) {
			stampa += "- " + evento.getData() + " - " + evento.getTitolo() + "\n";
		}
		
		return stampa;

		
	}
	
	public BigDecimal mediaPrezzoConcerto() {
		BigDecimal sum = BigDecimal.ZERO;
		BigDecimal counter = BigDecimal.ZERO;
		
		for (Evento evento: eventi) {
			if (evento instanceof Concerto) {
			sum = sum.add(((Concerto) evento).getPrezzo());
			counter = counter.add(new BigDecimal(1));
			}}
		
		return sum.divide(counter, 2, RoundingMode.HALF_UP);

	}
	
	public BigDecimal mediaPrezzoSpettacolo() {
		BigDecimal sum = BigDecimal.ZERO;
		BigDecimal counter = BigDecimal.ZERO;
		
		for (Evento evento: eventi) {
			if (evento instanceof Spettacolo) {
			sum = sum.add(((Spettacolo) evento).getPrezzo());
			counter = counter.add(new BigDecimal(1));
			}}
		
		return sum.divide(counter, 2, RoundingMode.HALF_UP);

	}
	
	public BigDecimal mediaPrezzoEvento() {
		BigDecimal sum = BigDecimal.ZERO;
		BigDecimal counter = BigDecimal.ZERO;
		
		for (Evento evento: eventi) {
			if (evento instanceof IPrice) {
			sum = sum.add(((IPrice) evento).getPrezzo());
			counter = counter.add(new BigDecimal(1));
			}}
				
		return sum.divide(counter, 2, RoundingMode.HALF_UP);
	}

}


