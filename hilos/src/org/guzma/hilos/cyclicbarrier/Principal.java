package org.guzma.hilos.cyclicbarrier;

import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Principal {

	public static void main(String[] args) {
		int participantes = 100;
		Runtime runtime = Runtime.getRuntime();
		int nucleos= runtime.availableProcessors();
		
		ExecutorService executorService= Executors.newCachedThreadPool();
		Carrera.setBarrier(new CyclicBarrier(participantes-1));
		Carrera.setTiempos( new double [participantes][4]);
		
		System.out.println("Ha comenzado la carrera");
		for(int i=1;i<=participantes;i++) {
			Runnable runnable=new Carrera(i, participantes);
			executorService.submit(runnable);
		}
	

		executorService.shutdown();
		
	
		try {
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 double [][] tiempos=Carrera.getTiempos();
		 int hGanador1= 0;
		 double ganadorTiempo1=tiempos[0][0];
		 int hGanador2= 0;
		 double ganadorTiempo2=tiempos[0][1];
		 int hGanador3= 0;
		 double ganadorTiempo3=tiempos[0][2];
		 int hGanador= 0;
		 double ganadorTiempo=tiempos[0][3];
		
		 System.out.println("hilo-"+ tiempos[0][0]);
	
		 List.of(tiempos).stream().map(t -> t[0]).forEach(System.out::println);;
		 for (int i = 0; i < tiempos.length; i++) {
		

			if(tiempos[i][0]<ganadorTiempo1) {
				ganadorTiempo1=tiempos[i][0];
				hGanador1=i;
			}
			
			if(tiempos[i][1]<ganadorTiempo2) {
				ganadorTiempo2=tiempos[i][1];
				hGanador2=i;
			}
			
			if(tiempos[i][2]<ganadorTiempo3) {
				ganadorTiempo1=tiempos[i][2];
				hGanador3=i;
			}
			
			if(tiempos[i][3]<ganadorTiempo) {
				ganadorTiempo=tiempos[i][3];
				hGanador=i;
			}
		}
		 
		 System.out.println("El ganador es el hilo "+ hGanador);
		 System.out.println("El ganador de la etapa 1 es el hilo "+ hGanador1);
		 System.out.println("El ganador de la etapa 2 es el hilo "+ hGanador2);
		 System.out.println("El ganador de la etapa 3 es el hilo "+ hGanador3);
		
	}

}
