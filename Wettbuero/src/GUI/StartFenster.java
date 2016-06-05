package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JWindow;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import Control.*;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * @author Andrea
 * @version 1.0
 */
public class StartFenster extends JFrame {
	public StartFenster() {
		getContentPane().setLayout(null);
		setBounds(200, 200, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblHerrzlichWillkommenBeim = new JLabel("Herrzlich Willkommen beim Wettb\u00FCro X!");
		lblHerrzlichWillkommenBeim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHerrzlichWillkommenBeim.setBounds(63, 0, 295, 42);
		getContentPane().add(lblHerrzlichWillkommenBeim);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JFrame wind = new JFrame();
				wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				wind.setBounds(200, 200, 500, 200);
				wind.setVisible(true);
				wind.getContentPane().setLayout(null);

				JLabel passwort = new JLabel("Bitte geben Sie Ihr Passwort und Ihren Benutzernamen ein!");
				passwort.setBounds(80, 0, 350, 20);
				wind.getContentPane().add(passwort);
				JTextField benutzer = new JTextField("Benutzer");
				JTextField passwort1 = new JTextField("Passwort");
				benutzer.setBounds(80, 30, 200, 20);
				passwort1.setBounds(80, 60, 200, 20);
				wind.getContentPane().add(benutzer);
				wind.getContentPane().add(passwort1);
				int benutzerID = 0;
				Account acc=new Account();
				WettDBManager wett = null;
				try {
					wett = new WettDBManager();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0;i<wett.getAccounts().size();i++){
					if(wett.getAccounts().get(i).getBenutzername().equals(benutzer)&&
							wett.getAccounts().get(i).getPasswort().equals(passwort1)){
						GUI gu=new GUI(benutzerID=i);
					}
				}
				//GUI g = new GUI(benutzerID);
			}
		});
		btnLogin.setBounds(83, 73, 89, 23);
		getContentPane().add(btnLogin);

		JButton btnRegistrieren = new JButton("Registrieren");
		btnRegistrieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame=new JFrame();
				frame.setLayout(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setBounds(200,200,300,300);
				JLabel lab=new JLabel("Bitte geben Sie Ihre Daten an!");
				lab.setBounds(200,0,100,20);
				JTextField benutzernamen=new JTextField("Benutzer!");
				JTextField vorname=new JTextField("Vorname");
				JTextField nachname=new JTextField("Nachname");
				JTextField passwort=new JTextField("Passwort");
				JTextField betrag=new JTextField("Betrag");
				JTextField kontonummer=new JTextField("Kontonummer");
				
				benutzernamen.setBounds(120,30,80,20);
				vorname.setBounds(120,50,80,20);
				nachname.setBounds(120,70,80,20);
				passwort.setBounds(120,90,80,20);
				betrag.setBounds(120,110,80,20);
				kontonummer.setBounds(120,130,80,20);
				
				frame.add(benutzernamen);
				frame.add(passwort);
				frame.add(vorname);
				frame.add(nachname);
				frame.add(betrag);
				frame.add(kontonummer);
				frame.setVisible(true);
				Account acc=new Account(Integer.parseInt(betrag.getText()),vorname.getText(),nachname.getText(),Integer.parseInt(kontonummer.getText()),passwort.getText());
			}
		});
		btnRegistrieren.setBounds(214, 73, 118, 23);
		getContentPane().add(btnRegistrieren);

		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnBeenden.setBounds(158, 161, 89, 23);
		getContentPane().add(btnBeenden);
		setVisible(true);
	}
}
