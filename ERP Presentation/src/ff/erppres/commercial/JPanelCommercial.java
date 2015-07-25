package ff.erppres.commercial;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import ff.erppres.connexion.UserConnexion;

import java.awt.BorderLayout;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JSpinner;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.OutputStreamWriter;

import javax.swing.JTable;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import net.miginfocom.swing.MigLayout;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.treetable.DefaultTreeTableModel;


 








import javax.swing.DefaultComboBoxModel;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

 

 

public class JPanelCommercial extends JPanel {

	/**
	 * Create the panel.
	 */
	JTabbedPane tabbedPane;
	private JTextField tktClient_NAME;
	private JTextField tktClient_MAIL;
	private JTextField tktTele;
	private JTextField TxtEmailCleintview;
	private JTextField txtTeleClientView;
	static int ID_Client;
	static int ID_Produit;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private DefaultTableModel model_panier;
	private ArrayList<String[]> detaille_commandes;
	private ArrayList<String[]> Paiement;
	static int prix=0;
	private JTextField textField_Montant1;
	private JTextField textField_Montant2;
	private JTextField textField_Montant3;
	private JTable table_6;
	private JTextField textFieldClientNamEnAttendes;
	private JTextField textFieldencoursClientNam;
	private JTextField textFieldClientNamSerachTermines;
	private JTextField textFieldClientNamValider;
	private JTextField textFieldClientNamSerchDelaiPaiement;
	
	public JPanelCommercial() {
		setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setFont( new Font( "Dialog", Font.BOLD|Font.ITALIC, 12 ) );
		add(tabbedPane);
		
		int min = 1;
	    int max = 100000;
	    int step = 1;
	    int initValue = 50;
	    SpinnerModel model = new SpinnerNumberModel(initValue, min, max, step);
	   
		
	

		final JComboBox comboBoxNamClientView = new JComboBox();
		final JComboBox comboBoxCategoriesProduit = new JComboBox();
		final JComboBox comboBoxProduit = new JComboBox();
		final JLabel label_Delai3 = new JLabel("3 :");
		final JLabel label_Delai2 = new JLabel("2 :");
		final JDateChooser dateChooser_Delai1 = new JDateChooser();
		final JDateChooser dateChooser_Delai2 = new JDateChooser();
		final JDateChooser dateChooser_Delai3 = new JDateChooser();
		final JLabel lblDh_1 = new JLabel("DH");
		final JLabel lblDh_2 = new JLabel("DH");
		final JLabel lblDh_3 = new JLabel("DH");
		final JComboBox comboBox_1 = new JComboBox();
		final JLabel lblTotal = new JLabel("0 DH");
		final DateFormat dateformat=new SimpleDateFormat("yyy/MM/dd");
		;
		
		 JPanel panel = new JPanel();
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {

				
			 
				
				commercial com=new commercial();
				comboBoxNamClientView.removeAllItems();
				comboBoxCategoriesProduit.removeAllItems();
				
				ArrayList<Client> clientList=com.GetAllNmeClient();
				for(Client c:clientList){
					comboBoxNamClientView.addItem(c.getClient_NAME());
				}
				
				Categorie Cat=new Categorie();
				ArrayList<Categorie> CategorieList=Cat.GetListeCategorie();
				for(Categorie categorie:CategorieList){
					comboBoxCategoriesProduit.addItem(categorie.getCATEGORIE_NAME());
				} 
				
				model_panier=new DefaultTableModel();
				model_panier.setColumnIdentifiers(new String[]{"Nom de Client","Nom de produit","Quantité produit","Prix unitaire","Date de Début","Date Fin"});
				table_5.setModel(model_panier);
				
				
				 detaille_commandes=new ArrayList<String[]>();
				 Paiement=new ArrayList<String[]>();
				 
				 Paiement.clear();
					try{
					Paiement.add(new String[]{dateformat.format(dateChooser_Delai1.getDate()),textField_Montant1.getText()});
					}catch(Exception ex){}
				 
				textField_Montant2.setVisible(false);
				textField_Montant3.setVisible(false);
				
				label_Delai2.setVisible(false);
				label_Delai3.setVisible(false);
				
				dateChooser_Delai2.setVisible(false);
				dateChooser_Delai3.setVisible(false);
				
				lblDh_2.setVisible(false);
				lblDh_3.setVisible(false);
				
				prix=0;
				textField_Montant1.setText(Integer.toString(prix));
				lblTotal.setText(Integer.toString(prix)+ " DH");
				
			}
		});
		
		comboBoxCategoriesProduit.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (e.getStateChange() == ItemEvent.DESELECTED)
				    return;
				
				
					Produit pro=new Produit();
					comboBoxProduit.removeAllItems();
					ArrayList<Produit> ProduitListe=pro.GetListeProduitsByCategorie(comboBoxCategoriesProduit.getSelectedItem().toString());
					for(Produit pr:ProduitListe){
						comboBoxProduit.addItem(pr.getNom_Produit());
						
					
					} 
				 
				 
			}
		});
		
		
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Rentr\u00E9e de nouvelles commandes", null, panel, null);
		panel.setLayout(null);
		
		JButton button = new JButton("Ajouter nouveaux Client");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(6);
				 
			}
		});
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(28, 23, 172, 29);
		panel.add(button);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(SystemColor.controlHighlight);
		desktopPane_1.setBounds(403, 111, 409, 265);
		panel.add(desktopPane_1);
		
		JLabel lblCatgoriesProduit = new JLabel("Cat\u00E9gories produit :");
		lblCatgoriesProduit.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblCatgoriesProduit.setBounds(10, 40, 156, 20);
		desktopPane_1.add(lblCatgoriesProduit);
		
		
		 
		comboBoxCategoriesProduit.setBounds(172, 40, 223, 20);
		desktopPane_1.add(comboBoxCategoriesProduit);
		
		JLabel lblProduitsRequis = new JLabel("Produits requis :");
		lblProduitsRequis.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblProduitsRequis.setBounds(36, 76, 156, 20);
		desktopPane_1.add(lblProduitsRequis);
		
	
		comboBoxProduit.setBounds(172, 77, 223, 20);
		desktopPane_1.add(comboBoxProduit);
		
		JLabel lblQuantitProduit = new JLabel("Quantit\u00E9 produit :");
		lblQuantitProduit.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblQuantitProduit.setBounds(24, 115, 156, 20);
		desktopPane_1.add(lblQuantitProduit);
		final JSpinner spinnerQuantite = new JSpinner(model);
		spinnerQuantite.setBounds(172, 116, 94, 20);
		desktopPane_1.add(spinnerQuantite);
		
		JLabel lblDateDbut = new JLabel("Date d\u00E9but :");
		lblDateDbut.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblDateDbut.setBounds(65, 158, 156, 20);
		desktopPane_1.add(lblDateDbut);
		
		JLabel lblDateFin = new JLabel("Date fin :");
		lblDateFin.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblDateFin.setBounds(92, 189, 156, 20);
		desktopPane_1.add(lblDateFin);
		
		final JDateChooser dateChooserDateDbut = new JDateChooser();
		dateChooserDateDbut.setBounds(172, 158, 145, 20);
		desktopPane_1.add(dateChooserDateDbut);
		
		final JDateChooser dateChooserDateFin = new JDateChooser();
		dateChooserDateFin.setBounds(172, 189, 145, 20);
		desktopPane_1.add(dateChooserDateFin);
		
		
		 
		JButton btnAjouterUnProduit = new JButton("Ajouter un produit au panier");
		Image img = new ImageIcon("img/Ok.png").getImage();
		btnAjouterUnProduit.setIcon(new ImageIcon(img));
		btnAjouterUnProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//"Nom de Client","Nom de produit","Quantité produit","Prix unitaire","Date de Début","Date Fin"
				
				
				String Message="";
				Produit pro=new Produit();
				
           if((Integer)spinnerQuantite.getValue() <0 || dateChooserDateFin.getDate() == null || dateChooserDateDbut.getDate() == null){
					
					Message +=" Vous n'avez pas rempli toutes les zones ";
					JOptionPane.showMessageDialog(new JFrame(), Message);
				}
           else{
			model_panier.addRow(new String[]{comboBoxNamClientView.getSelectedItem().toString(),comboBoxProduit.getSelectedItem().toString(),spinnerQuantite.getValue().toString(),pro.GetUNIT_VALUE_ByProduit_Name(comboBoxProduit.getSelectedItem().toString())+" DH",dateformat.format(dateChooserDateDbut.getDate()),dateformat.format(dateChooserDateFin.getDate())});
			table_5.setModel(model_panier); 
			prix+= pro.GetUNIT_VALUE_ByProduit_Name(comboBoxProduit.getSelectedItem().toString())*(int)spinnerQuantite.getValue();
			lblTotal.setText("");
			lblTotal.setText(lblTotal.getText().toString() +prix+" DH");
			textField_Montant1.setText(Integer.toString(prix));
			
		
			detaille_commandes.add(new String[]{dateformat.format(dateChooserDateDbut.getDate()),dateformat.format(dateChooserDateFin.getDate()),spinnerQuantite.getValue().toString(),Integer.toString(ID_Produit)});
			
			
           }
			
			}
		});
		btnAjouterUnProduit.setBounds(10, 220, 385, 33);
		desktopPane_1.add(btnAjouterUnProduit);
		btnAjouterUnProduit.setBackground(SystemColor.controlHighlight);
		
		JLabel label_2 = new JLabel(" l'information de Client");
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_2.setBounds(28, 80, 172, 20);
		panel.add(label_2);
		
		JLabel lblLinformationCommande = new JLabel(" l'information Commande");
		lblLinformationCommande.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblLinformationCommande.setBounds(403, 80, 232, 20);
		panel.add(lblLinformationCommande);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.controlHighlight);
		desktopPane.setBounds(15, 111, 378, 265);
		panel.add(desktopPane);
		
		JLabel label = new JLabel("Nom du client :");
		label.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		label.setBounds(10, 40, 156, 20);
		desktopPane.add(label);
		
		JLabel label_4 = new JLabel("Email client :");
		label_4.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		label_4.setBounds(30, 76, 156, 14);
		desktopPane.add(label_4);
		
		TxtEmailCleintview = new JTextField();
		TxtEmailCleintview.setEditable(false);
		TxtEmailCleintview.setColumns(10);
		TxtEmailCleintview.setBounds(136, 74, 171, 20);
		desktopPane.add(TxtEmailCleintview);
		
		final JTextArea tktAdressView = new JTextArea();
		tktAdressView.setEditable(false);
		tktAdressView.setBounds(137, 142, 221, 97);
		desktopPane.add(tktAdressView);
		
		JLabel label_5 = new JLabel("Adresse :");
		label_5.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		label_5.setBounds(56, 146, 156, 14);
		desktopPane.add(label_5);
		
		JLabel label_6 = new JLabel("T\u00E9le client :");
		label_6.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		label_6.setBounds(40, 110, 156, 14);
		desktopPane.add(label_6);
		
		txtTeleClientView = new JTextField();
		txtTeleClientView.setEditable(false);
		txtTeleClientView.setColumns(10);
		txtTeleClientView.setBounds(136, 108, 171, 20);
		desktopPane.add(txtTeleClientView);
		
		
		
		
		
		
		comboBoxNamClientView.setBounds(136, 40, 221, 20);
		
	 
		desktopPane.add(comboBoxNamClientView);
		
		JDesktopPane desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBackground(SystemColor.controlHighlight);
		desktopPane_3.setBounds(822, 111, 239, 265);
		panel.add(desktopPane_3);
		
		JLabel lblTypeDePaiement = new JLabel("type :");
		lblTypeDePaiement.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblTypeDePaiement.setBounds(10, 39, 55, 20);
		desktopPane_3.add(lblTypeDePaiement);
		
		JLabel lblDlaisDePaiement = new JLabel("D\u00E9lais :");
		lblDlaisDePaiement.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblDlaisDePaiement.setBounds(10, 70, 67, 14);
		desktopPane_3.add(lblDlaisDePaiement);
		
		JLabel label_Delai1 = new JLabel("1 : ");
		label_Delai1.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		label_Delai1.setBounds(14, 111, 25, 14);
		desktopPane_3.add(label_Delai1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Esp\u00E8ces", "Ch\u00E8que", "Cartes bancaires", "Virements"}));
		comboBox.setBounds(77, 40, 129, 20);
		desktopPane_3.add(comboBox);
		
		
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.DESELECTED)
					return;

				if(comboBox_1.getSelectedItem().toString().equals("1")){
					
					textField_Montant2.setVisible(false); 
					textField_Montant3.setVisible(false);
					
					label_Delai2.setVisible(false); 
					label_Delai3.setVisible(false);
					
					dateChooser_Delai2.setVisible(false);
					dateChooser_Delai3.setVisible(false);
					
					lblDh_2.setVisible(false);
					lblDh_3.setVisible(false);
					
					textField_Montant1.setText(Integer.toString(prix));
					
					
					
				}
				if(comboBox_1.getSelectedItem().toString().equals("2")){
					
					textField_Montant2.setVisible(true); 
					textField_Montant3.setVisible(false);
					
					label_Delai2.setVisible(true); 
					label_Delai3.setVisible(false);
					
					dateChooser_Delai2.setVisible(true);
					dateChooser_Delai3.setVisible(false);
					
					lblDh_2.setVisible(true);
					lblDh_3.setVisible(false);
					
					textField_Montant1.setText(Integer.toString(prix/2));
					textField_Montant2.setText(Integer.toString(prix/2));
					
					
					
				}
				if(comboBox_1.getSelectedItem().toString().equals("3")){
					
					textField_Montant2.setVisible(true);
					textField_Montant3.setVisible(true);
					
					label_Delai2.setVisible(true);
					label_Delai3.setVisible(true);
					
					dateChooser_Delai2.setVisible(true);
					dateChooser_Delai3.setVisible(true);
					
					lblDh_2.setVisible(true);
					lblDh_3.setVisible(true);
					
					textField_Montant1.setText(Integer.toString(prix/3));
					textField_Montant2.setText(Integer.toString(prix/3));
					textField_Montant3.setText(Integer.toString(prix/3));
					
				
				}
				
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox_1.setBounds(77, 68, 129, 20);
		desktopPane_3.add(comboBox_1);
		
		
		dateChooser_Delai1.setBounds(41, 105, 96, 20);
		desktopPane_3.add(dateChooser_Delai1);
		
		
		label_Delai2.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		label_Delai2.setBounds(11, 142, 25, 14);
		desktopPane_3.add(label_Delai2);
		
		
		dateChooser_Delai2.setBounds(41, 136, 96, 20);
		desktopPane_3.add(dateChooser_Delai2);
		
		
		label_Delai3.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		label_Delai3.setBounds(10, 169, 25, 14);
		desktopPane_3.add(label_Delai3);
		
		
		dateChooser_Delai3.setBounds(41, 163, 96, 20);
		desktopPane_3.add(dateChooser_Delai3);
		
		
		lblTotal.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblTotal.setBounds(122, 11, 89, 20);
		desktopPane_3.add(lblTotal);
		
		JLabel label_7 = new JLabel("TOTAL : ");
		label_7.setBounds(5, 11, 221, 20);
		desktopPane_3.add(label_7);
		label_7.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		textField_Montant1 = new JTextField();
		textField_Montant1.setBounds(147, 105, 59, 20);
		desktopPane_3.add(textField_Montant1);
		textField_Montant1.setEditable(false);
		textField_Montant1.setColumns(10);
		
		textField_Montant2 = new JTextField();
		textField_Montant2.setEditable(false);
		textField_Montant2.setColumns(10);
		textField_Montant2.setBounds(147, 136, 59, 20);
		desktopPane_3.add(textField_Montant2);
		
		textField_Montant3 = new JTextField();
		textField_Montant3.setEditable(false);
		textField_Montant3.setColumns(10);
		textField_Montant3.setBounds(147, 163, 59, 20);
		desktopPane_3.add(textField_Montant3);
		
		
		lblDh_1.setBounds(208, 104, 28, 20);
		desktopPane_3.add(lblDh_1);
		lblDh_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		
		lblDh_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDh_2.setBounds(208, 135, 28, 20);
		desktopPane_3.add(lblDh_2);
		
		
		lblDh_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDh_3.setBounds(208, 163, 28, 20);
		desktopPane_3.add(lblDh_3);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(82, 415, 655, 158);
		panel.add(scrollPane_5);
		
		table_5 = new JTable();
		scrollPane_5.setViewportView(table_5);
		
		JLabel lblInformationsDePaiement = new JLabel("Informations de paiement");
		lblInformationsDePaiement.setBounds(822, 80, 201, 20);
		panel.add(lblInformationsDePaiement);
		lblInformationsDePaiement.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		JButton button_2 = new JButton(" Vider le panier");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 

				Paiement.clear();
				detaille_commandes.clear();
				comboBox_1.setSelectedIndex(0);
				prix=0;
				textField_Montant1.setText(Integer.toString(prix));
				lblTotal.setText(Integer.toString(prix)+ " DH");
				
				if (model_panier.getRowCount() > 0) {
				    for (int i = model_panier.getRowCount() - 1; i > -1; i--) {
				    	model_panier.removeRow(i);
				    }
				}
				
//				for(int i=0;i<Paiement.size();i++){
//				String[] myString= new String[2];
//				myString=Paiement.get(i); 
//				System.out.println(myString[0] +"  "+myString[1]);
//				System.out.println("\n");
//			}

				
//				for(int i=0;i<table_5.getModel().getRowCount();i++)
//				{
//					System.out.println(table_5.getModel().getValueAt(i, 0));
//					System.out.println(table_5.getModel().getValueAt(i, 1));
//					System.out.println(table_5.getModel().getValueAt(i, 2));
//					System.out.println(table_5.getModel().getValueAt(i, 3));
//					System.out.println(table_5.getModel().getValueAt(i, 4));
//					System.out.println(table_5.getModel().getValueAt(i, 5));
//				}
				
				
				
			}
		});
		button_2.setBackground(SystemColor.controlHighlight);
		button_2.setBounds(598, 581, 140, 33);
		panel.add(button_2);
		
		JLabel lblPanier = new JLabel("Panier");
		lblPanier.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPanier.setBounds(82, 389, 172, 20);
		panel.add(lblPanier);
		
		JButton btnAjouterNouvelleCommande = new JButton("Ajouter nouvelle Commande");
		btnAjouterNouvelleCommande.setBounds(822, 407, 239, 33);
		panel.add(btnAjouterNouvelleCommande);
		btnAjouterNouvelleCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			 
				String Message="";
				DateFormat dateFormat    = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				DateFormat dateFormat_ch = new SimpleDateFormat("yyy/MM/dd");
				Date date = new Date();
				commercial com=new commercial();
				Produit pro=new Produit();
				
				if((Integer)spinnerQuantite.getValue() <0 || dateChooserDateFin.getDate() == null || dateChooserDateDbut.getDate() == null){
					
					Message +=" Vous n'avez pas rempli toutes les zones ";
					return;
				}
				else{
				
					if(comboBox_1.getSelectedItem().equals("1")){
						if(dateChooser_Delai1.getDate() == null){
							JOptionPane.showMessageDialog(new JFrame(), "S'il vous plaît choisir une date de paiement");
							return;
						}
						else{
						Paiement.clear();
						try{
						Paiement.add(new String[]{dateformat.format(dateChooser_Delai1.getDate()),textField_Montant1.getText()});
						}catch(Exception ex){}
						}
					}
					if(comboBox_1.getSelectedItem().equals("2")){
						if(dateChooser_Delai1.getDate() == null || dateChooser_Delai2.getDate() == null){
							JOptionPane.showMessageDialog(new JFrame(), "S'il vous plaît choisir une date de paiement");
							return;
						}
						else{
						Paiement.clear();
						try{
						Paiement.add(new String[]{dateformat.format(dateChooser_Delai1.getDate()),textField_Montant1.getText()});
						Paiement.add(new String[]{dateformat.format(dateChooser_Delai2.getDate()),textField_Montant2.getText()});
						}catch(Exception ex){}
						}
					}
					if(comboBox_1.getSelectedItem().equals("3")){
						if(dateChooser_Delai1.getDate() == null || dateChooser_Delai2.getDate()==null || dateChooser_Delai3.getDate()==null){
							JOptionPane.showMessageDialog(new JFrame(), "S'il vous plaît choisir une date de paiement");
							return;
						}
						else{
						Paiement.clear();
						try{
						Paiement.add(new String[]{dateformat.format(dateChooser_Delai1.getDate()),textField_Montant1.getText()});
						Paiement.add(new String[]{dateformat.format(dateChooser_Delai2.getDate()),textField_Montant2.getText()});
						Paiement.add(new String[]{dateformat.format(dateChooser_Delai3.getDate()),textField_Montant3.getText()});
						}catch(Exception ex){}
						}
					}
					
					
					
				
					Message+=com.AddCommande(dateFormat.format(date), ID_Client, UserConnexion.getIduser(), detaille_commandes,Integer.parseInt(comboBox_1.getSelectedItem().toString()),(float)prix,comboBox.getSelectedItem().toString(),Paiement);
						
					
				//System.out.println(ID_Produit +" "+ (int)spinnerQuantite.getValue() +" "+ ID_Client +" "+ UserConnexion.getIdprofil() +" "+ String.format("%1$td-%1$tm-%1$tY",dateChooserDateDbut.getDate()) +" "+ String.format("%1$td-%1$tm-%1$tY",dateChooserDateFin.getDate()) +" "+ dateFormat.format(date) +" "+ "en cours");
				//System.out.println(dateFormat.format(dateChooserDateDbut.getDate()));
				}
				
				
				JOptionPane.showMessageDialog(new JFrame(), Message);
			}
		});
		btnAjouterNouvelleCommande.setBackground(SystemColor.controlHighlight);
		
		comboBoxNamClientView.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.DESELECTED)
					return;
				commercial comm=new commercial();
				ArrayList<Client> clientList=comm.GetClient(comboBoxNamClientView.getSelectedItem().toString());
				for(Client c:clientList){
					TxtEmailCleintview.setText(c.getClient_MAIL());
					txtTeleClientView.setText(c.getTele());
					tktAdressView.setText(c.getAdresse_client());
					ID_Client=c.getID_Client();
					 
				} 
			}
		});
		
		comboBoxProduit.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() ==ItemEvent.DESELECTED)
					return;
				Produit pro=new Produit();
				ID_Produit =pro.GetID_ProduitBayProduit_Name(comboBoxProduit.getSelectedItem().toString());
				//System.out.println(ID_Produit);
			}
		});
		
	 
		
		JPanel panel_1 = new JPanel();
		final JScrollPane scrollPane_1 = new JScrollPane();
		table_1 = new JTable();
		panel_1.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				
				
			 
				
//				DefaultTableModel model=new DefaultTableModel();
//				model.setColumnIdentifiers(new String[]{"Nom de Client","Nom de produit","Quantité produit","Date de Début","Date Fin","Date Lancement"});
//				Commande com=new Commande();
//				ArrayList<Commande> ListeCommandes=com.GetListeCommandesEnattentes();
//				for(Commande c:ListeCommandes){
//					model.addRow(new String[]{c.getClient_Name(),c.getNom_Produit(),Integer.toString(c.getProduit_quantite()),c.getDate_debut().toString(),c.getDate_Fin().toString(),c.getDate_Lancement().toString()});
//				}
//				table_1.setModel(model);
				
				Commande com=new Commande();
				ArrayList<Commande> ListeCommandes=com.GetListeCommandesEnattentes();
				List<String[]> content = new ArrayList<>();

				for(int i=0;i<ListeCommandes.size();i++){
						
					 content.add(new String[] {ListeCommandes.get(i).getClient_Name()});
				 
					ArrayList<Commande> ListeCommandesBy=com.GetListeCommandesEnattentesByClienNam(ListeCommandes.get(i).getClient_Name());
					for(int j=0;j<ListeCommandesBy.size();j++)
						{
					content.add(new String[] { ListeCommandesBy.get(j).getNom_Produit(),Integer.toString(ListeCommandesBy.get(j).getProduit_quantite()),ListeCommandesBy.get(j).getDate_debut().toString(),ListeCommandesBy.get(j).getDate_Fin().toString(),ListeCommandesBy.get(j).getDate_Lancement().toString() });
					
						}
				
					
					}
				
				
				TreeTable treeTable = new TreeTable(content);
				scrollPane_1.setViewportView(treeTable.getTreeTable());
				
				
			}
		});
		tabbedPane.addTab("Des Commandes ( En attentes )", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		scrollPane_1.setBounds(50, 90, 883, 448);
		panel_1.add(scrollPane_1);
		final JScrollPane scrollPane = new JScrollPane();
		final JLabel lblRechercheDunClient = new JLabel("Recherche d'un client par nom :");
		lblRechercheDunClient.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblRechercheDunClient.setBounds(50, 58, 256, 20);
		panel_1.add(lblRechercheDunClient);
		
		textFieldClientNamEnAttendes = new JTextField();								  
		textFieldClientNamEnAttendes.getDocument().addDocumentListener (new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}
			
			public void MyFunction(){
				Commande com=new Commande();
				ArrayList<Commande> ListeCommandes=com.GetListeCommandesEnattentesSearchClientNam(textFieldClientNamEnAttendes.getText());
				List<String[]> content = new ArrayList<>();
				 
				   
				
					for(int i=0;i<ListeCommandes.size();i++){
							
						 content.add(new String[] {ListeCommandes.get(i).getClient_Name()});
					 
						ArrayList<Commande> ListeCommandesBy=com.GetListeCommandesEnattentesByClienNam(ListeCommandes.get(i).getClient_Name());
						for(int j=0;j<ListeCommandesBy.size();j++)
 						{
						content.add(new String[] { ListeCommandesBy.get(j).getNom_Produit(),Integer.toString(ListeCommandesBy.get(j).getProduit_quantite()),ListeCommandesBy.get(j).getDate_debut().toString(),ListeCommandesBy.get(j).getDate_Fin().toString(),ListeCommandesBy.get(j).getDate_Lancement().toString() });
						
							}
						
						
					
						
						}
					
					
  
					TreeTable treeTable = new TreeTable(content);
					scrollPane_1.setViewportView(treeTable.getTreeTable());
			}
		
		
		});
	
		textFieldClientNamEnAttendes.setBounds(305, 59, 192, 20);
		panel_1.add(textFieldClientNamEnAttendes);
		textFieldClientNamEnAttendes.setColumns(10);
		
		table = new JTable();
		JPanel panel_2 = new JPanel();
		
		panel_2.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
		
//				DefaultTableModel model=new DefaultTableModel();
//				model.setColumnIdentifiers(new String[]{"Nom de Client","Nom de produit","Quantité produit","Date de Début","Date Fin","Date Lancement"});
//				Commande com=new Commande();
//				ArrayList<Commande> ListeCommandes=com.GetListeCommandesEncours();
//				for(Commande c:ListeCommandes){
//					model.addRow(new String[]{c.getClient_Name(),c.getNom_Produit(),Integer.toString(c.getProduit_quantite()),c.getDate_debut().toString(),c.getDate_Fin().toString(),c.getDate_Lancement().toString()});
//				}
//				table.setModel(model);
				
				Commande com=new Commande();
				ArrayList<Commande> ListeCommandes=com.GetListeCommandesEncours();
				List<String[]> content = new ArrayList<>();
				 
				   
				
					for(int i=0;i<ListeCommandes.size();i++){
							
						 content.add(new String[] {ListeCommandes.get(i).getClient_Name()});
					 
						ArrayList<Commande> ListeCommandesBy=com.GetListeCommandesEncoursByNomClient(ListeCommandes.get(i).getClient_Name());
						for(int j=0;j<ListeCommandesBy.size();j++)
 						{
						content.add(new String[] { ListeCommandesBy.get(j).getNom_Produit(),Integer.toString(ListeCommandesBy.get(j).getProduit_quantite()),ListeCommandesBy.get(j).getDate_debut().toString(),ListeCommandesBy.get(j).getDate_Fin().toString(),ListeCommandesBy.get(j).getDate_Lancement().toString() });
						
							}
						
						
					
						
						}
					
					
  
				 TreeTable treeTable = new TreeTable(content);
				 scrollPane.setViewportView(treeTable.getTreeTable());
				
				
			}
		});
		tabbedPane.addTab("Des Commandes ( En cours )", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		scrollPane.setBounds(50, 90, 883, 448);
		panel_2.add(scrollPane);
		
	    JLabel label_3 = new JLabel("Recherche d'un client par nom :");
		label_3.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		label_3.setBounds(50, 58, 256, 20);
		panel_2.add(label_3);
		
		textFieldencoursClientNam = new JTextField();
		textFieldencoursClientNam.getDocument().addDocumentListener (new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}
			
			public void MyFunction(){
				Commande com=new Commande();
				ArrayList<Commande> ListeCommandes=com.GetListeCommandesEncoursSearchByNomClient(textFieldencoursClientNam.getText());
				List<String[]> content = new ArrayList<>();
				 
					for(int i=0;i<ListeCommandes.size();i++){
							
						 content.add(new String[] {ListeCommandes.get(i).getClient_Name()});
					 
						ArrayList<Commande> ListeCommandesBy=com.GetListeCommandesEncoursByNomClient(ListeCommandes.get(i).getClient_Name());
						for(int j=0;j<ListeCommandesBy.size();j++)
							{
						content.add(new String[] { ListeCommandesBy.get(j).getNom_Produit(),Integer.toString(ListeCommandesBy.get(j).getProduit_quantite()),ListeCommandesBy.get(j).getDate_debut().toString(),ListeCommandesBy.get(j).getDate_Fin().toString(),ListeCommandesBy.get(j).getDate_Lancement().toString() });
						
							}
						
						
					
						
						}
					
					
		
					 TreeTable treeTable = new TreeTable(content);
					 scrollPane.setViewportView(treeTable.getTreeTable());
			}
		
		
		});
		textFieldencoursClientNam.setColumns(10);
		textFieldencoursClientNam.setBounds(305, 59, 192, 20);
		panel_2.add(textFieldencoursClientNam);
		
		
		JPanel panel_3 = new JPanel(); 
		final JScrollPane scrollPane_2 = new JScrollPane();
		table_2 = new JTable();
		panel_3.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
//				DefaultTableModel model=new DefaultTableModel();
//				model.setColumnIdentifiers(new String[]{"Nom de Client","Nom de produit","Quantité produit","Date de Début","Date Fin","Date Lancement"});
//				Commande com=new Commande();
//				ArrayList<Commande> ListeCommandes=com.GetListeCommandesTermines();
//				for(Commande c:ListeCommandes){
//					model.addRow(new String[]{c.getClient_Name(),c.getNom_Produit(),Integer.toString(c.getProduit_quantite()),c.getDate_debut().toString(),c.getDate_Fin().toString(),c.getDate_Lancement().toString()});
//				}
//				table_2.setModel(model);
				
				Commande com=new Commande();
				ArrayList<Commande> ListeCommandes=com.GetListeCommandesTermines();
				List<String[]> content = new ArrayList<>();

				for(int i=0;i<ListeCommandes.size();i++){
						
					 content.add(new String[] {ListeCommandes.get(i).getClient_Name()});
				 
					ArrayList<Commande> ListeCommandesBy=com.GetListeCommandesTerminesByClientNam(ListeCommandes.get(i).getClient_Name());
					for(int j=0;j<ListeCommandesBy.size();j++)
						{
					content.add(new String[] { ListeCommandesBy.get(j).getNom_Produit(),Integer.toString(ListeCommandesBy.get(j).getProduit_quantite()),ListeCommandesBy.get(j).getDate_debut().toString(),ListeCommandesBy.get(j).getDate_Fin().toString(),ListeCommandesBy.get(j).getDate_Lancement().toString() });
					
						}
				
					
					}
				
				
				TreeTable treeTable = new TreeTable(content);
				scrollPane_2.setViewportView(treeTable.getTreeTable());
			}
		});
		tabbedPane.addTab("Des Commandes ( Termin\u00E9s  )", null, panel_3, null);
		panel_3.setLayout(null);
		
		
		scrollPane_2.setBounds(50, 90, 883, 448);
		panel_3.add(scrollPane_2);
		
		
		scrollPane_2.setViewportView(table_2);
		
		JLabel label_8 = new JLabel("Recherche d'un client par nom :");
		label_8.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		label_8.setBounds(50, 58, 256, 20);
		panel_3.add(label_8);
		
		textFieldClientNamSerachTermines = new JTextField();
		textFieldClientNamSerachTermines.getDocument().addDocumentListener (new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}
			
			public void MyFunction(){
				Commande com=new Commande();
				ArrayList<Commande> ListeCommandes=com.GetListeCommandesTerminesSearchByClientNam(textFieldClientNamSerachTermines.getText());
				List<String[]> content = new ArrayList<>();

				for(int i=0;i<ListeCommandes.size();i++){
						
					 content.add(new String[] {ListeCommandes.get(i).getClient_Name()});
				 
					ArrayList<Commande> ListeCommandesBy=com.GetListeCommandesTerminesByClientNam(ListeCommandes.get(i).getClient_Name());
					for(int j=0;j<ListeCommandesBy.size();j++)
						{
					content.add(new String[] { ListeCommandesBy.get(j).getNom_Produit(),Integer.toString(ListeCommandesBy.get(j).getProduit_quantite()),ListeCommandesBy.get(j).getDate_debut().toString(),ListeCommandesBy.get(j).getDate_Fin().toString(),ListeCommandesBy.get(j).getDate_Lancement().toString() });
					
						}
				
					
					}
				
				
				TreeTable treeTable = new TreeTable(content);
				scrollPane_2.setViewportView(treeTable.getTreeTable());
			}
		
		
		});
		
		textFieldClientNamSerachTermines.setColumns(10);
		textFieldClientNamSerachTermines.setBounds(305, 59, 192, 20);
		panel_3.add(textFieldClientNamSerachTermines);
		
		
		JPanel panel_4 = new JPanel(); 
		final JScrollPane scrollPane_3 = new JScrollPane();
		table_3 = new JTable();
		panel_4.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
//				DefaultTableModel model=new DefaultTableModel();
//				model.setColumnIdentifiers(new String[]{"Nom de Client","Nom de produit","Quantité produit","Date de Début","Date Fin","Date Lancement"});
//				Commande com=new Commande();
//				ArrayList<Commande> ListeCommandes=com.GetListeCommandesValider();
//				for(Commande c:ListeCommandes){
//					model.addRow(new String[]{c.getClient_Name(),c.getNom_Produit(),Integer.toString(c.getProduit_quantite()),c.getDate_debut().toString(),c.getDate_Fin().toString(),c.getDate_Lancement().toString()});
//				}
//				table_3.setModel(model);
				
				Commande com=new Commande();
				ArrayList<Commande> ListeCommandes=com.GetListeCommandesValider();
				List<String[]> content = new ArrayList<>();

				for(int i=0;i<ListeCommandes.size();i++){
						
					 content.add(new String[] {ListeCommandes.get(i).getClient_Name()});
				 
					ArrayList<Commande> ListeCommandesBy=com.GetListeCommandesValiderByClientNam(ListeCommandes.get(i).getClient_Name());
					for(int j=0;j<ListeCommandesBy.size();j++)
						{
					content.add(new String[] { ListeCommandesBy.get(j).getNom_Produit(),Integer.toString(ListeCommandesBy.get(j).getProduit_quantite()),ListeCommandesBy.get(j).getDate_debut().toString(),ListeCommandesBy.get(j).getDate_Fin().toString(),ListeCommandesBy.get(j).getDate_Lancement().toString() });
					
						}
				
					
					}
				
				
				TreeTable treeTable = new TreeTable(content);
				scrollPane_3.setViewportView(treeTable.getTreeTable());
				
				
			}
		});
		tabbedPane.addTab("Des Commandes  ( Valider )", null, panel_4, null);
		panel_4.setLayout(null);
		
		
		scrollPane_3.setBounds(50, 90, 883, 448);
		panel_4.add(scrollPane_3);
		
		
		scrollPane_3.setViewportView(table_3);
		
		JLabel label_9 = new JLabel("Recherche d'un client par nom :");
		label_9.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		label_9.setBounds(50, 58, 256, 20);
		panel_4.add(label_9);
		
		textFieldClientNamValider = new JTextField();
		textFieldClientNamValider.getDocument().addDocumentListener (new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}
			
			public void MyFunction(){
				
				Commande com=new Commande();
				ArrayList<Commande> ListeCommandes=com.GetListeCommandesValiderSearchByClientNam(textFieldClientNamValider.getText());
				List<String[]> content = new ArrayList<>();

				for(int i=0;i<ListeCommandes.size();i++){
						
					 content.add(new String[] {ListeCommandes.get(i).getClient_Name()});
				 
					ArrayList<Commande> ListeCommandesBy=com.GetListeCommandesValiderByClientNam(ListeCommandes.get(i).getClient_Name());
					for(int j=0;j<ListeCommandesBy.size();j++)
						{
					content.add(new String[] { ListeCommandesBy.get(j).getNom_Produit(),Integer.toString(ListeCommandesBy.get(j).getProduit_quantite()),ListeCommandesBy.get(j).getDate_debut().toString(),ListeCommandesBy.get(j).getDate_Fin().toString(),ListeCommandesBy.get(j).getDate_Lancement().toString() });
					
						}
				
					
					}
				
				
				TreeTable treeTable = new TreeTable(content);
				scrollPane_3.setViewportView(treeTable.getTreeTable());
				
			}
		
		
		});
		textFieldClientNamValider.setColumns(10);
		textFieldClientNamValider.setBounds(305, 59, 192, 20);
		panel_4.add(textFieldClientNamValider);
		
		
		JPanel panel_5 = new JPanel(); 
		final JScrollPane scrollPane_6 = new JScrollPane();
		
		panel_5.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
		 
				Commande com=new Commande();
				ArrayList<Commande> ListeCommandes=com.GetListeDelaiPaiementDivers();
				List<String[]> content = new ArrayList<>();

				for(int i=0;i<ListeCommandes.size();i++){
					 content.add(new String[] {ListeCommandes.get(i).getClient_Name()});
						
					
					ArrayList<Commande> ListeCommandesBy=com.GetListeDelaiPaiementDiversByClientName(ListeCommandes.get(i).getClient_Name());
					for(int j=0;j<ListeCommandesBy.size();j++)
						{
						 content.add(new String[] {ListeCommandesBy.get(j).getDate_Lancement().toString(),
								 ListeCommandesBy.get(j).getDate_Paiement().toString(),
								 Integer.toString(ListeCommandesBy.get(j).getMontant_Paiement()) +" DH"});
						 
						}
				
					
					}
				
				
				TreeTable treeTable = new TreeTable(content);
		
				scrollPane_6.setViewportView(treeTable.getTreeTableDelaiPaiementDivers());
				 
				
				
			}
		});
		tabbedPane.addTab("D\u00E9lai de payements divers", null, panel_5, null);
		panel_5.setLayout(null);
		
		
		scrollPane_6.setBounds(50, 90, 884, 443);
		panel_5.add(scrollPane_6);
		
		//table_6 = new JTable();
		//scrollPane_6.setViewportView(table_6);
//		List<String[]> content = new ArrayList<>();
//		content.add(new String[] { "Heading 1" });
//		content.add(new String[] { "Sub 1", "Sub 2", "Sub 3" });
//		content.add(new String[] { "Sub 4", "Sub 5", "Sub 6" });
//		content.add(new String[] { "Heading 2" });
//		content.add(new String[] { "Sub 1", "Sub 2", "Sub 3" });
//		content.add(new String[] { "Sub 4", "Sub 5", "Sub 6" });
//		content.add(new String[] { "Heading 3" });
//		content.add(new String[] { "Sub 1", "Sub 2", "Sub 3" });
//		content.add(new String[] { "Sub 4", "Sub 5", "Sub 6" });
//	    TreeTable treeTable1 = new TreeTable(content);
		
//		scrollPane_6.setViewportView(treeTable1.getTreeTable());
		
		JPanel panel_6 = new JPanel();
		final JScrollPane scrollPane_4 = new JScrollPane();
		tabbedPane.addTab("Ajouter nouveaux Client", null, panel_6, null);
		panel_6.setLayout(null);
		
		JPanel panel_7 =new JPanel();
		table_4 = new JTable();
		
		panel_7.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
//				DefaultTableModel model=new DefaultTableModel();
//				model.setColumnIdentifiers(new String[]{"Nom de Client","Nom de produit","Quantité produit","Délai restant par jour"});
//				Commande com=new Commande();
//				ArrayList<Commande> ListeCommandes=com.GetListeDelaiproductionRestant();
//				for(Commande c:ListeCommandes){
//					model.addRow(new String[]{c.getClient_Name(),c.getNom_Produit(),Integer.toString(c.getProduit_quantite()),c.getDelaiproductionRestant().toString()});
//				}
//				table_4.setModel(model);
				
				Commande com=new Commande();
				ArrayList<Commande> ListeCommandes=com.GetListeDelaiproductionRestant();
				List<String[]> content = new ArrayList<>();

				for(int i=0;i<ListeCommandes.size();i++){
						
					 content.add(new String[] {ListeCommandes.get(i).getClient_Name()});
				 
					ArrayList<Commande> ListeCommandesBy=com.GetListeDelaiproductionRestantByNamClient(ListeCommandes.get(i).getClient_Name());
					for(int j=0;j<ListeCommandesBy.size();j++)
						{
					content.add(new String[] { ListeCommandesBy.get(j).getNom_Produit(),Integer.toString(ListeCommandesBy.get(j).getProduit_quantite()),ListeCommandesBy.get(j).getDelaiproductionRestant().toString()});
					
						}
				
					
					}
				
				
				TreeTable treeTable = new TreeTable(content);
				scrollPane_4.setViewportView(treeTable.getTreeTableDelaiproductionRestant());
				
			}
		});
		tabbedPane.addTab("Délai de production restant", null,panel_7,null);
		panel_7.setLayout(null);
		
		
		scrollPane_4.setBounds(50, 90, 883, 448);
		panel_7.add(scrollPane_4);
		
		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);
		
		JLabel label_1 = new JLabel("Recherche d'un client par nom :");
		label_1.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		label_1.setBounds(50, 58, 256, 20);
		panel_7.add(label_1);
		
		textFieldClientNamSerchDelaiPaiement = new JTextField();
		textFieldClientNamSerchDelaiPaiement.getDocument().addDocumentListener (new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				MyFunction();
			}
			
			public void MyFunction(){
				Commande com=new Commande();
				ArrayList<Commande> ListeCommandes=com.GetListeDelaiproductionRestantSearchByNamClient(textFieldClientNamSerchDelaiPaiement.getText());
				List<String[]> content = new ArrayList<>();

				for(int i=0;i<ListeCommandes.size();i++){
						
					 content.add(new String[] {ListeCommandes.get(i).getClient_Name()});
				 
					ArrayList<Commande> ListeCommandesBy=com.GetListeDelaiproductionRestantByNamClient(ListeCommandes.get(i).getClient_Name());
					for(int j=0;j<ListeCommandesBy.size();j++)
						{
					content.add(new String[] { ListeCommandesBy.get(j).getNom_Produit(),Integer.toString(ListeCommandesBy.get(j).getProduit_quantite()),ListeCommandesBy.get(j).getDelaiproductionRestant().toString()});
					
						}
				
					
					}
				
				
				TreeTable treeTable = new TreeTable(content);
				scrollPane_4.setViewportView(treeTable.getTreeTableDelaiproductionRestant());
				
			}
		
		
		});
		textFieldClientNamSerchDelaiPaiement.setColumns(10);
		textFieldClientNamSerchDelaiPaiement.setBounds(305, 59, 192, 20);
		panel_7.add(textFieldClientNamSerchDelaiPaiement);
		
		JLabel lblLinformationDeClient = new JLabel(" L'information de Client");
		lblLinformationDeClient.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblLinformationDeClient.setBounds(79, 78, 172, 20);
		panel_6.add(lblLinformationDeClient);
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBackground(SystemColor.controlHighlight);
		desktopPane_2.setBounds(79, 102, 435, 307);
		panel_6.add(desktopPane_2);
		
		tktClient_NAME = new JTextField();
		tktClient_NAME.setColumns(10);
		tktClient_NAME.setBounds(136, 41, 171, 20);
		desktopPane_2.add(tktClient_NAME);
		
		JLabel lblNomDuClient = new JLabel("Nom du client :");
		lblNomDuClient.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblNomDuClient.setBounds(10, 45, 156, 14);
		desktopPane_2.add(lblNomDuClient);
		
		JLabel lblEmailDuClient = new JLabel("Email client :");
		lblEmailDuClient.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblEmailDuClient.setBounds(30, 76, 156, 14);
		desktopPane_2.add(lblEmailDuClient);
		
		tktClient_MAIL = new JTextField();
		tktClient_MAIL.setColumns(10);
		tktClient_MAIL.setBounds(136, 74, 171, 20);
		desktopPane_2.add(tktClient_MAIL);
		
		final JTextArea tktAdresse_client = new JTextArea();
		tktAdresse_client.setBounds(137, 142, 265, 97);
		desktopPane_2.add(tktAdresse_client);
		
		JLabel lblAdresseDuClient = new JLabel("Adresse :");
		lblAdresseDuClient.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblAdresseDuClient.setBounds(56, 146, 156, 14);
		desktopPane_2.add(lblAdresseDuClient);
		
		JLabel lblTleClient = new JLabel("T\u00E9le client :");
		lblTleClient.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblTleClient.setBounds(40, 110, 156, 14);
		desktopPane_2.add(lblTleClient);
		
		tktTele = new JTextField();
		tktTele.setColumns(10);
		tktTele.setBounds(136, 108, 171, 20);
		desktopPane_2.add(tktTele);
		
		JButton button_1 = new JButton("Ajouter nouveaux Client");
		button_1.setIcon(new ImageIcon(img));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Message="";
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				commercial com=new commercial();
				if(tktClient_NAME.getText().trim().equals("") && tktClient_MAIL.getText().trim().equals("") &&  tktAdresse_client.getText().trim().equals("")){
					
					Message +=" Vous n'avez pas rempli toutes les zones ";
				}
				else{
				Message += com.AddClient(tktClient_NAME.getText(), tktClient_MAIL.getText(), tktAdresse_client.getText(), tktTele.getText(),dateFormat.format(date),UserConnexion.getIduser());
				tktClient_NAME.setText("");
				tktClient_MAIL.setText("");
				tktAdresse_client.setText("");
				tktTele.setText("");
				}
				
				JOptionPane.showMessageDialog(new JFrame(), Message);
				}
		});
		button_1.setBounds(168, 256, 198, 33);
		desktopPane_2.add(button_1);
		button_1.setBackground(SystemColor.controlHighlight);
		
		JButton button_3 = new JButton("Rentr\u00E9e de nouvelles commandes");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);
				
			}
		});
		button_3.setBackground(SystemColor.controlHighlight);
		button_3.setBounds(26, 36, 241, 29);
		panel_6.add(button_3);
		

		
		
	}
	
	public void SetActvePanel(int i){
		tabbedPane.setSelectedIndex(i);
	}
}
