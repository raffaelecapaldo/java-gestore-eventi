package org.java.lessons;

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
		
		for (Evento evento: eventi) {
			int trovate = 0;
			if (evento.getRealDate().isEqual(dataCercata)) {
				System.out.println(evento);
				trovate++;
			}
			
			if (trovate == 0) {
				System.out.println("Nessun evento per questa data");
			}
		}

		
	}
	
	public int numEventi() {
		return eventi.size();
	}
	
	public void resetProgramma() {
		eventi.clear();
		System.out.println("Tutti gli eventi sono stati cancellati");
	}
}


