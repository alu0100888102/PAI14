/**
 * PRACTICA 14
 * 
 * Esta practica nos pide crear un Spline.
 * 
 * Clase Nodo. Representa un punto en el espacio por el que ha de pasar el spline
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */


package modelo;

public class Nodo {
	private int x;
	private int y;
	
	/** Constructores */
	public Nodo(){
		setX(0);
		setY(0);
	}
	public Nodo(int x, int y){
		setX(x);
		setY(y);
	}
	
	/** Setters y getters */
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
