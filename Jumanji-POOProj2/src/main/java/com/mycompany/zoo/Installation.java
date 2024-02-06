/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zoo;

import java.util.ArrayList;

public class Installation {
    
    private static int idInstallations = 0;
    private final int ID;
    private final int CAPACITY; //Capacity of the installation
    private final ArrayList<Animal> ANIMALS; //Array with all the animals in the installation
    private final int PRICE; //Price of the installation

    public Installation(int capacity, int price) {
        ID = ++idInstallations;
        this.CAPACITY = capacity;
        ANIMALS = new ArrayList<>();
        this.PRICE = price;
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public int getID() {
        return ID;
    }
    
    public ArrayList<Animal> getANIMALS() {
        return ANIMALS;
    }

    public void addAnimals(Animal oneAnimal) {
        ANIMALS.add(oneAnimal);
    }
    
    public boolean verifyCapacity() {
        return ANIMALS.size() == CAPACITY;
    }
    
    public int getPRICE() {
        return PRICE;
    }
    
    @Override
    public String toString() {
        return "Installation " + ID + " | Capacity: " + CAPACITY + " | Occupied: " + ANIMALS.size() + " | Price: " + PRICE;
    }
}
