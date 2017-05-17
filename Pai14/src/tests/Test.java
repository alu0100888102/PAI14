package tests;

import static org.junit.Assert.*;
import modelo.*;
import java.util.*;


import vista.*;

public class Test {

	/** Tests de la clase Nodo */
	
	@org.junit.Test
	public final void testNodo() {
		Nodo test = new Nodo();
		assert(test.getX() == 0 && test.getY() == 0);
	}

	@org.junit.Test
	public final void testNodoIntInt() {
		Nodo test = new Nodo(1,2);
		assert(test.getX() == 1 && test.getY() == 2);
	}

	@org.junit.Test
	public final void testSetX() {
		Nodo test = new Nodo();
		assert(test.getX() == 0 && test.getY() == 0);
		test.setX(10);
		assert(test.getX() == 10 && test.getY() == 0);
	}

	@org.junit.Test
	public final void testSetY() {
		Nodo test = new Nodo();
		assert(test.getX() == 0 && test.getY() == 0);
		test.setY(10);
		assert(test.getX() == 0 && test.getY() == 10);
	}

	/** Tests de la clase Spline */
	
	@org.junit.Test
	public final void testSpline() {
		Spline test = new Spline();
		assert(test.getPuntos() != null);
	}

	@org.junit.Test
	public final void testSplineArrayListOfNodo() {
		ArrayList<Nodo> p = new ArrayList<Nodo>();
		Spline test = new Spline(p);
		assert(test.getPuntos() == p);
	}

	@org.junit.Test
	public final void testSetPuntos() {
		Spline test = new Spline();
		assert(test.getPuntos() != null);
		ArrayList<Nodo> p = new ArrayList<Nodo>();
		test.setPuntos(p);
		assert(test.getPuntos() == p);
	}

	@org.junit.Test
	public final void testGetPunto() {
		ArrayList<Nodo> p = new ArrayList<Nodo>();
		Spline test = new Spline(p);
		p.add(new Nodo(1,2));
		p.add(new Nodo(3,4));
		p.add(new Nodo(5,6));
		p.add(new Nodo(7,9));
		assert(test.getPuntos().get(0) == test.getPunto(0));
		assert(test.getPuntos().get(1) == test.getPunto(1));
		assert(test.getPuntos().get(2) == test.getPunto(2));
		assert(test.getPuntos().get(3) == test.getPunto(3));
	}
	
	/** Tests de SplinePanel */
	

	@org.junit.Test
	public final void testSplinePanel() {
		SplinePanel test = new SplinePanel();
		assert(test != null);
	}

	@org.junit.Test
	public final void testReset() {
		SplinePanel test = new SplinePanel();
		ArrayList<Nodo> p = test.getPuntos();
		test.reset();
		assert(p != test.getPuntos() && test.getPuntos().size() == 0);
	}

	@org.junit.Test
	public final void testSetPuntosPanel() {
		SplinePanel test = new SplinePanel();
		assert(test.getPuntos() != null);
		ArrayList<Nodo> p = new ArrayList<Nodo>();
		test.setPuntos(p);
		assert(test.getPuntos() == p);
	}

	@org.junit.Test
	public final void testSetSpline() {
		SplinePanel test = new SplinePanel();
		assert(test.getSpline() != null);
		Spline p = new Spline();
		test.setSpline(p);
		assert(test.getSpline() == p);
	}
	
	/** Tests de SplineFrame */
	
	@org.junit.Test
	public final void testSplineFrame() {
		SplineFrame test = new SplineFrame();
		assert(test != null);
	}

	@org.junit.Test
	public final void testSetPanel() {
		SplineFrame test = new SplineFrame();
		SplinePanel p = new SplinePanel();
		test.setPanel(p);
		assert( test.getPanel() == p);
	}
	
}
