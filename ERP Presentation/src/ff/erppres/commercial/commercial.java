package ff.erppres.commercial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import ff.erppres.connexion.UserConnexion;
import ff.erppres.main.GuiTest;

public class commercial extends JPanel{
	
	
	private String nomUtilisateur;
	private JMenu mnCommandesVisualisation, mntCommandes, mnPayementsDivers,mnDelaiProductionRestant;
 
	private JMenuItem mntmNouvellesCommandes;
	private JMenuItem mntmAjouterClient;
	private JMenuItem mntmCommandesEnAttentes;
	private JMenuItem mntCommandesEncours;
	private JMenuItem mntCommandesTermines;
	private JMenuItem mntCommandesValider;
	private JMenuItem mntPayementsDivers;
	private JMenuItem mntDelaiProductionRestant;
	
	
	
	java.sql.Statement stmt = null;
	java.sql.Connection conn = null;
 
 
	
	public commercial(){}
	
	
	public commercial(String user) {
		setNomUtilisateur(user);
		
		//Create the menu bar.
		
	 
		final JPanelCommercial activatjPanelComercial = new JPanelCommercial();
		GuiTest.getFrame().setContentPane(activatjPanelComercial);
		  
		mntCommandes = new JMenu("Commandes");
		GuiTest.getMenubar().add(mntCommandes);
		
		mntmNouvellesCommandes = new JMenuItem("Rentr�e de nouvelles commandes",'C');
		mntCommandes.add(mntmNouvellesCommandes);
		mntmNouvellesCommandes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatjPanelComercial.SetActvePanel(0);
				
							
				 
			}
		});
		
		
		
		
		mntmAjouterClient = new JMenuItem("Ajouter nouveaux Client",'R');
		mntCommandes.add(mntmAjouterClient);
		mntmAjouterClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activatjPanelComercial.SetActvePanel(6);
				
			}
		});

		
		 
		mnCommandesVisualisation = new JMenu("Visualisation des Commandes");
		GuiTest.getMenubar().add(mnCommandesVisualisation);
		
		
		mntmCommandesEnAttentes = new JMenuItem("En attentes",'A');
		mnCommandesVisualisation.add(mntmCommandesEnAttentes);
		mntmCommandesEnAttentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatjPanelComercial.SetActvePanel(1);
				
							
				 
			}
		});
		
		
		
		
		mntCommandesEncours = new JMenuItem("En cours",'C');
		mnCommandesVisualisation.add(mntCommandesEncours);
		mntCommandesEncours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatjPanelComercial.SetActvePanel(2);
				
							
				 
			}
		});
		
		
		
		
		mntCommandesTermines = new JMenuItem("Termin�s",'T');
		mnCommandesVisualisation.add(mntCommandesTermines);
		mntCommandesTermines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatjPanelComercial.SetActvePanel(3);
				
							
				 
			}
		});
		
		
		mntCommandesValider = new JMenuItem("Valider",'V');
		mnCommandesVisualisation.add(mntCommandesValider);
		mntCommandesValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatjPanelComercial.SetActvePanel(4);
				
							
				 
			}
		});
		
		
		
		
		/*mnPayements  = new JMenu("D�lai de paiements divers");
		GuiTest.getMenubar().add(mnPayements );
		
		mntmPlanningDuJour = new JMenuItem("en cours");
		mntmPlanningDuJour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Erreur: Profil non conforme, contactez le service informatique");
			}
		});
		mnPayements .add(mntmPlanningDuJour);*/
  
		
		mnPayementsDivers = new JMenu("D�lai de payements divers");
		mntPayementsDivers = new JMenuItem("D�lai de payements",'D');
		mntPayementsDivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatjPanelComercial.SetActvePanel(5);
				
							
				 
			}
		});
		
		mnPayementsDivers.add(mntPayementsDivers);
		GuiTest.getMenubar().add(mnPayementsDivers);
		
	
		mnDelaiProductionRestant =new JMenu("D�lai de production restant");
		mntDelaiProductionRestant =new JMenuItem("D�lai de production restant",'D');
		mntDelaiProductionRestant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatjPanelComercial.SetActvePanel(7);
				
							
				 
			}
		});
		mnDelaiProductionRestant.add(mntDelaiProductionRestant);
		GuiTest.getMenubar().add(mnDelaiProductionRestant);
		 
		  
	 
	 	GuiTest.getFrame().validate();
		
		
		
		
		
	}
	
	public String AddClient(String Client_NAME,String Client_MAIL,String Adresse_client,String Tele,String DATE_CREATION,int ID_Commerciale){
		 
		conn = UserConnexion.getConnection();
		String Message ="";
		try {
			stmt =conn.createStatement();
			String sql = "INSERT INTO client(Client_NAME,Client_MAIL,Adresse_client,Tele,DATE_CREATION,ID_Commerciale) " +
                    "VALUES ('"+Client_NAME+"', '"+Client_MAIL+"', '"+Adresse_client+"','"+Tele+"','"+DATE_CREATION+"',"+ID_Commerciale+")";
			
			stmt.executeUpdate(sql);
			Message="Message de succ�s ,Bien ajouter.";	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Message="Message d'erreur !"+e.getMessage();
		}
		return Message;
		
	}
	
 
 
	
	public String AddCommande(String Date_Lancement,int ID_Client,int ID_User,ArrayList<String[]> detaille_commandes,int Delai_Paiement,float Montant_Paiement,String Type_Paiement,ArrayList<String[]> Paiement){
		 
		conn = UserConnexion.getConnection();
		String Message;
		String lastid_commande;
		String lastid_paiement;
		 
		try {
			stmt =conn.createStatement();
			String sql = "INSERT INTO commande (Date_Lancement,ID_Client,ID_User)" +
                    "VALUES ('"+Date_Lancement+"','"+ID_Client+"','"+ID_User+"')";

			stmt.executeUpdate(sql);
			
			
		ResultSet rs = stmt.executeQuery("select last_insert_id() as last_id from commande");
		rs.next();
		lastid_commande = rs.getString("last_id");
			
 	
		
		for(int i=0;i<detaille_commandes.size();i++)
		{
			String[] myString= new String[4];
			myString=detaille_commandes.get(i); 
		    String sql2 = "INSERT INTO detaille_commandes (Date_d�but,Date_Fin,etat_Commandes,Produit_quantite,ID_Produit,ID_Commande)" +
	                    "VALUES ('"+myString[0]+"','"+myString[1]+"','en cours','"+myString[2]+"','"+myString[3]+"','"+Integer.parseInt(lastid_commande)+"')";
				
			stmt.executeUpdate(sql2);
			 
		}
		
		 
	    String sql3 = "INSERT INTO paiement(ID_Commande,Delai_Paiement,Montant_Paiement,Type_Paiement,valider)" +
                    "VALUES ('"+Integer.parseInt(lastid_commande)+"','"+Delai_Paiement+"','"+Montant_Paiement+"','"+Type_Paiement+"','Non')";
			
		stmt.executeUpdate(sql3);
		
		ResultSet rss = stmt.executeQuery("select last_insert_id() as last_id from paiement");
		rss.next();
		lastid_paiement = rss.getString("last_id");
		
		for(int i=0;i<Paiement.size();i++)
		{
			String[] myPaiement= new String[2];
			myPaiement=Paiement.get(i); 		
		    String sql4 = "INSERT INTO detaille_paiement (Date_Paiement,Montant_Paiement,ID_Paiement,Valider)" +
	                    "VALUES ('"+myPaiement[0]+"','"+myPaiement[1]+"','"+Integer.parseInt(lastid_paiement)+"','Non')";
				
			stmt.executeUpdate(sql4);
			 
		}
			
			Message="Message de succ�s ,Bien ajouter.";	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Message="Message d'erreur !"+e.getMessage();
		}
		return Message;
		
	}
	
	
	
	public ArrayList<Client> GetAllNmeClient(){
		conn = UserConnexion.getConnection();
		ArrayList<Client> clientList=new ArrayList<Client>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select Client_NAME from client";
			
			ResultSet srs =stmt.executeQuery(sql);
			  while (srs.next()) {
	               Client c=new Client();
	               c.setClient_NAME(srs.getString("Client_NAME"));
	               clientList.add(c);
	               
	          }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  clientList;
	}
	
	public ArrayList<Client> GetClient(String Client_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Client> clientList=new ArrayList<Client>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select ID_Client,Client_MAIL,Adresse_client,Tele from client where Client_NAME like '"+Client_NAME+"'";
			
			ResultSet srs =stmt.executeQuery(sql);
			  while (srs.next()) {
	               Client c=new Client();
	               c.setClient_MAIL(srs.getString("Client_MAIL"));
	               c.setAdresse_client(srs.getString("Adresse_client"));
	               c.setTele(srs.getString("Tele"));
	               c.setID_Client(Integer.parseInt(srs.getString("ID_Client")));
	               clientList.add(c);
	               
	          }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  clientList;
		
	}
	
	

	
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

}
