package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import hilos.HiloPrime;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		List<Long> listNumbers = getNumbers();
		
		//Primer Hilo
		HiloPrime hiloPrime = new HiloPrime();
		hiloPrime.setNumber(listNumbers.get(0));
		Thread tPrime = new Thread(hiloPrime);
		
		//Segundo Hilo
		HiloPrime hiloPrime2 = new HiloPrime();
		hiloPrime2.setNumber(listNumbers.get(1));
		Thread tPrime2 = new Thread(hiloPrime2);
		
		//Tercer Hilo
		HiloPrime hiloPrime3 = new HiloPrime();
		hiloPrime3.setNumber(listNumbers.get(2));
		Thread tPrime3 = new Thread(hiloPrime3);
		
		//Ejecutamos los hilos
		tPrime.start();
		tPrime2.start();
		tPrime3.start();
		
	}

	/**
	 * 
	 * @return -> Devuelve una lista con todos los números introducidos por el usuario
	 */
	private static List<Long> getNumbers() {
		List<Long> listNumbers = new LinkedList<>();
		do {
			
			System.out.println("Introduce un número para saber si es primo: " + 
					((listNumbers.size()) + 1) + "/3");
			listNumbers.add(Long.parseLong(Main.sc.nextLine()));
			
		} while(listNumbers.size() < 3);
		
		return listNumbers;
	}
}
