package controlador;

import vista.*;

public class Controlador {
	private SplineFrame frame;

	public Controlador(){
		setFrame(new SplineFrame());
		getFrame().setLocationRelativeTo(null); // Center the frame
		getFrame().setVisible(false);
	}
	
	public void start(){
		getFrame().setVisible(true);
	}
	
	public SplineFrame getFrame() {
		return frame;
	}

	public void setFrame(SplineFrame frame) {
		this.frame = frame;
	}
	
}
