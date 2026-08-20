package com.example.ExemploConstrutor;


public class App 
{
    public static void main( String[] args )
    {
        Pessoa p1= new Pessoa("Deuclezio" , 34);
        Pessoa p2= new Pessoa("Cleiton" , 67 );
        
        System.out.println(p1.getNome());
        System.out.println(p1.getIdade());
        System.out.println(p2.getNome());
        System.out.println(p2.getIdade());
        
    }
}
