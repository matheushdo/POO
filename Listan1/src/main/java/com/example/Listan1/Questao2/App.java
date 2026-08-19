package com.example.Listan1.Questao2;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Pessoa p = new Pessoa();
		
		System.out.println("Digite sua altura: ");
		p.altura = scanner.nextDouble();
		
		System.out.println("Digite o seu peso: ");
		p.peso = scanner.nextDouble();
		
		System.out.println("Seu imc é: " + p.calcularIMC());
		
		scanner.close();
		
		
	}

}
