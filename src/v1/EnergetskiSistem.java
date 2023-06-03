package v1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Choice;



public class EnergetskiSistem extends Frame{
	
	private Plac plac;
	private Baterija baterija;
	private Panel gornjiPanel = new Panel();
	Panel centralniPanel = new Panel();

	public EnergetskiSistem(int redovi, int kolone, int kapacitet){
		
		plac = new Plac(redovi, kolone);
		baterija = new Baterija(kapacitet);

		setBounds(700, 200, 500, 500);
		setResizable(false);
		populateWindow();
		addListeners();
		setTitle("Energetski sistem");
		setVisible(true);
	}

	private void addListeners() {
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
	}

	private void populateWindow() {
		
		setLayout(new BorderLayout());
		
		Choice izborProizvodjaca = new Choice();
		izborProizvodjaca.add("Hidroelektrana");
		izborProizvodjaca.add("Vetrenjaca");
		izborProizvodjaca.add("Solarna Panela");
		
		Button dodaj = new Button("Dodaj");
		gornjiPanel.add(dodaj);
		add(gornjiPanel, BorderLayout.NORTH);
		
		plac.setPreferredSize(new Dimension( getWidth(), getHeight() - gornjiPanel.getHeight()));
		centralniPanel.add(plac, BorderLayout.CENTER);
		add(centralniPanel, BorderLayout.CENTER);
		pack();
				
	}
	
	public static void main(String[] args) {
		new EnergetskiSistem(4,4,0);
	}
	
}
