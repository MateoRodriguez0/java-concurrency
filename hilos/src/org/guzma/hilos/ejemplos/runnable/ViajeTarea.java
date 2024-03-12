package org.guzma.hilos.ejemplos.runnable;

public class ViajeTarea implements Runnable {

	private String  nombre;
	
	@Override
	public void run() {
		for(int i=0; i<10;i++) {
			System.out.println(i+". "+getNombre());
			try {
				Thread.sleep(250);
				
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Finalmente me voy de viaje a "+ nombre);
	}

	public String getNombre() {
		return nombre;
	}
	
	public ViajeTarea(String nombre) {
		this.nombre=nombre;
	}
	
}
