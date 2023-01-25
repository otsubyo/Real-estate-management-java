package controlleur.gestionInsertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controlleur.others.Boite;
import modele.Bien;
import modele.CompteurGeneral;
import modele.CompteurLogement;
import modele.Logement;
import modele.dao.DaoBien;
import modele.dao.DaoCompteurGeneral;
import modele.dao.DaoCompteurLogement;
import modele.dao.DaoLogement;
import vue.insertion.FenetreInsertionBien;

public class GestionInsertionBien implements ActionListener{
	private FenetreInsertionBien fib;
	private DaoBien daoBien;
	
	public GestionInsertionBien(FenetreInsertionBien f) {
		this.fib = f;
		this.daoBien = new DaoBien();
		Boite.initializeChest();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getText()) {
		case "Ajouter":
			try {
				Bien bien = new Bien(
						fib.getTextFieldIDBIEN().getText(),
						this.fib.getTextFieldAdresse().getText(), 
						this.fib.getTextFieldCP().getText(), 
						this.fib.getTextFieldVille().getText(), 
						this.fib.getTextFieldDesc().getText(), 
						Integer.parseInt(this.fib.getTextFieldNbLogMax().getText())
				);
				this.daoBien.create(bien);
				Boite.deleteItem("Bien");
				Boite.addItem("Bien", bien);
				this.fib.setStatItemsLogement(true);
				this.fib.setStatItemsCompteurgeneral(true);
				this.fib.getChckbxCompteurLogement().setEnabled(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "Insérer dans le nouveau bien":
			DaoLogement daoLogement = new DaoLogement();
			try {
				Logement logement = new Logement(
						((Bien) Boite.getItem("Bien")).getIdbien(),
						this.fib.getTextFieldIDLOG().getText(), 
						Float.parseFloat(this.fib.getTextFieldSurface().getText()),
						Integer.parseInt(this.fib.getTextFieldEtage().getText()),
						Float.parseFloat(this.fib.getTextFieldPrixM2().getText()), 
						Integer.parseInt(this.fib.getTextFieldNbPieces().getText()),
						(String) this.fib.getComboBoxTypeLog().getSelectedItem()
				);
				daoLogement.create(logement);
				Boite.deleteItem("Logement");
				Boite.addItem("Logement", logement);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "Ajouter au bien":
			DaoCompteurGeneral daoCompteurGeneral = new DaoCompteurGeneral();
			CompteurGeneral compteurGeneral = null;
			try {
				compteurGeneral = new CompteurGeneral(
						this.fib.getTextFieldMatriculeCB().getText(),
						((Bien) Boite.getItem("Bien")).getIdbien(),
						this.fib.getTextFieldAncienIndiceCB().getText(), 
						this.fib.getTextFieldAncienIndiceCB().getText(), 
						(String) this.fib.getComboBoxCG().getSelectedItem()
				);
				daoCompteurGeneral.create(compteurGeneral);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "Ajouter au logement":
			DaoCompteurLogement daoCompteurLogement = new DaoCompteurLogement();
			try {
				CompteurLogement compteurLogement = new CompteurLogement(
						this.fib.getTextFieldMatriculeCL().getText(),
						((Bien) Boite.getItem("Bien")).getIdbien(),
						((Logement) Boite.getItem("Logement")).getIdLog(),
						this.fib.getTextFieldAncienIndiceCL().getText(), 
						this.fib.getTextFieldNouvelIndiceCL().getText(), 
						(String) this.fib.getComboBoxCL().getSelectedItem()
				);
				daoCompteurLogement.create(compteurLogement);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "Quitter":
			Boite.clearChest();
			this.fib.dispose();
		default:
			break;
		}
		
	}

}
