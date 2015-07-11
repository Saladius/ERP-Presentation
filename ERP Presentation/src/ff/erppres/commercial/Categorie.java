package ff.erppres.commercial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ff.erppres.connexion.UserConnexion;

public class Categorie {

	
	
	private int	CATEGORIE_ID; 
	private String CATEGORIE_NAME;
	
	java.sql.Statement stmt = null;
	java.sql.Connection conn = null;
	
	
	public Categorie() {}
	
	public Categorie(int cATEGORIE_ID, String cATEGORIE_NAME) {
		CATEGORIE_ID = cATEGORIE_ID;
		CATEGORIE_NAME = cATEGORIE_NAME;
	}
	
	
	public String getCATEGORIE_NAME() {
		return CATEGORIE_NAME;
	}
	public void setCATEGORIE_NAME(String cATEGORIE_NAME) {
		CATEGORIE_NAME = cATEGORIE_NAME;
	}
	public int getCATEGORIE_ID() {
		return CATEGORIE_ID;
	}
	
	
	
	
	
	public ArrayList<Categorie> GetListeCategorie(){
		conn = UserConnexion.getConnection();
		ArrayList<Categorie> CategorieList=new ArrayList<Categorie>();
		
		try {
			stmt =conn.createStatement();
			String sql = "Select CATEGORIE_NAME from categorie";
			
			ResultSet srs =stmt.executeQuery(sql);
			
			  while (srs.next()) {
	             Categorie cat=new Categorie(); 
	             cat.setCATEGORIE_NAME(srs.getString("CATEGORIE_NAME"));
	             CategorieList.add(cat);
	               
	          }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}
		
		return  CategorieList;
		
	}
	
	
	
	
	
}
