package it.pg_Arnaldo.KT.RovinePerdute;

public class VeicoloMet extends Veicolo {

	
	public VeicoloMet() {
		// TODO Auto-generated constructor stub
	}
	
	
	//------------------------------------------------------
	
	
	
	@Override
	public int calcoloPeso(Città c1, Città c2) {
		
		int h1=c1.getH();
		int h2=c2.getH();
		
		return Math.abs(h2-h1);
	}
}
