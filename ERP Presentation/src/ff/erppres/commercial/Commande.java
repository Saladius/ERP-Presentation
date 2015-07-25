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
	private Date Date_Paiement;
	private int montant_Paiement;
	

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

	public Date getDate_Paiement() {
		return Date_Paiement;
	}

	public void setDate_Paiement(Date date_Paiement) {
		Date_Paiement = date_Paiement;
	}

	public int getMontant_Paiement() {
		return montant_Paiement;
	}

	public void setMontant_Paiement(int montant_Paiement) {
		this.montant_Paiement = montant_Paiement;
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
			String sql = "Select cl.Client_NAME, p.Nom_Produit, dc.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, cm.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'en cours' group by  cl.Client_NAME;";
			
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
	public ArrayList<Commande> GetListeCommandesEncoursSearchByNomClient(String Client_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit, dc.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, cm.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'en cours' and cl.Client_NAME like '%"+Client_NAME+"%' group by  cl.Client_NAME;";
			
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
	
	public ArrayList<Commande> GetListeCommandesEncoursByNomClient(String Client_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit, dc.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, cm.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'en cours' and cl.Client_NAME like '"+Client_NAME+"';";
			
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
			String sql = "Select cl.Client_NAME, p.Nom_Produit, dc.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, cm.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'en attentes'  group by  cl.Client_NAME;";
			
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
	
	public ArrayList<Commande> GetListeCommandesEnattentesSearchClientNam(String Client_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit, dc.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, cm.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'en attentes' and cl.Client_NAME like '%"+Client_NAME+"%'  group by  cl.Client_NAME;";
			
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
	
	public ArrayList<Commande> GetListeCommandesEnattentesByClienNam(String Client_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit, dc.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, cm.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'en attentes' and cl.Client_NAME like '"+Client_NAME+"';";
			
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
			String sql = "Select cl.Client_NAME, p.Nom_Produit, dc.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, cm.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'terminés' group by  cl.Client_NAME;";
			
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
	
	public ArrayList<Commande> GetListeCommandesTerminesSearchByClientNam(String Client_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit, dc.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, cm.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'terminés' and cl.Client_NAME like '%"+Client_NAME+"%'  group by  cl.Client_NAME;";
			
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
	
	public ArrayList<Commande> GetListeCommandesTerminesByClientNam(String Client_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit, dc.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, cm.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'terminés' and cl.Client_NAME like '"+Client_NAME+"';";
			
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
			String sql = "Select cl.Client_NAME, p.Nom_Produit, dc.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, cm.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'valider'  group by  cl.Client_NAME;";
			
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
	public ArrayList<Commande> GetListeCommandesValiderSearchByClientNam(String Client_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit, dc.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, cm.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'valider' and cl.Client_NAME like '%"+Client_NAME+"%' group by  cl.Client_NAME;";
			
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
	
	
	public ArrayList<Commande> GetListeCommandesValiderByClientNam(String Client_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit, dc.Produit_quantite, dc.etat_Commandes, dc.Date_début, dc.Date_Fin, cm.Date_Lancement "
				    	+ "From client as cl,commande as cm,produit as p,detaille_commandes as dc"
				    	+ " where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and dc.etat_Commandes like 'valider' and cl.Client_NAME like '"+Client_NAME+"';";
			
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
			String sql = "Select cl.Client_NAME, p.Nom_Produit,dc.Produit_quantite,DATEDIFF(dc.Date_Fin,CURDATE()) as dpr "
                        +" From erp_presentation.client as cl,erp_presentation.commande as cm,erp_presentation.produit as p,erp_presentation.detaille_commandes as dc "
                        +" where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande group by  cl.Client_NAME;";
			
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
	
	public ArrayList<Commande> GetListeDelaiproductionRestantByNamClient(String Client_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit,dc.Produit_quantite,DATEDIFF(dc.Date_Fin,CURDATE()) as dpr "
                        +" From erp_presentation.client as cl,erp_presentation.commande as cm,erp_presentation.produit as p,erp_presentation.detaille_commandes as dc "
                        +" where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and cl.Client_NAME like '"+Client_NAME+"' ;";
			
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
	
	public ArrayList<Commande> GetListeDelaiproductionRestantSearchByNamClient(String Client_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select cl.Client_NAME, p.Nom_Produit,dc.Produit_quantite,DATEDIFF(dc.Date_Fin,CURDATE()) as dpr "
                        +" From erp_presentation.client as cl,erp_presentation.commande as cm,erp_presentation.produit as p,erp_presentation.detaille_commandes as dc "
                        +" where cl.ID_Client=cm.ID_Client and p.ID_Produit=dc.ID_Produit and dc.ID_Commande=cm.ID_Commande and cl.Client_NAME like '%"+Client_NAME+"%' group by  cl.Client_NAME;";
			
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
	
	
	
	public ArrayList<Commande> GetListeDelaiPaiementDiversByClientName(String Client_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "select c.Client_NAME,com.Date_Lancement,dp.Date_Paiement,dp.Montant_Paiement "
						+" from erp_presentation.commande com,erp_presentation.client c,erp_presentation.paiement p,erp_presentation.detaille_paiement dp "
						+" where c.ID_Client=com.ID_Client and p.ID_Paiement=dp.ID_Paiement and com.ID_Commande=p.ID_Commande and dp.Valider like 'Non' and c.Client_NAME like '"+Client_NAME+"'";
			
			ResultSet srs =stmt.executeQuery(sql);
			
			  while (srs.next()) {
				  Commande com=new Commande(); 
				  com.setClient_Name(srs.getString("Client_NAME"));
				  com.setDate_Lancement(srs.getDate("Date_Lancement"));
				  com.setDate_Paiement(srs.getDate("Date_Paiement"));
				  com.setMontant_Paiement(srs.getInt("Montant_Paiement"));
	             VisualisationCommande.add(com);
	          }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  VisualisationCommande;
		
	}
	public ArrayList<Commande> GetListeDelaiPaiementDivers(){
		conn = UserConnexion.getConnection();
		ArrayList<Commande> VisualisationCommande=new ArrayList<Commande>();
		
		try {
			stmt =conn.createStatement();
			String sql = "select c.Client_NAME,com.Date_Lancement,dp.Date_Paiement,dp.Montant_Paiement "
						+" from erp_presentation.commande com,erp_presentation.client c,erp_presentation.paiement p,erp_presentation.detaille_paiement dp "
						+" where c.ID_Client=com.ID_Client and p.ID_Paiement=dp.ID_Paiement and com.ID_Commande=p.ID_Commande and dp.Valider like 'Non'  group by c.Client_NAME";
			
			ResultSet srs =stmt.executeQuery(sql);
			
			  while (srs.next()) {
				  Commande com=new Commande(); 
				  com.setClient_Name(srs.getString("Client_NAME"));
				  com.setDate_Lancement(srs.getDate("Date_Lancement"));
				  com.setDate_Paiement(srs.getDate("Date_Paiement"));
				  com.setMontant_Paiement(srs.getInt("Montant_Paiement"));
	             VisualisationCommande.add(com);
	          }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  VisualisationCommande;
		
	}

}
