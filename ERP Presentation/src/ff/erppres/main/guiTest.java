package ff.erppres.main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import ff.erppres.connexion.userConnexion;

import java.awt.Color;




public class guiTest {

	private final static JFrame frame = new JFrame();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new guiTest();
					guiTest.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		getFrame().getContentPane().setBackground(new Color(0, 102, 255));
		getFrame().getContentPane().setForeground(new Color(30, 144, 255));
		getFrame().setBackground(new Color(30, 144, 255));
		//getFrame().setBounds(100, 100, 1277, 840);
		getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH); 
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		new userConnexion();

	}

	public static JFrame getFrame() {
		return frame;
	}
}
