package ff.erppres.commercial;

import java.util.Date;

public class Client {
 
	private int ID_Client;
	

	private String Client_NAME;
	private String Client_MAIL;
	private String Adresse_client;
	private String Tele;
	private Date DATE_CREATION;
	private int ID_Commerciale;
	
	public String getClient_NAME() {
		return Client_NAME;
	}
	public void setClient_NAME(String client_NAME) {
		Client_NAME = client_NAME;
	}
	public String getClient_MAIL() {
		return Client_MAIL;
	}
	public void setClient_MAIL(String client_MAIL) {
		Client_MAIL = client_MAIL;
	}
	public String getAdresse_client() {
		return Adresse_client;
	}
	public void setAdresse_client(String adresse_client) {
		Adresse_client = adresse_client;
	}
	public String getTele() {
		return Tele;
	}
	public void setTele(String tele) {
		Tele = tele;
	}
	public Date getDATE_CREATION() {
		return DATE_CREATION;
	}
	public void setDATE_CREATION(Date dATE_CREATION) {
		DATE_CREATION = dATE_CREATION;
	}
	public int getID_Client() {
		return ID_Client;
	}
	public void setID_Client(int iD_Client) {
		ID_Client = iD_Client;
	}
	public int getID_Commerciale() {
		return ID_Commerciale;
	}
	public Client(String client_NAME, String client_MAIL,
			String adresse_client, String tele, Date dATE_CREATION,
			int iD_Commerciale) {
		Client_NAME = client_NAME;
		Client_MAIL = client_MAIL;
		Adresse_client = adresse_client;
		Tele = tele;
		DATE_CREATION = dATE_CREATION;
		ID_Commerciale = iD_Commerciale;
	}
	
	public Client(){}
	
}
