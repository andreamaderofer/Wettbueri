package GUI;

import Control.*;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Andrea
 * @version 1.0
 */
class GUI extends JFrame implements Observer {
	public GUI() {	
		
		
	}
	private static JTextField zahlenBetrag;
	private static JTextField zahlenEingabe;
	private static JTextField lottoBetrag;
	private static JTextField lottoEingabe;
	private static ZahlenWette zahlwett;
	private static ZahlenWette wette=new ZahlenWette();
	
	public static void main(String[] path) throws ClassNotFoundException, SQLException {
		StartFenster sf = new StartFenster();
	}

	public static void startFrame(int benutzerID) {
		GUI gu=new GUI();

		gu.getContentPane().setLayout(null);
		gu.setIconImage(Toolkit.getDefaultToolkit().getImage("Unbenannt.JPG"));
		gu.setTitle("Wettb\u00FCro");
		gu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 0, 545, 348);
		gu.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);

		JLabel lblWetten = new JLabel("WettB\u00FCro");
		lblWetten.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWetten.setBounds(182, 42, 190, 34);
		panel.add(lblWetten);

		zahlenBetrag = new JTextField();
		
		zahlenBetrag.setBounds(298, 159, 86, 20);
		panel.add(zahlenBetrag);
		zahlenBetrag.setColumns(10);

		JLabel lblZahlen = new JLabel("ZahlenWetten");
		lblZahlen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblZahlen.setBounds(216, 102, 104, 24);
		panel.add(lblZahlen);

		JLabel lblLottoWetten = new JLabel("LottoWetten");
		lblLottoWetten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLottoWetten.setBounds(216, 209, 101, 24);
		panel.add(lblLottoWetten);
		
		JLabel lblZahlenBetrag = new JLabel("Betrag");
		lblZahlenBetrag.setBounds(320, 132, 46, 14);
		panel.add(lblZahlenBetrag);
		
		zahlenEingabe = new JTextField();
		zahlenEingabe.setColumns(10);
		zahlenEingabe.setBounds(157, 159, 86, 20);
		panel.add(zahlenEingabe);
		
		zahlenBetrag.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				if(event.getKeyCode()==KeyEvent.VK_ENTER){
					WettDBManager man = null;
					try {
						man = new WettDBManager();
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					try {
						zahlwett=new ZahlenWette(zahlenEingabe.getText(), man.getAccounts().get(benutzerID), Double.parseDouble(zahlenBetrag.getText()));
						man.setWette(zahlwett,benutzerID);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("folgender Betrag wurde gesetzt: "+zahlenBetrag.getText());
				}
			}
		});
		
		lottoBetrag = new JTextField();
		lottoBetrag.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				if(event.getKeyCode()==KeyEvent.VK_ENTER){
					
					Account acc=new Account();
					int id=acc.getBenutzerID();
					try {
						WettDBManager wettManager=new WettDBManager();
						ArrayList<Account> accl=wettManager.getAccounts();
						accl.get(id);
						accl.get(id).auszahlung(Double.parseDouble(lottoBetrag.getText()));
						System.out.println("folgender Betrag wurde gesetzt: "+lottoBetrag.getText());
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		lottoBetrag.setColumns(10);
		lottoBetrag.setBounds(298, 261, 86, 20);
		panel.add(lottoBetrag);
		
		JLabel lbllottoBetrag = new JLabel("Betrag");
		lbllottoBetrag.setBounds(320, 236, 46, 14);
		panel.add(lbllottoBetrag);
		
		JLabel lblLottowette = new JLabel("Lottowette (6 Zahlen)");
		lblLottowette.setBounds(146, 236, 140, 14);
		panel.add(lblLottowette);
		
		JLabel lblZahlenwette = new JLabel("Zahlenwette(1 Zahl)");
		lblZahlenwette.setBounds(146, 137, 140, 14);
		panel.add(lblZahlenwette);
		
		lottoEingabe = new JTextField();
		lottoEingabe.setBounds(157, 261, 86, 20);
		panel.add(lottoEingabe);
		lottoEingabe.setColumns(10);
		gu.setSize(557, 388);
		gu.setVisible(true);
	}

	public void update(Observable obs, Object ob) {
		update(obs, ob);
	}
}