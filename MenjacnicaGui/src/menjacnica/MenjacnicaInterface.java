package menjacnica;

import java.util.LinkedList;

public interface MenjacnicaInterface {

	public void dodajValutu(Valuta valuta);

	public void izbrisiValutu(Valuta valuta);

	public LinkedList<Valuta> vratiSveValute();

	public void ucitajIzFajla(String putanja);

	public void sacuvajUFajl(String putanja);


}
