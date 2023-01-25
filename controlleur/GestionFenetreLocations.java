package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controlleur.gestiontables.TableEditor;
import modele.ViewLocations;
import modele.dao.DaoViewLocation;
import modele.dao.Iterateur;
import vue.FenetreAccueil;
import vue.FenetreLocations;
import vue.insertion.FenetreInsertionLocation;

public class GestionFenetreLocations implements ActionListener, TableEditor<ViewLocations>{
	private FenetreLocations fenetreLocations;
	private Iterateur<ViewLocations> iterateur;
	private DaoViewLocation daoViewLocation;
	private DefaultTableModel tableModel;
	
	public GestionFenetreLocations(FenetreLocations f) {
		this.fenetreLocations = f;
		this.daoViewLocation = new DaoViewLocation();
		this.tableModel = (DefaultTableModel) this.fenetreLocations.getTable().getModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getText()){
			case "Charger":
				try {
					this.iterateur = this.daoViewLocation.findAllIterateur();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				int i = 0;
				while (this.iterateur.hasNext()) {
					this.tableModel.addRow(new Object[] {
							null,null,null,null,null,null,null
					});
					this.ecrireLigneTable(this.iterateur.next(), i);
					i++;
				}
				button.setEnabled(false);
				break;
			case "Insérer":
				FenetreAccueil fenetreAccueil = (FenetreAccueil) fenetreLocations.getTopLevelAncestor();
				FenetreInsertionLocation fInsertionLocation = new FenetreInsertionLocation();
				fenetreAccueil.getLayeredPane().add(fInsertionLocation);
				fInsertionLocation.setBounds(260, 70, 835, 550);
				fInsertionLocation.setVisible(true);
				fInsertionLocation.moveToFront();
				break;
			case "Mise à jour":
				// A implementer
				break;
			case "Supprimer":
				// A implementer
				break;
			case "Annuler":
				this.fenetreLocations.dispose();
				break;
			case "Rechercher":
				// A implementer
				break;
			default:
				break;
		}
	}

	@Override
	public ViewLocations lireLigneTable(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ecrireLigneTable(ViewLocations data, int numeroLigne) {
		this.fenetreLocations.getTable().setValueAt(data.getLocataire(), numeroLigne, 0);
		this.fenetreLocations.getTable().setValueAt(data.getIdbien(), numeroLigne, 1);
		this.fenetreLocations.getTable().setValueAt(data.getIdlog(), numeroLigne, 2);
		this.fenetreLocations.getTable().setValueAt(data.getDateDebut(), numeroLigne, 3);
		this.fenetreLocations.getTable().setValueAt(data.getProvision(), numeroLigne, 4);
		this.fenetreLocations.getTable().setValueAt(data.getDateFin(), numeroLigne, 5);
		
	}

}
