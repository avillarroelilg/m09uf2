package interfaces;

public abstract class magatzen_v2 {
	private char[] posicionsEnMagatzem = {'0','0','0','0','0','0','0','0','0','0'};
	 int posicio = -1; 
	 
	 int numContenidorsAlMagatzem() {return posicio;}
	 void produirContenidorDeCombustible() {}
	 void consumirContenidorDeCombustible() {}
}
