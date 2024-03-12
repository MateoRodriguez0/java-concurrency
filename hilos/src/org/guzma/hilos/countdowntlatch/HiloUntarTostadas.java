package org.guzma.hilos.countdowntlatch;

import java.util.concurrent.CountDownLatch;

public class HiloUntarTostadas implements Runnable {

	private CountDownLatch countDownLatch;
	
	
	public HiloUntarTostadas(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}


	@Override
	public void run() {
		System.out.println();
		System.out.print("Estoy untando las Tostadas......");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("Tostadas untadas");
	}

}
