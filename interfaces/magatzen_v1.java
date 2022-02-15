package interfaces;

public abstract class magatzen_v1 {
	abstract void retornarRacions(int numRacions); //sumarà numRacions a quantitatRacions.
	abstract void agafaRacions(int numRacions); //restarà numRacions a quantitatRacions.
	abstract int comprovarQuantitatRacions(); //retornarà quantitatRacions.

}
interface quantitatRacions {public int quantitatRacions = 1000;}
