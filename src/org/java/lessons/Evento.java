package org.java.lessons;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	String titolo;
	String dataString;
	LocalDate data;
	int posti;
	int postiPrenotati;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	
	Evento(String titolo, String dataString, int posti) throws Exception {
		setTitolo(titolo);
		setData(dataString);
		setPosti(posti);
		setPostiPrenotati(0);
	}
	
	public void prenota() throws Exception {
		if (data.isBefore(LocalDate.now()) || posti == postiPrenotati)
			throw new Exception("Evento passato o posti esauri");
		postiPrenotati++;
		System.out.println("Posto prenotato");
			
	}
	
	public void disdici() throws Exception {
		if (data.isBefore(LocalDate.now()) || postiPrenotati == 0)
			throw new Exception("Evento passato o nessun posto prenotato");
		postiPrenotati--;
			
	}
	
	@Override
	public String toString() {
		return getData() + " - " + getTitolo();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getData() {
		return data.format(formatter);
	}

	public void setData(String dataString) throws Exception {
		LocalDate dataControllo = LocalDate.parse(dataString, formatter);
		if (dataControllo.isBefore(LocalDate.now()))
			throw new Exception("La data impostata è già passata");
		this.data = dataControllo;
	}

	public int getPosti() {
		return posti;
	}

	private void setPosti(int posti) throws Exception {
		if (posti < 0)
			throw new Exception("Deve esserci almeno un posto");
		this.posti = posti;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	private void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}
}
