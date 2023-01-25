package controlleur.gestionInsertion.intern;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import controlleur.others.Boite;
import modele.DiagnosticLogement;
import modele.Logement;
import vue.insertion.FenetreInsertionLocation;
import vue.insertion.intern.FenetreAjoutDiagnostic;

public class GestionInsertionDiagnostic implements ActionListener{
	private FenetreAjoutDiagnostic fenetreAjoutDiagnostic;
	private DiagnosticLogement diagnosticLogement;
	private File fichierDiag;
	private String cheminDiag;
	private JFileChooser openDiag;
	
	public GestionInsertionDiagnostic(FenetreAjoutDiagnostic f) {
		this.fenetreAjoutDiagnostic = f;
		this.openDiag = new JFileChooser();
		this.openDiag.setCurrentDirectory(new File("c:\\temp"));
		this.openDiag.setFileFilter(new FileNameExtensionFilter(null,"pdf","docx"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getText()) {
			case "Lier un fichier":
				int returnValue = this.openDiag.showOpenDialog(this.fenetreAjoutDiagnostic);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					this.fichierDiag = this.openDiag.getSelectedFile();
					this.cheminDiag = this.fichierDiag.getPath();
				}
				break;
			case "Ajouter":
				try {
					diagnosticLogement = new DiagnosticLogement(((Logement) Boite.getItem("Logement")).getIdbien().toUpperCase(),
																((Logement) Boite.getItem("Logement")).getIdLog().toUpperCase(),
																this.fenetreAjoutDiagnostic.getTextFieldIDDateRe().getText(), 
																this.fenetreAjoutDiagnostic.getComboBox().getSelectedItem().toString(),
																this.cheminDiag);
					Boite.addItem("Diagnostic", diagnosticLogement);
					FenetreInsertionLocation.getBtnAjouterUnDiagnostic().setBackground(new Color(0, 128, 0));
					FenetreInsertionLocation.getBtnAjouterUnDiagnostic().setForeground(Color.WHITE);

					// Activation du btn insérer
					if (Boite.onChest("Logement") && Boite.onChest("Locataire") && Boite.onChest("Diagnostic") && 
						Boite.onChest("Bail") && Boite.onChest("Etat des lieux")) {
						FenetreInsertionLocation.enableBtnInsert(true);
					}
					
					// DEBUG
					System.out.println(diagnosticLogement.toString());
					this.fenetreAjoutDiagnostic.dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				break;
			case "Annuler":
				this.fenetreAjoutDiagnostic.dispose();
				break;
			default:
				break;
		}
		
	}
	
}
