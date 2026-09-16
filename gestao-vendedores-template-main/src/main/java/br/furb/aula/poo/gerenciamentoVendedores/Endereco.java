package br.furb.aula.poo.gerenciamentoVendedores;

public class Endereco {
	
	private String logradouro;
	private int numero;
	private String cep;
	
	public Endereco(String logradouro, int numero,String cep) {
		setLogradouro(logradouro);
		setNumero(numero);
		setCep(cep);
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		if(logradouro == null || logradouro.isBlank()) {
			throw new IllegalArgumentException("Logradouro invalido");
		}
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
			if(numero<=0) {
				throw new IllegalArgumentException("Numero invalido");
			}
		this.numero = numero;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		if(cep == null || cep.isBlank()) {
			throw new IllegalArgumentException("Cep invalido");
		}
		this.cep = cep;
	}


}
