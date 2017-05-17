package vista;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class InfoFrame extends JFrame{
	
	public InfoFrame(){
		this.setLayout(new BorderLayout());
		this.setSize(750, 150);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		TextArea message = new TextArea();
		String out = "Aplicaci�n realizada durante la 14� pr�ctica de Programaci�n de Aplicaciones Interactivas, en la universidad de La Laguna\n";
		out += "Autor: �ngel Alberto Hamilton L�pez.\n";
		out += "alu0100888102\n";
		out += "alu0100888102@ull.edu.es";
		message.setEditable(false);
		message.setText(out);
		this.add(message);
	}

}