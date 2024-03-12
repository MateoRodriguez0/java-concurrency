package org.guzma.hilos.condition;

import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer implements Runnable  {

	
	private int orden;
	private int valor;
	private static  ReentrantLock lock= new ReentrantLock();
	private static Vector<Integer> elemts= new Vector<>();
	private static Condition restar= lock.newCondition();
	private static Condition sumar= lock.newCondition();
	public Buffer(int orden, int valor) {
		super();
		this.orden = orden;
		this.valor = valor;
	}

	@Override
	public void run() {
		while(true) {
			lock.lock();
			
			if(orden==0) {
				RestarElemento();
			}
			else {
				sumarElemento();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		
			lock.unlock();
		}
		
	}
	
	private void sumarElemento() {
		while(elemts.size()>20) {
			await(sumar);
			
		}
		elemts.add(valor);
		System.out.println("Se ha añadido el elemento "+ elemts.get(elemts.size()-1));
		
		
		restar.signal();
		await(sumar);
	}
	
	private void RestarElemento() {
		while(elemts.isEmpty()) {
			await(restar);
			
		}
		System.out.println("Se ha extraido el elemento "+ elemts.get(0));
		elemts.remove(0);
		
		sumar.signal();
		await(restar);
	}
	
	private void await(Condition condition) {
		try {
			condition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
