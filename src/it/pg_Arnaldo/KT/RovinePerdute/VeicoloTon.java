package it.pg_Arnaldo.KT.RovinePerdute;

public class VeicoloTon extends Veicolo{

	
	public VeicoloTon() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override 
	public int calcoloPeso(Città c1,Città c2) {
		
		int x1=c1.getX();
		int y1=c1.getY();
		
		int x2=c2.getX();
		int y2=c2.getY();
		
		
		return (int) Math.sqrt ( Math.pow(x2-x1,2) + Math.pow(y2-y1,2) );
	}
}
