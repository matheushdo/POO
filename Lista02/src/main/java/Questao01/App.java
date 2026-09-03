package Questao01;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pessoa[] pessoas = new Pessoa[3];

        for (int i = 0; i < 3; i++) {

            pessoas[i] = new Pessoa();

            System.out.println("Digite os dados da " + (i + 1) + "ª pessoa:");

            System.out.print("Nome: ");
            pessoas[i].setNome(scanner.nextLine());

            System.out.print("Altura: ");
            pessoas[i].setAltura(scanner.nextDouble());

            System.out.print("Peso: ");
            pessoas[i].setPeso(scanner.nextDouble());

            scanner.nextLine();

            System.out.println();
        }

        System.out.println("===== PESSOAS =====");

        for (int i = 2; i >= 0; i--) {

            double imc = pessoas[i].getPeso() /
                    (pessoas[i].getAltura() * pessoas[i].getAltura());

            System.out.println("Nome: " + pessoas[i].getNome());
            System.out.println("Peso: " + pessoas[i].getPeso());
            System.out.println("Altura: " + pessoas[i].getAltura());
            System.out.printf("IMC: %.2f%n", imc);
            System.out.println();
        }

        scanner.close();
    }
}