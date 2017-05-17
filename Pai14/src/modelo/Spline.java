package modelo;

import java.util.*;

public class Spline {
	private ArrayList<Nodo> puntos;

	public Spline(){
		setPuntos(new ArrayList<Nodo>());
	}
	public Spline(ArrayList<Nodo> puntos){
		setPuntos(puntos);
	}
	
	public ArrayList<Nodo> getPuntos() {
		return puntos;
	}

	public void setPuntos(ArrayList<Nodo> puntos) {
		this.puntos = puntos;
	}
	
	public Nodo getPunto(int index){
		return getPuntos().get(index);
	}
	
	public double calculateSpline(int i, double x){
		double x1 = getPunto(i).getX();
		double x2 = getPunto(i+1).getX();
		double y1 = getPunto(i).getY();
		double y2 = getPunto(i+1).getY();
		return calculate(x1, x2, y1, y2, x);
	}
	
	public static double calculate(double x1, double x2, double y1, double y2, double x){
		double k1 = 3;
		double k2 = 2;
		double a = k1 * (x2 - x1) - (y2 - y1);
		double b = -k2 * (x2- x1) + (y2 - y1);
		double t = (x-x1)/(x2-x1);
		double q = (1 - t) * y1 + t*y2 + t * (1 - t) * (a * (1 - t) + b * t);
		return q;
	}
}
