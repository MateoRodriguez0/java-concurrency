package org.guzma.hilos.countdowntlatch;

import java.util.concurrent.CountDownLatch;

public class HiloTostadas implements Runnable {

	private CountDownLatch countDownLatch;
	
	
	public HiloTostadas(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}
	
	
	@Override
	public void run() {
		System.out.println();
		System.out.print("Estoy haciendo Tostadas......");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("Tostadas hechas");
		countDownLatch.countDown();
	}

}
