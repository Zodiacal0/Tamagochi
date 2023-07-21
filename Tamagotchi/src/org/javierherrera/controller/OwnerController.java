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
import org.javierherrera.model.Owner;

/**
 *
 * @author Javier
 */

public class OwnerController {
    private static OwnerController instance;
    public static synchronized OwnerController getIn() {
        if (instance == null) {
            instance = new OwnerController();
        }
        return instance;
    }
    
    private ArrayList<Owner> owners = new ArrayList<Owner>();
    
    public void AddOwner(String name, String gender, int age) {
        Owner own = new Owner(name,gender,age);
        owners.add(own);
        saveOwner();
        saveOwner1();
        System.out.println("Dueño creado exitosamente");
    }
    
    public void saveOwner1() {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("PlainsTextOwners.txt"))) {
            for (Owner own : owners) {
                writer.println(  own.getName() + 
                               "," + own.getGender() +
                               "," + own.getAge());
            }
            System.out.println("Se ha guardado exitosamente");
        } catch (FileNotFoundException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void saveOwner(){
        try{
            FileOutputStream fileOut = new FileOutputStream("Owners.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(owners);
            System.out.println("Se ha guardado exitosamente");
        }catch (FileNotFoundException e){
            System.out.println("Existió un erro al guardar " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("No Se a podido acceder al archivo");
        }
    }
    
    
    
}
