package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

import java.awt.BorderLayout;
import java.awt.Event;

import javax.swing.SwingConstants;

import Control.*;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.acl.Acl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

/**
 * @author Andrea
 * @version 1.0
 */
public class StartFenster extends JFrame implements KeyListener {
	private JTextField benutzer;
	private JTextField passwort1;

	public StartFenster() throws ClassNotFoundException, SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Unbenannt.JPG"));
		setTitle("Wettb\u00FCro");
		setBackground(SystemColor.desktop);
		getContentPane().setBackground(SystemColor.desktop);
		getContentPane().setLayout(null);

		setBounds(200, 200, 400, 300);
		getContentPane().setSize(380, 280);
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
				wind.setIconImage(Toolkit.getDefaultToolkit().getImage("Unbenannt.JPG"));
				wind.setTitle("Wettb\u00FCro");
				wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				wind.setBounds(200, 200, 500, 200);
				wind.setVisible(true);
				wind.getContentPane().setLayout(null);
				JLabel pasw = new JLabel("Bitte geben Sie Ihr Passwort und Ihren Benutzernamen ein!");
				pasw.setBounds(80, 0, 350, 20);
				wind.getContentPane().add(pasw);
				benutzer = new JTextField("Benutzer");
				passwort1 = new JTextField("Passwort");
				benutzer.setBounds(80, 30, 200, 20);
				passwort1.setBounds(80, 60, 200, 20);
				wind.getContentPane().add(benutzer);
				wind.getContentPane().add(passwort1);
				passwort1.addKeyListener(new KeyListener() {
					public void keyTyped(KeyEvent e) {
					}

					public void keyReleased(KeyEvent e) {
					}

					public void keyPressed(KeyEvent event) {
						WettDBManager wettdb = null;
						try {
							wettdb = new WettDBManager();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
						if (event.getKeyCode() == KeyEvent.VK_ENTER && !passwort1.getText().equals("passwort")) {
							int benutzerID = 0;
							WettDBManager wett = null;
							ArrayList<Account> accAL = null;
							try {
								accAL = wettdb.getAccounts();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							wind.dispose();
							try {
								for (int i = 0; i <= wettdb.getAccounts().size() - 1; i++) {
									if (accAL.get(i).getBenutzername().equals(benutzer.getText())
											&& accAL.get(i).getPasswort().equals(passwort1.getText())) {
										GUI.startFrame(i);
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						try {
							wettdb.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnLogin.setBounds(83, 73, 89, 23);
		getContentPane().add(btnLogin);

		JButton btnRegistrieren = new JButton("Registrieren");
		btnRegistrieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Unbenannt.JPG"));
				frame.setTitle("Wettb\u00FCro");
				frame.getContentPane().setLayout(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setBounds(200, 200, 300, 300);
				JLabel lab = new JLabel("Bitte geben Sie Ihre Daten an!");
				lab.setBounds(200, 0, 100, 20);
				JTextField benutzernamen = new JTextField("Benutzer!");
				JTextField vorname = new JTextField("Vorname");
				JTextField nachname = new JTextField("Nachname");
				JTextField passwort = new JTextField("Passwort");
				JTextField betrag = new JTextField("Betrag");
				JTextField kontonummer = new JTextField("Kontonummer");

				benutzernamen.setBounds(120, 30, 80, 20);
				vorname.setBounds(120, 50, 80, 20);
				nachname.setBounds(120, 70, 80, 20);
				passwort.setBounds(120, 90, 80, 20);
				betrag.setBounds(120, 110, 80, 20);
				kontonummer.setBounds(120, 130, 80, 20);

				frame.getContentPane().add(benutzernamen);
				frame.getContentPane().add(passwort);
				frame.getContentPane().add(vorname);
				frame.getContentPane().add(nachname);
				frame.getContentPane().add(betrag);
				frame.getContentPane().add(kontonummer);
				frame.setVisible(true);
				kontonummer.addKeyListener(new KeyListener() {
					public void keyTyped(KeyEvent e) {
					}

					public void keyReleased(KeyEvent e) {
					}

					public void keyPressed(KeyEvent event) {
						if (event.getKeyCode() == KeyEvent.VK_ENTER && !kontonummer.getText().equals("kontonummer")) {

							WettDBManager wettdb = null;
							try {
								wettdb = new WettDBManager();
							} catch (ClassNotFoundException | SQLException e1) {
								e1.printStackTrace();
							}
							Account acc = null;
							try {
								acc = new Account(wettdb.getAccounts().size() + 1, Double.parseDouble(betrag.getText()),
										benutzernamen.getText(), vorname.getText(), nachname.getText(),
										Integer.parseInt(kontonummer.getText()), passwort.getText());
							} catch (Exception e) {
								e.printStackTrace();
							}
							try {
								wettdb.setAccount(acc);
							} catch (Exception e) {
								e.printStackTrace();
							}
							GUI.startFrame(1);
						}
					}
				});
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

	public void keyPressed(KeyEvent event) {

	}

	public void keyReleased(KeyEvent event) {
	}

	public void keyTyped(KeyEvent event) {
	}
}
