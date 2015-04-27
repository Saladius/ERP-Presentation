package ff.erppres.main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ff.erppres.connexion.UserConnexion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class GuiTest {

	private final static JFrame frame = new JFrame();
	private final static JMenuBar menuBar = new JMenuBar();
	
	
	




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new GuiTest();
					GuiTest.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiTest() {
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
		getFrame().setJMenuBar(menuBar);
		
		new UserConnexion();

	}

	public static JFrame getFrame() {
		return frame;
	}
	public static JMenuBar getMenubar() {
		return menuBar;
	}
	
}
