import java.util.Iterator;

public class Principal extends Thread {
	static int cons=0;
	
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			cons++;
		}
		
	}
	public static void main(String[] args) {
		Principal[] hilos= new Principal[1000];
		
		for(int i=0;i<hilos.length;i++) {
			hilos[i]= new Principal();
			hilos[i].start();
			if(i>0 && i<hilos.length) {
				try {
					hilos[i-1].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(cons);
	}
	

	
	
	
	
}
