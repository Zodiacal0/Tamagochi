/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.javierherrera.model;

import java.io.Serializable;

/**
 *
 * @author Javier
 */
public class Egg implements Serializable{
    
    private String name,gender;
    
    public Egg(){
    }

    public Egg(String name, String gender){
        this.name = name;
        this.gender = gender;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + "\n"
                + "Genero: " + gender + "\n";
    }
    
    
}
