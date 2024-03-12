package org.guzma.hilos.ejemplos.java8;


public class TestInterfaceRunnableJava8{

	public static void main(String[] args) {
		
		/*Runnable runnable= new Runnable() {
			public void run() {
				for(int i=0; i<10;i++) {
					System.out.println(i+". "+Thread.currentThread().getName());
					try {
						Thread.sleep(250);
						
					} catch (InterruptedException e) {
					}
				}
				System.out.println("Finalmente me voy de viaje a "+ Thread.currentThread().getName());
			}
		};*/
		
		Thread main=Thread.currentThread();
		Runnable runnable=() -> {
			for(int i=0; i<10;i++) {
				System.out.println(i+". "+Thread.currentThread().getName());
				try {
					Thread.sleep(250);
					
				} catch (InterruptedException e) {
				}
			}
			System.out.println("Finalmente me voy de viaje a "+ Thread.currentThread().getName());
		
			System.out.println(main.getState());
		};
		
		Thread v1= new Thread(runnable,"Medellin");
		Thread v2=new Thread(runnable,"Catagena");
		Thread v3=new Thread(runnable,"Paris");
		Thread v4=new Thread(runnable,"New york");

		v1.start();
		v2.start();
		v3.start();
		v4.start();
		try {
			v1.join();
			v2.join();
			v3.join();
			v4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Continuando con el metodo main");
		System.out.println(Thread.currentThread().getState());
	}
	
}
