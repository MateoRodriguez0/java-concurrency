package org.guzma.hilos.tarea;

import java.util.Iterator;

public class AlfanumericoTarea implements Runnable {

	public enum Tipo{NUMERO, LETRA};
	
	private Tipo tipo;
	
	public AlfanumericoTarea(Tipo tipo) {
		this.tipo=tipo;
	}
	
	
	@Override
	public void run() {
		if(tipo==Tipo.NUMERO) {
			numeros();
		}
		if(tipo==Tipo.LETRA) {
			letras();
		}
	}
	
	public static void numeros() {
		for(int i=0;i<10;i++){
			System.out.println(i);
		}
	}
	
	public static void letras() {
		for(int i=65;i<=90;i++){
			System.out.println((char)i);
		}
	}
}
