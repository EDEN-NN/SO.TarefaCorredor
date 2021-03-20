package controller;

import java.util.concurrent.Semaphore;

import controller.PessoaController;

public class CorredorController extends Thread{
	
	private static int pos = 0;
	private int corredor = 200;
	private int idPessoa;
	Semaphore semaforo;
	
	public CorredorController (int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	
	@Override
	public void run() {
		caminhar();
		try {
			semaforo.acquire();
			cruzarPorta();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			semaforo.release();
		}
	}
	
	private void caminhar() {
		int andar = (int) ((Math.random() * 2) + 5);
		PessoaController pessoa = new PessoaController(idPessoa);
		pessoa.setCorredor((int) ((Math.random() * 99) + 1));
		while(corredor - andar > 0) {
			System.out.println("A pessoa " + pessoa.getId() + " andou: " + andar + " metros pelo corredor " + pessoa.getCorredor() + ", faltam " + (corredor -= andar) + " metros \n");
			andar = (int) ((Math.random() * 2) + 5);
		}
		pos++;
		System.out.println("A pessoa "+ pessoa.getId() + " foi a " + pos + " a chegar a porta pelo corredor " + pessoa.getCorredor() + " \n");
	}
	
	private void cruzarPorta() {
		PessoaController pessoa = new PessoaController(idPessoa);
		int temp = (int) ((Math.random() * 1000) + 1000);
		try {
			sleep(temp);
			System.out.println("A pessoa " + pessoa.getId() + " levou " + (double) temp/1000 + " segundos para abrir e cruzar a porta. \n");
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
}
