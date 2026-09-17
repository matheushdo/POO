package com.example.Lista4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FuncionarioTest {

	@Test
	void verificarImpostoSalario3000() {
		Funcionario f = new Funcionario("Cleir", 3000);
		
		double esperado = 95.2;
		double tolerancia = 0.009;
		
		double resultado = f.calcularIrpf();
		assertEquals(esperado,resultado,tolerancia);
	}

}
