package Exercici_1_Threads_implements_Runnable;


import java.util.logging.Level;
import java.util.logging.Logger;



public class Magatzem {
	int quantitatRacions = 1000;

	
	public Magatzem() {
	}
	
	// El synchronized fa que només 1 fil pugui entrar a la vegada, a llavors
	// quan entra el fil que pateix el sleep(5000), bloqueja a la resta de
	// fils l'accés a aquest mètode.
	public synchronized void retornarRacions(int numRacions) {
        if (Thread.currentThread().getId() == Exercici_1.filID) {
            try {
            	System.out.println("    " + Thread.currentThread().getName() + ".SLEEP");

				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
        
        this.quantitatRacions = this.quantitatRacions + numRacions;
    }
    
    
    public synchronized void agafaRacions(int numRacions) {
        this.quantitatRacions = this.quantitatRacions - numRacions;    //És una suma perquè el nº que entra per paràmetre ya és negatiu.
    }
    
    
    public synchronized int comprovarQuantitatRacions() {
        return this.quantitatRacions;
    }

}
