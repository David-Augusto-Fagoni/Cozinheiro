package View;
import java.util.concurrent.Semaphore;

import Controller.Pratos;

public class Principal {

	public static void main(String[] args) {
			
		Semaphore Semaforo = new Semaphore(1);
		for (int J = 1;J<=5;J++)
		{
			Pratos pratos = new Pratos(J,Semaforo);
			
			pratos.start();
		}
	}

}
