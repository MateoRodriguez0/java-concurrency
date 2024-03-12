package com.baeldung.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Principal {

	
	public static void main(String[] args) {
		//1.
		/*try {
			Future<String> future1= CompletableFutureComoUnFuturoSimple.calculateAsync();
			String result= future1.get();
			assertEquals("hello", result);
			
			future1.cancel(true);
			System.out.println(future1.state());
		} catch (InterruptedException | ExecutionException e) {}*/
		
		//2
		/*try {
			String result = CompletableFutureLógicaEncapsulada.encapsuada();
			assertEquals("Hello", result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//3
		/*
		try {
			CompletableFuture<Persona> future=ProcesamientoResultadosAsincrónicos.SetPersonaAsincrona("Mateo", 2004, 03, 04);
			System.out.println(future.get().toString());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//3.1
		//ProcesamientoResultadosAsincrónicos.SetPersonaAsincrona("Mateo", 2004, 03, 04);
		
		
		//3.2
		/*try {
			ProcesamientoResultadosAsincrónicos.completableFutureVoid();
		} catch (InterruptedException | ExecutionException e) {
		
			e.printStackTrace();
		}*/
		
		/*4
		 * 
		 
		try {
			String result=CombinandoFuturos.encadenarDosFuturosDeFormaSecuencial();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//4.1
		/*try {
			new CombinandoFuturos().validandoEdadConCombine("Mateo", 2008, 03, 04);
			System.out.println("f");
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//8.
		try {
			FuturosEnParalelo.ejecutarTodos();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		//9.
		/*try {
			ManejoExcepciones.completableEception2();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	
	private static void assertEquals(String string, String result) {
		System.out.println(string==result);
		
	}
	
}
