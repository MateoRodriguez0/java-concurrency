package org.guzma.hilos.ejemplos.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploScheuledExecutorService {

	public static void main(String[] args) {
		
		ExecutorService exeService= Executors.newSingleThreadExecutor();
		
		Runnable tREA= () -> {
			System.out.println("inicio de la tarea");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("finalizacion de la tarea");
		};
		exeService.submit(tREA);
		exeService.shutdown();
		System.out.println("continuando con la ejecucion del main");
		
		
		try {
			exeService.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
