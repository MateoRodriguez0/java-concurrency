package org.guzma.hilos.ejemplos.sync;

public class Panaderia {

	private String pan;
	private boolean disponible;
	
	public synchronized void hornear(String tipo) {
		while(disponible) {
			try {
				System.out.println(Thread.currentThread().getState());
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("El panadero esta horneando el pan....");
		this.pan =tipo;
		disponible=true;
		notify();
	}
	
	public synchronized void comprar() {
		while(!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("He Acabado de comprar el pan "+getPan());
		this.disponible=false;
		notify();
	}
	
	public String getPan() {
		return pan;
	}
}
