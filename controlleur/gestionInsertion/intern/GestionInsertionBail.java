package controlleur.gestionInsertion.intern;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import controlleur.GestionFenetreLocations;
import controlleur.others.Boite;
import modele.BailLocataire;
import modele.Locataire;
import modele.dao.DaoBailLocataire;
import vue.insertion.FenetreInsertionLocation;
import vue.insertion.intern.FenetreAjoutBail;

@SuppressWarnings("unused")
public class GestionInsertionBail implements ActionListener{
	private FenetreAjoutBail fib;
	private DaoBailLocataire bail;
	private File fichierBail;
	private String cheminBail;
	private JFileChooser openBail;
	
	public GestionInsertionBail(FenetreAjoutBail f) {
		this.fib = f;
		this.bail = new DaoBailLocataire();
		this.openBail = new JFileChooser();
		this.openBail.setCurrentDirectory(new File("c:\\temp"));
		this.openBail.setFileFilter(new FileNameExtensionFilter(null,"pdf","docx"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getText()) {
			case "Ajouter un fichier":
				int returnValue = this.openBail.showOpenDialog(this.fib);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					this.fichierBail = this.openBail.getSelectedFile();
					this.cheminBail = this.fichierBail.getPath();
				}
				break;
			case "Ajouter":
				try {
					BailLocataire bail = new BailLocataire(
						this.fib.getTextFieldDateSignature().getText(),
						this.fib.getTextFieldIDLocation().getText(),
						this.fib.getTextFieldDateDebut().getText(),
						this.fib.getTextFieldDateFin().getText(),
						Float.parseFloat(this.fib.getTextFieldMontantC().getText()),
						this.cheminBail
					);
					Boite.addItem("Bail", bail);
					
					// DEBUG
					System.out.println(((BailLocataire) Boite.getItem("Bail")).toString());
					
					FenetreInsertionLocation.getBtnBail().setBackground(new Color(0, 128, 0));
					FenetreInsertionLocation.getBtnBail().setForeground(Color.WHITE);

					// Activation du btn insérer
					if (Boite.onChest("Logement") && Boite.onChest("Locataire") && Boite.onChest("Diagnostic") && 
						Boite.onChest("Bail") && Boite.onChest("Etat des lieux")) {
						FenetreInsertionLocation.enableBtnInsert(true);
					}
					
					this.fib.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break;
			case "Annuler":
				this.fib.dispose();
				break;
			default:
				break;
		}
		
	}

}
