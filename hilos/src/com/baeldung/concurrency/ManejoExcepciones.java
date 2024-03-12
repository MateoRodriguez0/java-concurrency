package com.baeldung.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ManejoExcepciones {

	
	public static void completableEception() throws InterruptedException, ExecutionException {
		String name = null;

		// ...

		CompletableFuture<String> completableFuture  
		  =  CompletableFuture.supplyAsync(() -> {
		      if (name == null) {
		          throw new RuntimeException("Computation error!");
		      }
		      return "Hello, " + name;
		  }).handle((s, t) -> s != null ? s : "Hello, Stranger!");



		String result= completableFuture.get();
		System.out.println(result);
	}
	
	public static void completableEception2() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		// ...

		completableFuture.completeExceptionally(
		  new RuntimeException("Calculation failed!"));
		completableFuture.get();
		
	}
}
