/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zoo;

import static com.mycompany.zoo.Panthera.PRICE;

/**
 *
 * @author nunoo
 */
public class Zebra extends Animal implements Equus {
    
    public Zebra(int age, double attractiveness, int price) {
        super(age, attractiveness, price);
        setTimeLife(20, 40);
        setMaintenance(30);
    }
    
   

    @Override
    public void abrirTerreno() {
        
    }
    
    @Override
    public int getPRICE() {
        return PRICE;
    }
    
}
