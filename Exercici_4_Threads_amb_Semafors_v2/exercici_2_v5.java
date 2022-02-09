/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici_4_Threads_amb_Semafors_v2;


/**
 *
 * @author gines
 */
public class exercici_2_v5 {
	static public void inicialitzarPrograma() {
        MagatzemCombustible_v5 magatzemDeCombustible_v5 = new MagatzemCombustible_v5();
        DeptCienciaProductor_v5 deptCienciaProductor_v5 = new DeptCienciaProductor_v5(magatzemDeCombustible_v5);
        DeptEnginyeriaConsumidor_v5 deptEnginyeriaConsumidor_1_v5 = new DeptEnginyeriaConsumidor_v5(magatzemDeCombustible_v5, 7);
        DeptEnginyeriaConsumidor_v5 deptEnginyeriaConsumidor_2_v5 = new DeptEnginyeriaConsumidor_v5(magatzemDeCombustible_v5, 10);

        
        System.out.println("Exercici_6.inicialitzarPrograma() - INICI");
        System.out.println("Exercici_6.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemDeCombustible_v5.posicionsEnMagatzem);
        
        Thread deptCienciaProductor = new Thread(deptCienciaProductor_v5);
        Thread deptEnginyeriaConsumidor_1 = new Thread(deptEnginyeriaConsumidor_1_v5);
        deptEnginyeriaConsumidor_1.setName("deptEnginyeriaConsumidor_1");
        Thread deptEnginyeriaConsumidor_2 = new Thread(deptEnginyeriaConsumidor_2_v5);
        deptEnginyeriaConsumidor_2.setName("deptEnginyeriaConsumidor_2");
        
        deptCienciaProductor.start();
        deptEnginyeriaConsumidor_1.start();
        deptEnginyeriaConsumidor_2.start();
        
        try {
        	deptCienciaProductor.join();
            deptEnginyeriaConsumidor_1.join();
            deptEnginyeriaConsumidor_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Exercici_6.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemDeCombustible_v5.posicionsEnMagatzem);
        System.out.println("Exercici_6.inicialitzarPrograma() - FI");
        
    }
    
    
}
