package org.guzma.hilos.tarea;

import org.guzma.hilos.tarea.AlfanumericoTarea.Tipo;

public class EjecutaTarea {

	public static void main(String[] args) {
		
		AlfanumericoTarea letras= new AlfanumericoTarea(Tipo.LETRA);
		Thread thread1= new Thread(letras);
		thread1.start();
	}

}
