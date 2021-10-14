package hilos;

import java.util.concurrent.TimeUnit;

public class HiloPrime {

	/**
	 * Atributo de la clase, ser� el n�mero que queremos comprobar si es primo
	 */
	private long number;

	/**
	 * Este m�todo se encargar� de arrancar el hilo y comprobar si el n�mero que nos han pasado es primo o no e
	 * imprimir� el resultado de este por pantalla
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
	 * @param startTime -> Parametro que indica cuando ha empezado la ejecuci�n del hilo
	 * @param message -> String que indica si el n�mero es primo o no
	 * @return
	 */
	public String getMessage(long startTime, String message) {
		
		return "El n�mero " + this.number + " " + message + ", el proceso ha durado: "
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
