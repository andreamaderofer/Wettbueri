package GUI;

/**
 * @ author Andrea
 * @ version 1.0
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Endergebnis extends JFrame {

	private JPanel contentPane;
	private JLabel gerateneZahl;

	public Endergebnis(int gezogeneZ, int gerateneZahl, double kontostand) {
		ergebnisGui(""+gezogeneZ, "" + gerateneZahl, "" + kontostand);
	}

	public Endergebnis(int[] zufallsZahlen, int gerateneZahl, double kontostand) {
		String zufallsZ = "";
		for (int i = 0; i < zufallsZahlen.length; i++) {
			zufallsZ = zufallsZ + "," + zufallsZahlen[i];
		}
		ergebnisGui(zufallsZ, "" + gerateneZahl, "" + kontostand);
	}

	public void ergebnisGui(String zufallsZahl, String gerateneZa, String Kontostand) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Andrea\\Dropbox\\4. Klasse\\SWP\\Wettbuero\\Unbenannt.JPG"));
		setTitle("Wettb\u00FCro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Das Endergebnis lautet");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(5, 5, 424, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnBeenden.setBounds(5, 233, 424, 23);
		contentPane.add(btnBeenden);

		JLabel lblNewLabel_1 = new JLabel("Deine Zahl lautet:");
		lblNewLabel_1.setBounds(35, 89, 87, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Die Gezogene Zahl lautet:");
		lblNewLabel_2.setBounds(35, 114, 132, 14);
		contentPane.add(lblNewLabel_2);

		gerateneZahl = new JLabel("ZAHL");
		gerateneZahl.setBounds(223, 89, 46, 14);
		gerateneZahl.setText(gerateneZa);
		contentPane.add(gerateneZahl);

		JLabel gezogeneZahl = new JLabel("ZAHL");
		gezogeneZahl.setBounds(223, 114, 46, 14);
		gezogeneZahl.setText(zufallsZahl);
		contentPane.add(gezogeneZahl);

		JLabel lblKontostand = new JLabel("Kontostand:");
		lblKontostand.setBounds(35, 149, 132, 14);
		contentPane.add(lblKontostand);

		JLabel lblBetrag = new JLabel("BETRAG");
		lblBetrag.setBounds(223, 149, 46, 14);
		lblBetrag.setText(Kontostand);
		contentPane.add(lblBetrag);
	}
}
