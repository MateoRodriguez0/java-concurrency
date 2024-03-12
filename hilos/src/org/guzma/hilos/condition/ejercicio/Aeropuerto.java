package org.guzma.hilos.condition.ejercicio;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Aeropuerto implements Runnable {

	/*
	 * Cuando un avion esta en la pista de aterrizaje ningun otro hilo debe estar ejecutandose en ese momento
	 * Cuando un avion aterriza pasa a la seccion de aparcamiento donde estaran todos los aviones 
	 * en la pista reservada de despegue solo pueden estar dos aviones
	 * cuando la pista este disponible los aviones despegaran
	 *  
	 */
	private Avion avion;
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition aparcamiento = lock.newCondition();
	private static Condition PistaaterrizajeDespegue= lock.newCondition();
	private static Condition ZonaReservada = lock.newCondition();
	private static int totalEnPistaDeAterrizaje=0;
	private static int totalEnPistaReservada=0;
	private static int totalAparcados=0;
	
	
	public Aeropuerto(Avion avion) {
		super();
		this.avion = avion;
	}
	

	@Override
	public void run() {
		int intencion=avion.getIntencion();
		while(true) {
			lock.lock();
			
			switch (intencion) {
			case 0: {		
				intencion=avion.nextIntencion();
				despegar();
				break;
			}
			case 1: {		
				intencion=avion.nextIntencion();
				aterrizaje();
				break;
			}
			
			case 4:{
				intencion=avion.nextIntencion();
				intentoDespegue();
				break;
			}
			default:
				intencion=avion.nextIntencion();
				System.out.println("El avion con id "+avion.getId()+" sigue aparcado");
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			lock.unlock();
		}
		
		
		
		
	}

	
	private void despegar() {
		System.out.println("El avion con id "+avion.getId()+" acaba de despegar a las"+ LocalDateTime.now());
		totalEnPistaReservada--;
		ZonaReservada.signal();
		aparcamiento.signalAll();
	}
	
	private void intentoDespegue() {
		System.out.println("El avion con id "+avion.getId()+" esta intentando despegar a las"+ LocalDateTime.now());
		while(totalEnPistaReservada==2) {
			await(aparcamiento);
		}
		if(totalEnPistaReservada<2) {
			totalEnPistaReservada++;
			totalAparcados--;
			System.out.println("El avion con id "+avion.getId()+" ha sido movido a la zona reservada"+ LocalDateTime.now());
		}
		
		despegar();
	}
	

	private void aterrizaje() {
		totalAparcados++;
		System.out.println("El avion con id "+avion.getId()+" acaba de aterrizar a las "+ LocalDateTime.now());
		await(aparcamiento);
	}
	
	

	
	
	
	private void await(Condition condition) {
		try {
			condition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
