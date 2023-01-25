package controlleur.gestionInsertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controlleur.others.Boite;
import modele.Logement;
import modele.dao.DaoLogement;
import vue.insertion.FenetreInsertionLogement;

@SuppressWarnings("unused")
public class GestionInsertionLogement implements ActionListener{
	
	private FenetreInsertionLogement fenetre;
	private DaoLogement daoLogement;
	private Logement logement;
	
	public GestionInsertionLogement(FenetreInsertionLogement f) {
		this.fenetre = f;
		this.logement = null;
		this.daoLogement = new DaoLogement();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getText()) {
			case "Ajouter":
				Logement log = null;
			try {
				log = new Logement(
						this.fenetre.getTextFieldIdBien().getText(), 
						this.fenetre.getTextFieldIdLog().getText(),
						Float.parseFloat(this.fenetre.getTextFieldSurface().getText()),
						Integer.parseInt(this.fenetre.getTextFieldNumEtage().getText()), 
						Float.parseFloat(this.fenetre.getTextFieldPrixM2().getText()),
						Integer.parseInt(this.fenetre.getTextFieldNbPiece().getText()),
						this.fenetre.getComboBoxTypeLog().getSelectedItem().toString()
				);
				daoLogement.create(log);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			case "Annuler":
				this.fenetre.dispose();
				break;
			default:
				break;
		}
		
	}
	
}
