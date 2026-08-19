package com.example.primeiro;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Carro c = new Carro();
    	c.marca = "BYD";
    	c.kmRodado = 1000;
    	
    	System.out.println("Marca: " + c.marca +  " Km Rodado: " + c.kmRodado );
    	c.andar(500);
    	System.out.println("Km rodado " + c.kmRodado);
    	 
    	Cachorro a = new Cachorro();
    	    a.nome = "Amora";
    	    a.raca = "Vira-lata";
    	    a.latir();
    	    
    	    System.out.println("Nome: " + a.nome +  " Raça: " + a.raca ); 
    	    }
	
}
   
