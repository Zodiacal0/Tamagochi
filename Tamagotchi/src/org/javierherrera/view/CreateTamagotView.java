/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.javierherrera.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.javierherrera.controller.EggController;
import org.javierherrera.utils.GlobalScanner;
import org.javierherrera.controller.OwnerController;
import org.javierherrera.controller.StatsController;
import org.javierherrera.model.Tamagotchi;

/**
 *
 * @author Javier
 */
public class CreateTamagotView {
    
    private static CreateTamagotView instance;
    public static synchronized CreateTamagotView getIn() {
        if (instance == null) {
            instance = new CreateTamagotView();
        }
        return instance;
    }
    
    Tamagotchi t = new Tamagotchi();
    
    Scanner in = GlobalScanner.getIn();
    EggController eg = EggController.getIn();
    OwnerController og = OwnerController.getIn();
    StatsController sc = StatsController.getIn();
    OwnerMenu om = OwnerMenu.getIn();
    
    public void transition(){
    System.out.println("Creando nuevo compañero...");
    System.out.println();

    // Fase inicial
    System.out.println("   ( )___");
    System.out.println("   . / *\\ / o\\");
    System.out.println("   ()* ____) ");
    System.out.println("      ||||");
    System.out.println();

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // Fase intermedia
    System.out.println("     ");
    System.out.println("   ( )___");
    System.out.println("   . / *\\ / o\\");
    System.out.println("   ()* ____) ");
    System.out.println("      ||||");
    System.out.println();

    try {
        
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // Fase 3 Final
    System.out.println("                                                        \n" +
"                     ..      :!JYYYYJ?~.                                             \n" +
"                  :JY555Y~ ~5PY?777??J5P?~7?J?7~.                                    \n" +
"                 ~BY?777JGGG?!!!!!777775GYYJ?JY5PJ^                                  \n" +
"                .B5777777P5!!!!!7777777?77777777?YP5^                                \n" +
"                ~#?77777JJ!!77777777777777777777777JGY^  .^~7????7~:                 \n" +
"                !#?77777777J7777777777777777777777777YGYY55YYJJJJY5PY:               \n" +
"                ^#?7777777?Y77777777?5?7777777777777777J?77777777777PG.              \n" +
"                :BJ7777JJJ???77777777?777777777777777777777777777???J#^              \n" +
"                .BY7777??JYYYY555555YYYYYYJ77777777777777777777????75G.              \n" +
"                .GY77777777777777?????????7777777777777777777??????J#!               \n" +
"                .BY777777777777777777777777777777777777777????????JB?                \n" +
"                ~#?77777777777777777777777777777777777777????????JB?                 \n" +
"                YG777777777777777777777777777777777777777???????YB7                  \n" +
"               !#?77777777777777777777777777777777777777777?????PG.                  \n" +
"              ^BY777777777777777777777777777777777777777777777???5G!                 \n" +
"             .G577777777777777777777777777777777777777777777777???JG5~               \n" +
"             5G77777777777777777777777777777777777777777777777??????YGY.             \n" +
"            ~#?7777777777777777777777777777777777777777777777?????????PG^            \n" +
"            YG7777777777777777777777777777777777777777777777??????????75B^           \n" +
"            PP???77777777777777777777777777777777777777777?????????????7PP           \n" +
"            5G7????777777777777777777777777777777777777?????????????????J#^          \n" +
"            ~#J7?????????????77777777777777777777777????????????????????J#^          \n" +
"             7BJ7???????????????????777777777???????????????????????????G5           \n" +
"              ~GPJ????????????????????????????????????????????????????JG5.           \n" +
"               .?PPYJ??????????????????????????????????????????????J5P5!             \n" +
"                 .~?Y555555555YYYJJ????????????????????????JJYY555YJ!:               \n" +
"                     ..:^^~~~~!!7?JY5555YYJJJJYYYYY5555555YYJ?!~:.                   \n" +
"                                     .:~!7?????77!!~~^::.. ");
    System.out.println();

    System.out.println("¡Felicidades! Ha nacido un nuevo compañero.");
    System.out.println("Disfruta de una nueva aventura juntos.");
    System.out.println("-----------------------------------------------------------------");
        System.out.println("Hola, quiero conocerte un poco más");
        addOwnerInformation();
        t.setBoredom(0);
        t.setHappiness(100);
        t.setIntelligence(0);
        t.setLifeTime(5);
        t.setWeight(3);
        t.setSleepiness(0);
        sc.getLife();
        sc.saveTamagotchi();
        Thread decrementThread = new Thread(() -> sc.decrementLifeTime());
        decrementThread.start();
        Thread incrementThread = new Thread(() -> sc.increasedBoredom());
        incrementThread.start();
        Thread incrementHungry = new Thread(() -> sc.increasedHungry());
        incrementHungry.start();
        Thread decrementHappiness = new Thread(() -> sc.decrementHappiness());
        decrementHappiness.start();
        Thread incrementSleepiness = new Thread(() -> sc.increasedSleepiness());
        incrementSleepiness.start();
        
    try{
            String ruta = "back.txt";    
            File file = new File(ruta); 
            file.createNewFile();
    }catch(IOException e){
        System.out.println("Error al crear el validador " + e.getMessage() );
    }
}

    
    public void addBasicInformation(){
        in.nextLine();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Ingrese el nombre de su compañero");
        String name = in.nextLine();
        System.out.println("Ingrese El Género de su Compañero");
        String gender = in.nextLine();
        eg.AddEgg(name, gender);
        om.ownerMenu();
    }
    
    public void addOwnerInformation(){
        in.nextLine();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("¿Como te llamas?");
        String name = in.nextLine();
        System.out.println("¿Cuál es tu Genero?");
        String gender = in.nextLine();
        System.out.println("¿Cuantos años tienes?");
        int age = in.nextInt();
        og.AddOwner(name, gender,age);
    }
    
}
