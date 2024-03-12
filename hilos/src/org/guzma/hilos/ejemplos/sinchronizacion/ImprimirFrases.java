package org.guzma.hilos.ejemplos.sinchronizacion;

import static org.guzma.hilos.ejemplos.sinchronizacion.EjemploZincronizacionThread.imprimeFrases;
public class ImprimirFrases implements Runnable{

	private String frase1;
	private String frase2;
	
	public ImprimirFrases(String frase1, String frase2) {
		super();
		this.frase1 = frase1;
		this.frase2 = frase2;
	}

	@Override
	public void run() {
		imprimeFrases(frase1, frase2);
		
	}

}
