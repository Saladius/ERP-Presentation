import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;


public class FrameTest {

	private JFrame frame;
	private JLabel lblUtilisateur;
	private JLabel lblerreurmdp;
	private JLabel label;
	private JTextField newPWTF;
	private JTextField validationPWTF;
	private String nomUtilisateur;
    private JPanel panel_1;


	/**
	 * Create the application.
	 */
	public FrameTest(String userName) {
		setNomUtilisateur(userName);
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setForeground(new Color(30, 144, 255));
		frame.setBackground(new Color(30, 144, 255));
		frame.setBounds(100, 100, 1277, 840);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(45, 185, 1108, 445);
		frame.getContentPane().add(panel_1);
		
		JButton btnValidater = new JButton("Valider");
		btnValidater.setBounds(476, 343, 147, 34);
		Image img = new ImageIcon(this.getClass().getResource("Ok.png")).getImage();
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
			
			lblUtilisateur = new JLabel("Utilisateur:");
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
			img = new ImageIcon(this.getClass().getResource("secrecy.png")).getImage();
			label.setIcon(new ImageIcon(img));
		btnValidater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO FF Action qui a lieu lors de la validation

			}
		});
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
}
