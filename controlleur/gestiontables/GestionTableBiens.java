package controlleur.gestiontables;

import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modele.Assurer;
import modele.Garage;
import modele.Logement;
import modele.dao.DaoAssurer;
import modele.dao.DaoGarage;
//import modele.dao.DaoBien;
import modele.dao.DaoLogement;
import vue.FenetreBiens;

public class GestionTableBiens implements ListSelectionListener{
	private FenetreBiens fenetre;
	private DaoLogement daoLogement;
	private DaoAssurer daoAssurer;
	private String[] primaryKeys;
	
	public GestionTableBiens(FenetreBiens f) {
		this.fenetre = f;
		this.daoAssurer = new DaoAssurer();
		this.daoLogement = new DaoLogement();
		this.primaryKeys = new String[4];
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JTable tablebiens = fenetre.getTable();
		int numeroLigne = tablebiens.getSelectedRow();
		DefaultTableModel tableLogs = (DefaultTableModel) this.fenetre.getTableLogements().getModel();
		DefaultTableModel tableAssurances = (DefaultTableModel) this.fenetre.getTableAssurer().getModel();
		if (numeroLigne != -1) {
			int ls = 0;
			while(tableLogs.getRowCount() >= 1) {
				tableLogs.removeRow(ls);
			}
			
			ls = 0;
			while(tableAssurances.getRowCount() >= 1) {
				tableAssurances.removeRow(ls);
			}
			this.primaryKeys[0] = (String) tablebiens.getValueAt(numeroLigne, 0);
			
			// Logements | Bien
			Object[] logementsGarages = null;
			try {
				if (((String) this.fenetre.getComboBoxLogGar().getSelectedItem()) == "Garages") {
					DaoGarage daoGarage = new DaoGarage();
					logementsGarages = daoGarage.findByIdBien(primaryKeys).toArray();
				} else {
					logementsGarages = daoLogement.findByIdBien(primaryKeys).toArray();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			// Assurer
			Object[] assurer = null;
			try {
				assurer = daoAssurer.findByIdBien(primaryKeys).toArray();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			// Affichage des données sur la JTable logements
			for (int i = 0; i < logementsGarages.length; i++) {
				tableLogs.addRow(new Object[] {
						null,null,null
				});
				if ("Garages".equals((this.fenetre.getComboBoxLogGar().getSelectedItem()))) {
					this.fenetre.getTableLogements().setValueAt(((Garage) logementsGarages[i]).getIdGarage(), i, 0);
					this.fenetre.getTableLogements().setValueAt(((Garage) logementsGarages[i]).getSurface(), i, 1);
				} else {
					this.fenetre.getTableLogements().setValueAt(((Logement) logementsGarages[i]).getIdLog(), i, 0);
					this.fenetre.getTableLogements().setValueAt(((Logement) logementsGarages[i]).getSurface(), i, 1);
					this.fenetre.getTableLogements().setValueAt(((Logement) logementsGarages[i]).getNumeroEtage(), i, 2);
				}
			}
			
			// Affichage des données sur la JTable assurances
			for (int i = 0; i < assurer.length; i++) {
				tableAssurances.addRow(new Object[] {
						null,null,null,null,null,null, null
				});
				this.fenetre.getTableAssurer().setValueAt(((Assurer) assurer[i]).getNumeroPolice(), i, 0);
				this.fenetre.getTableAssurer().setValueAt(((Assurer) assurer[i]).getIdAssurance(), i, 1);
				this.fenetre.getTableAssurer().setValueAt(((Assurer) assurer[i]).getProtectionjuridique(), i, 2);
				this.fenetre.getTableAssurer().setValueAt(((Assurer) assurer[i]).getPrime(), i, 3);
				this.fenetre.getTableAssurer().setValueAt(((Assurer) assurer[i]).getQuotite(), i, 4);
				this.fenetre.getTableAssurer().setValueAt(((Assurer) assurer[i]).getDateDebut(), i, 5);
				this.fenetre.getTableAssurer().setValueAt(((Assurer) assurer[i]).getDateFin(), i, 6);
			}
		}
	}
}
