package org.guzma.hilos.ejemplos.timer;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class AgendartTareaTimer {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("Tarea realizada en "+LocalDateTime.now()+" pr el Thread"+Thread.currentThread().getName());
				timer.cancel();
			}
		},5000,4000);
		
		
		
	}
}
