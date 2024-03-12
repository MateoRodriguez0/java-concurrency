
import java.util.concurrent.locks.LockSupport;

public class Principal2 {
	static int i=0;
	public static void main(String[] args) {
		
		for(int n=i=0;i<100;i++) {
		Thread.startVirtualThread(() ->{
			System.out.println("hola-"+i);
			LockSupport.park();
		});
		
		}
	}
	
	
	
}
