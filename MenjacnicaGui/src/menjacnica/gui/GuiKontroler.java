package menjacnica.gui;

import java.awt.EventQueue;
import java.util.List;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import menjacnica.MenjacnicaInterface;
import menjacnica.Valuta;

public class GuiKontroler {

	private static MenjacnicaGUI glavniProzor;
	private static MenjacnicaInterface menjacnica;

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
				"Da li zelite da izadjete iz programa?", "Izlaz", JOptionPane.YES_NO_CANCEL_OPTION,
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

	public static void dodajUPoljeZaIspis(String tekst) {
		glavniProzor.getJtfStatus().setText(tekst);
	}

	public static void ucitajIzfajla() {
		try {
			JFileChooser fc = new JFileChooser();
			int vrednost = fc.showOpenDialog(glavniProzor.getContentPane());

			if (vrednost == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();

				menjacnica.ucitajIzFajla(f.getAbsolutePath());
				String tekst = "Ucitan fajl: " + f.getAbsolutePath() + System.lineSeparator();
				dodajUPoljeZaIspis(tekst);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void sacuvajUFajl() {
		try {
			JFileChooser fc = new JFileChooser();
			int vrednost = fc.showSaveDialog(glavniProzor.getContentPane());

			if (vrednost == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();

				menjacnica.sacuvajUFajl(f.getAbsolutePath());
				String tekst = "Sacuvan fajl: " + f.getAbsolutePath() + System.lineSeparator();
				dodajUPoljeZaIspis(tekst);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static List<Valuta> vratiSveValute() {
		return menjacnica.vratiSveValute();
	}

}
