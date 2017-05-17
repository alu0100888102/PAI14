/**
 * PRACTICA 14
 * 
 * Esta practica nos pide crear un Spline.
 * 
 * Clase Controlador. Controla el pograma, aunque de momento su unica tarea es iniciarlo.
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */


package controlador;

import javax.swing.JFrame;

import vista.*;

public class Controlador {
	private SplineFrame frame;

	/** Constructor */
	public Controlador(){
		setFrame(new SplineFrame());
		getFrame().setLocationRelativeTo(null); // Center the frame
		getFrame().setVisible(false);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setSize(900, 700);
	}
	
	public void start(){
		getFrame().setVisible(true);
	}
	
	/** Setters y getters */
	public SplineFrame getFrame() {
		return frame;
	}

	public void setFrame(SplineFrame frame) {
		this.frame = frame;
	}
	
}
