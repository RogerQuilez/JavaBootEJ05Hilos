package main;

import hilos.HiloPrime;

public class Main {
	
	public static void main(String[] args) {
		
		//Primer Hilo
		HiloPrime hiloPrime = new HiloPrime();
		hiloPrime.setNumber(1233211231231232321L);
		Thread tPrime = new Thread(hiloPrime);
		
		//Segundo Hilo
		HiloPrime hiloPrime2 = new HiloPrime();
		hiloPrime2.setNumber(2);
		Thread tPrime2 = new Thread(hiloPrime2);
		
		//Tercer Hilo
		HiloPrime hiloPrime3 = new HiloPrime();
		hiloPrime3.setNumber(1233211231231232321L);
		Thread tPrime3 = new Thread(hiloPrime3);
		
		//Ejecutamos los hilos
		tPrime.start();
		tPrime2.start();
		tPrime3.start();
		
	}
}
