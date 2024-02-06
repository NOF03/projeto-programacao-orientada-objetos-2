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
public class Cavalo extends Animal implements Equus {
    
    public Cavalo(int age, double attractiveness, int price) {
        super(age, attractiveness, price);
        setTimeLife(25, 30);
        setMaintenance(55);
    }
    

    @Override
    public void abrirTerreno() {
        
    }
    
    @Override
    public int getPRICE() {
        return PRICE;
    }
}
