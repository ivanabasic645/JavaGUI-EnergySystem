package v1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class Plac extends Panel {

	private int redovi;
	private int kolone;
	private Parcela[][] celije;
	private Parcela izabrana;

	public Plac(int redovi, int kolone) {
		this.redovi = redovi;
		this.kolone = kolone;

		populate();
		setLayout(new GridLayout(redovi, kolone, 8, 8));
		setVisible(true);

	}

	public synchronized void izaberiParcelu(Parcela p) {
		if (izabrana != null) {
			izabrana.setFont(new Font("Serif", Font.BOLD, 14));
		}
		p.setFont(new Font("Serif", Font.BOLD, 20));
		izabrana = p;
	}

	public void dodajProizvodjaca(Baterija baterija) {
		if (izabrana == null)
			return;

		this.removeAll();
		for (int i = 0; i < redovi; i++) {
			for (int j = 0; j < kolone; j++) {
				if (izabrana == celije[i][j]) {
					izabrana = null;
					celije[i][j] = new Hidroelektrana(baterija);
					azurirajVodenePovrsine();
				}
				add(celije[i][j]);
			}
		}
		this.revalidate();
		this.repaint();
	}

	public void zaustaviRadProizvodjaca() {
		for (int i = 0; i < redovi; i++) {
			for (int j = 0; j < kolone; j++) {
				if (celije[i][j] instanceof Proizvodjac) {
					((Proizvodjac) celije[i][j]).zaustavi();
				}
			}
		}
	}

	private void azurirajVodenePovrsine() {
		for (int i = 0; i < redovi; i++) {
			for (int j = 0; j < kolone; j++) {
				if (celije[i][j] instanceof Hidroelektrana) {
					// izracunaj broj vodenih povrsina u dodiru
					Hidroelektrana p = (Hidroelektrana) celije[i][j];
					int voda = 0;
					if (i != 0 && j != 0 && celije[i - 1][j - 1] instanceof VodenaPovrs) {
						voda++;
					}
					if (i != redovi - 1 && j != kolone - 1 && celije[i + 1][j + 1] instanceof VodenaPovrs) {
						voda++;
					}
					if (i != redovi - 1 && celije[i + 1][j] instanceof VodenaPovrs) {
						voda++;
					}
					if (j != kolone - 1 && celije[i][j + 1] instanceof VodenaPovrs) {
						voda++;
					}
					if (i != 0 && celije[i - 1][j] instanceof VodenaPovrs) {
						voda++;
					}
					if (j != 0 && celije[i][j - 1] instanceof VodenaPovrs) {
						voda++;
					}
					if (i != redovi - 1 && j != 0 && celije[i + 1][j - 1] instanceof VodenaPovrs) {
						voda++;
					}
					if (i != 0 && j != kolone - 1 && celije[i - 1][j + 1] instanceof VodenaPovrs) {
						voda++;
					}

					p.setVodenePovrsine(voda);
				}
			}
		}
	}

	private void populate() {
		celije = new Parcela[redovi][kolone];
		for (int i = 0; i < redovi; i++) {
			for (int j = 0; j < kolone; j++) {
				Parcela p = generisiParcelu();
				celije[i][j] = p;
				add(celije[i][j]);
			}
		}

	}

	private Parcela generisiParcelu() {
		Parcela p;
		double vrv = Math.random();
		if (vrv <= .3) {
			p = new VodenaPovrs();
		} else {
			p = new TravnataPovrs();
		}
		return p;
	}

}
