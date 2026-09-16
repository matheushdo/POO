package com.example.ExemploAssociacao1;

public class Veiculo {
private String modelo;
private String marca;
private Pessoa motorista;

public Pessoa getMotorista() {
	return motorista;
}

public void setMotorista(Pessoa motorista) {
	this.motorista = motorista;
}

public Veiculo(String modelo, String marca) {
	setModelo(modelo);
	setMarca(marca);
	setMotorista(motorista);
	
}

public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}


}
