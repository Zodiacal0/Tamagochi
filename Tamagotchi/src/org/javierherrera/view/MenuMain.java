/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.javierherrera.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.javierherrera.controller.StatsController;
import org.javierherrera.model.Egg;
import org.javierherrera.model.Owner;
import org.javierherrera.model.Tamagotchi;
import org.javierherrera.utils.GlobalScanner;

/**
 *
 * @author Javier
 */

public class MenuMain {
    private static MenuMain instance;
    public static synchronized MenuMain getIn() {
        if (instance == null) {
            instance = new MenuMain();
        }
        return instance;
    }
    private ArrayList<Egg> firstEgg = new ArrayList<Egg>();

    Scanner in = GlobalScanner.getIn();
    CreateTamagotView ctv = CreateTamagotView.getIn();
    StatsController st = StatsController.getIn();
    OwnerMenu om = OwnerMenu.getIn();
    StatsController sc = StatsController.getIn();
    
    
    
    public void firstInteraction(){
        int opt = -1;
        boolean flag = false;
        do {
            try {
                System.out.println("----------------------Tamagotchi----------------------");
                System.out.println("Elija una Opción");
                System.out.println("1. Crear un Compañe@");
                System.out.println("2. Salir");
                opt = in.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("creando");
                        ctv.transition();
                        ctv.addBasicInformation();
                        flag = true;
                        break;
                    case 2:
                        System.out.println("Saliendo");
                        flag = true;
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Solo se Aceptan Números: " + e.getMessage());
                in.nextLine();
                continue;
            }
        } while (!flag);

        in.close();
    }
    
    
    
    public void comeBack(){
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
        System.out.println("----------------------Tamagotchi----------------------");
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
        
        System.out.println("Hola de nuevo compañero");
        om.ownerMenu();
        st.loadTamagotchi();

    }
    
    public void InformationOfOwner(){
            System.out.println("Dame algún dato interesante");
            String data = in.nextLine();
            st.increasedIntelligence();
            
    }
}
