package org.guzma.hilos.condition;

import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		Random random= new Random();
		Thread [] threads= new Thread[30];
		
		for (int i = 0; i < threads.length; i++) {
			
			Runnable run= new Buffer(random.nextInt(), i);
			
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
