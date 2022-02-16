package interfaces;

public abstract class magatzen_v1 {
	protected int quantitatRacions = 1000;
	public abstract void retornarRacions(int numRacions); //sumarà numRacions a quantitatRacions.
	public abstract void agafaRacions(int numRacions); //restarà numRacions a quantitatRacions.
	public abstract int comprovarQuantitatRacions(); //retornarà quantitatRacions.

}
