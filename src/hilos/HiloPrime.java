package hilos;

import java.util.concurrent.TimeUnit;

public class HiloPrime {

	/**
	 * Atributo de la clase, será el número que queremos comprobar si es primo
	 */
	private long number;

	/**
	 * Este método se encargará de arrancar el hilo y comprobar si el número que nos han pasado es primo o no e
	 * imprimirá el resultado de este por pantalla
	 */
	private Runnable thread = () -> {
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());

		//Capturamos los nanoSegundos actuales de cuando se inicia la tarea
		long startTime = System.nanoTime();

		if (this.isPrimeNumber()) {
			System.out.println(getMessage(startTime, "Es Primo"));

		} else {
			System.out.println(getMessage(startTime, "No es Primo"));
		}
	};

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
	 * @param startTime -> Parametro que indica cuando ha empezado la ejecución del hilo
	 * @param message -> String que indica si el número es primo o no
	 * @return
	 */
	public String getMessage(long startTime, String message) {
		
		return "El número " + this.number + " " + message + ", el proceso ha durado: "
				+ TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime) + " Microsegundos";
		
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public Runnable getThread() {
		return thread;
	}

	public void setThread(Runnable runHilo) {
		this.thread = runHilo;
	}
	
}
