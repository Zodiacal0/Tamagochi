/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.javierherrera.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.javierherrera.controller.StatsController;
import org.javierherrera.model.Tamagotchi;
import org.javierherrera.utils.GlobalScanner;

/**
 *
 * @author Javier
 */
public class OwnerMenu {
    
    private static OwnerMenu instance;
    public static synchronized OwnerMenu getIn() {
        if (instance == null) {
            instance = new OwnerMenu();
        }
        return instance;
    }
    Tamagotchi t = new Tamagotchi();
    StatsController sc = StatsController.getIn();
    Scanner in = GlobalScanner.getIn();
    
    public void readFood(){
        String ruta = "src/org/javierherrera/assets/Food.txt";
        try{
            FileReader fileReader = new FileReader(ruta);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException e){
            System.out.println("Error al Acceder al archivo");
        }
    }
    
    public void giveFood() {
        readFood();
        int opt = in.nextInt();
        sc.increasedSatiety(opt);
    }

    
    
    public void ownerMenu(){
        sc.loadTamagotchi();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Elige una opción");
        System.out.println("1. Ver estado del Tamagotchi");
        System.out.println("2. Alimentarlo");
        System.out.println("3. Enseñarle Cosas");
        System.out.println("4. Jugar Con él");
        System.out.println("5. Dormir");
        System.out.println("6. Ver lo prendido");
        int opt = in.nextInt();
        switch(opt){
            case 1:
                sc.printTamagotchiData();
                int opt1 = in.nextInt();
                if(opt1 == 1){
                    sc.saveTamagotchi();
                    System.exit(0);
                }else{
                ownerMenu();
                }
                break;
            case 2: 
                giveFood();
                int opt2 = in.nextInt();
                if(opt2 == 7){
                    sc.saveTamagotchi();
                    System.exit(0);
                }else{
                ownerMenu();
                }
                break;
            case 3:
                askQuestions();
                int opt4 = in.nextInt();
                if(opt4 == 1){
                    sc.saveTamagotchi();
                    System.exit(0);
                }else{
                ownerMenu();
                }
                break;
            case 4:
                System.out.println("------------------------------------------");
                System.out.println("1. Jugar Ahorcado");
                System.out.println("2. Jugar Adivinanza");
                int opt3 = in.nextInt();
                sc.decrementBoredom(opt3);
                break;
            case 5:
                sc.decrementSleepiness();
                System.out.println("Presiona Enter Para despertarlo");
                in.next();
                ownerMenu();
                break;
            case 6:
                int opt6 = in.nextInt();
                printUserDataFromFile();
                if(opt6 == 1){
                    sc.saveTamagotchi();
                    System.exit(0);
                }else{
                ownerMenu();
                }
                break;
            default:
                System.out.println("Opción invalida");
        }
    }
    
    public void askQuestions() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Hola! Soy tu Tamagotchi. Vamos a conocernos mejor.");
        System.out.print("Cuál es tu comida favorita? ");
        String food = in.nextLine();
        in.nextLine();
        System.out.println("Cuantos años tienes?");
        int age = in.nextInt();
        System.out.println("Cual es tu nombre?");
        String name = in.nextLine();
        in.nextLine();
        System.out.println("De donde eres?");
        String location = in.nextLine();
        in.nextLine();
        t.setIntelligence(t.getIntelligence() + 45);
        t.setHungry(t.getHungry() + 25);
        System.out.println("1. Salir ");
        System.out.println("2. Continuar");

        saveUserDataToFile(food,name,age,location);

        System.out.println("¡Gracias por responder! Tus datos se han guardado en el archivo exitosamente.");

        scanner.close();
    }
    
    public void saveUserDataToFile(String food, String name, int age, String location) {
        String ruta = "Data.txt";
        System.out.println("1. Salir");
        System.out.println("2. Continuar");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write("Nombre: " + name);
            writer.newLine();
            writer.write("Edad: " + age);
            writer.newLine();
            writer.write("Comida Favorita: " + food);
            writer.newLine();
            writer.write("Pais: " + location);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }
    public void printUserDataFromFile() {
        String ruta = "Data.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al acceder al archivo o el archivo no existe: " + e.getMessage());
        }
    }
    public void printTamagotchiData() {
        int min = t.getLife();
        System.out.println("Datos del Tamagotchi:");
        System.out.println("Vida: " + t.getLife());
        System.out.println("Tiempo de Vida: " + (t.getLifeTime()) + " minutos");
        System.out.println("Peso: " + t.getWeight());
        System.out.println("Felicidad: " + t.getHappiness());
        System.out.println("Aburrimiento: " + t.getBoredom());
        System.out.println("Inteligencia: " + t.getIntelligence());
        System.out.println("1. Continuar");
        System.out.println("2. Salir");
        
    }
}
