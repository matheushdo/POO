package com.example.ExemploEncapsulamento;

public class ContaBancaria {

    private String titular;
    private double saldo;

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {
    	if(valor > saldo) {
    		throw new IllegalArgumentException("Saldo Insufuciente");
    	}
        saldo -= valor;
    }

    public void depositar(double valor) {
        saldo += valor;
    }
}