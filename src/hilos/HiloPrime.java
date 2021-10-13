package hilos;

import java.util.concurrent.TimeUnit;

public class HiloPrime implements Runnable {

	/**
	 * Atributo de la clase, ser� el n�mero que queremos comprobar si es primo
	 */
	private long number;

	/**
	 * Este m�todo se encargar� de arrancar el hilo y comprobar si el n�mero que nos han pasado es primo o no e
	 * imprimir� el resultado de este por pantalla
	 */
	@Override
	public void run() {

		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());

		//Capturamos los nanoSegundos actuales de cuando se inicia la tarea
		long startTime = System.nanoTime();
		long endTime;

		if (this.isPrimeNumber()) {
			//En esto punto ya ha realizado la comprobaci�n de si el n�mero es primo y debemos capturar
			//los nanosegundos actuales para realizar la resta y saber la duraci�n en nanosegundos
			//que ha tardado en realizar la comprobaci�n
			endTime = System.nanoTime();
			
			System.out.println(getMessage(startTime, endTime, "es Primo"));

		} else {
			//En esto punto ya ha realizado la comprobaci�n de si el n�mero es primo y debemos capturar
			//los nanosegundos actuales para realizar la resta y saber la duraci�n en nanosegundos
			//que ha tardado en realizar la comprobaci�n
			endTime = System.nanoTime();
			
			System.out.println(getMessage(startTime, endTime, "No es Primo"));
		}
	}

	/**
	 * 
	 * @return -> Devuelve true en caso de que el numero sea primo o false en caso contrario
	 */
	public boolean isPrimeNumber() {

		//Si el n�mero es menor a dos no puede ser primo
		if (this.number < 2) 
			return false;

		//Recorre desde el n�mero 2 hasta el n�mero que queremos averiguar si es primo, en caso de que 
		//la divisi�n entre el n�mero y el iterador de como residuo 0, significar� que el n�mero no es primo
		for (int i = 2; i * i <= this.number; i++) {
			if (this.number % i == 0)
				return false;
			
		}
		
		return true;
	}
	
	/**
	 * Devuelve el resultado en milisegundos y indicando si el n�mero es primo o no
	 * @param startTime
	 * @param endTime
	 * @param message
	 * @return
	 */
	public String getMessage(long startTime, long endTime, String message) {
		
		return "El n�mero " + this.number + " " + message + ", el proceso ha durado: "
				+ TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " Milisegundos";
		
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

}
