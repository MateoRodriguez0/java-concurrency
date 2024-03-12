package org.guzma.hilos.ejemplos.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploExecutor {

	public static void main(String[] args) {
		
		ScheduledExecutorService scheService= Executors.newSingleThreadScheduledExecutor();
	
		System.out.println("Antes de ejecutar la tarea ");
		
		AtomicInteger atomicInteger= new AtomicInteger(5);
		Future<?> futur=scheService.scheduleAtFixedRate(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println("ha comenzado la tarea");
			atomicInteger.getAndDecrement();
		}, 5,2, TimeUnit.SECONDS);
		
		while(atomicInteger.get()>=0) {
			if(atomicInteger.get()==0) {
				futur.cancel(false);
				break;
			}
		}
		
		
		try {
			scheService.awaitTermination(0, TimeUnit.SECONDS);
			//scheService.shutdown();
			System.out.println("Hola mundo");
		} catch (InterruptedException e) {
		}
		
		
		
	}
}
