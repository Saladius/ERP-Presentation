package ff.erppres.commercial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ff.erppres.connexion.UserConnexion;

public class Produit {

	
	private int ID_Produit; 
	private String Nom_Produit;
	private String Desc_Produit; 
	private String ID_Catégories;
	private double UNIT_VALUE;
	private int STOCK_MIN;
	private int STOCK;
	
	java.sql.Statement stmt = null;
	java.sql.Connection conn = null;
	
	
	public double getUNIT_VALUE() {
		return UNIT_VALUE;
	}
	public void setUNIT_VALUE(double uNIT_VALUE) {
		UNIT_VALUE = uNIT_VALUE;
	}
	public int getSTOCK_MIN() {
		return STOCK_MIN;
	}
	public void setSTOCK_MIN(int sTOCK_MIN) {
		STOCK_MIN = sTOCK_MIN;
	}
	public int getSTOCK() {
		return STOCK;
	}
	public void setSTOCK(int sTOCK) {
		STOCK = sTOCK;
	}

	
	
	public String getNom_Produit() {
		return Nom_Produit;
	}
	public void setNom_Produit(String nom_Produit) {
		Nom_Produit = nom_Produit;
	}
	public String getDesc_Produit() {
		return Desc_Produit;
	}
	public void setDesc_Produit(String desc_Produit) {
		Desc_Produit = desc_Produit;
	}
	public int getID_Produit() {
		return ID_Produit;
	}
	public void setID_Produit(int iD_Produit) {
		ID_Produit = iD_Produit;
	}
	public String getID_Catégories() {
		return ID_Catégories;
	}
	public Produit() {}
	public Produit(int iD_Produit, String nom_Produit, String desc_Produit,
			String iD_Catégories) {
		ID_Produit = iD_Produit;
		Nom_Produit = nom_Produit;
		Desc_Produit = desc_Produit;
		ID_Catégories = iD_Catégories;
	}
	
	
	public ArrayList<Produit> GetListeProduitsByCategorie(String CATEGORIE_NAME){
		conn = UserConnexion.getConnection();
		ArrayList<Produit> ProduitList=new ArrayList<Produit>();
		
		try {
			stmt =conn.createStatement();
			String sql = "SELECT ID_Produit,Nom_Produit,Desc_Produit FROM produit where ID_Catégories in (select CATEGORIE_ID FROM categorie where CATEGORIE_NAME like '"+CATEGORIE_NAME+"' );";
			
			ResultSet srs =stmt.executeQuery(sql);
			  while (srs.next()) {
				 Produit pro=new Produit(); 
				 pro.setNom_Produit(srs.getString("Nom_Produit"));
				 pro.setDesc_Produit(srs.getString("Desc_Produit"));
				 pro.setID_Produit(Integer.parseInt(srs.getString("ID_Produit")));
	             ProduitList.add(pro);
	               
	          }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  ProduitList;
	}
	
	public int GetID_ProduitBayProduit_Name(String Produit_Name){
		conn = UserConnexion.getConnection();
		 int ID_Produit = 0;
		
		try {
			stmt =conn.createStatement();
			String sql = "SELECT ID_Produit FROM produit where Nom_Produit like '"+Produit_Name+"';";
			
			ResultSet srs =stmt.executeQuery(sql);
			    srs.next();
			 ID_Produit =Integer.parseInt(srs.getString("ID_Produit"));
	             
	               
	          
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  ID_Produit;
	}
	
	public double GetUNIT_VALUE_ByProduit_Name(String Produit_Name){
		conn = UserConnexion.getConnection();
		double UNIT_VALUE = 0;
		
		try {
			stmt =conn.createStatement();
			String sql = "SELECT UNIT_VALUE FROM produit where Nom_Produit like '"+Produit_Name+"';";
			
			ResultSet srs =stmt.executeQuery(sql);
			    srs.next();
			    UNIT_VALUE =Double.parseDouble(srs.getString("UNIT_VALUE"));
	             
	               
	          
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  UNIT_VALUE;
	}
	
	
}
