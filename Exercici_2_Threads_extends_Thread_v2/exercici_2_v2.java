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
public class exercici_2_v2 {
	static public void inicialitzarPrograma() {
        MagatzemCombustible_v2 magatzemDeCombustible_v2 = new MagatzemCombustible_v2();
        DeptCienciaProductor_v2 deptCienciaProductor_v2 = new DeptCienciaProductor_v2(magatzemDeCombustible_v2);
        DeptEnginyeriaConsumidor_v2 deptEnginyeriaConsumidor_v2 = new DeptEnginyeriaConsumidor_v2(magatzemDeCombustible_v2);

        
        System.out.println("Exercici_3.inicialitzarPrograma() - INICI");
        System.out.println("Exercici_3.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemDeCombustible_v2.posicionsEnMagatzem);
        
        deptCienciaProductor_v2.start();
        deptEnginyeriaConsumidor_v2.start();
        
        try {
            deptCienciaProductor_v2.join();
            deptEnginyeriaConsumidor_v2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Exercici_3.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemDeCombustible_v2.posicionsEnMagatzem);
        System.out.println("Exercici_3.inicialitzarPrograma() - FI");
        
    }
    
    
}
