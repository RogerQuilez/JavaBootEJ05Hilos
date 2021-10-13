package hilos;

import java.util.concurrent.TimeUnit;

public class HiloPrime implements Runnable {

	/**
	 * Atributo de la clase, será el número que queremos comprobar si es primo
	 */
	private long number;

	/**
	 * Este método se encargará de arrancar el hilo y comprobar si el número que nos han pasado es primo o no.
	 * Imprimirá el resultado de este por pantalla
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
			
			//TimeUnit nos permite pasar de nanosegundos a, en este caso, milisegundos
			System.out.println("El número " + this.number + " es Primo, el proceso ha durado: "
					+ TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " Milisegundos");

		} else {
			//En esto punto ya ha realizado la comprobación de si el número es primo y debemos capturar
			//los nanosegundos actuales para realizar la resta y saber la duración en nanosegundos
			//que ha tardado en realizar la comprobación
			endTime = System.nanoTime();
			
			//TimeUnit nos permite pasar de nanosegundos a, en este caso, milisegundos
			System.out.println("El número " + this.number + " no es Primo, el proceso ha durado: "
					+ TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " Milisegundos");
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

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

}
