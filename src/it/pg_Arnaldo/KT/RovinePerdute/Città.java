package it.pg_Arnaldo.KT.RovinePerdute;

import java.util.ArrayList;

public class Città {

	private int x; //Coordinata x città
	private int y; //Coordinata y città
	private int h; //Altezza città
	
	private int id; //Identificativo città
	
	private String nome; //Nome città
	
	private ArrayList<Integer> collegamenti=new ArrayList<Integer>(); //Collegamenti con le altre città 
	
	
	//---------------------------------------------------------------
	
	
	public Città(int _x, int _y, int _h, int _id , String _nome) {
		// TODO Auto-generated constructor stub
		
		x=_x;
		
		y=_y;
		
		h=_h;
		
		id=_id;
		
		nome=_nome;
		
		
	}
	
	
	//----------------------------------------------------------------
	
	
	/**
	 * Lettura posizione x città corrispondente
	 * @return posizione x città
	 */
	public int getX() {
		
		return x;
	}
	
	
	//----------------------------------------------------------------
	
	
	/**
	 * Lettura posizione y città corrispondente
	 * @return posizione y città
	 */
	public int getY() {
		
		return y;
	}
	
	
	//----------------------------------------------------------------
	
	
	/**
	 * Lettura altezza città corrispondente
	 * @return altezza città
	 */
	public int getH() {
		
		return h;
	}
	
	
	//-----------------------------------------------------------------
	
	
	/**
	 * Lettura identificativo città
	 * @return identificativo città 
	 */
	public int getId() {
		
		return id;
	}
	
	
	//-----------------------------------------------------------------
	
	
	/**
	 * Lettura nome città
	 * @return nome città
	 */
	public String getNome(){
		
		return nome;
	}
	
	
	//------------------------------------------------------------------
	
	
	/**
	 * Lettura città collegate 
	 * @return città collegata
	 */
	public Integer getNextCity(int pos) {
		
		return collegamenti.get(pos);
	}
	
	
	//-------------------------------------------------------------------
	
	
	/**
	 * Aggiungi città collegata 
	 * @param nextCity città che si collega
	 */
	public void addNextCity(int nextCity) {
		
		collegamenti.add(nextCity);
	}
	
	
	//--------------------------------------------------------------------
	
	
	
	public int retNumColleg() {
		
		return collegamenti.size();
	}
}
