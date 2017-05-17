/**
 * PRACTICA 14
 * 
 * Esta practica nos pide crear un Spline.
 * 
 * Clase SplinePanel. Esta clase se encarga de dibujar el spline.
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */

package vista;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.*;
import modelo.*;

public class SplinePanel extends JPanel {
	private ArrayList<Nodo> puntos;
	private Spline spline;
	private int selected;
	
	/** Constructor */
	public SplinePanel(){
		this.reset();
		this.addMouseListener(new Mover());
	}
	
	public void reset(){
		setPuntos(new ArrayList<Nodo>());
		setSpline(new Spline(getPuntos()));
		setSelected(0);
		this.repaint();
	}

	/** Método para generar puntos aleatorios */
	public void generateRandom(int cuantity){
		Random randomGenerator = new Random();
		for(int i =0; i < cuantity; i++){
			int y = randomGenerator.nextInt(this.getHeight());
			int x = randomGenerator.nextInt(this.getWidth()/cuantity) + i*(this.getWidth()/cuantity);
			Nodo punto = new Nodo(x, y);
			getPuntos().add(punto);
		}
		
		this.repaint();
		
	}
	
	/** Métodos para cambair el nodo selecionado con las flechas del teclado */
	public void nextSelect(){
		setSelected(getSelected() +1);
		if(getSelected() >= getPuntos().size())
			setSelected(0);
		this.repaint();
	}
	
	public void prevSelect(){
		setSelected(getSelected() -1);
		if(getSelected() < 0)
			setSelected(getPuntos().size()-1);
		this.repaint();
	}
	
	/** Método que vuelve el nodo selecionado a donde pinches con el raton */
	public void moveSelected(int x, int y){
		if(getPuntos().size() < 1)
			return;
		int prevX, nextX;
		if(getSelected()  == 0)
			prevX =  0;
		else
			prevX = getPuntos().get(getSelected()-1).getX();
		if(getSelected()  == getPuntos().size()-1)
			nextX = this.getWidth();
		else
			nextX = getPuntos().get(getSelected()+1).getX();
		
		Nodo selec = getPuntos().get(getSelected());
		
		if( x <= prevX)
			selec.setX(prevX+1);
		else if( x >= nextX)
			selec.setX(nextX - 1);
		else
			selec.setX(x);
		selec.setY(y);
		
		this.repaint();
	}
	
	/** Setters y getters */
	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}
	
	public ArrayList<Nodo> getPuntos() {
		return puntos;
	}

	public void setPuntos(ArrayList<Nodo> puntos) {
		this.puntos = puntos;
	}

	public Spline getSpline() {
		return spline;
	}

	public void setSpline(Spline spline) {
		this.spline = spline;
	}
	
	/** Método para dibujar */
	public void paintComponent(Graphics g){	
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g.setColor(Color.BLACK);
		
		/** Pintamos los Splines. Para cada X entre dos puntos, pintamos una recta entre los valores del spline en X y X+1 */
		for(int i =0; i< puntos.size()-1; i++){
			for(int j = getPuntos().get(i).getX(); j < getPuntos().get(i+1).getX(); j++){
				g.drawLine(j, (int)getSpline().calculateSpline(i, j), j+1, (int)getSpline().calculateSpline(i, j+1));
			}
		}
		
		/** Pintamos los puntos */
		int puntorad = 5;
		for(Nodo punto : getPuntos()){
			g.setColor(Color.RED);
			g.fillOval(punto.getX()-puntorad, punto.getY()-puntorad, puntorad*2, puntorad*2);
		}
		
		/** Pintamos un circulo azul en torno al nodo selecionado */
		g.setColor(Color.BLUE);
		if(getPuntos().size() > selected){
			g2.setStroke(new BasicStroke(3));
			g.drawOval(getPuntos().get(selected).getX()-puntorad*2, getPuntos().get(selected).getY()-puntorad*2, puntorad*4, puntorad*4);
		}
	}
	
	
	/** Listener privado */
	private class Mover implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			int x = arg0.getX();
			int y = arg0.getY();
			moveSelected(x,y);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0){}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
	}
}
