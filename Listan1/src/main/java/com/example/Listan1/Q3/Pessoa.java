package com.example.Listan1.Q3;

public class Pessoa {

    public double peso;
    public double altura;

    public double calcularIMC() {
        double resultado = peso / (altura * altura);

        return resultado;
    }
}