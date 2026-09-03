package com.example.Lista4;



public class App {
    public static void main(String[] args) {
        Funcionario[] funcionarios = {
            new Funcionario("Ana", 850.00),
            new Funcionario("Bruno", 2000.00),
            new Funcionario("Carla", 3000.00),
            new Funcionario("Diego", 4000.00),
            new Funcionario("Elisa", 5000.00)
        };

        for (Funcionario f : funcionarios) {
            System.out.printf(
                "Nome: %-10s Salário: R$ %-10.2f Faixa: %-10s Imposto: R$ %.2f%n",
                f.getNome(),
                f.getSalario(),
                f.identificarFaixaIrpf(),
                f.calcularIrpf()
            );
        }
    }
}
