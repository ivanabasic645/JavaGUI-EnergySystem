package v1;

import java.awt.*;
import java.awt.event.*;

public abstract class Parcela extends Label {
	private Panel centar = new Panel();
	protected Color pozadina;
	protected char oznaka;

	public Parcela() {
		setFont(new Font("Serif", Font.BOLD, 14));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Component source = ((Component) e.getSource());
				Plac plac = (Plac) source.getParent();
				plac.izaberiParcelu(Parcela.this);
			}
		});
	}

	public Color getPozadina() {
		return pozadina;
	}

	public void setPozadina(Color pozadina) {
		this.pozadina = pozadina;
	}

	public char getOznaka() {
		return oznaka;
	}

}
