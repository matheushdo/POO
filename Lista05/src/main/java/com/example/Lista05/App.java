package com.example.Lista05;

public class App {

    public static void main(String[] args) {

        Bairro bairro = new Bairro();

        bairro.setNome("Centro");
        bairro.setCoeficienteIptu(2.5);

        Imovel imovel = new Imovel("Rua XV de Novembro", 420);

        imovel.setBairro(bairro);
        imovel.setFinalidade(Finalidade.RESIDENCIAL);

        System.out.println("Endereço: " + imovel.getEndereco());
        System.out.println("Área: " + imovel.getArea());
        System.out.println("Bairro: " + imovel.getBairro().getNome());
        System.out.println("Finalidade: " + imovel.getFinalidade());
        System.out.println("IPTU: R$ " + imovel.calcularIptu());

    }

}