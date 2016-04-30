package menjacnica.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;

import menjacnica.Menjacnica;
import menjacnica.Valuta;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblKupovni;
	private JLabel lblProdajniKurs;
	private JTextField textFieldKupovniKurs;
	private JTextField textFieldProdajniKurs;
	private JLabel lblValuta;
	private JLabel lblIznos;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private JLabel lblVrstaTransakcije;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;
	private JTextField jtfIznos;
	private JSlider slider;
	private final ButtonGroup buttonGroup = new ButtonGroup(); // Moguce
																// check samo
																// jedan radio
																// button

	private MenjacnicaGUI glavniProzor;
	private Menjacnica sistem;
	private Valuta valuta;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI(MenjacnicaGUI glavniProzor, Valuta valuta) {
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblKupovni());
		contentPane.add(getLabel_1());
		contentPane.add(getTextFieldKupovniKurs());
		contentPane.add(getTextFieldProdajniKurs());
		contentPane.add(getLblValuta());
		contentPane.add(getLblIznos());
		contentPane.add(getRdbtnKupovina());
		contentPane.add(getRdbtnProdaja());
		contentPane.add(getLblVrstaTransakcije());
		contentPane.add(getBtnIzvrsiZamenu());
		contentPane.add(getBtnOdustani());
		contentPane.add(getJtfIznos());
		contentPane.add(getSlider());
		contentPane.add(getComboBox());

		// podesavanje
		this.glavniProzor = glavniProzor;
		this.valuta = valuta;

		prikaziValutu();
	}

	private JLabel getLblKupovni() {
		if (lblKupovni == null) {
			lblKupovni = new JLabel("Kupovni kurs");
			lblKupovni.setPreferredSize(new Dimension(91, 25));
			lblKupovni.setBounds(10, 10, 108, 25);
		}
		return lblKupovni;
	}

	private JLabel getLabel_1() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(276, 10, 134, 25);
		}
		return lblProdajniKurs;
	}

	private JTextField getTextFieldKupovniKurs() {
		if (textFieldKupovniKurs == null) {
			textFieldKupovniKurs = new JTextField();
			textFieldKupovniKurs.setEditable(false);
			textFieldKupovniKurs.setBounds(10, 34, 160, 25);
			textFieldKupovniKurs.setColumns(10);
		}
		return textFieldKupovniKurs;
	}

	private JTextField getTextFieldProdajniKurs() {
		if (textFieldProdajniKurs == null) {
			textFieldProdajniKurs = new JTextField();
			textFieldProdajniKurs.setEditable(false);
			textFieldProdajniKurs.setBounds(276, 34, 160, 25);
			textFieldProdajniKurs.setColumns(10);
		}
		return textFieldProdajniKurs;
	}

	private JLabel getLblValuta() {
		if (lblValuta == null) {
			lblValuta = new JLabel("Valuta");
			lblValuta.setBounds(177, 10, 79, 25);
		}
		return lblValuta;
	}

	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setBounds(10, 60, 160, 25);
		}
		return lblIznos;
	}

	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			rdbtnKupovina.setSelected(true);
			buttonGroup.add(rdbtnKupovina); // Jedan check
			rdbtnKupovina.setBounds(261, 92, 149, 23);
		}
		return rdbtnKupovina;
	}

	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			buttonGroup.add(rdbtnProdaja); // Jedan check
			rdbtnProdaja.setBounds(261, 128, 149, 23);
		}
		return rdbtnProdaja;
	}

	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setBounds(261, 70, 149, 25);
		}
		return lblVrstaTransakcije;
	}

	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izracunaj iznos");

			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					izvrsiZamenu();
				}
			});

			btnIzvrsiZamenu.setBounds(24, 234, 160, 25);
		}
		return btnIzvrsiZamenu;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Zatvori prozor");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(250, 234, 160, 25);
		}
		return btnOdustani;
	}

	private JTextField getJtfIznos() {
		if (jtfIznos == null) {
			jtfIznos = new JTextField();
			jtfIznos.setBounds(10, 91, 200, 25);
			jtfIznos.setColumns(10);
		}
		return jtfIznos;
	}

	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					jtfIznos.setText("" + slider.getValue());
				}
			});
			slider.setPaintLabels(true);
			slider.setSnapToTicks(true);
			slider.setPaintTicks(true);
			slider.setMajorTickSpacing(10);
			slider.setMinorTickSpacing(5);
			slider.setBounds(10, 158, 424, 42);
		}
		return slider;
	}

	private void prikaziValutu() {
		textFieldProdajniKurs.setText("" + valuta.getProdajni());
		textFieldKupovniKurs.setText("" + valuta.getKupovni());
	}

	private void izvrsiZamenu() {
		try {
			String valutaCombo = getComboBox().getSelectedItem().toString();
			double iznos = Double.parseDouble(getJtfIznos().getText());
			String kupovinaIliProdaja;
			double izracunatiIznos;

			if (getRdbtnKupovina().isSelected()) {
				kupovinaIliProdaja = "kupovina";

				izracunatiIznos = valuta.getKupovni() * iznos;

			} else {
				kupovinaIliProdaja = "prodaja";
				izracunatiIznos = valuta.getProdajni() * iznos;

			}

			glavniProzor.getJtfStatus().append("[Izvrsena zamena] Valuta: " + valutaCombo + ", iznos: "
					+ izracunatiIznos + ", kupovina/prodaja: " + kupovinaIliProdaja + '\n');

			dispose();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Morate da unesete iznos", "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addItem("EUR");
			comboBox.addItem("USD");
			comboBox.addItem("CHR");
			comboBox.setBounds(180, 36, 63, 20);
		}
		return comboBox;
	}
}
