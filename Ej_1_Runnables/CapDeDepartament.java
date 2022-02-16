package Ej_1_Runnables;

public class CapDeDepartament implements Runnable {
	private Magatzem magatzem;
	int movimentRacions;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String nomFil = Thread.currentThread().getName();
		System.out.println("    " + nomFil + ".INICI\n "
				+ "\\s.movimentRacions = "  + movimentRacions
				+ "\n\\s.magatzem.comprovarQuantitatRacions() = "  + magatzem.comprovarQuantitatRacions());
		
        System.out.println("    " + nomFil + ".REALITZO L'OPERACIÓ");
		
		if (movimentRacions > 0) {
        	magatzem.retornarRacions(movimentRacions);
        } else {
        	magatzem.agafaRacions(movimentRacions);
        }
		System.out.println("    " + nomFil + ".magatzem.comprovarQuantitatRacions() = "  + magatzem.comprovarQuantitatRacions());
        System.out.println("    " + nomFil + ".FI");
	}

}
