package ff.erppres.production;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ff.erppres.main.GuiTest;

public class Production extends JPanel {
	
	private String nomUtilisateur;
	
	private JMenu mnProduction;
	private JMenu mnCommandes;
	private JMenu mnMachines;
	private JMenu mnStock;
	private JMenuItem mntmPlanningDuJour;
	private JMenuItem mntmProductionTerminer;
	private JMenuItem mntmCommandesEnAttentes;
	private JMenuItem mntmEnCours;
	private JMenuItem mntmFonctionnement;
	private JMenuItem mntmDemandeDachat;
	private JMenuItem mntmVisionnement;
	private JMenuItem mntmAchatPrevisionnel;
	/**
	 * Create the panel.
	 */
	public Production(String user) {
		setNomUtilisateur(user);
		
	//	GuiTest.menuProduction();
	
		
		mnProduction = new JMenu("Production");
		GuiTest.getMenubar().add(mnProduction);
		
		mntmPlanningDuJour = new JMenuItem("Planning du Jour");
		mntmPlanningDuJour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Erreur: Profil non conforme, contactez le service informatique");
			}
		});
		mnProduction.add(mntmPlanningDuJour);
		
		mntmProductionTerminer = new JMenuItem("Production terminer");
		mnProduction.add(mntmProductionTerminer);
		
		mnCommandes = new JMenu("Commandes");
		GuiTest.getMenubar().add(mnCommandes);
		
		mntmCommandesEnAttentes = new JMenuItem("En attentes");
		mnCommandes.add(mntmCommandesEnAttentes);
		
		mntmEnCours = new JMenuItem("En cours");
		mnCommandes.add(mntmEnCours);
		
		mnMachines = new JMenu("Machines");
		GuiTest.getMenubar().add(mnMachines);
		
		mntmFonctionnement = new JMenuItem("Fonctionnement");
		mnMachines.add(mntmFonctionnement);
		
		mntmDemandeDachat = new JMenuItem("Demande d'achat");
		mnMachines.add(mntmDemandeDachat);
		
		mnStock = new JMenu("Stock");
		GuiTest.getMenubar().add(mnStock);
		
		mntmVisionnement = new JMenuItem("Visionnement ");
		mnStock.add(mntmVisionnement);
		
		mntmAchatPrevisionnel = new JMenuItem("Achat Pr\u00E9visionnel");
		mnStock.add(mntmAchatPrevisionnel);
		
		GuiTest.getFrame().validate();
	}
	
	
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

}
