package org.guzma.hilos.ejemplos.runnable;

public class TestIterfaceRunnable {

	public static void main(String[] args) {
	
		new Thread(new ViajeTarea("madrid")).start();;
		new Thread(new ViajeTarea("Paris")).start();
		new Thread(new ViajeTarea("Medellin")).start();
		new Thread(new ViajeTarea("Catagena")).start();

	}

}
