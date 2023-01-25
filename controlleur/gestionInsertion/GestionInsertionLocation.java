package controlleur.gestionInsertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import controlleur.others.Boite;
import modele.BailLocataire;
import modele.DiagnosticLogement;
import modele.EtatDesLieux;
import modele.Locataire;
import modele.Logement;
import modele.dao.DaoBailLocataire;
import modele.dao.DaoDiagnosticLogement;
import modele.dao.DaoEtatDesLieux;
import modele.dao.DaoLocataire;
import modele.dao.DaoLogement;
import vue.FenetreAccueil;
import vue.insertion.FenetreInsertionLocation;
import vue.insertion.FenetreInsertionLogement;
import vue.insertion.intern.FenetreAjoutBail;
import vue.insertion.intern.FenetreAjoutDiagnostic;
import vue.insertion.intern.FenetreAjoutEtatLieux;

@SuppressWarnings("unused")
public class GestionInsertionLocation implements ActionListener{
	private FenetreInsertionLocation fil;
	
	public GestionInsertionLocation(FenetreInsertionLocation f) {
		this.fil = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		int returnValue;
		FenetreAccueil mainPage = (FenetreAccueil) this.fil.getTopLevelAncestor();
		DefaultTableModel tableLogs = (DefaultTableModel) this.fil.getTableLogement().getModel();
		DaoLogement daoLogement = new DaoLogement();
		String id = this.fil.getComboBoxBien().getSelectedItem().toString();
		switch (button.getText()){
			case "Refresh":
				// Gestion du tableau des logements
				id = this.fil.getComboBoxBien().getSelectedItem().toString();
				int ls = 0;
				while(tableLogs.getRowCount() >= 1) {
					tableLogs.removeRow(ls);
				}
				Object[] logements = null;
				try {
					logements = daoLogement.findByIdBien(id).toArray();
					for (int i = 0; i < logements.length; i++) {
						tableLogs.addRow(new Object[] {
								null,null
						});
						this.fil.getTableLogement().setValueAt(((Logement) logements[i]).getIdLog(), i, 0);
						this.fil.getTableLogement().setValueAt(((Logement) logements[i]).getNumeroEtage(), i, 1);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case "Valider la séléction":
				try {
					Locataire locataire = new Locataire(
							this.fil.getTextFieldIdLoc().getText(),
							this.fil.getComboBoxCivilite().getSelectedItem().toString(),
							this.fil.getTextFieldNom().getText(),
							this.fil.getTextFieldPrenom().getText(),
							this.fil.getTextFieldAdresse().getText(),
							this.fil.getTextFieldCP().getText(),
							this.fil.getTextFieldVille().getText(),
							this.fil.getTextFieldNumTel().getText(),
							this.fil.getTextFieldCourriel().getText());
					Boite.addItem("Locataire", locataire);
					DaoLocataire daoLocataire = new DaoLocataire();
					daoLocataire.create(locataire);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				int numeroLigne = this.fil.getTableLogement().getSelectedRow();
				if (numeroLigne != -1) {
					String idB = this.fil.getComboBoxBien().getSelectedItem().toString();
					String idL = (String) tableLogs.getValueAt(numeroLigne, 0);
					try {
						Logement logement = daoLogement.findById(idB,idL);
						Boite.addItem("Logement", logement);
						this.fil.enableItems(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				break;
			case "Insérer":
				DaoLocataire daoLocataire = new DaoLocataire();
				DaoEtatDesLieux daoEtatDesLieux = new DaoEtatDesLieux();
				DaoDiagnosticLogement daoDiagnosticLogement = new DaoDiagnosticLogement();
				
				try {
					daoEtatDesLieux.create((EtatDesLieux) Boite.getItem("Etat des lieux"));
					daoDiagnosticLogement.create((DiagnosticLogement) Boite.getItem("Diagnostic"));
					Boite.clearChest();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case "Annuler":
				Boite.clearChest();
				this.fil.dispose();
				break;
			case "Ajouter un bail":
				FenetreAjoutBail fenAjBail = new FenetreAjoutBail();
				mainPage.getLayeredPane().add(fenAjBail);
				fenAjBail.setVisible(true);
				fenAjBail.moveToFront();
				break;
			case "Ajouter un diagnostic":
				FenetreAjoutDiagnostic fenAjDiag = new FenetreAjoutDiagnostic();
				mainPage.getLayeredPane().add(fenAjDiag);
				fenAjDiag.setVisible(true);
				fenAjDiag.moveToFront();
				break;
			case "Ajouter l'etat des lieux":
				FenetreAjoutEtatLieux fenAjEtat = new FenetreAjoutEtatLieux();
				mainPage.getLayeredPane().add(fenAjEtat);
				fenAjEtat.setVisible(true);
				fenAjEtat.moveToFront();
				break;
			case "l":
				// A implementer recherche logement
				break;
			case "o":
				// A implementer recherche locataire
				break;
			default:
				break;
		}
		
	}

}
