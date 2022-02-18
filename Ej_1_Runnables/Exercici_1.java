package Ej_1_Runnables;


public class Exercici_1 {
	static long filID;
	public static void inicialitzarPrograma() throws InterruptedException{
		Magatzem magatzemTmp = new Magatzem();
		
		System.out.println("Inici del main de CapDeDepartament.");

		Thread filCapDepartamentComandament = new Thread(new CapDeDepartament(magatzemTmp, 100));
		filCapDepartamentComandament.setName("Fil del departament 'commandament'");
		filID = filCapDepartamentComandament.getId();
		
		Thread filCapDepartamentArmes = new Thread(new CapDeDepartament(magatzemTmp, 100));
		filCapDepartamentArmes.setName("Fil del departament 'armes'");
		
		Thread filCapDepartamentTimoINavegacio = new Thread(new CapDeDepartament(magatzemTmp, -30));
		filCapDepartamentTimoINavegacio.setName("Fil del departament 'timó i navegació'");
		
		Thread filCapDepartamentEnginyeria = new Thread(new CapDeDepartament(magatzemTmp, 1000));
		filCapDepartamentEnginyeria.setName("Fil del departament 'enginyeria'");
		
		Thread filCapDepartamentCiencia = new Thread(new CapDeDepartament(magatzemTmp, -50));
		filCapDepartamentCiencia.setName("Fil del departament 'ciència'");
		
		filCapDepartamentComandament.start();
		filCapDepartamentArmes.start();
		filCapDepartamentTimoINavegacio.start();
		filCapDepartamentEnginyeria.start();
		filCapDepartamentCiencia.start();
		
		filCapDepartamentComandament.join();
		filCapDepartamentArmes.join();
		filCapDepartamentTimoINavegacio.join();
		filCapDepartamentEnginyeria.join();
		filCapDepartamentCiencia.join();
		
		System.out.println("Saldo total (desde el main) = " + magatzemTmp.comprovarQuantitatRacions());
        System.out.println("Final Fil Principal");
		
	
		
	}
}
