package gui.demo.c2.p26;

import javax.swing.JFrame;

import gui.demo.c2.p21.Traductor;

public class VentanaTraductor extends JFrame{
	static final long serialVersionUID=1;
	
	public VentanaTraductor(Traductor traductor) {

		this.setContentPane(new PanelTraductor(traductor));
		this.setTitle("Traductor (2.6)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,200);
		this.setVisible(true);
	}
}
