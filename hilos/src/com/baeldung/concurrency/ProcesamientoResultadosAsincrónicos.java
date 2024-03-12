package com.baeldung.concurrency;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ProcesamientoResultadosAsincrónicos {

	public static void SetPersonaAsincrona(String nombre,int year,int mes,int day){
	
		CompletableFuture.supplyAsync(() ->{
			Persona persona =new Persona();
			persona.setNombre(nombre);
			persona.setFechaNacimiento( LocalDate.of(year, mes, day));
			return persona;
		}).thenApply(p -> {
			int edad= Period.between(p.getFechaNacimiento(), LocalDate.now()).getYears() ;
			p.setEdad(edad);
			System.out.println(p.toString());
			return p;
		});
		
	}
	
	
	public static void completableFutureVoid() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture 
		  = CompletableFuture.supplyAsync(() -> "Hello");

		CompletableFuture<Void> future = completableFuture
		  .thenRun(() -> System.out.println("Computation finished."));

		future.get();
	}
}


class Persona{
	private int edad;
	private String nombre;
	private LocalDate fechaNacimiento;
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@Override
	public String toString() {
		return "Persona [edad=" + edad + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
	

}