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
public class DeptCienciaProductor_v2 extends Thread {
    private MagatzemCombustible_v2 magatzemDeCombustible;

        
    public DeptCienciaProductor_v2(MagatzemCombustible_v2 magatzemDeCombustible) {
        this.magatzemDeCombustible = magatzemDeCombustible;
    }
    
    
    @Override
    public void run() {
    	int i;
    	
    	
        System.out.println("1111 - DeptCienciaProductor.INICI");
        
        i = 0;
        while (i < 20) {
        	if (magatzemDeCombustible.numContenidorsAlMagatzem() < 10) {
            	System.out.println("1111.1 - DeptCienciaProductor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() + ", " + magatzemDeCombustible.posicionsEnMagatzem);
                magatzemDeCombustible.produirContenidorDeCombustible();
                System.out.println("1111.2 - DeptCienciaProductor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() + ", " + magatzemDeCombustible.posicionsEnMagatzem);
                
                i++;
            }
        }
        
        System.out.println("1111 - DeptCienciaProductor.FI");
    }
    
}
