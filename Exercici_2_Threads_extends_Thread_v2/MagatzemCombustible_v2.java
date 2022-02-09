/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici_2_Threads_extends_Thread_v2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author gines
 */
public class MagatzemCombustible_v2 {
    ArrayList <Character> posicionsEnMagatzem = new ArrayList<Character>();

    
   	public MagatzemCombustible_v2() {
   		Character[] posicions = {'0','0','0','0','0','0','0','0','0','0'};
   		posicionsEnMagatzem.addAll(Arrays.asList(posicions));
    }
    
    
   	public synchronized int numContenidorsAlMagatzem() {
   		int numContenidors;
   		
   		
   		numContenidors = 0;
   		for(char ocupada : posicionsEnMagatzem) {
   			if (ocupada == '1') {
   				numContenidors++;
   			}
   		}
   		
    	return numContenidors;
    }
   	
    
    // EL PROBLEMA ES QUE 1 FIL POT ENTRAR EN produirContenidorDeCombustible() I UN ALTRE EN consumirContenidorDeCombustible() I 
    // A LLAVORS ACCEDIR A LA VARIABLE posicionsEnMagatzem SIMULTÀNEAMENT I PROVOCAR UN ERROR A L'ESCRIURE EN ELLA.
    // PER AIXÒ DE VEGADES PETA.
    
   	// SI HI HAGUESSIN 2 O MÉS DEPARTAMENTS DE CIENCIA, EL METODE produirContenidorDeCombustible() HAURIA DE SER synchronized.
    public void produirContenidorDeCombustible() {
    	int posTmp;
    	
    	posTmp = posicionsEnMagatzem.indexOf('0');
    	//System.out.println("Produit en posTmp = " + posTmp);
    	
    	posicionsEnMagatzem.set(posTmp, '1');		// El mètode add(pos, '1') fa un INSERT un '1' en la posició 'pos' i mou la resta d'elements que hi ha  
    												// des de 'pos' cap a la dreta 1 posició per a deixar un forat pel nou '1'. El mètode set fa un UPDATE.
    }
    
    
    // SI HI HAGUESSIN 2 O MÉS DEPARTAMENTS D'ENGINYERIA, EL METODE consumirContenidorDeCombustible() HAURIA DE SER synchronized.
    public void consumirContenidorDeCombustible() {
    	int posTmp;
    	
    	posTmp = posicionsEnMagatzem.indexOf('1');
    	//System.out.println("Consumit en posTmp = " + posTmp);
    	
    	posicionsEnMagatzem.set(posTmp, '0');
    }
    
}
