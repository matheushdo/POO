package com.example.Questao2;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dados da 1ª conta:");
        System.out.print("Número: ");
        String numero1 = scanner.nextLine();
        System.out.print("Titular: ");
        String titular1 = scanner.nextLine();
        ContaBancaria conta1 = new ContaBancaria(numero1, titular1);

        System.out.println("\nDados da 2ª conta:");
        System.out.print("Número: ");
        String numero2 = scanner.nextLine();
        System.out.print("Titular: ");
        String titular2 = scanner.nextLine();
        ContaBancaria conta2 = new ContaBancaria(numero2, titular2);

        // a. Depósitos na primeira conta
        conta1.depositar(1000.00);
        conta1.depositar(700.00);

        // b. Depósito na segunda conta
        conta2.depositar(5000.00);

        // c. Saque na 2ª conta
        conta2.sacar(3000.00);

        // d. Transferência da 2ª conta para a 1ª conta
        conta2.transferir(conta1, 1800.00);

        // e. Exibição do titular e saldo de cada conta
        System.out.println("\n--- Resumo das contas ---");
        System.out.printf("Titular: %s | Saldo: R$ %.2f%n", conta1.getTitular(), conta1.getSaldo());
        System.out.printf("Titular: %s | Saldo: R$ %.2f%n", conta2.getTitular(), conta2.getSaldo());

        scanner.close();
    }
}