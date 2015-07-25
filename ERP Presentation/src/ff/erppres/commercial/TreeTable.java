package ff.erppres.commercial;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.treetable.DefaultTreeTableModel;

public class TreeTable {

	private String[] headings = {"Client / Nom de produit","Quantité produit","Date de Début","Date Fin","Date Lancement" };
	private String[] headings2 = {"Client / Nom de produit","Quantité produit","Délai restant par jour"};
	private String[] headings3 ={"Client / Date Lencement","Date de paiement","Montant Paiement "};
	private Node root;
	private DefaultTreeTableModel model;
	private JXTreeTable table;
	private List<String[]> content;

	public TreeTable(List<String[]> content) {
		this.content = content;
	}

	public JXTreeTable getTreeTable() {
		root = new RootNode("Root");

		ChildNode myChild = null;
		for (String[] data : this.content) {
			ChildNode child = new ChildNode(data);
			if (data.length <= 1) {
				root.add(child);
				myChild = child;
			} else {
				myChild.add(child);
			}
		}

		model = new DefaultTreeTableModel(root, Arrays.asList(headings));
		table = new JXTreeTable(model);
		table.setShowGrid(true, true);
		table.setColumnControlVisible(true);

		table.packAll();

		return table;
	}
	
	public JXTreeTable getTreeTableDelaiproductionRestant() {
		root = new RootNode("Root");

		ChildNode myChild = null;
		for (String[] data : this.content) {
			ChildNode child = new ChildNode(data);
			if (data.length <= 1) {
				root.add(child);
				myChild = child;
			} else {
				myChild.add(child);
			}
		}

		model = new DefaultTreeTableModel(root, Arrays.asList(headings2));
		table = new JXTreeTable(model);
		table.setShowGrid(true, true);
		table.setColumnControlVisible(true);

		table.packAll();

		return table;
	}
	
	
	public JXTreeTable getTreeTableDelaiPaiementDivers(){
		
		root = new RootNode("Root");

		ChildNode myChild = null;
		for (String[] data : this.content) {
			ChildNode child = new ChildNode(data);
			if (data.length <= 1) {
				root.add(child);
				myChild = child;
			} else {
				myChild.add(child);
			}
		}

		model = new DefaultTreeTableModel(root, Arrays.asList(headings3));
		table = new JXTreeTable(model);
		table.setShowGrid(true, true);
		table.setColumnControlVisible(true);
		
		
		for(int i=0;i<table.getRowCount();i++){
			
		 
			
			for(int j=0;j<table.getColumnCount();j++){
				// table.columnAtPoint(j).setBackground(Color.BLUE);
				 
			}
		}
		
 //		TableColumn column = table.getColumnModel().getColumn(2);
 	
//	table.setBackground(Color.blue);
		
		// table.getValueAt(0, 0).equals(obj)
		 
		table.packAll();
		return table;
	}
	
	
	
	

}
