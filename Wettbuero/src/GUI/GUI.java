package GUI;

import Control.*;
import javax.swing.JFrame;

import java.awt.Component;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class GUI extends JFrame implements Observer 
{
	private JTextField txtWetteingabe;
	public static void main(String[] path)
	{
		GUI gui=new GUI();
	}
	
	public GUI ()
	{
		getContentPane().setLayout(null);
		setSize(500, 300);
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		btnStart.setBounds(91, 185, 89, 23);
		getContentPane().add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		btnStop.setBounds(222, 185, 89, 23);
		getContentPane().add(btnStop);
		
		JLabel lblWettbuero = new JLabel("Wettbuero");
		lblWettbuero.setBounds(175, 11, 67, 23);
		getContentPane().add(lblWettbuero);
		
		txtWetteingabe = new JTextField();
		txtWetteingabe.setBounds(70, 99, 86, 20);
		txtWetteingabe.setText("Wetteingabe");
		getContentPane().add(txtWetteingabe);
		txtWetteingabe.setColumns(10);
		
		JButton btnZahlenwette = new JButton("Zahlenwette");
		btnZahlenwette.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ZahlenWettObjekt zo=new ZahlenWettObjekt();
			}
		});
		btnZahlenwette.setBounds(80, 140, 110, 23);
		getContentPane().add(btnZahlenwette);
		
		JButton btnLottowette = new JButton("Lottowette");
		btnLottowette.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				LottoWettObjekt lotteObjekt=new LottoWettObjekt();
			}
		});
		btnLottowette.setBounds(222, 140, 110, 23);
		getContentPane().add(btnLottowette);
		
		JLabel lblErgebnis = new JLabel("Ergebnis");
		lblErgebnis.setBounds(233, 76, 46, 14);
		getContentPane().add(lblErgebnis);
		
		JLabel lblErgebnisdarstellen = new JLabel("ergebnisdarstellen");
		lblErgebnisdarstellen.setBounds(214, 102, 97, 14);
		getContentPane().add(lblErgebnisdarstellen);
		setVisible(true);
		
	}

	public void update(Observable obs, Object ob) 
	{
		update(obs, ob);
	}
}