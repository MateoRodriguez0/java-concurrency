package com.baeldung.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CompletableFutureComoUnFuturoSimple {

	public CompletableFutureComoUnFuturoSimple() {
		// TODO Auto-generated constructor stub
	}
	
	public static Future<String> calculateAsync()throws InterruptedException{
		CompletableFuture<String> completableFuture= new CompletableFuture<>();
		ExecutorService ex=Executors.newCachedThreadPool();
		ex.submit(() ->{
			TimeUnit.SECONDS.sleep(3);
			completableFuture.complete("hello");
			return null;
		});
		
		ex.shutdown();
		return completableFuture;
	}
}
