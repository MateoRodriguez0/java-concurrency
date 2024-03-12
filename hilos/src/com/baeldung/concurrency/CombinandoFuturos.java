package com.baeldung.concurrency;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombinandoFuturos {

	public static String encadenarDosFuturosDeFormaSecuencial() throws InterruptedException, ExecutionException{
		
		return CompletableFuture.supplyAsync(() -> "hello")
				.thenCompose(s ->{
					CompletableFuture<String> future=CompletableFuture.supplyAsync(() -> s+" world");
					return future;
				})
				.get();
	}
	
	
	public void validandoEdadConCombine(String nombre,int year,int mes,int day) throws InterruptedException, ExecutionException {
		LocalDateTime dateTime1= LocalDateTime.now();
		edad=0;
		CompletableFuture<Persona> future1= CompletableFuture.supplyAsync(() -> {
			Persona persona =new Persona();
			persona.setNombre(nombre);
			persona.setFechaNacimiento( LocalDate.of(year, mes, day));
			edad=Period.between(persona.getFechaNacimiento(), LocalDate.now()).getYears();
			return persona;
		});
		
	
		future1.thenCombine(CompletableFuture.supplyAsync(() ->{
			if(edad <18) {
				edad=(-18);
				
			}
			return edad;
		}),(p, e) ->{
			p.setEdad(e);
			System.out.println(p.toString());
			return p;
		}).get();
		
		
		
		LocalDateTime dateTime2= LocalDateTime.now();
		long segundos = ChronoUnit.MILLIS.between(dateTime1, dateTime2);
		System.out.println("Duracion= "+segundos+" milisegundos");
		
		
	}
	
	private int edad= 0;
}
