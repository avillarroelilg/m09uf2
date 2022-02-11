/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici_4_Threads_amb_Semafors_v2;

public class DeptEnginyeriaConsumidor_v5 implements Runnable {
    private MagatzemCombustible_v5 magatzemDeCombustible;
    private int numContenidorsPerAgafar;
    
    
    public DeptEnginyeriaConsumidor_v5(MagatzemCombustible_v5 borsaDeLLetres, int num) {
        this.magatzemDeCombustible = borsaDeLLetres;
        this.numContenidorsPerAgafar = num;
    }
    
    
    @Override
    public void run() {
    	int i = 0;
    	boolean exitOperacio;
    	
    	System.out.println("2222 - " + Thread.currentThread().getName() + ".INICI");
    	
    	i = 0;
        while ( i < numContenidorsPerAgafar) {
            exitOperacio = magatzemDeCombustible.consumirContenidorDeCombustible();
            
            if (exitOperacio == true) {
            	i++;
            }
        }
        
        System.out.println("2222 - " + Thread.currentThread().getName() + ".FI");
    }
    
}
