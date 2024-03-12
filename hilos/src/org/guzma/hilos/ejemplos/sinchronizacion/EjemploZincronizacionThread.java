package org.guzma.hilos.ejemplos.sinchronizacion;

public class EjemploZincronizacionThread {

	public static void main(String[] args) {
		new Thread(new ImprimirFrases("Hola ", "Que tal")).start();
		new Thread(new ImprimirFrases("quien ", "eres tu?")).start();
		new Thread(new ImprimirFrases("Me llamo ", "Mateo")).start();
	}
	
	
	public synchronized static void imprimeFrases(String frase1,String frase2) {
		
		System.out.print(frase1);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		System.out.println(frase2);
	}
}
