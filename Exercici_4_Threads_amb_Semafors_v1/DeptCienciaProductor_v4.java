/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici_4_Threads_amb_Semafors_v1;



/**
 *
 * @author gines
 */
public class DeptCienciaProductor_v4 implements Runnable {
    private MagatzemCombustible_v4 magatzemDeCombustible;

        
    public DeptCienciaProductor_v4(MagatzemCombustible_v4 magatzemDeCombustible) {
        this.magatzemDeCombustible = magatzemDeCombustible;
    }
    
    
    @Override
    public void run() {
    	int i;
    	boolean exitOperacio;
    	
    	
        System.out.println("1111 - DeptCienciaProductor.INICI");
        
        i = 0;
        while (i < 20) {
        	exitOperacio = magatzemDeCombustible.produirContenidorDeCombustible();
        	
            if (exitOperacio == true) {
            	i++;
            }
        }
        
        System.out.println("1111 - DeptCienciaProductor.FI");
    }
    
}
