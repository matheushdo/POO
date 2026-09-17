package com.example.Lista4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void testCaso1_FaixaPrimeira() {
        Funcionario f = new Funcionario("Teste", 850.00);
        assertEquals(FaixaIrpf.PRIMEIRA, f.identificarFaixaIrpf());
    }

    @Test
    void testCaso2_ImpostoPrimeiraFaixa() {
        Funcionario f = new Funcionario("Teste", 850.00);
        assertEquals(0.00, f.calcularIrpf());
    }

    @Test
    void testCaso3_FaixaSegunda() {
        Funcionario f = new Funcionario("Teste", 2000.00);
        assertEquals(FaixaIrpf.SEGUNDA, f.identificarFaixaIrpf());
    }

    @Test
    void testCaso4_ImpostoSegundaFaixa() {
        Funcionario f = new Funcionario("Teste", 2000.00);
        assertEquals(7.20, f.calcularIrpf());
    }

    @Test
    void testCaso5_FaixaTerceira() {
        Funcionario f = new Funcionario("Teste", 2826.66);
        assertEquals(FaixaIrpf.TERCEIRA, f.identificarFaixaIrpf());
    }

    @Test
    void testCaso6_ImpostoTerceiraFaixa_LimiteInferior() {
        Funcionario f = new Funcionario("Teste", 2826.66);
        assertEquals(69.20, f.calcularIrpf());
    }

    @Test
    void testCaso7_FaixaTerceira3000() {
        Funcionario f = new Funcionario("Teste", 3000.00);
        assertEquals(FaixaIrpf.TERCEIRA, f.identificarFaixaIrpf());
    }

    @Test
    void testCaso8_ImpostoTerceiraFaixa3000() {
        Funcionario f = new Funcionario("Teste", 3000.00);
        assertEquals(95.20, f.calcularIrpf());
    }

    @Test
    void testCaso9_FaixaQuarta() {
        Funcionario f = new Funcionario("Teste", 4000.00);
        assertEquals(FaixaIrpf.QUARTA, f.identificarFaixaIrpf());
    }

    @Test
    void testCaso10_ImpostoQuartaFaixa() {
        Funcionario f = new Funcionario("Teste", 4000.00);
        assertEquals(263.87, f.calcularIrpf());
    }

    @Test
    void testCaso11_FaixaQuinta() {
        Funcionario f = new Funcionario("Teste", 5000.00);
        assertEquals(FaixaIrpf.QUINTA, f.identificarFaixaIrpf());
    }

    @Test
    void testCaso12_ImpostoQuintaFaixa() {
        Funcionario f = new Funcionario("Teste", 5000.00);
        assertEquals(505.64, f.calcularIrpf());
    }

    @Test
    void testCaso13_SalarioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Funcionario("Teste", -100.00);
        });
    }
}