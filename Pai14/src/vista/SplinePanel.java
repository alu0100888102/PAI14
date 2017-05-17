package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.CubicCurve2D;

import javax.swing.*;
import java.util.*;
import modelo.*;

public class SplinePanel extends JPanel {
	private ArrayList<Nodo> puntos;
	private Spline spline;
	private int selected;
	
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
	
	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public void sprevious(){
		setSelected(getSelected()-1);
		if(getSelected() < 0)
			setSelected(getPuntos().size()-1);
	}
	
	public void snext(){
		setSelected(getSelected()+1);
		if(getSelected() >= getPuntos().size())
			setSelected(0);
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
	
	public void paintComponent(Graphics g){	
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setBackground(Color.LIGHT_GRAY);
		g.setColor(Color.BLACK);
		for(int i =0; i< puntos.size()-1; i++){
			for(int j = getPuntos().get(i).getX(); j < getPuntos().get(i+1).getX(); j++){
				g.drawLine(j, (int)getSpline().calculateSpline(i, j), j+1, (int)getSpline().calculateSpline(i, j+1));
			}
		}
		
		
		for(Nodo punto : getPuntos()){
			g.setColor(Color.RED);
			g.fillOval(punto.getX()-5, punto.getY()-5, 10, 10);
		}
		
		g.setColor(Color.BLUE);
		if(getPuntos().size() > selected){
			g2.setStroke(new BasicStroke(3));
			g.drawOval(getPuntos().get(selected).getX()-10, getPuntos().get(selected).getY()-10, 20, 20);
		}
	}
	
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
	
	private class Selector implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
	
			if(key == KeyEvent.VK_RIGHT)
				nextSelect();
			if(key == KeyEvent.VK_LEFT)
				prevSelect();
		}

		@Override
		public void keyReleased(KeyEvent e) {}

		@Override
		public void keyTyped(KeyEvent e) {}
		
	}
}
