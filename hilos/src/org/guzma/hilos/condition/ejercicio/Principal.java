package org.guzma.hilos.condition.ejercicio;

import java.util.Random;

public class Principal {

	
	public static void main(String[] args) {
		
		Random random= new Random();
		Thread [] threads= new Thread[30];
		
		for (int i = 0; i < threads.length; i++) {
			Avion avion= new Avion(i,random.nextInt(5));
			
			Runnable run= new Aeropuerto(avion);
			
			threads[i]= new Thread(run);
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}
