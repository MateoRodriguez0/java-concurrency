package org.guzma.hilos.ejemplos.sync;

public class Consumidor implements Runnable {

	private Panaderia panaderia;
	
	public Consumidor(Panaderia panaderia) {
		super();
		this.panaderia = panaderia;
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			panaderia.comprar();
		
		}
	}

}
