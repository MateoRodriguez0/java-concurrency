package org.guzma.hilos.ejemplos.sync;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable{

	private Panaderia panaderia;
	
	public Panadero(Panaderia panaderia) {
		super();
		this.panaderia = panaderia;
	}

	@Override
	public void run() {

		for(int i=0;i<10;i++) {
			 panaderia.hornear("Pant tipo " +i);
			 try {
				Thread.sleep(ThreadLocalRandom.current().nextLong(500, 2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
