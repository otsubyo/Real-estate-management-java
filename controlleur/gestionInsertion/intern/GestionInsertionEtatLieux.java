package controlleur.gestionInsertion.intern;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import controlleur.others.Boite;
import modele.EtatDesLieux;
import modele.Locataire;
import modele.Logement;
import vue.insertion.FenetreInsertionLocation;
import vue.insertion.intern.FenetreAjoutEtatLieux;

public class GestionInsertionEtatLieux implements ActionListener {
	private FenetreAjoutEtatLieux fenEtatLieux;
	private EtatDesLieux etatDesLieux;
	private File fichierEt;
	private String cheminEt;
	private JFileChooser openEt;
	
	public GestionInsertionEtatLieux(FenetreAjoutEtatLieux f) {
		this.fenEtatLieux = f;
		this.openEt = new JFileChooser();
		this.openEt.setCurrentDirectory(new File("c:\\temp"));
		this.openEt.setFileFilter(new FileNameExtensionFilter(null,"pdf","docx"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getText()) {
			case "Ajouter":
				try {
					etatDesLieux = new EtatDesLieux(
											((Logement) Boite.getItem("Logement")).getIdbien(), 
											((Logement) Boite.getItem("Logement")).getIdLog(), 
											((Locataire) Boite.getItem("Locataire")).getIdloc(), 
											this.fenEtatLieux.getTextFieldIDAnalyse().getText(), 
											this.fenEtatLieux.getTextFieldIDElem().getText(), 
											this.fenEtatLieux.getTextFieldEtatGen().getText(), 
											this.fenEtatLieux.getTextPaneObservations().getText(),
											cheminEt);
					Boite.addItem("Etat des lieux", etatDesLieux);
					
					// DEBUG
					System.out.println(etatDesLieux.toString());
					FenetreInsertionLocation.getBtnAjouterEtatLieux().setBackground(new Color(0, 128, 0));
					FenetreInsertionLocation.getBtnAjouterEtatLieux().setForeground(Color.WHITE);
					
					// Activation du btn insérer
					if (Boite.onChest("Logement") && Boite.onChest("Locataire") && Boite.onChest("Diagnostic") && 
						Boite.onChest("Bail") && Boite.onChest("Etat des lieux")) {
						FenetreInsertionLocation.enableBtnInsert(true);
					}
					
					this.fenEtatLieux.dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				break;
			case "Lier un fichier":
				int returnValue = this.openEt.showOpenDialog(this.fenEtatLieux);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					this.fichierEt = this.openEt.getSelectedFile();
					this.cheminEt = this.fichierEt.getPath();
				}
				break;
			case "Annuler":
				this.fenEtatLieux.dispose();
				break;
			default:
				break;
		}
		
		
		
	}
	

}
