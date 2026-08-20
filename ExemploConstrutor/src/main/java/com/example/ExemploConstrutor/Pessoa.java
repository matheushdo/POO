package com.example.ExemploConstrutor;

public class Pessoa {

    private String nome;

    private int idade;

    public Pessoa(String nome, int idade) {

        setNome(nome);
        setIdade(idade);

    }

    public void setNome(String nome) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {

        if (idade < 0) {
            throw new IllegalArgumentException("Idade inválida");
        }

        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }
}