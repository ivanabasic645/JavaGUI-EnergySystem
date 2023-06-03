package v1;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac implements Runnable {
	
	int vodenePovrsine;
	Thread nit = new Thread(this);

	public Hidroelektrana(int vreme, int baterija) {
		super(vreme, baterija);
		pozadina = Color.BLUE;
		oznaka = 'H';
	}
	
	

}
