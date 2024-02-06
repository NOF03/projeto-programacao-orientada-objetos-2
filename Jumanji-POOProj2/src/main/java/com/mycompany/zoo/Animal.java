/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zoo;

import java.util.Objects;
import java.util.Random;

public abstract class Animal {
    
    private static int idAnimals = 0;
    private static final String[] NAMES = {"Abelha Maia", "Salvador", "BBC", "George Floyd", "Maiq Taison", "Buba J", "Amanda D. P. Throat", "Ligma", "Anita Hardcok", "Banana Hammock", "Ben Dover", "Betty Humper", "Dick Long", "Dixie Rect", "E. Normous Peter", "Fluffy Cookie", "Harry Cox", "Harry Maguire", "Marion Money", "Stella Virgin", "Yuri Nator", "Tiger Style", "Captain Morgan", "Edward Cocaine", "Bouncy Nuggets", "Willie Stroker", "Emerson Bigguns", "Annie Rection", "Bob Maddick", "Mike Hawk", "CR7 SEWEYYYY"};
    private static final String[] CLASSES = {"Boi", "Cabra", "Cao", "Cavalo", "Chita", "Cobra", "Coelho", "Dragao", "Galo", "Jaguar", "Leao", "Macaco", "Porco", "Rato", "Tigre", "Zebra"};
    private static final String[] CHINESECALENDAR = {"Macaco", "Galo", "Cao", "Porco", "Rato", "Boi", "Tigre", "Coelho", "Dragao", "Cobra", "Cavalo", "Cabra"};
    private static final String[] CHARATERISTICS = {"Equus", "Panthera"};
    private static final String[] MUTATIONS = {"heterochromia", "albinism"};
    private final int ID;
    private final String NAME;
    private int age;
    private double attractiveness; 
    private final int[] TIMELIFE = new int[2];
    private final int PRICE;
    private final boolean HETEROCHROMIA;
    private final boolean ALBINISM;
    private double maintenance = 0; //Maintenance cost for each animal
    
    public Animal(int age, double attractiveness, int price) {
        
        Random rd = new Random();
        ID = ++idAnimals;        
        this.NAME = NAMES[rd.nextInt(NAMES.length)]; //Random name from the NAMES array
        this.age = age;
        this.attractiveness = attractiveness;
        this.PRICE = price;
        this.HETEROCHROMIA = (Objects.hash(NAME, age, attractiveness, price, ID)% 635) < 1; //Animal chances to have heterochromia
        this.ALBINISM = (Objects.hash(NAME, age, attractiveness, ID)% 100) == 2; //Animal chances to have albinism
        
    }
    
    public double moneyWithAttractiveness() {
        return attractiveness * 50 + (1/(age+1)) * 20;
    }
    
    public int getId() {
        return ID;
    }
    
    public String getNAME() {
        return NAME;
    }
    
    
    public int getAge() {
       return age; 
    }
    
    public void increaseAge() {
        age++;
    }
    
    public double getAttractiveness() {
        return attractiveness;
    }
    
    public void setAttractiveness(double attractiveness) {
        this.attractiveness = attractiveness;
    }
    
    public boolean getHeterochromia() {
        return HETEROCHROMIA;
    }
    
    public boolean getAlbinism() {
        return ALBINISM;
    }
    
    public static String[] getClasses() {
        return CLASSES;
    }
    
    public static String[] getCharateristics() {
        return CHARATERISTICS;
    }
    
    public static String[] getMutations(){
        return MUTATIONS;
    }
    
    public static String[] getNames() {
        return NAMES;
    }
    
    public int getPRICE() {
        return PRICE;
    }
    
    public int[] getTIMELIFE() {
        return TIMELIFE;
    }
    
    public void setTimeLife(int timeLifeLow, int timeLifeHigh) {
        TIMELIFE[0] = timeLifeLow;
        TIMELIFE[1] = timeLifeHigh;
    }
    
    public static String[] getCalendar() {
        return CHINESECALENDAR;
    }
    
    //Returns the chinese animal of that year
    public static String getChineseAnimal(int year) {
        return getCalendar()[year%12];
    }
    
    public double getMaintenance() {
        return maintenance;
    }
    
    public void setMaintenance(double value) {
        maintenance = value;
    }
    
    @Override
    public String toString() {
        return "Animal: " + getClass().getSimpleName() + " | Name: " + NAME + " | Idade: " + age + " | Albino: " + getAlbinism() + " | Heterocromia: " + getHeterochromia() + " | Preço: " + getPRICE() + " | ID: " + getId();
    }
}
