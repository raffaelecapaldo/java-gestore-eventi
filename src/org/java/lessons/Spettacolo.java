package org.java.lessons;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Spettacolo extends Evento implements IPrice {

	private BigDecimal prezzo;
	
	Spettacolo(String titolo, String dataString, int posti, double prezzo) throws Exception {
		super(titolo, dataString, posti);
		setPrezzo(prezzo);
		
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = BigDecimal.valueOf(prezzo);
	}
	
	@Override
	public String toString() {
		return getData() + " - " + super.getTitolo() + " - " + getPrezzoFormattato();
	}
	
	public String getPrezzoFormattato() {
        DecimalFormat priceFormatter = new DecimalFormat("#,##0.00€");
		return priceFormatter.format(getPrezzo());
		
	}
}

