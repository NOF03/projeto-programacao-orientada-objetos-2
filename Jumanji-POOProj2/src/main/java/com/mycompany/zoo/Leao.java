/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zoo;

/**
 *
 * @author nunoo
 */
public class Leao extends Animal implements Panthera {
    
    public Leao(int age, double attractiveness, int price) {
        super(age, attractiveness, price);
        setTimeLife(8, 16);
        setMaintenance(60);
    }
    
    

    @Override
    public void rugir() {
       System.out.print("O leao" + getNAME() + "rugiu.(Rawr!)");
    }
    
    @Override
    public int getPRICE() {
        return PRICE;
    }
}
