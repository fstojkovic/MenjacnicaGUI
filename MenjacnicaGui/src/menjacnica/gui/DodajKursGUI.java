package menjacnica.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.Valuta;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSifra;
	private JTextField jtfSifra;
	private JLabel lblNaziv;
	private JTextField jtfNaziv;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField jtfProdajniKurs;
	private JTextField jtfKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField jtfSrednjiKurs;
	private JTextField jtfSkraceniNaziv;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private MenjacnicaGUI glavniProzor;

	/**
	 * Create the frame.
	 */
	public DodajKursGUI(MenjacnicaGUI glavniProzor) {

		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 302, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		contentPane.add(getLblSifra());
		contentPane.add(getLblNaziv());
		contentPane.add(getJtfSifra());
		contentPane.add(getJtfNaziv());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getJtfProdajniKurs());
		contentPane.add(getJtfKupovniKurs());
		contentPane.add(getLblSrednjiKurs());
		contentPane.add(getLblSkraceniNaziv());
		contentPane.add(getJtfSrednjiKurs());
		contentPane.add(getJtfSkraceniNaziv());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
		this.glavniProzor = glavniProzor;
	}

	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
		}
		return lblSifra;
	}

	private JTextField getJtfSifra() {
		if (jtfSifra == null) {
			jtfSifra = new JTextField();
			jtfSifra.setColumns(10);
		}
		return jtfSifra;
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
		}
		return lblNaziv;
	}

	private JTextField getJtfNaziv() {
		if (jtfNaziv == null) {
			jtfNaziv = new JTextField();
			jtfNaziv.setColumns(10);
		}
		return jtfNaziv;
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
		}
		return lblProdajniKurs;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
		}
		return lblKupovniKurs;
	}

	private JTextField getJtfProdajniKurs() {
		if (jtfProdajniKurs == null) {
			jtfProdajniKurs = new JTextField();
			jtfProdajniKurs.setColumns(10);
		}
		return jtfProdajniKurs;
	}

	private JTextField getJtfKupovniKurs() {
		if (jtfKupovniKurs == null) {
			jtfKupovniKurs = new JTextField();
			jtfKupovniKurs.setColumns(10);
		}
		return jtfKupovniKurs;
	}

	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
		}
		return lblSrednjiKurs;
	}

	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
		}
		return lblSkraceniNaziv;
	}

	private JTextField getJtfSrednjiKurs() {
		if (jtfSrednjiKurs == null) {
			jtfSrednjiKurs = new JTextField();
			jtfSrednjiKurs.setColumns(10);
		}
		return jtfSrednjiKurs;
	}

	private JTextField getJtfSkraceniNaziv() {
		if (jtfSkraceniNaziv == null) {
			jtfSkraceniNaziv = new JTextField();
			jtfSkraceniNaziv.setColumns(10);
		}
		return jtfSkraceniNaziv;
	}

	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					unesiKurs();

				}
			});
		}
		return btnDodaj;
	}

	private void unesiKurs() {
		try {
			Valuta valuta = new Valuta();

			valuta.setNaziv(jtfNaziv.getText());
			valuta.setSkraceniNaziv(jtfSkraceniNaziv.getText());
			valuta.setSifra(Integer.parseInt(jtfSifra.getText()));
			valuta.setProdajni(Double.parseDouble(jtfProdajniKurs.getText()));
			valuta.setKupovni(Double.parseDouble(jtfKupovniKurs.getText()));
			valuta.setSrednji(Double.parseDouble(jtfSrednjiKurs.getText()));

			glavniProzor.sistem.dodajValutu(valuta);
			glavniProzor.getJtfStatus().append("Uneli ste valutu: "+valuta.toString()+'\n');
			glavniProzor.prikaziSveValute();

			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnOdustani;
	}
}
