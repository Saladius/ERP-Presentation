package ff.erppres.connexion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import ff.erppres.main.guiTest;


public class userActivate extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	private JLabel lblUtilisateur;
	private JLabel lblerreurmdp;
	private JLabel label;
	private JTextField newPWTF;
	private JTextField validationPWTF;
	private String nomUtilisateur;


	public userActivate(String userName) {
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(448, 336, 1108, 445);
		setNomUtilisateur(userName);
		JButton btnValidater = new JButton("Valider");
		btnValidater.setBounds(476, 343, 147, 34);
		Image img = new ImageIcon("img/Ok.png").getImage();
		this.setLayout(null);
		this.add(btnValidater);
		btnValidater.setIcon(new ImageIcon(img));
		btnValidater.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel panel = new JPanel();
		panel.setBounds(177, 100, 845, 171);
		this.add(panel);
		panel.setBackground(new Color(135, 206, 250));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(null);
			
		
			lblUtilisateur = new JLabel("Utilisateur: "+getNomUtilisateur());
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
			this.add(lblerreurmdp);
			lblerreurmdp.setVisible(false);
			lblerreurmdp.setFont(new Font("Arial", Font.PLAIN, 14));
			lblerreurmdp.setForeground(Color.RED);
			
			label = new JLabel("");
			label.setBounds(36, 98, 139, 171);
			this.add(label);
			img = new ImageIcon("img/secrecy.png").getImage();
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
