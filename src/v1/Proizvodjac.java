package v1;

public class Proizvodjac extends Parcela implements Runnable{
	
	private int vreme;
	private int baterija;
	Thread proizvodjac = new Thread(this);
	
	public Proizvodjac(int vreme, int baterija) {
		this.vreme = vreme;
		this.baterija = baterija;
		proizvodjac.start();
	}
	
	public int ukupnoVreme() {
		return (int) (vreme + Math.random() * 300);
	}

	@Override
	public void run() {
		//Произвођач периодично сачека укупно време, затим произведе извесан број јединица
		//енергије којима пуни батерију (уз могући неуспех производње) и додатно сачека 300
		//милисекунди. Уколико је произвођач успешно произвео енергију, његов натпис се исписује
		//црвеном бојом (RED) у току наведеног интервала од 300 милисекунди, након текуће
		//производње, а пре новог циклуса производње. Могуће је зауставити произвођача.
		while(!Thread.interrupted()) {
			try {
				int ukupnoVreme = ukupnoVreme();
				synchronized(this) {
					while(ukupnoVreme != 0) {
						wait();
						ukupnoVreme--;
					}
				}
				proizvedi();
				Thread.sleep(300);
			}catch(InterruptedException e) {}
			
		}
	}
	
	private void proizvedi() {
		
	}

	public void zaustavi() {
		proizvodjac.interrupt();
	}

}
