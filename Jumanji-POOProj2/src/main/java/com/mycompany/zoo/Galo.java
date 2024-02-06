/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zoo;

/**
 *
 * @author nunoo
 */
public class Galo extends Animal{
    
    public Galo(int age, double attractiveness, int price) {
        super(age, attractiveness, price);
        setTimeLife(5, 10);
        setMaintenance(25);
    }
    
    
}
