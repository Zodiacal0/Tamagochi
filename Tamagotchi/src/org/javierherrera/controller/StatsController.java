/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.javierherrera.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.javierherrera.model.Tamagotchi;
import org.javierherrera.utils.GlobalScanner;
/**
 *
 * @author Javier
 */
public class StatsController {
    
    int life,lifeTime,weight,happiness,boredom,intelligence;
    
    private static StatsController instance;
    public static synchronized StatsController getIn() {
        if (instance == null) {
            instance = new StatsController();
        }
        return instance;
    }
    
    
    
    Tamagotchi t = new Tamagotchi();
    Scanner in = GlobalScanner.getIn();
    
   public void increasedBoredom(){
       try{
           while(t.getBoredom() <= 99){
                t.setBoredom(t.getBoredom() + 5);
                Thread.sleep(8000);
                saveTamagotchi();
                
            }
       }catch(InterruptedException e){
                System.out.println("Error al incrementar el aburrimiento");   
        }
    }
    public void increasedHungry() {
        try {
            while (t.getHungry() <= 99) {
                t.setHungry(t.getHungry() + 5);
                Thread.sleep(8000);
                saveTamagotchi();
            }
        } catch (InterruptedException e) {
            System.out.println("Error al incrementar el hambre del Tamagotchi: " + e.getMessage());
        }
    }
    public void increasedSleepiness() {
        try {
            while (t.getSleepiness() <= 99) {
                t.setSleepiness(t.getSleepiness() + 5);
                Thread.sleep(10000);
                saveTamagotchi();
            }
        } catch (InterruptedException e) {
            System.out.println("Error al incrementar el hambre del Tamagotchi: " + e.getMessage());
        }
    }
    public void decrementSleepiness() {
        System.out.println("El Tamagotchi despertará solo cuando tenga energía");
        try {
                t.setSleepiness(t.getSleepiness() - 35);
                t.setHungry(t.getHungry() + 45);
                Thread.sleep(10000);
                saveTamagotchi();
        } catch(InterruptedException e) {
            System.out.println("Error al decrementar el sueño del Tamagotchi: " + e.getMessage());
        }   
    }
    public void decrementHappiness() {
        try {
            while (t.getHappiness() > 0) {
                t.setHappiness(t.getHappiness() - 5);
                Thread.sleep(8000);
                saveTamagotchi();
            }
        } catch (InterruptedException e) {
            System.out.println("Error al incrementar el hambre del Tamagotchi: " + e.getMessage());
        }
    }

   public void increasedIntelligence(){
    t.setBoredom(t.getBoredom() + 1);
   }
   
   public void decrementBoredom(int opt3){
       switch(opt3){
           case 1:
               ahorcadoJuego();
               break;
           case 2: 
               adivinanzasJuego();
               break;
           default:
               System.out.println("Opción invalida");
       }
   }
   
   public void getLife(){
       t.setLifeTime(5);
   }
   
   public void ahorcadoJuego(){
        int indi;
        boolean parar = false;
        int intentos = 6;
        String  palabraRandom = " ";
        ArrayList<String> palabras= new ArrayList<String>();              
        palabras.add("Compilacion");
        palabras.add("javaSE");
        palabras.add("Error");
        palabras.add("Java");
        
        int azar = (int)(Math.random()*3+0);
        
        for(indi = 0; indi < palabras.size(); indi++){
            if(indi == azar){
                palabraRandom = palabras.get(indi);
                break;
            }
        }
        System.out.println(palabraRandom);
        char[] adivinar = palabraRandom.toCharArray();
        char[] espacios = new char [6];
        
        for(indi = 0; indi<espacios.length;indi++){
           espacios[indi] = '_';
        }
        
        do{
            System.out.println(espacios);
            System.out.println("La letra");
            char letra = in.next().charAt(0);
            boolean correcto = false;
            for(indi = 0; indi<adivinar.length; indi++){
                if(palabraRandom.charAt(indi)== letra){
                   espacios[indi] = letra;
                   correcto = true;
                }
            }               
            if(!correcto){
                System.out.println("Respuesta incorrecta");
                intentos--;
                System.out.println("||| TIENES: " + intentos + " INTENTOS");
                if(intentos==0){
                    System.out.println("Lo siento, Perdiste");
                    parar = true;
                }
            }else{   
              boolean juego = !Guiones(espacios);
              if(juego){
                  System.out.println("FELICIDADES ganaste");
                  parar = true;
                  System.out.println(" ||| LA RESPUESTA CORRECTA ERA: " + palabraRandom);
                    t.setBoredom(t.getBoredom() - 25);
                    t.setHappiness(t.getHappiness() + 15);
                    t.setHungry(t.getHungry() + 25);
                    t.setIntelligence(t.getIntelligence() + 10);
                    t.setLife(t.getLife() + 10);
                    saveTamagotchi();
              }
            }
        }while(!parar);     
    }
    
    static boolean Guiones(char[] array){
        for(char ind: array){
            if(ind=='_'){
                return true;
            }
        }
        return false;
    }


    public boolean adivinanzasJuego()throws InputMismatchException{
        int intentos= 5;
        boolean resultado = false;
        int num = (int)(Math.random()*20+1);;
        int numsUsuario;
        System.out.println("------------------------------------------------------------");
        System.out.println("EMPECEMOS: te dare pistas por cada intento para que adivines "
                + "el numero");
        System.out.println("El numero a adivinar esta entre el 1 y el 20");
        System.out.println("tendras " + intentos + " intentos para adivinar");
        System.out.println("------------------------------------------------------------");
        for(int indi = 0; indi <intentos; indi++){
            numsUsuario = in.nextInt(); 
        if(numsUsuario < num){
                System.out.println("cerca, pero ingresaste un numero menor al mio");
            }else if(numsUsuario > num){
                System.out.println("cerca, pero el numero ingresado es mayor al mio");
            }else if(numsUsuario == num){
                System.out.println("felicidades, adivinaste el numero");
                resultado = true;
                indi=4;
                t.setBoredom(t.getBoredom() - 25);
                t.setHappiness(t.getHappiness() + 15);
                t.setHungry(t.getHungry() + 25);
                t.setIntelligence(t.getIntelligence() + 10);
                saveTamagotchi();
                t.setLife(t.getLife() + 10);
                
            } 
        }
        System.out.println("------------------------------------------------------------");
        System.out.println("||| El numero a adivinar era: "  + num);
        System.out.println("------------------------------------------------------------");
                 
        return resultado;
    }
   
    public void increasedSatiety(int opt) {
        switch (opt) {
            case 1:
                t.setWeight(t.getWeight() + 1);
                t.setHappiness(t.getHappiness() + 3);
                t.setHungry(Math.max(t.getHungry() - 25, 0)); 
                saveTamagotchi();
                break;
            case 2:
                t.setWeight(t.getWeight() + 1);
                t.setHappiness(t.getHappiness() + 1);
                t.setHungry(Math.max(t.getHungry() - 10, 0));
                saveTamagotchi();
                break;
            case 3:
                t.setWeight(t.getWeight() + 1);
                t.setHappiness(t.getHappiness() + 4);
                t.setHungry(Math.max(t.getHungry() - 35, 0));
                saveTamagotchi();
                break;
            case 4:
                t.setWeight(t.getWeight() + 1);
                t.setHappiness(t.getHappiness() + 6);
                t.setHungry(Math.max(t.getHungry() - 2, 0));
                saveTamagotchi();
                break;
            case 5:
                t.setWeight(t.getWeight() + 1);
                t.setHappiness(t.getHappiness() + 15);
                t.setHungry(t.getHungry() + 10);
                saveTamagotchi();
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    
   public void exit(){
   System.exit(0);
   }
   
    public void decrementLifeTime() {
        loadTamagotchi();
        try {
            while (t.getLifeTime() > 0) {
                t.setLifeTime(t.getLifeTime() - 1);
                Thread.sleep(60000);
                saveTamagotchi();
            }

            System.out.println("Tu Tamagotchi ha muerto. Gracias por jugar.");
            System.exit(0);
        } catch (InterruptedException e) {
            System.out.println("Error al decrementar el tiempo de vida del Tamagotchi: " + e.getMessage());
        }
    }

    public void reset() {
        String ruta = "Tamagotchi.txt";

        // Crear un objeto File con la ruta del archivo
        File archivo = new File(ruta);

        // Verificar si el archivo existe antes de intentar borrarlo
        if (archivo.exists()) {
            try {
                // Intentar borrar el archivo
                if (archivo.delete()) {
                    System.out.println("El archivo se ha borrado exitosamente.");
                } else {
                    System.out.println("No se pudo borrar el archivo.");
                }
            } catch (SecurityException e) {
                System.out.println("No se tienen los permisos necesarios para borrar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe en la ruta especificada.");
        }
    }

    public void saveTamagotchi() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Tamagotchi.txt"))) {
            writer.write(t.getLife() + "," + t.getLifeTime() + "," + t.getWeight() + "," +
                    t.getHappiness() + "," + t.getBoredom() + "," + t.getIntelligence() + "," +
                    t.getHungry() + "," + t.getSleepiness()); // Completar el resto de atributos si es necesario
        } catch (IOException e) {
            System.out.println("Error al guardar los datos del Tamagotchi en el archivo: " + e.getMessage());
        }
    }

    public void loadTamagotchi() {
        try (Scanner scanner = new Scanner(new File("Tamagotchi.txt"))) {
            if (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                t.setLifeTime((long) Integer.parseInt(data[1]));
                t.setWeight((int) Integer.parseInt(data[2]));
                t.setHappiness(Integer.parseInt(data[3]));
                t.setBoredom(Integer.parseInt(data[4]));
                t.setIntelligence(Integer.parseInt(data[5]));
                t.setHungry(Integer.parseInt(data[6]));
                t.setSleepiness(Integer.parseInt(data[7]));
                // Completar la asignación de atributos restantes si es necesario
                System.out.println("Datos del Tamagotchi cargados exitosamente.");
            } else {
                System.out.println("El archivo está vacío. No se pudieron cargar datos.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo Tamagotchi.txt no encontrado. Se creará uno nuevo al guardar los datos.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos del Tamagotchi desde el archivo: " + e.getMessage());
        }
    }
    //Solo aquí Perdone profe por poner impresiones en el controlador porque de otro lado no me las reconocía
    public void printTamagotchiData() {
        int min = t.getLife();
        System.out.println("Datos del Tamagotchi:");
        System.out.println("Vida: " + t.getLife());
        System.out.println("Tiempo de Vida: " + (t.getLifeTime()) + " minutos");
        System.out.println("Peso: " + t.getWeight());
        System.out.println("Felicidad: " + t.getHappiness());
        System.out.println("Aburrimiento: " + t.getBoredom());
        System.out.println("Inteligencia: " + t.getIntelligence());
        System.out.println("Hambre: " + t.getHungry());
        System.out.println("Sueño: " + t.getSleepiness());
        System.out.println("1. Salir");
        System.out.println("2. Continuar");
    }
}


