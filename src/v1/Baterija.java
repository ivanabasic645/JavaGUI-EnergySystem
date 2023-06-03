package v1;

public class Baterija {

	int trenutnaEnergija;
	int maxKapacitet;

	public Baterija(int max) {
		maxKapacitet = max;
		trenutnaEnergija = max;
	}
	
	public void dodajEnergiju(int n) {
		trenutnaEnergija += n;
		if(trenutnaEnergija > maxKapacitet) {
			trenutnaEnergija = maxKapacitet;
		}
	}
	
	public void isprazni() {
		trenutnaEnergija = 0;
	}
	
	public boolean baterijaPuna() {
		return trenutnaEnergija == maxKapacitet;
	}

}
