package ff.erppres.commercial;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;

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
import java.util.Date;

import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JSpinner;
import com.toedter.calendar.JCalendar;

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
	
		
	
		
		
		
		JPanel panel = new JPanel();
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
		button.setBounds(28, 52, 172, 29);
		panel.add(button);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(SystemColor.controlHighlight);
		desktopPane_1.setBounds(460, 145, 489, 357);
		panel.add(desktopPane_1);
		
		JLabel lblCatgoriesProduit = new JLabel("Cat\u00E9gories produit :");
		lblCatgoriesProduit.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblCatgoriesProduit.setBounds(10, 40, 156, 20);
		desktopPane_1.add(lblCatgoriesProduit);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(172, 40, 221, 20);
		desktopPane_1.add(comboBox);
		
		JLabel lblProduitsRequis = new JLabel("Produits requis :");
		lblProduitsRequis.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblProduitsRequis.setBounds(36, 76, 156, 20);
		desktopPane_1.add(lblProduitsRequis);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(172, 77, 221, 20);
		desktopPane_1.add(comboBox_1);
		
		JLabel lblQuantitProduit = new JLabel("Quantit\u00E9 produit :");
		lblQuantitProduit.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblQuantitProduit.setBounds(24, 115, 156, 20);
		desktopPane_1.add(lblQuantitProduit);
		JSpinner spinner = new JSpinner(model);
		spinner.setBounds(172, 116, 94, 20);
		desktopPane_1.add(spinner);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(40, 180, 198, 153);
		desktopPane_1.add(calendar);
		
		JLabel lblDateDbut = new JLabel("Date d\u00E9but ");
		lblDateDbut.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblDateDbut.setBounds(40, 158, 156, 20);
		desktopPane_1.add(lblDateDbut);
		
		JCalendar calendar_1 = new JCalendar();
		calendar_1.setBounds(261, 180, 198, 153);
		desktopPane_1.add(calendar_1);
		
		JLabel lblDateFin = new JLabel("Date fin");
		lblDateFin.setFont(new Font("Gotham Light", Font.PLAIN, 16));
		lblDateFin.setBounds(260, 158, 156, 20);
		desktopPane_1.add(lblDateFin);
		
		JLabel label_2 = new JLabel(" l'information de Client");
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_2.setBounds(28, 119, 172, 20);
		panel.add(label_2);
		
		JLabel lblLinformationCommande = new JLabel(" l'information Commande");
		lblLinformationCommande.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblLinformationCommande.setBounds(462, 119, 232, 20);
		panel.add(lblLinformationCommande);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.controlHighlight);
		desktopPane.setBounds(15, 143, 435, 359);
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
		tktAdressView.setBounds(137, 142, 265, 97);
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
		
		
		
		final JComboBox comboBoxNamClientView = new JComboBox();
		
		
		commercial com=new commercial();
		ArrayList<Client> clientList=com.GetAllNmeClient();
		for(Client c:clientList){
			comboBoxNamClientView.addItem(c.getClient_NAME());
		}
		comboBoxNamClientView.setBounds(136, 40, 221, 20);
		
	 
		desktopPane.add(comboBoxNamClientView);
		
		JButton btnAjouterNouvelleCommande = new JButton("Ajouter nouvelle Commande");
		btnAjouterNouvelleCommande.setBounds(353, 519, 198, 33);
		panel.add(btnAjouterNouvelleCommande);
		btnAjouterNouvelleCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAjouterNouvelleCommande.setBackground(SystemColor.controlHighlight);
		
		comboBoxNamClientView.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				commercial comm=new commercial();
				ArrayList<Client> clientList=comm.GetClient(comboBoxNamClientView.getSelectedItem().toString());
				for(Client c:clientList){
					TxtEmailCleintview.setText(c.getClient_MAIL());
					txtTeleClientView.setText(c.getTele());
					tktAdressView.setText(c.getAdresse_client());
					 
				}
			}
		});
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Des Commandes ( En attentes )", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		JPanel panel_2 = new JPanel(); 
		tabbedPane.addTab("Des Commandes ( En cours )", null, panel_2, null);
		
		
		JPanel panel_3 = new JPanel(); 
		tabbedPane.addTab("Des Commandes ( Termin\u00E9s  )", null, panel_3, null);
		
		
		JPanel panel_4 = new JPanel(); 
		tabbedPane.addTab("Des Commandes  ( Valider )", null, panel_4, null);
		
		
		JPanel panel_5 = new JPanel(); 
		tabbedPane.addTab("D\u00E9lai de payements divers", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Ajouter nouveaux Client", null, panel_6, null);
		panel_6.setLayout(null);
		
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
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Message;
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				commercial com=new commercial();
				Message =com.AddClient(tktClient_NAME.getText(), tktClient_MAIL.getText(), tktAdresse_client.getText(), tktTele.getText(),dateFormat.format(date),UserConnexion.getIdprofil());
				tktClient_NAME.setText("");
				tktClient_MAIL.setText("");
				tktAdresse_client.setText("");
				tktTele.setText("");
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
		button_3.setBounds(26, 36, 188, 29);
		panel_6.add(button_3);
		

		
		
	}
	
	public void SetActvePanel(int i){
		tabbedPane.setSelectedIndex(i);
	}
}
