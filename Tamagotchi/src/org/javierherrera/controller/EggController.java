/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.javierherrera.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.javierherrera.model.Egg;

/**
 *
 * @author Javier
 */
public class EggController {
    
    private static EggController instance;
    public static synchronized EggController getIn() {
        if (instance == null) {
            instance = new EggController();
        }
        return instance;
    }
    
    private ArrayList<Egg> firstEgg = new ArrayList<Egg>();

    public void AddEgg(String name, String gender) {
        Egg gge = new Egg(name,gender);
        firstEgg.add(gge);
        saveEgg();
        saveEgg1();
        System.out.println("creado exitosamente");
    }
    
    public void saveEgg1() {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("PlainsTextFriends.txt"))) {
            for (Egg gee : firstEgg) {
                writer.println(  gee.getName()+ 
                               "," + gee.getGender());
            }
            System.out.println("Se ha guardado exitosamente");
        } catch (FileNotFoundException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void saveEgg(){
        try{
            FileOutputStream fileOut = new FileOutputStream("Friends.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(firstEgg);
            System.out.println("Se ha guardado exitosamente");
        }catch (FileNotFoundException e){
            System.out.println("Existió un erro al guardar " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("No Se a podido acceder al archivo");
        }
    }
    public ArrayList<Egg> readFriend() {
        try{
            FileInputStream fileIn = new FileInputStream("Friends.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            firstEgg = (ArrayList)objectIn.readObject();
        }catch(FileNotFoundException e){
            System.out.println("Existió un erro al recuperar la información: " + e.getMessage());
        }catch (IOException ex) {
            System.out.println("Error de entrada o de salida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Existió un error al recuperar la información, no se encuentra la clase.");
        }
        return firstEgg;
    }
    
    public void print(){
        ArrayList<Egg> array = readFriend();
        
        for(int c = 0; c < array.size(); c++){
            System.out.println(array.get(c));
        }
    }
}
