package org.guzma.hilos.condition.ejercicio;

public class Avion {


	
	private int id;
	/*Intencion 
	 * 0- el avion quiere despegar
	 * 1- esta volando
	 * !=0 !=1 el  avion esta aparcado
	 * ultima intencion posible 4 
	 * 
	 */
	private int intencion;
	
	public Avion(int id, int intencion) {
		super();
		this.id = id;
		this.intencion = intencion;
	}

	public int getId() {
		return id;
	}

	public int getIntencion() {
		return intencion;
	}
	
	public int nextIntencion() {
		intencion = ++intencion % 5;
		return intencion;
	}
	
	
	
	
}
