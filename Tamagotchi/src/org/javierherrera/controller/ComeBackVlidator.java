/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.javierherrera.controller;

import java.io.File;
import org.javierherrera.view.CreateTamagotView;
import org.javierherrera.view.MenuMain;

/**
 *
 * @author Javier
 */
public class ComeBackVlidator {
    
    private static ComeBackVlidator instance;
    public static synchronized ComeBackVlidator getIn() {
        if (instance == null) {
            instance = new ComeBackVlidator();
        }
        return instance;
    }
    StatsController sc = StatsController.getIn();
    MenuMain mm = MenuMain.getIn();
    CreateTamagotView ctv = CreateTamagotView.getIn();
    
    public void validator(){
        String ruta = "back.txt";
        File file = new File(ruta);
        if(file.exists()){
            mm.comeBack();
            sc.loadTamagotchi();
        }else{
            mm.firstInteraction();
        }
    }
    
    
}
