/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici_3_Threads_amb_Notify_Wait;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author gines
 */
public class MagatzemCombustible_v3 {
    ArrayList <Character> posicionsEnMagatzem = new ArrayList<Character>();

    
   	public MagatzemCombustible_v3() {
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
    
   	// Per a poder fer servir els wait() i el notify() hem de fer synchronized al mètode.
    public synchronized void produirContenidorDeCombustible() {
    	int posTmp;
    	
    	if (numContenidorsAlMagatzem() < 10) {
    		posTmp = posicionsEnMagatzem.indexOf('0');
    		
    		posicionsEnMagatzem.set(posTmp, '1'); 
    		// El mètode add(pos, '1') fa un INSERT un '1' en la posició 'pos' i mou la resta d'elements que hi ha
    		// des de 'pos' cap a la dreta 1 posició per a deixar un forat pel nou '1'. El mètode set fa un UPDATE.    		
    		
    		notify();
    	} else {
    		try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
    	}
    }
    
    
    public synchronized void consumirContenidorDeCombustible() {
    	int posTmp;
    	
    	if (numContenidorsAlMagatzem() > 0) {
    		posTmp = posicionsEnMagatzem.indexOf('1');
    		
    		posicionsEnMagatzem.set(posTmp, '0');
    		
    		notify();
    	} else {
    		try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
    
}
