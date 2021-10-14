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
		Thread tPrime = getThread(listNumbers.get(0));
		
		//Segundo Hilo
		Thread tPrime2 = getThread(listNumbers.get(1));
		
		//Tercer Hilo
		Thread tPrime3 = getThread(listNumbers.get(2));
		
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
	
	/**
	 * 
	 * @param number -> Número contenido en la lista de números ofrecidos por el cliente
	 * @return -> Devuelve un hilo creado a partir del número que se le pasa por parámetro
	 */
	private static Thread getThread(Long number) {
		HiloPrime hiloPrime = new HiloPrime();
		hiloPrime.setNumber(number);
		return new Thread(hiloPrime.getThread());
	}
}
