package GUI;
/**
 * @author Andrea
 *  @version 1.0
 */
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

class GUI extends JFrame implements Observer {
	private JTextField txtWetteingabe;

	public static void main(String[] path) {
		GUI gui = new GUI();
	}

	public GUI() {

	}

	public void update(Observable obs, Object ob) {
		update(obs, ob);
	}
}