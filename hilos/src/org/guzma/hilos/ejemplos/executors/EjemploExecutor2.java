package org.guzma.hilos.ejemplos.executors;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor2 {

	public static void main(String[] args) {
		LocalDateTime dateTime1= LocalDateTime.now();
		//ExecutorService exeService= Executors.newFixedThreadPool(3);
		ThreadPoolExecutor exeService=new ThreadPoolExecutor(2, 3, 30,TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		System.out.println("tamaño del pool "+exeService.getPoolSize());
		Callable<String> tarea1= () ->{TimeUnit.SECONDS.sleep(3); return "get";};
		Callable<String> tarea2= () -> {TimeUnit.SECONDS.sleep(3); return"post";};
		Callable<String> tarea3= () -> { TimeUnit.SECONDS.sleep(3); return "put";};
		
		Future<String> future1= exeService.submit(tarea1);
		Future<String> future2= exeService.submit(tarea2);
		Future<String> future3= exeService.submit(tarea3);
		
		System.out.println("tamaño del pool "+exeService.getPoolSize());
		
		while(!(future1.isDone() && future2.isDone() && future3.isDone())) {
			System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3 %s", 
					future1.isDone()? "finalizo":"en proceso",
					future2.isDone()? "finalizo":"en proceso",
					future3.isDone()? "finalizo":"en proceso"));

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}
		System.out.println("tamaño del pool "+exeService.getPoolSize());
		try {
			System.out.println("resultado tarea1 "+future1.get());
			System.out.println("resultado tarea2 "+future2.get());
			System.out.println("resultado tarea3 "+future3.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		LocalDateTime dateTime2= LocalDateTime.now();
		long segundos = ChronoUnit.SECONDS.between(dateTime1, dateTime2);
		System.out.println("las tareas duraron "+segundos+ " segundos");
		try {
			exeService.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
