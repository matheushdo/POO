package br.furb.aula.poo.gerenciamentoVendedores;

import java.util.ArrayList;

public class Loja {

	private String nome;

	private ArrayList<Vendedor> vendedores;

	public Loja(String nome) {

		setNome(nome);

		vendedores = new ArrayList<>();

	}

	public String getNome() {

		return nome;

	}

	public void setNome(String nome) {

		 if (nome == null || nome.isBlank()) {

	            throw new IllegalArgumentException("Nome invalido");

	        }

		this.nome = nome;

	}

	public void adicionarVendedor(Vendedor vendedor) {

		if(vendedor == null) {

			throw new IllegalArgumentException("Vendedor invalido");

		}

		vendedores.add(vendedor);

	}

	public void removerVendedor(Vendedor vendedor) {

		if(vendedor == null || vendedores.size()==0) {

			throw new IllegalArgumentException("Vendedor invalido");

		}

		vendedores.remove(vendedor);

	}

	public ArrayList<Vendedor>getVendedores(){

		return new ArrayList<>(vendedores);

	}

	public double calcularMediaComissao() {

		if(vendedores.size()==0) {

			return 0;

		}

		double somaComissoes=0;

		for(int i=0; i <vendedores.size(); i++) {

			Vendedor vendedor = vendedores.get(i);

			somaComissoes= somaComissoes + vendedor.calcularComissao();

		}

		return somaComissoes / vendedores.size();

	}

	public Vendedor vendedorMaiorVenda() {

		Vendedor maior = null;

		for(int i=0; i < vendedores.size();i++) {

			Vendedor vendedor = vendedores.get(i);

			if(maior == null || vendedor.getValorVendas() > maior.getValorVendas()) {

				maior = vendedor;

			}

		}

		return maior;

	}

	public double calcularFolhaPagamento() {

		double totalFolha = 0;

		for(int i = 0; i < vendedores.size(); i++) {

			Vendedor vendedor = vendedores.get(i);

			totalFolha = totalFolha + vendedor.calcularSalario();

		}

		return totalFolha;

	}



}