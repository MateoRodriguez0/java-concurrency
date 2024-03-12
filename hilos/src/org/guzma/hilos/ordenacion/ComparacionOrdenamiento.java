package org.guzma.hilos.ordenacion;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ComparacionOrdenamiento {

	public static void main(String[] args) {
		Instant instant= Instant.now();
		System.out.println(instant);
		SecureRandom random=new SecureRandom();
		int [] array1= random.ints(1500000).toArray();
		int [] array2= new int[array1.length];
		System.out.println(Arrays.toString(array1));
		System.arraycopy(array1, 0, array2, 0, array1.length);
		
		//tiempo de ordenamiento del array 1 con el metodo sort de arrays
		instant= Instant.now();
		System.out.println(instant);
		Arrays.sort(array1);
		Instant sortEnd= Instant.now();
		System.out.println(sortEnd);
		Long mili=Duration.between(instant, sortEnd).getSeconds();
		System.out.println(mili);
		
		
		System.out.println("ordenamiento paralelo");
		
		
		instant= Instant.now();
		System.out.println(instant);
		Arrays.parallelSort(array1);
		sortEnd= Instant.now();
		System.out.println(sortEnd);
		
		mili=Duration.between(instant, sortEnd).getSeconds();
		System.out.println(mili);
		
	}
}
