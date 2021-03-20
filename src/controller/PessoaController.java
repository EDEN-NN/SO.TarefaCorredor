package controller;

public class PessoaController {
	
	private int idPessoa;
	private int corredor;
	
	public PessoaController(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public void setId(int id) {
		this.idPessoa = id;
	}
	
	public int getId () {return idPessoa;}
	
	public void setCorredor (int corredor) {
		this.corredor = corredor;
	}
	
	public int getCorredor () {return corredor;}
	
}
