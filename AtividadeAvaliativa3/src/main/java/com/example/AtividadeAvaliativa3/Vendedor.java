package br.furb.aula.poo.gerenciamentoVendedores;


public class Vendedor {
	
	private String nome;
	private double salarioBase;
	private double valorVendas;
	private Endereco endereco;
	
	public Vendedor(String nome, double salarioBase, double valorVendas, Endereco endereco) {
		setNome(nome);
		setSalarioBase(salarioBase);
		setValorVendas(valorVendas);
		setEndereco(endereco);

		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome==null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome invalido");
		}
		this.nome = nome;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		if(salarioBase<1412.00) {
			throw new IllegalArgumentException("salarioBase invalido");
		}
		this.salarioBase = salarioBase;
	}
	public double getValorVendas() {
		return valorVendas;
	}
	public void setValorVendas(double valorVendas) {
		if(valorVendas <0) {
			throw new IllegalArgumentException("valorVendas invalido");
		}
		this.valorVendas = valorVendas;
	}
	
	public Endereco getEndereco() {

		return endereco;

	}

	public void setEndereco(Endereco endereco) {

		if(endereco == null) {

			throw new IllegalArgumentException("Endereco invalido");

		}

		this.endereco = endereco;

	}
	
	public double calcularComissao() {
		return valorVendas * 0.10;
	}
	public double calcularSalario() {
		return calcularComissao() + salarioBase;
	}
	
	
	

}
