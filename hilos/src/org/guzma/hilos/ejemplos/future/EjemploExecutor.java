package org.guzma.hilos.ejemplos.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EjemploExecutor {

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
		
		Future<?> future= exeService.submit(tREA);
		exeService.shutdown();
		
		System.out.println("continuando con la ejecucion del main");
		
		
		System.out.println("continuamoss");
		try {
			System.out.println(future.isDone()+" "+future.get(5,TimeUnit.SECONDS));
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
