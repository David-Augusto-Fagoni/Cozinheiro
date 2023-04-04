package Controller;

import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class Pratos extends Thread {
	private int Num;
	private Semaphore semaforo;
	public Pratos (int Num, Semaphore semaforo) {
		this.Num = Num;
		this.semaforo = semaforo;
	}
	public void run () {
		double Temp;
		String nome;
		if (Num % 2 == 0) {
			nome = "Lasanha de Bolonhesa";
			System.out.println("O cozinheiro colocou o prato "+ nome +" N"+Num +" para cozinhar.");
				Temp =  (int)(Math.random()*7+6);
		}else {
			nome = "Sopa de Cebola";
			System.out.println("O cozinheiro colocou o prato "+ nome +" N"+Num +" para cozinhar.");
				Temp =  (int) (Math.random()*4+5);
		}
		
		Cozinha(Temp,nome);
	}
	public void Cozinha (double temp, String nome) {
		double TempA = 0;
		temp = temp/10;
		double Tot=0;
		while (TempA < temp) {
			Tot = (float) (Tot + ((0.1/temp)));
			if (Tot >= 1) {
				break;
			}else {
				System.out.println("O prato "+nome+" N"+ Num +" esta "+Tot*100+"% completo");
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				
				}
				TempA = TempA + 0.1;
			}
		}
		System.out.println("O prato "+nome+" N"+ Num +" esta completo");
		try {
			semaforo.acquire();
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			System.out.println("O jogador entregou o prato "+nome+" N"+Num);
			semaforo.release();
		}
	}
}