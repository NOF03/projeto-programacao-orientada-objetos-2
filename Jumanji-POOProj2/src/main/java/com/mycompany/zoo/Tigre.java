/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zoo;

/**
 *
 * @author nunoo
 */
public class Tigre extends Animal implements Panthera {
    
    public Tigre(int age, double attractiveness, int price) {
        super(age, attractiveness, price);
        setTimeLife(8, 10);
        setMaintenance(100);
    }
    
    /**
     *
     */
    @Override
    public void rugir() {
        System.out.print("O tigre" + getNAME() + "rugiu.(Rawr!)");
    }

    @Override
    public int getPRICE() {
        return PRICE;
    }
    
}
