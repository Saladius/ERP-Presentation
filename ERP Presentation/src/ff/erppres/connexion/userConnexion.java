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

public class userConnexion extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField UserTF;
	private JTextField MdpTF;
	private JLabel lblUtilisateur;
	private JLabel lblMdp;
	private JLabel lblerreurmdp;
	private JLabel lblCompteBloquer;
	private JLabel label;
	private JLabel lblInvalidUserName;


	/**
	 * Create the panel.
	 */
	public userConnexion() {
		this.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(655, 336, 676, 445);
		guiTest.getFrame().getContentPane().add(this);
		JButton btnValidater = new JButton("Valider");
		btnValidater.setBounds(264, 343, 147, 34);
		Image img = new ImageIcon("img/Ok.png").getImage();
		this.setLayout(null);
		this.add(btnValidater);
		btnValidater.setIcon(new ImageIcon(img));
		btnValidater.setFont(new Font("Arial", Font.BOLD, 14));

		JPanel panel = new JPanel();
		panel.setBounds(211, 98, 408, 171);
		this.add(panel);
		panel.setBackground(new Color(135, 206, 250));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(null);

		UserTF = new JTextField();
		UserTF.setBounds(162, 25, 202, 28);
		panel.add(UserTF);
		UserTF.setColumns(10);


		MdpTF = new JTextField();
		MdpTF.setBounds(162, 92, 202, 28);
		panel.add(MdpTF);
		MdpTF.setColumns(10);

		lblUtilisateur = new JLabel("Utilisateur");
		lblUtilisateur.setFont(new Font("Arial", Font.BOLD, 14));
		lblUtilisateur.setBounds(10, 13, 200, 50);
		panel.add(lblUtilisateur);

		lblMdp = new JLabel("Mot de Pass");
		lblMdp.setFont(new Font("Arial", Font.BOLD, 14));
		lblMdp.setBounds(10, 81, 200, 50);
		panel.add(lblMdp);

		lblerreurmdp = new JLabel("erreur Mot de Pass; tentative restante :");
		lblerreurmdp.setBounds(247, 282, 311, 50);
		this.add(lblerreurmdp);
		lblerreurmdp.setVisible(false);
		lblerreurmdp.setFont(new Font("Arial", Font.PLAIN, 14));
		lblerreurmdp.setForeground(Color.RED);

		lblCompteBloquer = new JLabel("Compte Bloquer. Veuillez contacter l'administrateur");
		lblCompteBloquer.setBounds(211, 388, 329, 50);
		this.add(lblCompteBloquer);
		lblCompteBloquer.setVisible(false);
		lblCompteBloquer.setForeground(Color.RED);
		lblCompteBloquer.setFont(new Font("Arial", Font.ITALIC, 14));

		label = new JLabel("");
		label.setBounds(36, 98, 139, 171);
		this.add(label);
		img = new ImageIcon("img/secrecy.png").getImage();
		label.setIcon(new ImageIcon(img));

		lblInvalidUserName = new JLabel("Nom de l'Utilisateur incorrect");
		lblInvalidUserName.setFont(new Font("Arial", Font.ITALIC, 14));
		lblInvalidUserName.setForeground(Color.RED);
		lblInvalidUserName.setVisible(false);
		lblInvalidUserName.setBounds(264, 52, 218, 14);
		add(lblInvalidUserName);

		btnValidater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO FF Action qui a lieu lors de la validation

				lblCompteBloquer.setVisible(false);
				lblerreurmdp.setVisible(false);
				lblInvalidUserName.setVisible(false);
				
				String utilisateur = UserTF.getText();
				String mdp = MdpTF.getText();
				boolean isFirstLogin = true;/*User.getIsFirstLogin()*/
				int nbrEssai = 0; /*User.getNbrEssai()*/
				boolean actif = true; // User.getActif();
				
				JPanel activationPanel;
			
				
				if(false/* utilisateur n'est pas dans la table des User*/)
				{
					lblInvalidUserName.setVisible(true);
					MdpTF.setText("");
				}
				else{ 
					if(!mdp.equalsIgnoreCase("fahlalouk")){

						if(!actif){
							lblCompteBloquer.setVisible(true);
							MdpTF.setText("");
						}
						else if(nbrEssai>=3){
							lblCompteBloquer.setVisible(true);
							actif=false;

						}
						else{
							lblerreurmdp.setText("erreur Mot de Pass; tentative restante :"+nbrEssai);
							lblerreurmdp.setVisible(true);
						}
						MdpTF.setText("");
					}
					else if(isFirstLogin){
						actif=true;
						activationPanel = new userActivate(utilisateur);	
						guiTest.getFrame().getContentPane().removeAll();
						guiTest.getFrame().getContentPane().add(activationPanel);
						guiTest.getFrame().repaint();
					}
					else if(!actif){
						lblCompteBloquer.setVisible(true);
						MdpTF.setText("");
					}
					else {
						//User.setNbrEssai(3);
						//User.setDateLastConnexion(getDate());
						//User.getProfilId()
						//switch case :activationPanel = new XXXXX(utilisateur);	
						//guiTest.getFrame().getContentPane().removeAll();
						//guiTest.getFrame().getContentPane().add(activationPanel);
						//guiTest.getFrame().repaint();
					}
					
				}
			}

		});
	}
}
