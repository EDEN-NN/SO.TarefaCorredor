package view;

import java.util.concurrent.Semaphore;

import controller.CorredorController;
import controller.PessoaController;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for(int id = 1; id < 5; id++) {
		//	System.out.println(pessoa.getCorredor());
			Thread t = new CorredorController(id, semaforo);
			t.start();
		}
	}

}
