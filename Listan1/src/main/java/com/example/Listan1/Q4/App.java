package com.example.Listan1.Q4;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pessoa[] pessoas = new Pessoa[3];

        // Cadastro das 3 pessoas
        for (int i = 0; i < 3; i++) {

            pessoas[i] = new Pessoa();

            System.out.println("Digite o nome da pessoa " + (i + 1) + ":");
            pessoas[i].nome = scanner.next();

            System.out.println("Digite a altura:");
            pessoas[i].altura = scanner.nextDouble();

            System.out.println("Digite o peso:");
            pessoas[i].peso = scanner.nextDouble();
        }

        // Exibição em ordem inversa
        System.out.println("\n--- DADOS DAS PESSOAS ---");

        for (int i = 2; i >= 0; i--) {

            System.out.println("Nome: " + pessoas[i].nome);
            System.out.println("Peso: " + pessoas[i].peso);
            System.out.println("Altura: " + pessoas[i].altura);
            System.out.println("IMC: " + pessoas[i].calcularIMC());
            System.out.println();
        }

        scanner.close();
    }
}