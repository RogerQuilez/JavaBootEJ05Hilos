package hilos;

import java.util.concurrent.TimeUnit;

public class HiloPrime implements Runnable {

	/**
	 * Atributo de la clase, será el número que queremos comprobar si es primo
	 */
	private long number;

	/**
	 * Este método se encargará de arrancar el hilo y comprobar si el número que nos han pasado es primo o no e
	 * imprimirá el resultado de este por pantalla
	 */
	@Override
	public void run() {

		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());

		//Capturamos los nanoSegundos actuales de cuando se inicia la tarea
		long startTime = System.nanoTime();
		long endTime;

		if (this.isPrimeNumber()) {
			//En esto punto ya ha realizado la comprobación de si el número es primo y debemos capturar
			//los nanosegundos actuales para realizar la resta y saber la duración en nanosegundos
			//que ha tardado en realizar la comprobación
			endTime = System.nanoTime();
			
			System.out.println(getMessage(startTime, endTime, "es Primo"));

		} else {
			//En esto punto ya ha realizado la comprobación de si el número es primo y debemos capturar
			//los nanosegundos actuales para realizar la resta y saber la duración en nanosegundos
			//que ha tardado en realizar la comprobación
			endTime = System.nanoTime();
			
			System.out.println(getMessage(startTime, endTime, "No es Primo"));
		}
	}

	/**
	 * 
	 * @return -> Devuelve true en caso de que el numero sea primo o false en caso contrario
	 */
	public boolean isPrimeNumber() {

		//Si el número es menor a dos no puede ser primo
		if (this.number < 2) 
			return false;

		//Recorre desde el número 2 hasta el número que queremos averiguar si es primo, en caso de que 
		//la división entre el número y el iterador de como residuo 0, significará que el número no es primo
		for (int i = 2; i * i <= this.number; i++) {
			if (this.number % i == 0)
				return false;
			
		}
		
		return true;
	}
	
	/**
	 * Devuelve el resultado en milisegundos y indicando si el número es primo o no
	 * @param startTime
	 * @param endTime
	 * @param message
	 * @return
	 */
	public String getMessage(long startTime, long endTime, String message) {
		
		return "El número " + this.number + " " + message + ", el proceso ha durado: "
				+ TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " Milisegundos";
		
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

}
