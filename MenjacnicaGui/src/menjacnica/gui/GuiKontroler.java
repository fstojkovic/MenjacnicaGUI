package menjacnica.gui;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

public class GuiKontroler {

	private static MenjacnicaGUI glavniProzor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new MenjacnicaGUI();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void exit() {
		int izbor = JOptionPane.showConfirmDialog(glavniProzor.getContentPane(),
				"Da li zelite da izadjete iz programa?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);

		if (izbor == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void about() {
		String poruka = "Autor: Filip Stojkovic";
		JOptionPane.showMessageDialog(glavniProzor.getContentPane(), poruka, "Podaci o autoru",
				JOptionPane.PLAIN_MESSAGE);
	}

}
