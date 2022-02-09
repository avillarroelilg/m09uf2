/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici_3_Threads_amb_Notify_Wait;

import Exercici_2_Threads_extends_Thread_v2.DeptCienciaProductor_v2;
import Exercici_2_Threads_extends_Thread_v2.DeptEnginyeriaConsumidor_v2;
import Exercici_2_Threads_extends_Thread_v2.MagatzemCombustible_v2;

/**
 *
 * @author gines
 */
public class exercici_2_v3 {
	static public void inicialitzarPrograma() {
        MagatzemCombustible_v3 magatzemDeCombustible_v3 = new MagatzemCombustible_v3();
        DeptCienciaProductor_v3 deptCienciaProductor_v3 = new DeptCienciaProductor_v3(magatzemDeCombustible_v3);
        DeptEnginyeriaConsumidor_v3 deptEnginyeriaConsumidor_v3 = new DeptEnginyeriaConsumidor_v3(magatzemDeCombustible_v3);

        
        System.out.println("Exercici_4.inicialitzarPrograma() - INICI");
        System.out.println("Exercici_4.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemDeCombustible_v3.posicionsEnMagatzem);
        
        Thread deptCienciaProductor = new Thread(deptCienciaProductor_v3);
        Thread deptEnginyeriaConsumidor = new Thread(deptEnginyeriaConsumidor_v3);
        
        deptCienciaProductor.start();
        deptEnginyeriaConsumidor.start();
        
        try {
        	//El main() continuarà la seva execució 5 segons després d'inicialitzar productorDeLLetresThread i 
            //consumidorDeLLetresThread independentment que aquest hagin acabat la seva execució.
        	deptCienciaProductor.join(5000);
            deptEnginyeriaConsumidor.join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Exercici_4.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemDeCombustible_v3.posicionsEnMagatzem);
        System.out.println("Exercici_4.inicialitzarPrograma() - FI");
        
    }
    
}
