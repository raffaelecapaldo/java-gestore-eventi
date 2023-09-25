package org.java.lessons;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	private LocalTime ora;
	private BigDecimal prezzo;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	
	Concerto(String titolo, String dataString, int posti, String oraString, double prezzo) throws Exception {
		super(titolo, dataString, posti);
		setOra(oraString);
		setPrezzo(prezzo);
		
	}

	public String getOra() {
		return ora.format(formatter);
	}

	public void setOra(String oraString) {
		this.ora = LocalTime.parse(oraString, formatter);
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = BigDecimal.valueOf(prezzo);
	}
	
	public String getFullData() {
		return super.getData() + " alle: " + getOra();
	}
	
	public String getPrezzoFormattato() {
        DecimalFormat priceFormatter = new DecimalFormat("#,##0.00€");
		return priceFormatter.format(getPrezzo());
		
	}
	
	@Override
	public String toString() {
		return getFullData() + " - " + super.getTitolo() + " - " + getPrezzoFormattato();
	}
}
