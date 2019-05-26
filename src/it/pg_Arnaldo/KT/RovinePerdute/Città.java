package it.pg_Arnaldo.KT.RovinePerdute;

import java.util.ArrayList;

public class Citt� {

	private int x; //Coordinata x citt�
	private int y; //Coordinata y citt�
	private int h; //Altezza citt�
	
	private int id; //Identificativo citt�
	
	private String nome; //Nome citt�
	
	private ArrayList<Integer> collegamenti=new ArrayList<Integer>(); //Collegamenti con le altre citt� 
	
	
	//---------------------------------------------------------------
	
	
	public Citt�(int _x, int _y, int _h, int _id , String _nome) {
		// TODO Auto-generated constructor stub
		
		x=_x;
		
		y=_y;
		
		h=_h;
		
		id=_id;
		
		nome=_nome;
		
		
	}
	
	
	//----------------------------------------------------------------
	
	
	/**
	 * Lettura posizione x citt� corrispondente
	 * @return posizione x citt�
	 */
	public int getX() {
		
		return x;
	}
	
	
	//----------------------------------------------------------------
	
	
	/**
	 * Lettura posizione y citt� corrispondente
	 * @return posizione y citt�
	 */
	public int getY() {
		
		return y;
	}
	
	
	//----------------------------------------------------------------
	
	
	/**
	 * Lettura altezza citt� corrispondente
	 * @return altezza citt�
	 */
	public int getH() {
		
		return h;
	}
	
	
	//-----------------------------------------------------------------
	
	
	/**
	 * Lettura identificativo citt�
	 * @return identificativo citt� 
	 */
	public int getId() {
		
		return id;
	}
	
	
	//-----------------------------------------------------------------
	
	
	/**
	 * Lettura nome citt�
	 * @return nome citt�
	 */
	public String getNome(){
		
		return nome;
	}
	
	
	//------------------------------------------------------------------
	
	
	/**
	 * Lettura citt� collegate 
	 * @return citt� collegata
	 */
	public Integer getNextCity(int pos) {
		
		return collegamenti.get(pos);
	}
	
	
	//-------------------------------------------------------------------
	
	
	/**
	 * Aggiungi citt� collegata 
	 * @param nextCity citt� che si collega
	 */
	public void addNextCity(int nextCity) {
		
		collegamenti.add(nextCity);
	}
	
	
	//--------------------------------------------------------------------
	
	
	
	public int retNumColleg() {
		
		return collegamenti.size();
	}
}
