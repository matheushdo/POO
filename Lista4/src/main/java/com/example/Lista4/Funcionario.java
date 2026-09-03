package com.example.Lista4;

public class Funcionario {

    private static final double FAIXA_1_LIMITE_SUP = 1903.98;
    private static final double FAIXA_2_LIMITE_INF = 1903.99;
    private static final double FAIXA_2_LIMITE_SUP = 2826.65;
    private static final double FAIXA_3_LIMITE_INF = 2826.66;
    private static final double FAIXA_3_LIMITE_SUP = 3751.05;
    private static final double FAIXA_4_LIMITE_INF = 3751.06;
    private static final double FAIXA_4_LIMITE_SUP = 4664.68;
    private static final double FAIXA_5_LIMITE_INF = 4664.69;

    private static final double ALIQUOTA_FAIXA_2 = 0.075;
    private static final double ALIQUOTA_FAIXA_3 = 0.15;
    private static final double ALIQUOTA_FAIXA_4 = 0.225;
    private static final double ALIQUOTA_FAIXA_5 = 0.275;

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

        if (salario <= FAIXA_1_LIMITE_SUP) {
            return FaixaIrpf.PRIMEIRA;

        } else if (salario <= FAIXA_2_LIMITE_SUP) {
            return FaixaIrpf.SEGUNDA;

        } else if (salario <= FAIXA_3_LIMITE_SUP) {
            return FaixaIrpf.TERCEIRA;

        } else if (salario <= FAIXA_4_LIMITE_SUP) {
            return FaixaIrpf.QUARTA;

        } else {
            return FaixaIrpf.QUINTA;
        }
    }

    public double calcularIrpf() {

        double imposto = 0.0;

        FaixaIrpf faixa = identificarFaixaIrpf();

        // 2ª faixa
        if (faixa == FaixaIrpf.SEGUNDA) {

            imposto += (salario - FAIXA_1_LIMITE_SUP)
                    * ALIQUOTA_FAIXA_2;
        }

        // 3ª faixa
        else if (faixa == FaixaIrpf.TERCEIRA) {

            imposto += (FAIXA_2_LIMITE_SUP - FAIXA_1_LIMITE_SUP)
                    * ALIQUOTA_FAIXA_2;

            imposto += (salario - FAIXA_2_LIMITE_SUP)
                    * ALIQUOTA_FAIXA_3;
        }

        // 4ª faixa
        else if (faixa == FaixaIrpf.QUARTA) {

            imposto += (FAIXA_2_LIMITE_SUP - FAIXA_1_LIMITE_SUP)
                    * ALIQUOTA_FAIXA_2;

            imposto += (FAIXA_3_LIMITE_SUP - FAIXA_2_LIMITE_SUP)
                    * ALIQUOTA_FAIXA_3;

            imposto += (salario - FAIXA_3_LIMITE_SUP)
                    * ALIQUOTA_FAIXA_4;
        }

        // 5ª faixa
        else if (faixa == FaixaIrpf.QUINTA) {

            imposto += (FAIXA_2_LIMITE_SUP - FAIXA_1_LIMITE_SUP)
                    * ALIQUOTA_FAIXA_2;

            imposto += (FAIXA_3_LIMITE_SUP - FAIXA_2_LIMITE_SUP)
                    * ALIQUOTA_FAIXA_3;

            imposto += (FAIXA_4_LIMITE_SUP - FAIXA_3_LIMITE_SUP)
                    * ALIQUOTA_FAIXA_4;

            imposto += (salario - FAIXA_4_LIMITE_SUP)
                    * ALIQUOTA_FAIXA_5;
        }

        return Math.round(imposto * 100.0) / 100.0;
    }
}