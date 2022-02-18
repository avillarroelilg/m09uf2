package menuMisEjerc;

import Pantalles.MenuConstructorPantalla;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

import Ej_1_Runnables.Exercici_1;



public class PAU_487 {
    
    public static void bloquejarPantalla() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nToca 'C' per a continuar ");
        while (in.hasNext()) {
            if ("C".equalsIgnoreCase(in.next())) break;
        }
    }
    
    
    public static void menuPAU_487() { //throws IOException  {
        String opcio;
        Scanner sc = new Scanner(System.in);
        StringBuilder menu = new StringBuilder("");
        
        do {
            menu.delete(0, menu.length());
            
            menu.append(System.getProperty("line.separator"));
            menu.append("PAU-487");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator")); 
            
            menu.append("1. Threads implements Runnable");
            menu.append(System.getProperty("line.separator"));
            menu.append("2. Threads extends Thread (I)");
            menu.append(System.getProperty("line.separator"));
            menu.append("3. Threads extends Thread (II)");
            menu.append(System.getProperty("line.separator"));
            menu.append("4. Threads amb wait() i notify()");
            menu.append(System.getProperty("line.separator"));
            menu.append("5. Threads amb semàfors (I)");
            menu.append(System.getProperty("line.separator"));
            menu.append("6. Threads amb semàfors (II)");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            menu.append("10. LLançar tots els torpedes");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("50. Tornar al menú pare (PNS-24 Puma)");
            menu.append(System.getProperty("line.separator"));
            
            
            System.out.print(MenuConstructorPantalla.constructorPantalla(menu));
            
            opcio = sc.next();
            
            String str = "selecciono la opcion ";
            switch (opcio) {
                case "1":
					try {
						Exercici_1.inicialitzarPrograma();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				//Exercici_1.inicialitzarPrograma();
                	printarMensaje(str+opcio);
					
                    bloquejarPantalla();
                    break;
                case "2":
                	//exercici_2_v1.inicialitzarPrograma();
                	printarMensaje(str+opcio);
                    bloquejarPantalla();
                    break;
                case "3":
                	//exercici_2_v2.inicialitzarPrograma();
                	printarMensaje(str+opcio);
                    bloquejarPantalla();
                    break;
                case "4":
                	//exercici_2_v3.inicialitzarPrograma();
                	printarMensaje(str+opcio);
                    bloquejarPantalla();
                    break;
                case "5":
                	//exercici_2_v4.inicialitzarPrograma();
                	printarMensaje(str+opcio);
                    bloquejarPantalla();
                    break;    
                case "6":
                	//exercici_2_v5.inicialitzarPrograma();
                	printarMensaje(str+opcio);
                    bloquejarPantalla();
                    break;    
                case "10":
                	//exercici_2_v6.inicialitzarPrograma();
                	printarMensaje(str+opcio);
                    bloquejarPantalla();
                    break;
                case "50":
                    break; 
                default:
                    System.out.println("COMANDA NO RECONEGUDA");
            }   
        } while (!opcio.equals("50"));
    }
    public static void printarMensaje(String str_tp) {
    	System.out.println(str_tp);
		
	}
    
}
