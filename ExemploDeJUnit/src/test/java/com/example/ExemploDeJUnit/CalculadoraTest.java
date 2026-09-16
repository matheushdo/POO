package com.example.ExemploDeJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    void testSomar() {
        Calculadora c = new Calculadora();

        int valor1 = 32;
        int valor2 = 10;

        int esperado = 42;
        int resultado = c.somar(valor1, valor2);

        assertEquals(esperado, resultado);
    }

    @Test
    void TestMutiplicar() {
        Calculadora c = new Calculadora();

        double valor1 = 1.0;
        double valor2 = 2.0;

        double resultado = c.multiplicar(valor1, valor2);

        double esperado = 2.0;
        double tolerancia = 0;

        assertEquals(esperado, resultado, tolerancia);
    }

    @Test
    void TestDividirPorZero() {
        Calculadora c = new Calculadora();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            int a = 42;
            int b = 0;

            c.divisao(a, b);
        });
        String esperado = "Divisão por 0";
        assertEquals(esperado,ex.getMessage());
    }

    @Test
    void TestDividir() {
        Calculadora c = new Calculadora();

        int valor1 = 1;
        int valor2 = 1;

        double resultado = c.divisao(valor1, valor2);

        double esperado = 1;
        double tolerancia = 0;

        assertEquals(esperado, resultado, tolerancia);
    }
}