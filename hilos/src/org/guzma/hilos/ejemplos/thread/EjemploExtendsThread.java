package org.guzma.hilos.ejemplos.thread;

public class EjemploExtendsThread extends Thread {

	@Override
	public void run() {
		System.out.println("el nombre es "+ getName());
	
		System.out.println("Finaliza el hilo "+ getName());
	}
	
	public EjemploExtendsThread(String name) {
		super(name);
	}
}
