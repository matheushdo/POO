package com.example.ExemploDeJUnit;

public class Calculadora {
	public int somar(int a, int b) {
		return a+b;
		
	}
	
	public double multiplicar(double a,double b) {
		return a * b;
	}
	
	public int divisao(int a,int b) {
		if(b==0) {
			throw new IllegalArgumentException("Divisão por zero");
		}
		return a/b;
	}

}
