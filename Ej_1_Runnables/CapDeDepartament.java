package Ej_1_Runnables;

import Ej_1_Runnables.Magatzem;

public class CapDeDepartament implements Runnable {
	private Magatzem magatzem;
	int movimentRacions;
<<<<<<< HEAD
	public CapDeDepartament() {

=======
	
	public CapDeDepartament(Magatzem magatzemTmp, int movimentRacions) {
		this.magatzem = magatzemTmp;
		this.movimentRacions = movimentRacions;
>>>>>>> c39670c36c855e18104efba63d2e839f12576c3c
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String nomFil = Thread.currentThread().getName();
		System.out.println("    " + nomFil + ".INICI\n "
				+ "   .movimentRacions = "  + movimentRacions
				+ "\n   .magatzem.comprovarQuantitatRacions() = "  + magatzem.comprovarQuantitatRacions());
		
        System.out.println("    " + nomFil + ".REALITZO L'OPERACIÓ");
		
		if (movimentRacions > 0) {
        	magatzem.retornarRacions(movimentRacions);
        	//System.out.println("#### retornar ####");
        } else {
        	magatzem.agafaRacions(movimentRacions);
        	//System.out.println("#### agafar ####");
        }
		System.out.println("    " + nomFil + ".magatzem.comprovarQuantitatRacions() = "  + magatzem.comprovarQuantitatRacions());
        System.out.println("    " + nomFil + ".FI");
	}

}
