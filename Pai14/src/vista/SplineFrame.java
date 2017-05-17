package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class SplineFrame extends JFrame {
	private SplinePanel panel;
	private JTextField numero;
	private JButton info, clear, generar;
	
	public SplineFrame(){
		this.setLayout(new BorderLayout());
		this.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 700);
		panel = new SplinePanel();
		this.add(panel, BorderLayout.CENTER);
		Action next = new AbstractAction("nextSelect") {
		    public void actionPerformed(ActionEvent e) {
		    	getPanel().nextSelect();
			}
		};
		Action prev = new AbstractAction("prevSelect") {
		    public void actionPerformed(ActionEvent e) {
		    	getPanel().prevSelect();
			}
		};
		panel.setFocusable(true);
		panel.getActionMap().put("nextSelect", next);
		panel.getActionMap().put("prevSelect", prev);
		panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"),"nextSelect");
		panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"),"prevSelect");
		
		info = new JButton();
		clear = new JButton("Clear");
		generar = new JButton("Generar");
		numero = new JTextField(10);
		JPanel buttons = new JPanel();
		buttons.add(numero);
		buttons.add(generar);
		buttons.add(clear);
		buttons.add(info);
		this.add(buttons, BorderLayout.SOUTH);
		ButtonListener listener = new ButtonListener();
		info.addActionListener(listener);
		clear.addActionListener(listener);
		generar.addActionListener(listener);
		info.setIcon(new ImageIcon("assets/info.png"));
		info.setBounds(0, 0, 100, 100);
		info.setMargin(new Insets(0, 0, 0, 0));
		info.setBorder(null);
	}

	public SplinePanel getPanel() {
		return panel;
	}

	public void setPanel(SplinePanel panel) {
		this.panel = panel;
	}

	public JTextField getNumero() {
		return numero;
	}

	public void setNumero(JTextField numero) {
		this.numero = numero;
	}
	
	public JButton getInfo() {
		return info;
	}

	public void setInfo(JButton info) {
		this.info = info;
	}

	public JButton getClear() {
		return clear;
	}

	public void setClear(JButton clear) {
		this.clear = clear;
	}

	public JButton getGenerar() {
		return generar;
	}

	public void setGenerar(JButton generar) {
		this.generar = generar;
	}

	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == getInfo()){
				popup();
				return;
			}
			if(e.getSource() == getGenerar()){
				generarRandom();
				return;
			}
			if(e.getSource() == getClear()){
				clearPanel();
				return;
			}
		}
		
		public void popup(){
			InfoFrame info = new InfoFrame();
			info.setVisible(true);
		}
		
		public void generarRandom(){
			try{
				getPanel().reset();
				getPanel().generateRandom(Integer.parseInt(getNumero().getText()));
			}
			catch(Exception e){
				System.out.println("Tienes que poner un numero en el campo de texto");
			}
		}
		
		public void clearPanel(){
			getPanel().reset();
		}
	}
}
