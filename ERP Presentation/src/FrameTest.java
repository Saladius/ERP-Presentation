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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;


public class FrameTest {

	private  JFrame frame;
	private JLabel lblUtilisateur;
	private JLabel lblerreurmdp;
	private JLabel label;
	private JTextField newPWTF;
	private JTextField validationPWTF;
	private String nomUtilisateur;
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
					FrameTest window = new FrameTest();
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
	public FrameTest() {
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
			frame.getContentPane().add(panel_1);
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBounds(448, 336, 1108, 445);
			JButton btnValidater = new JButton("Valider");
			btnValidater.setBounds(476, 343, 147, 34);
			panel_1.setLayout(null);
			panel_1.add(btnValidater);
			btnValidater.setIcon(new ImageIcon(img));
			btnValidater.setFont(new Font("Arial", Font.BOLD, 14));
			
			JPanel panel = new JPanel();
			panel.setBounds(177, 100, 845, 171);
			panel_1.add(panel);
			panel.setBackground(new Color(135, 206, 250));
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setLayout(null);
				
				lblUtilisateur = new JLabel("Utilisateur: "+"Fahd");
				lblUtilisateur.setFont(new Font("Arial", Font.BOLD, 14));
				lblUtilisateur.setBounds(10, 13, 200, 50);
				panel.add(lblUtilisateur);
				
				newPWTF = new JTextField();
				newPWTF.setColumns(10);
				newPWTF.setBounds(541, 25, 202, 28);
				panel.add(newPWTF);
				
				validationPWTF = new JTextField();
				validationPWTF.setColumns(10);
				validationPWTF.setBounds(541, 92, 202, 28);
				panel.add(validationPWTF);
				
				JLabel lblNouveauMotDe = new JLabel("Nouveau Mot de Pass");
				lblNouveauMotDe.setFont(new Font("Arial", Font.BOLD, 14));
				lblNouveauMotDe.setBounds(302, 31, 164, 14);
				panel.add(lblNouveauMotDe);
				
				JLabel lblConfirmationMotDe = new JLabel("Confirmation Mot de Pass");
				lblConfirmationMotDe.setFont(new Font("Arial", Font.BOLD, 14));
				lblConfirmationMotDe.setBounds(302, 98, 202, 14);
				panel.add(lblConfirmationMotDe);
				
				lblerreurmdp = new JLabel("erreur Mot de Pass");
				lblerreurmdp.setBounds(486, 282, 311, 50);
				panel_1.add(lblerreurmdp);
				lblerreurmdp.setVisible(false);
				lblerreurmdp.setFont(new Font("Arial", Font.PLAIN, 14));
				lblerreurmdp.setForeground(Color.RED);
				
				label = new JLabel("");
				label.setBounds(36, 98, 139, 171);
				panel_1.add(label);
				img = new ImageIcon("img/secrecy.png").getImage();
				label.setIcon(new ImageIcon(img));
			btnValidater.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO FF Action qui a lieu lors de la validation
				}
			});
	}

}