/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici_4_Threads_amb_Semafors_v1;

public class DeptEnginyeriaConsumidor_v4 implements Runnable {
    private MagatzemCombustible_v4 magatzemDeCombustible;
    
    
    public DeptEnginyeriaConsumidor_v4(MagatzemCombustible_v4 borsaDeLLetres) {
        this.magatzemDeCombustible = borsaDeLLetres;
    }
    
    
    @Override
    public void run() {
    	int i = 0;
    	boolean exitOperacio;
    	
    	System.out.println("2222 - DeptEnginyeriaConsumidor.INICI");
    	
    	i = 0;
        while ( i < 13) {
            exitOperacio = magatzemDeCombustible.consumirContenidorDeCombustible();
            
            if (exitOperacio == true) {
            	i++;
            }
        }
        
        System.out.println("2222 - DeptEnginyeriaConsumidor.FI");
    }
    
}
