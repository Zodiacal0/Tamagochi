/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.javierherrera.system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.javierherrera.controller.ComeBackVlidator;

/**
 *
 * @author Javier
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        
        
        ComeBackVlidator cbv = ComeBackVlidator.getIn();
        cbv.validator();

    }
}
