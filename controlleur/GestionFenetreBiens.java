package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controlleur.gestiontables.TableEditor;
import modele.Bien;
import modele.dao.DaoBien;
import modele.dao.Iterateur;
import vue.FenetreAccueil;
import vue.FenetreBiens;
import vue.insertion.FenetreInsertionBien;

public class GestionFenetreBiens implements ActionListener, TableEditor<Bien>{
	private FenetreBiens fenetreBiens;
	private DaoBien daoBien;
	private Iterateur<Bien> iterateurBien;
	private DefaultTableModel modeletable;
	
	public GestionFenetreBiens(FenetreBiens f) {
		this.fenetreBiens = f;
		this.daoBien = new DaoBien();
		this.modeletable = (DefaultTableModel) this.fenetreBiens.getTable().getModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		FenetreAccueil fa = (FenetreAccueil) this.fenetreBiens.getTopLevelAncestor();
		switch (button.getText()){
			case "Charger":
				try {
					this.iterateurBien = this.daoBien.findAllIterateur();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				int i = 0;
				while (this.iterateurBien.hasNext()) {
					this.modeletable.addRow(new Object[] {
							null,null,null,null,null,null,null
					});
					this.ecrireLigneTable(this.iterateurBien.next(), i);
					i++;
				}
				button.setEnabled(false);
				break;
			case "Insérer":
				FenetreInsertionBien f = new FenetreInsertionBien();
				fa.getLayeredPane().add(f);
				f.setVisible(true);
				f.moveToFront();
				break;
			case "Mise à jour":
				// A implementer
				break;
			case "Supprimer":
				break;
			case "Annuler":
				this.fenetreBiens.dispose();
				break;
			case "Recherche":
				// A implementer
				break;
			default:
				break;
		}
	}

	@Override
	public Bien lireLigneTable(int index) {
		Bien bien = null;
		try {
			bien = new Bien(
					(String) this.modeletable.getValueAt(index, 0),
					(String) this.modeletable.getValueAt(index, 1),
					(String) this.modeletable.getValueAt(index, 2),
					(String) this.modeletable.getValueAt(index, 3),
					(String) this.modeletable.getValueAt(index, 4),
					(int) this.modeletable.getValueAt(index, 5)
			);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bien;
	}

	@Override
	public void ecrireLigneTable(Bien data, int numeroLigne) {
		this.fenetreBiens.getTable().setValueAt(data.getIdbien(), numeroLigne, 0);
		this.fenetreBiens.getTable().setValueAt(data.getAdresse(), numeroLigne, 1);
		this.fenetreBiens.getTable().setValueAt(data.getCodepostal(), numeroLigne, 2);
		this.fenetreBiens.getTable().setValueAt(data.getVille(), numeroLigne, 3);
		this.fenetreBiens.getTable().setValueAt(data.getDescription(), numeroLigne, 4);
		this.fenetreBiens.getTable().setValueAt(data.getNbLogementmax(), numeroLigne, 5);
		
	}
	
	
}
