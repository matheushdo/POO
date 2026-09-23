package com.example.Lista05;

import junit.framework.TestCase;

/**
 * Classe de testes da classe Imovel.
 */
public class ImovelTest extends TestCase {

    /**
     * Testa se não é permitido definir uma área negativa.
     */
    public void testAreaNegativa() {

        Imovel imovel = new Imovel();

        try {

            imovel.setArea(-5);

            fail("Deveria lançar IllegalArgumentException");

        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Testa se o cálculo do IPTU lança exceção quando
     * a área não foi definida.
     */
    public void testCalcularIptuSemArea() {

        Bairro bairro = new Bairro();

        bairro.setNome("Centro");
        bairro.setCoeficienteIptu(1);

        Imovel imovel = new Imovel();

        imovel.setBairro(bairro);
        imovel.setFinalidade(Finalidade.RESIDENCIAL);

        try {

            imovel.calcularIptu();

            fail("Deveria lançar IllegalArgumentException");

        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Testa se o cálculo do IPTU lança exceção quando
     * a finalidade não foi definida.
     */
    public void testCalcularIptuSemFinalidade() {

        Bairro bairro = new Bairro();

        bairro.setNome("Centro");
        bairro.setCoeficienteIptu(1);

        Imovel imovel = new Imovel();

        imovel.setBairro(bairro);
        imovel.setArea(250);

        try {

            imovel.calcularIptu();

            fail("Deveria lançar IllegalArgumentException");

        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Testa se o cálculo do IPTU lança exceção quando
     * o bairro não foi definido.
     */
    public void testCalcularIptuSemBairro() {

        Imovel imovel = new Imovel();

        imovel.setArea(400);
        imovel.setFinalidade(Finalidade.RESIDENCIAL);

        try {

            imovel.calcularIptu();

            fail("Deveria lançar IllegalArgumentException");

        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Testa o cálculo do IPTU para um imóvel residencial.
     */
    public void testIptuResidencial() {

        Bairro bairro = new Bairro();

        bairro.setCoeficienteIptu(1);

        Imovel imovel = new Imovel();

        imovel.setBairro(bairro);
        imovel.setArea(400);
        imovel.setFinalidade(Finalidade.RESIDENCIAL);

        assertEquals(400.0, imovel.calcularIptu(), 0.001);
    }

    /**
     * Testa o cálculo do IPTU comercial para área
     * menor ou igual a 100 metros quadrados.
     */
    public void testIptuComercialAte100() {

        Bairro bairro = new Bairro();

        bairro.setCoeficienteIptu(1);

        Imovel imovel = new Imovel();

        imovel.setBairro(bairro);
        imovel.setArea(80);
        imovel.setFinalidade(Finalidade.COMERCIAL);

        assertEquals(500.0, imovel.calcularIptu(), 0.001);
    }

    /**
     * Testa o cálculo do IPTU comercial para área
     * entre 100 e 400 metros quadrados.
     */
    public void testIptuComercialEntre100E400() {

        Bairro bairro = new Bairro();

        bairro.setCoeficienteIptu(1);

        Imovel imovel = new Imovel();

        imovel.setBairro(bairro);
        imovel.setArea(250);
        imovel.setFinalidade(Finalidade.COMERCIAL);

        assertEquals(1000.0, imovel.calcularIptu(), 0.001);
    }

    /**
     * Testa o cálculo do IPTU comercial para área
     * maior que 400 metros quadrados.
     */
    public void testIptuComercialAcima400() {

        Bairro bairro = new Bairro();

        bairro.setCoeficienteIptu(1);

        Imovel imovel = new Imovel();

        imovel.setBairro(bairro);
        imovel.setArea(500);
        imovel.setFinalidade(Finalidade.COMERCIAL);

        assertEquals(1275.0, imovel.calcularIptu(), 0.001);
    }

    /**
     * Testa o cálculo do IPTU industrial para área
     * menor ou igual a 2000 metros quadrados.
     */
    public void testIptuIndustrialAte2000() {

        Bairro bairro = new Bairro();

        bairro.setCoeficienteIptu(1);

        Imovel imovel = new Imovel();

        imovel.setBairro(bairro);
        imovel.setArea(2000);
        imovel.setFinalidade(Finalidade.INDUSTRIAL);

        assertEquals(1000.0, imovel.calcularIptu(), 0.001);
    }

    /**
     * Testa o cálculo do IPTU industrial para área
     * maior que 2000 metros quadrados.
     */
    public void testIptuIndustrialAcima2000() {

        Bairro bairro = new Bairro();

        bairro.setCoeficienteIptu(1);

        Imovel imovel = new Imovel();

        imovel.setBairro(bairro);
        imovel.setArea(3000);
        imovel.setFinalidade(Finalidade.INDUSTRIAL);

        assertEquals(1650.0, imovel.calcularIptu(), 0.001);
    }

    /**
     * Testa o cálculo do IPTU residencial utilizando
     * um coeficiente de bairro igual a 2.5.
     */
    public void testIptuComCoeficiente25() {

        Bairro bairro = new Bairro();

        bairro.setCoeficienteIptu(2.5);

        Imovel imovel = new Imovel();

        imovel.setBairro(bairro);
        imovel.setArea(500);
        imovel.setFinalidade(Finalidade.RESIDENCIAL);

        assertEquals(1250.0, imovel.calcularIptu(), 0.001);
    }
}