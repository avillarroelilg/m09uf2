/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici_4_Threads_amb_Semafors_v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

/**
 *
 * @author gines
 */
public class SistemaDeGuiaDeTorpedes {
	private int numDeTorpedesQuePotGuiarSimultaneament;
    private Semaphore semaforAssignacioSistemaDeGuia;
	private boolean[] usDelSistemaDeGuia;   			// Array que controla l'us del sistema de guia. True = ocupat.
	private Semaphore semaforPerEscriureEnUsDelSistemaDeGuia;

    
	
	public SistemaDeGuiaDeTorpedes(int num) {
   		numDeTorpedesQuePotGuiarSimultaneament = num;
        semaforAssignacioSistemaDeGuia = new Semaphore(num);         	// Creem un semàfor per controlar l'accés al sistema de guia.
        usDelSistemaDeGuia = new boolean[num];    						// Creem l'array indicador de l'ús dels recursos. És el que té 3 slots.
        semaforPerEscriureEnUsDelSistemaDeGuia = new Semaphore(1);		// Només 1 fil pot escriure simultàneament en l'array 'tubs'.
    }
	
	
	
	// Aquest mètode té accés a 'usDelSistemaDeGuia' per imprimir el seu contingut
	// i per tant ens hem d'assegurar que ningú estigui manipulant 'usDelSistemaDeGuia'.
	// Això s'aconsegueix des de el mètode que crida a aquest mètode.
    public void imprimirUsDelSistemaDeGuia(String nomThread) {
    	String resultat = "";
    	boolean primeraVegada = true;
    	
    	
    	for (int i = 0; i < usDelSistemaDeGuia.length; i++) {
    		if (primeraVegada == true) {
    			resultat = nomThread + ", usDelSistemaDeGuia = [" + usDelSistemaDeGuia[i];
    			
    			primeraVegada = false;
    		} else {
    			resultat = resultat + ", " + usDelSistemaDeGuia[i];	
    		}
    	}
    	
		resultat = resultat + "]";
    	
		System.out.println(resultat);
    }
	


	// Aqui nomes arriben fins a 3 torpedes.
   	// Aquí només poden entrar d'un en un gràcies al syncronized. Recordar que 3 torpedes llançats simultàneament 
    // poden arribar aquí a la vegada. NO FA FALTA FER synchronized AL METODE PERQUE LA 1a LINIA DE CODI ES UN SEMAFOR
    // DE TAMANY 1 QUE CONTROLA L'ACCES A LA VARIABLE 'usDelSistemaDeGuia'.
   	public synchronized int assignarSistemaDeGuia(String nomThread) {
   		int i = 0;
   		
   		// No volem que ningú manipuli 'usDelSistemaDeGuia[]' mentre busquem si un slot de 'usDelSistemaDeGuia' està lliure. 
   		// I de pas que tampoc el manipulin si acabem fent un usDelSistemaDeGuia[i] = true. 
   		// Des de el mètode 'alliberarSistemaDeGuia()' també s'accedir a 'usDelSistemaDeGuia[]'.
   		try {
			semaforPerEscriureEnUsDelSistemaDeGuia.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		
   		while (i < numDeTorpedesQuePotGuiarSimultaneament) {
   			if (usDelSistemaDeGuia[i] == false) {
   				usDelSistemaDeGuia[i] = true;
   				
   				break;
   			}
   			
   			i++;
   		}
   		
   		System.out.println(nomThread + ", numUsDelSistemaDeGuia = " + i);
   		
   		imprimirUsDelSistemaDeGuia(nomThread);
   		
   		semaforPerEscriureEnUsDelSistemaDeGuia.release();
   		
   		return(i);
   	}
   	
   	
   	
   	// Fins a 3 torpedes poden entrar aquí simultàniament.
   	public int adquirirSistemaDeGuia(String nomThread) {
   		try {
			semaforAssignacioSistemaDeGuia.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		
   		// Fins aquí poden arribar 3 torpedes simultàniament.
   		return(assignarSistemaDeGuia(nomThread));
   	}
   	
   	
   	
   	public void alliberarSistemaDeGuia(int numUsDelSistemaDeGuia, String nomThread) {
   		// No volem que ningú manipuli o llegeixi 'usDelSistemaDeGuia[]' mentre modifiquem el seu contingut.
   		try {
			semaforPerEscriureEnUsDelSistemaDeGuia.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		
   		usDelSistemaDeGuia[numUsDelSistemaDeGuia] = false;
   		
   		imprimirUsDelSistemaDeGuia(nomThread);
   		
   		semaforPerEscriureEnUsDelSistemaDeGuia.release();
   		
   		semaforAssignacioSistemaDeGuia.release();
   	}
   	
   	
}
