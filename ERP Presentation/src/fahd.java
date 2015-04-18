import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;


public class fahd {

	private  JFrame frame;
	private JTextField UserTextField;
	private JTextField MdptextField;
	private JLabel lblUtilisateur;
	private JLabel lblMdp;
	private JLabel lblerreurmdp;
	private JLabel lblCompteBloquer;
	private JLabel label;
	private JPanel panel_1;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fahd window = new fahd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public fahd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 255));
		frame.getContentPane().setForeground(new Color(30, 144, 255));
		frame.setBackground(new Color(30, 144, 255));
	//	frame.setBounds(100, 100, 1167, 857);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image img = new ImageIcon(this.getClass().getResource("Ok.png")).getImage();
			frame.getContentPane().setLayout(null);
			
			panel_1 = new JPanel();
			panel_1.setBounds(655, 336, 676, 445);
			panel_1.setBackground(Color.LIGHT_GRAY);
			frame.getContentPane().add(panel_1);
			JButton btnValidater = new JButton("Valider");
			btnValidater.setBounds(284, 343, 147, 34);
			panel_1.setLayout(null);
			panel_1.add(btnValidater);
			btnValidater.setIcon(new ImageIcon(img));
			btnValidater.setFont(new Font("Arial", Font.BOLD, 14));
			
			JPanel panel = new JPanel();
			panel.setBounds(211, 98, 408, 171);
			panel_1.add(panel);
			panel.setBackground(new Color(135, 206, 250));
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setLayout(null);
			
			UserTextField = new JTextField();
			UserTextField.setBounds(162, 25, 202, 28);
			panel.add(UserTextField);
			UserTextField.setColumns(10);
			
				
				MdptextField = new JTextField();
				MdptextField.setBounds(162, 92, 202, 28);
				panel.add(MdptextField);
				MdptextField.setColumns(10);
				
				lblUtilisateur = new JLabel("Utilisateur");
				lblUtilisateur.setFont(new Font("Arial", Font.BOLD, 14));
				lblUtilisateur.setBounds(10, 13, 200, 50);
				panel.add(lblUtilisateur);
				
				lblMdp = new JLabel("Mot de Pass");
				lblMdp.setFont(new Font("Arial", Font.BOLD, 14));
				lblMdp.setBounds(10, 81, 200, 50);
				panel.add(lblMdp);
				
				lblerreurmdp = new JLabel("erreur Mot de Pass; tentative restante :");
				lblerreurmdp.setBounds(221, 282, 311, 50);
				panel_1.add(lblerreurmdp);
				lblerreurmdp.setVisible(false);
				lblerreurmdp.setFont(new Font("Arial", Font.PLAIN, 14));
				lblerreurmdp.setForeground(Color.RED);
				
				lblCompteBloquer = new JLabel("Compte Bloquer. Veuillez contacter l'administrateur");
				lblCompteBloquer.setBounds(211, 388, 329, 50);
				panel_1.add(lblCompteBloquer);
				lblCompteBloquer.setVisible(false);
				lblCompteBloquer.setForeground(Color.RED);
				lblCompteBloquer.setFont(new Font("Arial", Font.ITALIC, 14));
				
				label = new JLabel("");
				label.setBounds(36, 98, 139, 171);
				panel_1.add(label);
				img = new ImageIcon(this.getClass().getResource("secrecy.png")).getImage();
				label.setIcon(new ImageIcon(img));
	}

}
