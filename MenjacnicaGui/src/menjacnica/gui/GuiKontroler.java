package menjacnica.gui;

import java.awt.EventQueue;

public class GuiKontroler {

	private static MenjacnicaGUI glavniprozor;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniprozor = new MenjacnicaGUI();
					glavniprozor.setVisible(true);
					glavniprozor.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
