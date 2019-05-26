package it.pg_Arnaldo.KT.RovinePerdute;

import java.util.ArrayList;

public class PercorsOttimale {
	
	
	private ArrayList<Citt�>listaCity;//Citt� da analizzare
	private ArrayList<Citt�>listaCopia;
	
	private int [] [] tabellaDist; //Tabella iniziale con ditanze minime e citt�
	

	public PercorsOttimale() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	
	//-------------------------------------------------------------------------------
	
	
	/**
	 * Trova il percorso migliore tra le citt� e le copia 
	 * @param v Tipo di veicolo
	 */
	public void trovaMigliore(Veicolo v) {
		
		int calc_dist=0;
		int distanza2;
		int iteration=0;
		int i;
		
		tabellaDist=new int [listaCity.size()] [2];
		inizTabellaDist();
		
		while(!listaCity.isEmpty()) {
			
			
			for(i=0;i<listaCity.get(i).retNumColleg();i++) { //Faccio scorrere tutti i collegamenti di ciascuna citt�
				
				distanza2=v.calcoloPeso(listaCity.get(iteration),listaCity.get(listaCity.get(iteration).getNextCity(i)) );
				
				calc_dist=tabellaDist[i][0]+distanza2;
				
				if(calc_dist<tabellaDist[i][0]) {
					
					tabellaDist[i][0]=calc_dist;
					
					tabellaDist[i][1]=iteration;
				}
				
			}
			
			v.aggiungiCitt�(listaCity.get(tabellaDist[i][1]));
			listaCity.remove(tabellaDist[i][1]);
			
			
		}
		
		
		
	}
	
	
	//---------------------------------------------------------------------------------
	
	
	public void inizTabellaDist() {
		
		tabellaDist[0][0]=0;
		tabellaDist[0][1]=0;
		
		
		for(int i=1;i<listaCity.size();i++) {
			
			tabellaDist[i][0]=Integer.MAX_VALUE;
			
			
		}
		
	}
	
	
	//----------------------------------------------------------------------------
	
	
	public void copiaArray(ArrayList<Citt�> city) {
		
		listaCity=new ArrayList<Citt�>(city);
		listaCopia=new ArrayList<Citt�>(city);
	}
}
