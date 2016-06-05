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
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;

/**
 * @author Andrea
 * @version 1.0
 */
class GUI extends JFrame implements Observer {
	private JTextField txtWetteingabe;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] path) {
		StartFenster sf = new StartFenster();
	}

	public GUI(int benutzerID) {
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 204, 204));
		panel.setBounds(0, 0, 545, 348);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStart.setBounds(134, 175, 89, 23);
		panel.add(btnStart);
		panel.setForeground(Color.WHITE);

		JLabel lblWetten = new JLabel("WettenB\u00FCro");
		lblWetten.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWetten.setBounds(206, 73, 190, 34);
		panel.add(lblWetten);

		textField = new JTextField();
		textField.setBounds(343, 176, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(343, 232, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblZahlen = new JLabel("ZahlenWetten");
		lblZahlen.setBounds(350, 154, 79, 14);
		panel.add(lblZahlen);

		JLabel lblLottoWetten = new JLabel("LottoWetten");
		lblLottoWetten.setBounds(353, 207, 76, 14);
		panel.add(lblLottoWetten);

		JButton btnEnd = new JButton("Ende");
		btnEnd.setBounds(134, 231, 89, 23);
		panel.add(btnEnd);
		setSize(557, 388);
		setVisible(true);

	}

	public void update(Observable obs, Object ob) {
		update(obs, ob);
	}
}