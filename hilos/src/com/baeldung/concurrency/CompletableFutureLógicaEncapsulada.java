package com.baeldung.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureLógicaEncapsulada {


	public static String encapsuada() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future
		  = CompletableFuture.supplyAsync(() -> "Hello");
		
		return future.get();
	}
}
