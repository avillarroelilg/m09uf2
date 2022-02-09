/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici_2_Threads_extends_Thread_v2;


/**
 *
 * @author gines
 */
public class DeptEnginyeriaConsumidor_v2 extends Thread {
    private MagatzemCombustible_v2 magatzemDeCombustible;
    
    
    public DeptEnginyeriaConsumidor_v2(MagatzemCombustible_v2 borsaDeLLetres) {
        this.magatzemDeCombustible = borsaDeLLetres;
    }
    
    
    @Override
    public void run() {
    	char contenidor;
    	int i = 0;
    	
    	System.out.println("2222 - DeptEnginyeriaConsumidor.INICI");
    	
    	i = 0;
        while ( i < 13) {
            if (magatzemDeCombustible.numContenidorsAlMagatzem() > 0) {
                System.out.println("2222.1 - [" + i + "] - DeptEnginyeriaConsumidor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() + ", " + magatzemDeCombustible.posicionsEnMagatzem);
                magatzemDeCombustible.consumirContenidorDeCombustible();
                System.out.println("2222.2 - [" + i + "] - DeptEnginyeriaConsumidor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() + ", " + magatzemDeCombustible.posicionsEnMagatzem);
                
                i++;
            }
        }
        
        System.out.println("2222 - DeptEnginyeriaConsumidor.FI");
    }
    
}
