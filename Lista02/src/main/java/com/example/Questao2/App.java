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

        

        System.out.print("\nValor do 1º depósito na 1ª conta: R$ ");
        double deposito1Conta1 = scanner.nextDouble();

        conta1.depositar(deposito1Conta1);

        System.out.print("Valor do 2º depósito na 1ª conta: R$ ");
        double deposito2Conta1 = scanner.nextDouble();

        conta1.depositar(deposito2Conta1);

        

        System.out.print("Valor do depósito na 2ª conta: R$ ");
        double depositoConta2 = scanner.nextDouble();

        conta2.depositar(depositoConta2);

        

        System.out.print("Valor do saque na 2ª conta: R$ ");
        double saqueConta2 = scanner.nextDouble();

        conta2.sacar(saqueConta2);

        

        System.out.print("Valor da transferência da 2ª conta para a 1ª conta: R$ ");
        double valorTransferencia = scanner.nextDouble();

        conta2.transferir(conta1, valorTransferencia);

        

        System.out.println("\n--- Resumo das contas ---");

        System.out.printf(
                "Titular: %s | Saldo: R$ %.2f%n",
                conta1.getTitular(),
                conta1.getSaldo()
        );

        System.out.printf(
                "Titular: %s | Saldo: R$ %.2f%n",
                conta2.getTitular(),
                conta2.getSaldo()
        );

        scanner.close();
    }
}