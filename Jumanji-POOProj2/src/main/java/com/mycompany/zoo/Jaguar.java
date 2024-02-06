/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zoo;

/**
 *
 * @author nunoo
 */
public class Jaguar extends Animal implements Panthera {
    
    public Jaguar(int age, double attractiveness, int price) {
        super(age, attractiveness, price);
        setTimeLife(12, 15);
    }
    
    

    @Override
    public void rugir() {
        System.out.print("O jaguar" + getNAME() + "rugiu.(Rawr!)");
    }
    
    @Override
    public int getPRICE() {
        return PRICE;
    }
}
