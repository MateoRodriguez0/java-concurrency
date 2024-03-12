package org.guzma.hilos.completablefuture;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Principal {
	public static void main(String[] args) {
		List<Integer> values=new LinkedList<>();
		List<CompletableFuture<Integer>> futures=new LinkedList<>();
		ExecutorService executor= Executors.newFixedThreadPool(10);
		ExternalService externalService= new ExternalService(executor);
		Instant instant= Instant.now();
		for(int i=0;i<10;i++) {
			futures.add(externalService.ItegAsync());
		}
		futures.forEach(f ->f.join());
		for (CompletableFuture<Integer> completableFuture : futures) {
			try {
				values.add(completableFuture.get());
			} catch (InterruptedException | ExecutionException e) {
			}
		}
		
		Instant instant2= Instant.now();
		System.out.println("Duracion: "+ Duration.between(instant, instant2).getSeconds());
		System.out.println(values.toString());
	}
	
}


class ExternalService{
	private Executor executor;
	public ExternalService(Executor executor) {
		this.executor= executor;
	}

	public Integer Iteg() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			
		}
		return new Random().nextInt();

	}
	
	public CompletableFuture<Integer> ItegAsync() {
		
		return CompletableFuture
				.supplyAsync(() ->Iteg(),executor);

	}
}