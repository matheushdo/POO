package com.example.Lista05;

/**
 * Representa um imóvel que possui endereço, área, bairro e finalidade.
 */
public class Imovel {

    private String endereco;
    private int area;
    private Bairro bairro;
    private Finalidade finalidade;

    /**
     * Construtor vazio para criar um imóvel sem definir seus dados inicialmente.
     */
    public Imovel() {
    }

    /**
     * Construtor que cria um imóvel informando endereço e área.
     *
     * @param endereco endereço do imóvel
     * @param area área do imóvel em metros quadrados
     */
    public Imovel(String endereco, int area) {

        setEndereco(endereco);
        setArea(area);

    }

    /**
     * Retorna o endereço do imóvel.
     *
     * @return endereço do imóvel
     */
    public String getEndereco() {

        return endereco;

    }

    /**
     * Define o endereço do imóvel.
     *
     * @param endereco endereço do imóvel
     */
    public void setEndereco(String endereco) {

        this.endereco = endereco;

    }

    /**
     * Retorna a área do imóvel.
     *
     * @return área do imóvel em metros quadrados
     */
    public int getArea() {

        return area;

    }

    /**
     * Define a área do imóvel.
     *
     * @param area área do imóvel em metros quadrados
     * @throws IllegalArgumentException se a área for negativa
     */
    public void setArea(int area) {

        if (area < 0) {

            throw new IllegalArgumentException("A área não pode ser negativa.");

        }

        this.area = area;

    }

    /**
     * Retorna o bairro do imóvel.
     *
     * @return bairro do imóvel
     */
    public Bairro getBairro() {

        return bairro;

    }

    /**
     * Define o bairro do imóvel.
     *
     * @param bairro bairro do imóvel
     */
    public void setBairro(Bairro bairro) {

        this.bairro = bairro;

    }

    /**
     * Retorna a finalidade do imóvel.
     *
     * @return finalidade do imóvel
     */
    public Finalidade getFinalidade() {

        return finalidade;

    }

    /**
     * Define a finalidade do imóvel.
     *
     * @param finalidade finalidade do imóvel
     */
    public void setFinalidade(Finalidade finalidade) {

        this.finalidade = finalidade;

    }

    /**
     * Calcula o valor do IPTU do imóvel de acordo com sua área,
     * finalidade e coeficiente do bairro.
     *
     * @return valor do IPTU
     * @throws IllegalArgumentException se a área não estiver definida,
     * o bairro não estiver definido ou a finalidade não estiver definida
     */
    public double calcularIptu() {

        if (area == 0) {

            throw new IllegalArgumentException("A área não foi definida.");

        }

        if (bairro == null) {

            throw new IllegalArgumentException("O imóvel não possui bairro definido.");

        }

        if (bairro.getCoeficienteIptu() < 0) {

            throw new IllegalArgumentException("O coeficiente do IPTU não pode ser negativo.");

        }

        if (finalidade == null) {

            throw new IllegalArgumentException("O imóvel não possui finalidade definida.");

        }

        double valorIptu = 0;

        if (finalidade == Finalidade.RESIDENCIAL) {

            valorIptu = area * 1.00;

        } else if (finalidade == Finalidade.COMERCIAL) {

            if (area <= 100) {

                valorIptu = 500.00;

            } else if (area <= 400) {

                valorIptu = 1000.00;

            } else {

                valorIptu = area * 2.55;

            }

        } else if (finalidade == Finalidade.INDUSTRIAL) {

            if (area <= 2000) {

                valorIptu = 1000.00;

            } else {

                valorIptu = area * 0.55;

            }

        }

        return valorIptu * bairro.getCoeficienteIptu();

    }

}