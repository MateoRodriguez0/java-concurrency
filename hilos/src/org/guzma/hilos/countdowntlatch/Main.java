package org.guzma.hilos.countdowntlatch;

import java.util.concurrent.CountDownLatch;

public class Main {

	public static void main(String[] args) {

		CountDownLatch countDownLatch= new CountDownLatch(3);
		
		Thread cafe= new Thread(new HiloCafe(countDownLatch));
		Thread naranja= new Thread(new HiloZumoNaranja(countDownLatch));
		Thread untar= new Thread(new HiloUntarTostadas(countDownLatch));
		Thread tostadas= new Thread(new HiloTostadas(countDownLatch));
		
		System.out.println("Preparando desyuno");
		cafe.start();
		naranja.start();
		tostadas.start();
		untar.start();
		
		try {
			countDownLatch.await();
			System.out.println("Desayuno preparado");
		} catch (InterruptedException e) {
			
		}
	}

}
