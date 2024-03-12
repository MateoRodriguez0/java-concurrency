package org.guzma.hilos.countdowntlatch;

import java.util.concurrent.CountDownLatch;

public class HiloCafe implements Runnable {


	private CountDownLatch countDownLatch;
	
	
	public HiloCafe(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}
	
	
	@Override
	public void run() {
		System.out.println();
		System.out.print("Estoy haciendo cafe......");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("Cafe hecho");
		countDownLatch.countDown();
	}

}
