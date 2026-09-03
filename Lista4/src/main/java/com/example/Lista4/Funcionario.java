package com.example.Lista4;

public class Funcionario {

    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        setSalario(salario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que Zero");
        }
        this.salario = salario;
    }

    public FaixaIrpf identificarFaixaIrpf() {
        if (salario <= 1903.98) {
            return FaixaIrpf.PRIMEIRA;
        } else if (salario <= 2826.65) {
            return FaixaIrpf.SEGUNDA;
        } else if (salario <= 3751.05) {
            return FaixaIrpf.TERCEIRA;
        } else if (salario <= 4664.68) {
            return FaixaIrpf.QUARTA;
        } else {
            return FaixaIrpf.QUINTA;
        }
    }

    public double calcularIrpf() {
        double imposto = 0.0;
        FaixaIrpf faixa = identificarFaixaIrpf();

        if (faixa == FaixaIrpf.PRIMEIRA) {
            return 0.0;
        }

        // 2ª faixa
        double limiteFaixa1 = 1903.98;
        double limiteFaixa2 = 2826.65;
        if (faixa == FaixaIrpf.SEGUNDA) {
            imposto += (salario - limiteFaixa1) * 0.075;
            return arredondar(imposto);
        }
        imposto += (limiteFaixa2 - limiteFaixa1) * 0.075;

        // 3ª faixa
        double limiteFaixa3 = 3751.05;
        if (faixa == FaixaIrpf.TERCEIRA) {
            imposto += (salario - limiteFaixa2) * 0.15;
            return arredondar(imposto);
        }
        imposto += (limiteFaixa3 - limiteFaixa2) * 0.15;

        // 4ª faixa
        double limiteFaixa4 = 4664.68;
        if (faixa == FaixaIrpf.QUARTA) {
            imposto += (salario - limiteFaixa3) * 0.225;
            return arredondar(imposto);
        }
        imposto += (limiteFaixa4 - limiteFaixa3) * 0.225;

        // 5ª faixa
        imposto += (salario - limiteFaixa4) * 0.275;
        return arredondar(imposto);
    }

    private double arredondar(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}
