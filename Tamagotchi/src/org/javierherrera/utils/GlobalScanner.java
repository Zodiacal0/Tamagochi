package org.javierherrera.utils;

import java.util.Scanner;

/**
 *
 * @author Javier Herrera
 */
public class GlobalScanner {
        private static Scanner in;
        
        private GlobalScanner(){
        
        }
            
    public static synchronized Scanner getIn(){
             if(in == null){
            in = new Scanner(System.in);
        }
        return in;
    } 
    
}