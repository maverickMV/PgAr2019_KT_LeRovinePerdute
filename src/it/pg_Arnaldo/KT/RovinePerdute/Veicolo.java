package it.pg_Arnaldo.KT.RovinePerdute;

import java.util.ArrayList;

public class Veicolo {

	
	
	private ArrayList<Città> percorsOttimale = new ArrayList<Città>(); //Percorso ottimale delle città
	
	
	public Veicolo() {
		// TODO Auto-generated constructor stub
	}
	
	
	//-------------------------------------------------------------------------
	
	
	/**
	 * Calcola la distanz tra 2 città in base al veicolo
	 * @param c1 Città1
	 * @param c2 Città2
	 * @return distanza tra città 
	 */
	public int calcoloPeso(Città c1, Città c2) {
		
		
		return 1;
	}
	
	
	//---------------------------------------------------------------------------
	
	public void aggiungiCittà(Città c1) {
		
		percorsOttimale.add(c1);
		
	}
}
