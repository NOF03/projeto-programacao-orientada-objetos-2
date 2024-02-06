/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.zoo;

import java.util.Scanner;
import java.util.ArrayList;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

public final class Zoo {

    private final ArrayList<Animal> animalsZoo; //Array with Zoo animals
    private final ArrayList<Installation> installationsZoo; //Array with Zoo installations 
    private double balance; //Balance of the User - Starts with 20000
    private final ArrayList<String> history; //Array with the Zoo history
    private final ArrayList<String> obituary; //Array with the Zoo obituary
    private final Random rd; //Random variable for the all the program
    
    public Zoo() {
        animalsZoo = new ArrayList<>(); 
        installationsZoo = new ArrayList<>();
        history = new ArrayList<>();
        obituary = new ArrayList<>();
        balance = 20000;
        rd = new Random();
    }
        
    //Zoo menu
    public void menu() {
        
        boolean leave = false;
        clearConsole();
        Scanner option = new Scanner(System.in, "cp1252");
        
        //Option verification for the Menu
        do {
         
            System.out.println("Saldo atual: " + balance);
            display();
            
            switch (option.next()) {
                case "1" -> {
                    randomAnimalAcquire();
                }
                case "2" -> {
                    randomAnimalAcquireWithGenetic();
                }
                case "3" -> {
                    randomInstallation();
                }
                case "4" -> {
                    placeAnimalInstallation();
                }
                case "5" -> {
                    chineseCalendar();
                }
                case "6" -> {
                    animalsList();
                }
                case "7" -> {
                    animalsWithGenetic();
                }
                case "8" -> {
                    animalsWithMutation();
                }
                case "9" -> {
                    printInstallation();
                }
                case "10" -> {
                    familyLog();
                }
                case "11" -> {
                    printObituary();
                }
                case "12" -> {
                    printHistory();
                }
                case "13" -> {
                    accountingPeriod();
                }
                case "14" -> {
                    jumanji();
                }
                case "0" -> {
                    leave = true;
                }
                default -> System.out.println("Selecione uma das opções!");

            }
        } while (!leave);
        
    }
    
    private void display() {
        
        System.out.println("(1)Adquirir animal aleatório");
        System.out.println("(2)Adquirir animal com caraterística genética");
        System.out.println("(3)Construir instalação");
        System.out.println("(4)Colocar animal em instalação");
        System.out.println("(5)Calendário chinês");
        System.out.println("(6)Listar animais");
        System.out.println("(7)Listar animais com dada caraterística genética");
        System.out.println("(8)Listar animais com dada mutação");
        System.out.println("(9)Listar instalações");
        System.out.println("(10)Retrato de família animal");
        System.out.println("(11)Obituário");
        System.out.println("(12)Histórico");
        System.out.println("(13)Período contabilístico");
        System.out.println("(14)Jumanji");
        System.out.println("(0)Sair da aplicação");
        
    }
    
    //First Menu option
    private void randomAnimalAcquire() {
        
        
        System.out.println("Escolha um dos seguintes animais:");
        Animal[] option = new Animal[3];
        //Creation of 3 random animals
        for (int i = 0; i < 3; i++) {
            int idxRandom = rd.nextInt(Animal.getClasses().length);
            System.out.print((i+1)+")");
            option[i] = createAnimal(Animal.getClasses()[idxRandom], rd.nextInt(10));
            System.out.println(option[i].toString());
        }
        boolean leave = false;
        Scanner validation = new Scanner(System.in, "cp1252");
        
        //User's choice verification
        do {
            
            String oneoption = validation.next();
            switch (oneoption) {
                case "1", "2", "3" -> {
                    int myOption = Integer.parseInt(oneoption);
                    Animal optionAnimal = option[myOption-1]; //Chosen animal
                    payWithMoney(optionAnimal.getPRICE()); //Pay for the chosen animal                 
                    animalsZoo.add(optionAnimal); //Add the animal to the ZOO
                    history.add("Adquiriu: " + optionAnimal.toString());
                    leave = true;
                }
                case "0" -> {
                    leave = true;
                }
                default -> System.out.println("Insira um número válido");
            }
            
        } while (!leave);   
        
        
        
    }
    
    //Second Menu option
    private void randomAnimalAcquireWithGenetic() {
        
        boolean leave = false;
        String oneoption;
        Scanner validation = new Scanner(System.in, "cp1252");
        
        //Print all animal charateristics
        System.out.println("Escolha uma das seguintes caraterísticas:");
        for (String oneCharateristic : Animal.getCharateristics()) 
                System.out.println("- " + oneCharateristic);
        
        //User's choice verification
        do {
            
            oneoption = validation.next();
            for (String oneCharateristic : Animal.getCharateristics()) 
                if (oneoption.equals(oneCharateristic)) leave = true;
            
            if (!leave)
                System.out.println("Selecione uma das opções!");
        } while (!leave);

        String[] classes = Animal.getClasses(); // Get a list of all classes

        Object interfaceClass = null;
        try {
            interfaceClass = Class.forName("com.mycompany.zoo."+oneoption); //Get the interface class for the chosen charateristic
        } catch (ClassNotFoundException ex) {
            System.out.println("Caraterística não encontrada!");
        }
        ArrayList<String> classesWithChar = new ArrayList<>();
        for (String cls : classes) {
            try {
                if (((Class)interfaceClass).isAssignableFrom(Class.forName("com.mycompany.zoo."+cls))) 
                    classesWithChar.add(cls); // All classes with the chosen charateristics
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Animal não encontrado!");
            }
        }
        
        Animal oneAnimal;
        oneAnimal = createAnimal(classesWithChar.get(rd.nextInt(classesWithChar.size())), rd.nextInt(10));
        
        animalsZoo.add(oneAnimal);
        payWithMoney(oneAnimal.getPRICE());
        System.out.println("Adquiriu: " + oneAnimal.toString());
        history.add("Adquiriu: " + oneAnimal.toString() + " com a genética " + oneoption);
    }
    
    //Third Menu option
    private void randomInstallation() {
        
        System.out.println("Escolha uma das seguintes instalações:");
        int[][] option = new int[3][2];
        
        //Print all installations
        for (int i = 0; i < 3; i++) {
            System.out.print((i+1)+")");
            option[i][0] = rd.nextInt(2,10);
            option[i][1] = rd.nextInt(1000, 10000);
            System.out.println("Capacidade: " + option[i][0] + " | Price: " + option[i][1]);
        }
        System.out.println("0) Sair");
        
        boolean leave = false;
        Scanner validation = new Scanner(System.in, "cp1252");
        
        //User's choice verification
        do {
            
            String oneoption = validation.next();
            switch (oneoption) {
                case "1", "2", "3" -> {
                    int myOption = Integer.parseInt(oneoption);
                    leave = true;
                    balance -= option[myOption-1][1];
                    Installation oneInstallation = new Installation(option[myOption-1][0], option[myOption-1][1]);
                    installationsZoo.add(oneInstallation);
                    history.add("Instalação " + oneInstallation.getID() + " criada.");
                }
                case "0" -> leave = true;
                default -> System.out.println("Insira um número válido!");
            }
            
        } while (!leave);
    
    }
    
    //Creation of a new Animal depending on the chosen Animal
    private Animal createAnimal(String oneClass, int oneAge) {
        
        Animal oneAnimal;
        double oneAttractiveness = rd.nextDouble(10);
        int onePrice = rd.nextInt(100,1000);
        
        switch (oneClass) {
            case "Boi" -> oneAnimal = new Boi(oneAge, oneAttractiveness, onePrice); 
            case "Cabra" -> oneAnimal = new Cabra(oneAge, oneAttractiveness, onePrice); 
            case "Cao" -> oneAnimal = new Cao(oneAge, oneAttractiveness, onePrice); 
            case "Cavalo" -> oneAnimal = new Cavalo(oneAge, oneAttractiveness, onePrice); 
            case "Chita" -> oneAnimal = new Chita(oneAge, oneAttractiveness, onePrice);  
            case "Cobra" -> oneAnimal = new Cobra(oneAge, oneAttractiveness, onePrice); 
            case "Coelho" -> oneAnimal = new Coelho(oneAge, oneAttractiveness, onePrice); 
            case "Dragao" -> oneAnimal = new Dragao(oneAge, oneAttractiveness, onePrice); 
            case "Galo" -> oneAnimal = new Galo(oneAge, oneAttractiveness, onePrice); 
            case "Jaguar" -> oneAnimal = new Jaguar(oneAge, oneAttractiveness, onePrice); 
            case "Leao" -> oneAnimal = new Leao(oneAge, oneAttractiveness, onePrice); 
            case "Macaco" -> oneAnimal = new Macaco(oneAge, oneAttractiveness, onePrice); 
            case "Porco" -> oneAnimal = new Porco(oneAge, oneAttractiveness, onePrice);  
            case "Rato" -> oneAnimal = new Rato(oneAge, oneAttractiveness, onePrice); 
            case "Tigre" -> oneAnimal = new Tigre(oneAge, oneAttractiveness, onePrice); 
            case "Zebra" -> oneAnimal = new Zebra(oneAge, oneAttractiveness, onePrice); 
            default -> oneAnimal = new Boi(oneAge, oneAttractiveness, onePrice); 
        }
        return oneAnimal;
    }
    
    //Fourth Menu option
    private void placeAnimalInstallation() {
        
        if (installationsZoo.isEmpty()) {System.out.println("Não existem instalações!"); return; }
        System.out.println("Escolha uma das seguintes instalações:");
        
        //Print Installations
        for (Installation oneInstallation : installationsZoo) {
            if (oneInstallation.verifyCapacity())
                System.out.println("- " + oneInstallation.getID() + "(FULL)");
            else 
                System.out.println("- " + oneInstallation.getID());
        }
        
        
        boolean leave = false;
        int oneoption;
        Installation optionedInstallation = null;
        Scanner validation = new Scanner(System.in, "cp1252");
        
        //User's choice verification
        do {
            
            String myOption = validation.next();
            if (isNumeric(myOption)) {
                oneoption = Integer.parseInt(myOption);

                for (Installation oneInstallation : installationsZoo) 
                    if (oneInstallation.getID() == oneoption) {
                        leave = true;
                        optionedInstallation = oneInstallation;
                        break;
                    }
                
                if (!leave)
                    System.out.println("Insira um ID válido da instalação!");
            } else 
                System.out.println("Insira um ID válido da instalação!");
            
            
        } while (!leave);
        
        //Print the list of animals in the Zoo
        System.out.println("Escolha um dos seguintes animais para colocar na instalação:");
        for (Animal oneAnimal : animalsZoo) 
            System.out.println("- " + oneAnimal.getId());
        
        
        leave = false;
        Animal optionedAnimal = null;
        
        //User's choice verification for the animal
        do {
            
            String myOption = validation.next();
            if (isNumeric(myOption)) {
                oneoption = Integer.parseInt(myOption);

                for (Animal oneAnimal : animalsZoo) 
                    if (oneAnimal.getId() == oneoption) {
                        leave = true;
                        optionedAnimal = oneAnimal;
                        break;
                    }
                
                if (!leave)
                    System.out.println("Insira um ID válido do Animal!");
            } else 
                System.out.println("Insira um ID válido do Animal!");
            
            
        } while (!leave);
        
        addToInstallationFromZoo(optionedInstallation, optionedAnimal);

    }
    
    //Fifth Menu option
    private void chineseCalendar() {
        
        boolean leave = false;
        int oneoption = 0;
        Scanner validation = new Scanner(System.in, "cp1252");
        
        System.out.print("Insira o ano: ");
       
        do {
            
            String myOption = validation.next();
            
            if (isNumeric(myOption)) {
                oneoption = Integer.parseInt(myOption);
                leave = true;
            } else 
                System.out.println("Insira um número!");
            
            
        } while (!leave);
        
        for (Animal oneAnimal : getAllAnimals()) 
            if (Animal.getChineseAnimal(oneoption).equals(oneAnimal.getClass().getSimpleName())) 
                oneAnimal.setAttractiveness(oneAnimal.getAttractiveness() + (10-oneAnimal.getAttractiveness()) * 0.5); //Increase the attractiveness (max: 10)
            
        System.out.println("O animal do ano é: " + Animal.getChineseAnimal(oneoption) + " - Boost atribuído!");
    }
    
    //Sixth Menu option
    private void animalsList() {
        
        for (Animal oneAnimal : getAllAnimals()) 
            System.out.println(oneAnimal.toString());
        
    }
    
    //Seventh Menu option
    private void animalsWithGenetic(){
       
       boolean leave = false;
       String option;
       Object interfaceClass = null;
       Scanner scan = new Scanner(System.in,"cp1252");
       
       //Print all animal charateristics 
       System.out.println("Escolha uma característica");
       for (String oneCharateristic : Animal.getCharateristics()) 
                System.out.println("- " + oneCharateristic);
       
       //User's choice verification
       do {
            
            option = scan.next();
            for (String oneCharateristic : Animal.getCharateristics()) 
                if (option.equals(oneCharateristic)){
                    leave = true;
                    break;
                }
            if (!leave)
                System.out.println("Selecione uma das opções!");
            
        } while (!leave);
        try {
            interfaceClass = Class.forName("com.mycompany.zoo."+option);
        } catch (ClassNotFoundException ex) {
            System.out.println("Caraterística não encontrada!");
        }
        try {
            
            for(Animal oneAnimal : getAllAnimals()) 
                if(((Class)interfaceClass).isAssignableFrom(Class.forName(oneAnimal.getClass().getName())))
                    System.out.println(oneAnimal.toString());
        
        }
        catch (ClassNotFoundException ex) {
                System.out.println("Animal não encontrado!");
        }
    }
    
    //Eighth Menu option
    private void animalsWithMutation(){
      
        boolean leave = false;
        String option;
        Scanner scan = new Scanner(System.in,"cp1252");
        
        System.out.println("Escolha uma característica");
        for (String oneMutation : Animal.getMutations()) 
                System.out.println("- " + oneMutation);
        do {
  
            option = scan.next();
            for (String oneMutation : Animal.getMutations()) 
                if (option.equals(oneMutation))
                    leave = true;
                
            if (!leave)
                System.out.println("Selecione uma das opções!");
            
        } while (!leave);
        
        switch(option){
            case "heterochromia" -> {
                for(Animal oneAnimal : getAllAnimals())
                    if(oneAnimal.getHeterochromia())
                       System.out.println(oneAnimal.toString());
                    
            }
            case "albinism" -> {
                for(Animal oneAnimal : getAllAnimals())
                    if(oneAnimal.getAlbinism())
                       System.out.println(oneAnimal.toString());
                       
                
            }
        }
    }
    
    //Ninth Menu Option
    private void printInstallation() {
        
        for (Installation oneInstallation : installationsZoo)
            System.out.println(oneInstallation.toString());
        
    }
    
    //Tenth Menu Option
    private void familyLog(){
        
        System.out.println("--RETRATO DE FAMILIA ANIMAL--");
        
        animalsList();
        printAnimalsInInstallation();
        printObituary();
        printHistory();   
        
    }
    
    //Auxiliar function to the 10th option
    private void printAnimalsInInstallation(){
        
        for (Installation oneInstallation : installationsZoo){
            System.out.println(oneInstallation.toString());
            for (Animal oneAnimal : oneInstallation.getANIMALS())
                System.out.println("- " + oneAnimal.toString());     
        }   
        
    }
    
    //Eleventh Menu option
    private void printObituary() {
        
        System.out.println("--Obituário--");
        for (String oneString : obituary)
            System.out.println(oneString);
        
    }
    
    //Twelfth Menu option
    private void printHistory() {
         
        System.out.println("--História--");
        for (String oneString : history)
            System.out.println(oneString);
        
    }
    
    //Thirteenth Menu option
    private void accountingPeriod() {
        
        moneyFromAnimals();
        animalMaintenance();
        
        dieForAgeOrIllness();
        bornAnimals();
        brokeNoMoney();
        
        increaseAgeAnimals();
        
    }
    
    //Determine animals that die for age or illness - Accounting period
    private void dieForAgeOrIllness() {
        
        ArrayList<Animal> animalsToRemove = new ArrayList<>();
        
        //Determine if an animal dies for eld
        for (Animal oneAnimal : getAllAnimals()) 
            if ((oneAnimal.getAge() >= oneAnimal.getTIMELIFE()[0] && rd.nextInt(100) < 10) || oneAnimal.getAge() >= oneAnimal.getTIMELIFE()[1] ) {
                history.add("- O animal " + oneAnimal.getId() + " morreu de velhice.");
                obituary.add(oneAnimal.toString());
                animalsToRemove.add(oneAnimal);
            }
        //Remove the animal from the whole Zoo
        for (Animal oneAnimal : animalsToRemove) 
            removeAnimal(oneAnimal);
            
        animalsToRemove = new ArrayList<>();
        
        //Determine if an animal dies for illness
        for (Animal oneAnimal : getAllAnimals()) 
            if (rd.nextInt(100) < 2) {
                history.add("- O animal " + oneAnimal.getId() + " morreu de doença.");
                obituary.add(oneAnimal.toString());
                animalsToRemove.add(oneAnimal);
            } 
        
        //Remove the animal from the whole Zoo
        for (Animal oneAnimal : animalsToRemove) 
            removeAnimal(oneAnimal);
            
    }
    
    //Money received from the animals in the installations - Accounting period
    private void moneyFromAnimals() {
        
        for (Animal oneAnimal : getInstallationsAnimals()) 
            receiveMoney(oneAnimal.moneyWithAttractiveness());
        
    }
    
    //Money taken from the animal maintenance - Accounting period
    private void animalMaintenance() {
        
        for (Animal oneAnimal : getAllAnimals()) 
            payWithMoney(oneAnimal.getMaintenance());
            
    }
    
    //New born Animals on the Zoo - Accounting period
    private void bornAnimals() {
        
        ArrayList<Animal> animals = new ArrayList<>();
        
        for (Animal oneAnimal : getAllAnimals()) 
            if (rd.nextInt(100) < 5) {
                Animal myAnimal = createAnimal(oneAnimal.getClass().getSimpleName(), 0);
                animals.add(myAnimal);
                history.add("+ Nascimento de um " + oneAnimal.getClass().getSimpleName() + " " + myAnimal.getId());
            }
        animalsZoo.addAll(animals);
        
    }
    
    //Animals that run away from the Zoo with no maintenance or a minor chance to leave - Accounting period
    private void brokeNoMoney() {
        
        ArrayList<Animal> animalsToRemove = new ArrayList<>();
        
        for (Animal oneAnimal : getAllAnimals()) 
            if (rd.nextInt(100) < 10 && balance <= 0) 
                animalsToRemove.add(oneAnimal);
        
        for (Animal oneAnimal : animalsToRemove) {
            history.add("Animal " + oneAnimal.getId() + " fugiu!");
            removeAnimal(oneAnimal); 
        }
        
    }
    
    //Function to increase the age of all animals - Accounting period
    private void increaseAgeAnimals() {
        
        for (Animal oneAnimal : getAllAnimals()) 
            oneAnimal.increaseAge();
        
        
    }
            
    //Remove an animal from all the ZOO
    private void removeAnimal(Animal myAnimal) {        
        
        animalsZoo.remove(myAnimal);  
        
        for (Installation oneInstallation : installationsZoo) {
            oneInstallation.getANIMALS().remove(myAnimal);
            break;
        }
        
    }
    
    //Fourteenth Menu Option
    private void jumanji() {
        
        ArrayList<Animal> animalsToRemove = new ArrayList<>();
        ArrayList<Animal> animalsToMoveToZoo = new ArrayList<>();
        
        //Determine if an animal leave the Zoo
        for (Animal oneAnimal : animalsZoo) 
            if (rd.nextInt(100) < 10)
                animalsToRemove.add(oneAnimal);   
        
        
        for (Animal oneAnimal : getInstallationsAnimals())
            //Determine if an animal leaves the installation to the Zoo
            if (rd.nextInt(100) < 33) 
                animalsToMoveToZoo.add(oneAnimal);
            //Determine if an animal leaves the installation and the whole Zoo    
            else if (rd.nextInt(100) > 67)
                animalsToRemove.add(oneAnimal);
        
        //Remove the animals from the whole Zoo
        for (Animal oneAnimal : animalsToRemove) 
            removeAnimal(oneAnimal);
        
        //Move the animals to the Zoo
        for (Animal oneAnimal : animalsToMoveToZoo)
            removeFromInstallationToZoo(oneAnimal);
        
    }
    
    //Remove an animal from installation and add it to the Zoo
    private void removeFromInstallationToZoo(Animal oneAnimal) {
        
        animalsZoo.add(oneAnimal);
        for (Installation oneInstallation : installationsZoo) 
            oneInstallation.getANIMALS().remove(oneAnimal);
        
        history.add("Animal " + oneAnimal.getId() + " saiu da instalação!");
        
    }
    
    //Remove an animal from the Zoo and add it to the Installation
    private void addToInstallationFromZoo(Installation oneInstallation, Animal oneAnimal) {

        if (!oneInstallation.verifyCapacity())
            oneInstallation.getANIMALS().add(oneAnimal);           
        else {
            int idx = rd.nextInt(oneInstallation.getANIMALS().size());
            Animal theAnimal = oneInstallation.getANIMALS().get(idx);
            removeFromInstallationToZoo(theAnimal);
            oneInstallation.getANIMALS().add(idx, oneAnimal);
        }
        animalsZoo.remove(oneAnimal); 
        history.add("Animal " + oneAnimal.getId() + " entrou na instalação " + oneInstallation.getID());
        
    }
    
    //Verify if a string is numeric
    private static boolean isNumeric(String strNum) {
        
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    
    }
    
    private void payWithMoney(double pay) {
        balance -= pay;
    }
    
    private void receiveMoney(double money) {
        balance += money;
    }
    
    //Auxiliar function to get all animals in the whole Zoo
    private ArrayList<Animal> getAllAnimals() {
        
        ArrayList<Animal> allAnimals = new ArrayList<>();
        
        allAnimals.addAll(animalsZoo);
        allAnimals.addAll(getInstallationsAnimals());

        return allAnimals;
        
    }
    
    //Auxiliar function to get all animals inside the Installations
    private ArrayList<Animal> getInstallationsAnimals() {
        
        ArrayList<Animal> installationAnimals = new ArrayList<>();
        
        for (Installation oneInstallation : installationsZoo) {
            installationAnimals.addAll(oneInstallation.getANIMALS());
        }
        
        return installationAnimals;
        
    }
    
    //Function to clear the Netbeans console
    private void clearConsole() {
        
        try {
            Robot limpa = new Robot();
            limpa.keyPress(KeyEvent.VK_CONTROL);
            limpa.keyPress(KeyEvent.VK_L);
            limpa.keyRelease(KeyEvent.VK_CONTROL);
            limpa.keyRelease(KeyEvent.VK_L);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("ERRO");
            }

        } catch (AWTException e) {
            System.out.print("ERRO\n");
        }
        System.out.println("--------------------------------Jumanji---------------------------------");
        
    }
}
