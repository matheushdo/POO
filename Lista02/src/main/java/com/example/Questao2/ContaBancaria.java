package com.example.Questao2;

public class ContaBancaria {

    private String numero;
    private String titular;
    private double saldo;

    public ContaBancaria(String numero, String titular) {

        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {

        if (valor < 0) {
            System.out.println("Erro: não é possível depositar um valor negativo.");
            return;
        }

        saldo += valor;
    }

    public void sacar(double valor) {

        if (valor < 0) {
            System.out.println("Erro: não é possível sacar um valor negativo.");
            return;
        }

        if (valor > saldo) {
            System.out.println("Erro: saldo insuficiente para realizar o saque.");
            return;
        }

        saldo -= valor;
    }

    public void transferir(ContaBancaria contaDestino, double valor) {

        if (valor < 0) {
            System.out.println("Erro: não é possível transferir um valor negativo.");
            return;
        }

        if (valor > saldo) {
            System.out.println("Erro: saldo insuficiente para realizar a transferência.");
            return;
        }

        this.sacar(valor);
        contaDestino.depositar(valor);
    }
}