package ff.erppres.commercial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import ff.erppres.connexion.UserConnexion;

public class Commande {
	
	private String Client_NAME;
	private String Nom_Produit;
	private int Produit_quantite;
	private String etat_Commandes;
	private Date Date_debut;
	private Date Date_Fin;
	private Date Date_Lancement;
	private String DelaiproductionRestant;
	
	java.sql.Statement stmt = null;
	java.sql.Connection conn = null;
	
	
	public Commande(){}
	
	public Commande(String client_Name, String produit_Name,
			int produit_quantite, String etat_Commandes, Date date_debut,
			Date date_Fin, Date date_Lancement) {
		Client_NAME = client_Name;
		Nom_Produit = produit_Name;
		Produit_quantite = produit_quantite;
		this.etat_Commandes = etat_Commandes;
		Date_debut = date_debut;
		Date_Fin = date_Fin;
		Date_Lancement = date_Lancement;
	}
	
	public String getDelaiproductionRestant(){
		return DelaiproductionRestant;
	}
	public void setDelaiproductionRestant(String delaiproductionRestant){
		DelaiproductionRestant=delaiproductionRestant;
	}
	public String getClient_Name() {
		return Client_NAME;
	}
	public void setClient_Name(String client_Name) {
		Client_NAME = client_Name;
	}
	public String getNom_Produit() {
		return Nom_Produit;
	}
	public void setNom_Produit(String produit_Name) {
		Nom_Produit = produit_Name;
	}
	public int getProduit_quantite() {
		return Produit_quantite;
	}
	public void setProduit_quantite(int produit_quantite) {
		Produit_quantite = produit_quantite;
	}
	public String getEtat_Commandes() {
		return etat_Commandes;
	}
	public void setEtat_Commandes(String etat_Commandes) {
		this.etat_Commandes = etat_Commandes;
	}
	public Date getDate_debut() {
		return Date_debut;
	}
	public void setDate_debut(Date date_debut) {
		Date_debut = date_debut;
	}
	public Date getDate_Fin() {
		return Date_Fin;
	}
	public void setDate_Fin(Date date_Fin) {
		Date_Fin = date_Fin;
	}
	public Date getDate_Lancement() {
		return Date_Lancement;
	}
	public void setDate_Lancement(Date date_Lancement) {
		Date_Lancement = date_Lancement;
	}
	
	
	
	public ArrayList<Commande> GetListeCommandesEncours(){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit, cm.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, dc.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=cm.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'en cours';";
			
			ResultSet srs =stmt.executeQuery(sql);
			
			  while (srs.next()) {
				  Commande com=new Commande(); 
				  com.setClient_Name(srs.getString("Client_NAME"));
				  com.setNom_Produit(srs.getString("Nom_Produit"));
				  com.setProduit_quantite(srs.getInt("Produit_quantite"));
				  com.setEtat_Commandes(srs.getString("etat_Commandes"));
				  com.setDate_debut(srs.getDate("Date_début"));
				  com.setDate_Fin(srs.getDate("Date_Fin"));
				  com.setDate_Lancement(srs.getDate("Date_Lancement"));
	             VisualisationCommande.add(com);
	          }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  VisualisationCommande;
		
	}
	
	
	public ArrayList<Commande> GetListeCommandesEnattentes(){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit, cm.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, dc.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=cm.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'en attentes';";
			
			ResultSet srs =stmt.executeQuery(sql);
			
			  while (srs.next()) {
				  Commande com=new Commande(); 
				  com.setClient_Name(srs.getString("Client_NAME"));
				  com.setNom_Produit(srs.getString("Nom_Produit"));
				  com.setProduit_quantite(srs.getInt("Produit_quantite"));
				  com.setEtat_Commandes(srs.getString("etat_Commandes"));
				  com.setDate_debut(srs.getDate("Date_début"));
				  com.setDate_Fin(srs.getDate("Date_Fin"));
				  com.setDate_Lancement(srs.getDate("Date_Lancement"));
	             VisualisationCommande.add(com);
	          }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  VisualisationCommande;
		
	}
	
	public ArrayList<Commande> GetListeCommandesTermines(){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit, cm.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, dc.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=cm.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'terminés';";
			
			ResultSet srs =stmt.executeQuery(sql);
			
			  while (srs.next()) {
				  Commande com=new Commande(); 
				  com.setClient_Name(srs.getString("Client_NAME"));
				  com.setNom_Produit(srs.getString("Nom_Produit"));
				  com.setProduit_quantite(srs.getInt("Produit_quantite"));
				  com.setEtat_Commandes(srs.getString("etat_Commandes"));
				  com.setDate_debut(srs.getDate("Date_début"));
				  com.setDate_Fin(srs.getDate("Date_Fin"));
				  com.setDate_Lancement(srs.getDate("Date_Lancement"));
	             VisualisationCommande.add(com);
	          }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  VisualisationCommande;
		
	}
	
	public ArrayList<Commande> GetListeCommandesValider(){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit, cm.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, dc.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=cm.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'valider';";
			
			ResultSet srs =stmt.executeQuery(sql);
			
			  while (srs.next()) {
				  Commande com=new Commande(); 
				  com.setClient_Name(srs.getString("Client_NAME"));
				  com.setNom_Produit(srs.getString("Nom_Produit"));
				  com.setProduit_quantite(srs.getInt("Produit_quantite"));
				  com.setEtat_Commandes(srs.getString("etat_Commandes"));
				  com.setDate_debut(srs.getDate("Date_début"));
				  com.setDate_Fin(srs.getDate("Date_Fin"));
				  com.setDate_Lancement(srs.getDate("Date_Lancement"));
	             VisualisationCommande.add(com);
	          }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  VisualisationCommande;
		
	}
	
	public ArrayList<Commande> GetListeDelaiproductionRestant(){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit,cm.Produit_quantite,DATEDIFF(dc.Date_Fin,CURDATE()) as dpr "
                        +" From erp_presentation.client as cl,erp_presentation.commande as cm,erp_presentation.produit as p,erp_presentation.detaille_commandes as dc "
                        +" where cl.ID_Client=cm.ID_Client and p.ID_Produit=cm.ID_Produit and dc.ID_Commande=cm.ID_Commande ;";
			
			ResultSet srs =stmt.executeQuery(sql);
			
			  while (srs.next()) {
				  Commande com=new Commande(); 
				  com.setClient_Name(srs.getString("Client_NAME"));
				  com.setNom_Produit(srs.getString("Nom_Produit"));
				  com.setProduit_quantite(srs.getInt("Produit_quantite"));
				  com.setDelaiproductionRestant(srs.getString("dpr"));
	             VisualisationCommande.add(com);
	          }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  VisualisationCommande;
		
	}

}
