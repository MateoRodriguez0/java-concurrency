package org.guzma.hilos.cyclicbarrier;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Carrera implements Runnable{

	private static int participantes;
	private int id;
	private double inicio, total;

	private static CyclicBarrier barrier= null;
	private static double [][] tiempos=null; 
	public Carrera( int llegados,int participates) {
		
		setParticipantes(participates);
		this.id = llegados;

	}



	@Override
	public void run() {
		etapa(1);
		etapa(2);
		etapa(3);
		tiempos[id][3]=tiempos[id][2]+tiempos[id][1]+tiempos[id][0];
	}

	
	private void etapa(int etapa) {
		inicio= System.nanoTime();
		
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		total=System.nanoTime()-inicio;
		System.out.println(id+"-- etapa"+  etapa+" "+(System.nanoTime()-inicio));
		tiempos [id][etapa]= total;		
		try {
			barrier.await();
			barrier.reset();
		} catch (InterruptedException | BrokenBarrierException e) {
			
		}
	}
	
	public static void setParticipantes(int participantes) {
		Carrera.participantes = participantes;
	}
	

	public static void setBarrier(CyclicBarrier barrier) {
		Carrera.barrier = barrier;
	}
	public static double[][] getTiempos() {
		return tiempos;
	}

	public static void setTiempos(double[][] tiempos) {
		Carrera.tiempos = tiempos;
	}
}
