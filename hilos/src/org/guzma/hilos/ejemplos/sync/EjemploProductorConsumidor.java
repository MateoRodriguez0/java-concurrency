package org.guzma.hilos.ejemplos.sync;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidor {

	public static void main(String[] args) {
		
		Panaderia panaderia= new Panaderia();

		//Thread consumidor= new Thread(new Consumidor(panaderia));
		//Thread productor= new Thread(new Panadero(panaderia));
		
		
		/// java 8 lambdas 
		
		Thread consumidor= new Thread(() -> {
			for(int i=0;i<10;i++) {
				panaderia.comprar();
			
			}
		});
		
		Thread productor= new Thread(() -> {
			for(int i=0;i<10;i++) {
				 panaderia.hornear("Pant tipo " +i);
				 try {
					Thread.sleep(ThreadLocalRandom.current().nextLong(500, 2000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		productor.start();
		consumidor.start();
		
		
	}

}
