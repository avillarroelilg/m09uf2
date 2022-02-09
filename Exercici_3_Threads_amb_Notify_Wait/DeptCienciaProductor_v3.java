/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici_3_Threads_amb_Notify_Wait;



/**
 *
 * @author gines
 */
public class DeptCienciaProductor_v3 implements Runnable {
    private MagatzemCombustible_v3 magatzemDeCombustible;

        
    public DeptCienciaProductor_v3(MagatzemCombustible_v3 magatzemDeCombustible) {
        this.magatzemDeCombustible = magatzemDeCombustible;
    }
    
    
    @Override
    public void run() {
    	int i;
    	
    	
        System.out.println("1111 - DeptCienciaProductor.INICI");
        
        i = 0;
        while (i < 20) {
        	System.out.println("1111.1 - DeptCienciaProductor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() + ", " + magatzemDeCombustible.posicionsEnMagatzem);
            magatzemDeCombustible.produirContenidorDeCombustible();
            System.out.println("1111.2 - DeptCienciaProductor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() + ", " + magatzemDeCombustible.posicionsEnMagatzem);
            
            i++;
        }
        
        System.out.println("1111 - DeptCienciaProductor.FI");
    }
    
}
