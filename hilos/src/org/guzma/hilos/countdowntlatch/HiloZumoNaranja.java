package org.guzma.hilos.countdowntlatch;

import java.util.concurrent.CountDownLatch;

public class HiloZumoNaranja implements Runnable {


	private CountDownLatch countDownLatch;
	
	
	public HiloZumoNaranja(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}
	
	
	@Override
	public void run() {
		System.out.println();
		System.out.print("Estoy haciendo el jugo de naranja......");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("jugo de naranja hecho");
		countDownLatch.countDown();
	}

}
