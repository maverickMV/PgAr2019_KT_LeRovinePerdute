package it.pg_Arnaldo.KT.RovinePerdute;

import java.util.ArrayList;

public class Veicolo {

	
	
	private ArrayList<Citt�> percorsOttimale = new ArrayList<Citt�>(); //Percorso ottimale delle citt�
	
	
	public Veicolo() {
		// TODO Auto-generated constructor stub
	}
	
	
	//-------------------------------------------------------------------------
	
	
	/**
	 * Calcola la distanz tra 2 citt� in base al veicolo
	 * @param c1 Citt�1
	 * @param c2 Citt�2
	 * @return distanza tra citt� 
	 */
	public int calcoloPeso(Citt� c1, Citt� c2) {
		
		
		return 1;
	}
	
	
	//---------------------------------------------------------------------------
	
	public void aggiungiCitt�(Citt� c1) {
		
		percorsOttimale.add(c1);
		
	}
}
