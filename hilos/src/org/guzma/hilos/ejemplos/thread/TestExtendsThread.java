package org.guzma.hilos.ejemplos.thread;

public class TestExtendsThread {

	
	public static void main(String[] args) {
		Thread hilo= new EjemploExtendsThread("new");
		Thread hilo2= new EjemploExtendsThread("new 2");
		Thread hilo3= new EjemploExtendsThread("new 3");
		hilo.start();
		hilo2.start();
		hilo3.start();
		try {
			hilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(hilo.getState());
	}
}
