package GUI;

import Control.*;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
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
		
		lottoBetrag = new JTextField();
		lottoBetrag.setColumns(10);
		lottoBetrag.setBounds(298, 261, 86, 20);
		panel.add(lottoBetrag);
		
		JLabel lbllottoBetrag = new JLabel("Betrag");
		lbllottoBetrag.setBounds(320, 236, 46, 14);
		panel.add(lbllottoBetrag);
		
		JLabel lblLottowette = new JLabel("Lottowette (6 Zahlen)");
		lblLottowette.setBounds(146, 236, 114, 14);
		panel.add(lblLottowette);
		
		JLabel lblZahlenwette = new JLabel("Zahlenwette(1 Zahl)");
		lblZahlenwette.setBounds(146, 137, 109, 14);
		panel.add(lblZahlenwette);
		
		lottoEingabe = new JTextField();
		lottoEingabe.setBounds(157, 261, 86, 20);
		panel.add(lottoEingabe);
		lottoEingabe.setColumns(10);
		gu.setSize(557, 388);
		gu.setVisible(true);
	}
	private static JTextField zahlenBetrag;
	private static JTextField zahlenEingabe;
	private static JTextField lottoBetrag;
	private static JTextField lottoEingabe;

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
		
		JLabel lblBetrag = new JLabel("Betrag");
		lblBetrag.setBounds(320, 132, 46, 14);
		panel.add(lblBetrag);
		
		zahlenEingabe = new JTextField();
		zahlenEingabe.setColumns(10);
		zahlenEingabe.setBounds(157, 159, 86, 20);
		panel.add(zahlenEingabe);
		
		lottoBetrag = new JTextField();
		lottoBetrag.setColumns(10);
		lottoBetrag.setBounds(298, 261, 86, 20);
		panel.add(lottoBetrag);
		
		JLabel lottoBetrag = new JLabel("Betrag");
		lottoBetrag.setBounds(320, 236, 46, 14);
		panel.add(lottoBetrag);
		
		JLabel lblLottowette = new JLabel("Lottowette (6 Zahlen)");
		lblLottowette.setBounds(146, 236, 114, 14);
		panel.add(lblLottowette);
		
		JLabel lblZahlenwette = new JLabel("Zahlenwette(1 Zahl)");
		lblZahlenwette.setBounds(146, 137, 109, 14);
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