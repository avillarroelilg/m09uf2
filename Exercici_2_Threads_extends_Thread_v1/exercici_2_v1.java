/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici_2_Threads_extends_Thread_v1;


/**
 *
 * @author gines
 */
public class exercici_2_v1 {
	static public void inicialitzarPrograma() {
        MagatzemCombustible_v1 magatzemDeCombustible_v1 = new MagatzemCombustible_v1();
        DeptCienciaProductor_v1 deptCienciaProductor_v1 = new DeptCienciaProductor_v1(magatzemDeCombustible_v1);
        DeptEnginyeriaConsumidor_v1 deptEnginyeriaConsumidor_v1 = new DeptEnginyeriaConsumidor_v1(magatzemDeCombustible_v1);

        
        System.out.println("Exercici_2.inicialitzarPrograma() - INICI");
        System.out.println("Exercici_2.magatzemDeCombustible.posicionsEnMagatzem = " + new String(magatzemDeCombustible_v1.posicionsEnMagatzem));
        
        deptCienciaProductor_v1.start();
        deptEnginyeriaConsumidor_v1.start();
        
        try {
            deptCienciaProductor_v1.join();
            deptEnginyeriaConsumidor_v1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Exercici_2.magatzemDeCombustible.posicionsEnMagatzem = " + new String(magatzemDeCombustible_v1.posicionsEnMagatzem));
        System.out.println("Exercici_2.inicialitzarPrograma() - FI");
        
    }
    
    
}
