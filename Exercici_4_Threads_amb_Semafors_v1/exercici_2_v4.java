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
public class exercici_2_v4 {
	static public void inicialitzarPrograma() {
        MagatzemCombustible_v4 magatzemDeCombustible_v4 = new MagatzemCombustible_v4();
        DeptCienciaProductor_v4 deptCienciaProductor_v4 = new DeptCienciaProductor_v4(magatzemDeCombustible_v4);
        DeptEnginyeriaConsumidor_v4 deptEnginyeriaConsumidor_v4 = new DeptEnginyeriaConsumidor_v4(magatzemDeCombustible_v4);

        
        System.out.println("Exercici_5.inicialitzarPrograma() - INICI");
        System.out.println("Exercici_5.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemDeCombustible_v4.posicionsEnMagatzem);
        
        Thread deptCienciaProductor = new Thread(deptCienciaProductor_v4);
        Thread deptEnginyeriaConsumidor = new Thread(deptEnginyeriaConsumidor_v4);
        
        deptCienciaProductor.start();
        deptEnginyeriaConsumidor.start();
        
        try {
        	deptCienciaProductor.join();
            deptEnginyeriaConsumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Exercici_5.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemDeCombustible_v4.posicionsEnMagatzem);
        System.out.println("Exercici_5.inicialitzarPrograma() - FI");
        
    }
    
    
}
