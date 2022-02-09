package Exercici_2_Threads_extends_Thread_v1;

public class MagatzemCombustible_v1 {
	char[] posicionsEnMagatzem = {'0','0','0','0','0','0','0','0','0','0'};
    int posicio = -1;		//En posicio tenim l'índex on hi ha l'últim contenidor ficat.

    
   	public MagatzemCombustible_v1() {
    }
    
    
    public synchronized int numContenidorsAlMagatzem() {
    	int numContenidors;
    	
    	numContenidors = posicio + 1;
    	
    	return numContenidors;
    }
    
    
    // EL PROBLEMA ES QUE 1 FIL POT ENTRAR EN produirContenidorDeCombustible() I UN ALTRE EN consumirContenidorDeCombustible() I 
    // A LLAVORS ACCEDIR A LA VARIABLE posicionsEnMagatzem SIMULTÀNEAMENT I PROVOCAR UN ERROR A L'ESCRIURE EN ELLA.
    // PER AIXÒ DE VEGADES PETA.
    
    // SI HI HAGUESSIN 2 O MÉS DEPARTAMENTS DE CIENCIA, EL METODE produirContenidorDeCombustible() HAURIA DE SER synchronized.
    public void produirContenidorDeCombustible() {
        if ((-1 <= posicio) && (posicio <= 8)){		//De  [-1,8] --> [0,9].
            posicio++;
        	
            posicionsEnMagatzem[posicio] = '1';
        }
    }
    
    
    // SI HI HAGUESSIN 2 O MÉS DEPARTAMENTS D'ENGINYERIA, EL METODE consumirContenidorDeCombustible() HAURIA DE SER synchronized.    
    public void consumirContenidorDeCombustible() {
        if ((0 <= posicio) && (posicio <= 9)){		//Entre [0,9] hi ha contenidors.
            posicionsEnMagatzem[posicio] = '0';
            
            posicio--;
        } 
    }
    
}
