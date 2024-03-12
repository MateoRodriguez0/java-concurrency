package com.baeldung.concurrency;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FuturosEnParalelo {

	
	public static void ejecutarTodos() throws InterruptedException, ExecutionException {
		LocalDateTime dateTime1= LocalDateTime.now();
		
		CompletableFuture<String> future1  
		  = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2  
		  = CompletableFuture.supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future3  
		  = CompletableFuture.supplyAsync(() ->{
			  try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return "World";  
		  });
		CompletableFuture<Void> combinedFuture =
		CompletableFuture.allOf(future1,future2,future3);


		
		System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3 %s", 
				future1.isDone()? "finalizo":"en proceso",
				future2.isDone()? "finalizo":"en proceso",
				future3.isDone()? "finalizo":"en proceso"));
		
		LocalDateTime dateTime2= LocalDateTime.now();
		long segundos = ChronoUnit.MILLIS.between(dateTime1, dateTime2);
		System.out.println("Duracion= "+segundos+" milisegundos");
	}
}
