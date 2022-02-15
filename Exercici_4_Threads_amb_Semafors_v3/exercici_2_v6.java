/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici_4_Threads_amb_Semafors_v3;

public class exercici_2_v6 {
	static public void inicialitzarPrograma() {
		int numTubs = 3;									// Indica quants tubs hi ha. Només es pot llançar 1 torpede per tub simultàneament.
		SistemaDeGuiaDeTorpedes sistemaDeGuiaDeTorpedes = new SistemaDeGuiaDeTorpedes(numTubs);		
		int numTorpedes = 10; 								// Indica quants torpedes hi ha.
        Thread[] torpedes = new Thread[numTorpedes];		// En aquest array tinc tots els torpedes.
		

        sistemaDeGuiaDeTorpedes.imprimirUsDelSistemaDeGuia("Exercici_7.inicialitzarPrograma() - INICI");
        
        for (int i = 0; i < numTorpedes; i++){
        	Torpede torpedeTmp = new Torpede(sistemaDeGuiaDeTorpedes);
        	
        	torpedes[i] = new Thread(torpedeTmp);
        	torpedes[i].setName("torpede " + i);
        	
        	torpedes[i].start();
        }
        
        try {
			torpedes[numTorpedes - 1].join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        sistemaDeGuiaDeTorpedes.imprimirUsDelSistemaDeGuia("Exercici_7.inicialitzarPrograma() - FI");
    }
    
    
}
