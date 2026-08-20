package com.example.ExemploConstrutor;

public class Carro {
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAroPneu() {
		return aroPneu;
	}
	public void setAroPneu(int aroPneu) {
		this.aroPneu = aroPneu;
	}
	public int getCapacidadeTanque() {
		return capacidadeTanque;
	}
	public void setCapacidadeTanque(int capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	private String marca;
	private String modelo;
	private int aroPneu;
	private int capacidadeTanque;
	private String placa;
	private int velocidade;

}
