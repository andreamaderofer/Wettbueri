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

/**
 * @author Andrea
 * @version 1.0
 */
class GUI extends JFrame implements Observer {
	public GUI() {
	}
	private JTextField txtWetteingabe;
	private static JTextField textField;
	private static JTextField textField_2;
	private static JTextField textField_3;

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

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LottoWettObjekt lotto=new LottoWettObjekt();
			}
		});
		btnStart.setBounds(116, 213, 89, 24);
		panel.add(btnStart);
		panel.setForeground(Color.WHITE);

		JLabel lblWetten = new JLabel("WettB\u00FCro");
		lblWetten.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWetten.setBounds(206, 73, 190, 34);
		panel.add(lblWetten);

		textField = new JTextField();
		textField.setBounds(343, 159, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblZahlen = new JLabel("ZahlenWetten");
		lblZahlen.setBounds(126, 134, 79, 14);
		panel.add(lblZahlen);

		JLabel lblLottoWetten = new JLabel("LottoWetten");
		lblLottoWetten.setBounds(129, 190, 76, 14);
		panel.add(lblLottoWetten);
		
		JLabel lblBetrag = new JLabel("Betrag");
		lblBetrag.setBounds(367, 134, 46, 14);
		panel.add(lblBetrag);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 159, 86, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(343, 217, 86, 20);
		panel.add(textField_3);
		
		JLabel lottoBetrag = new JLabel("Betrag");
		lottoBetrag.setBounds(367, 190, 46, 14);
		panel.add(lottoBetrag);
		gu.setSize(557, 388);
		gu.setVisible(true);
	}

	public void update(Observable obs, Object ob) {
		update(obs, ob);
	}
}