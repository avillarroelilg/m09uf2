package Ej_1_Runnables;
import interfaces.*;

// implementacion del synchronized version 1 

public class Magatzem extends magatzen_v1 {
	
	public Magatzem() {} 
	
	@Override
	public synchronized void agafaRacions(int numRacions) {
		
		System.out.println(" " + Thread.currentThread().getName() + ".SLEEP");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.quantitatRacions -=  numRacions;
	}
	
	@Override
	public synchronized void retornarRacions(int numRacions) {
		this.quantitatRacions += numRacions;	
	}
	
	@Override
	public synchronized int comprovarQuantitatRacions() {

		return quantitatRacions;
	}
}
