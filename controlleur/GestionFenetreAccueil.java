package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JMenuItem;

import vue.*;

public class GestionFenetreAccueil implements ActionListener {
	private FenetreAccueil fenetreAccueil;
	
	
	public GestionFenetreAccueil(FenetreAccueil ac) {
		this.fenetreAccueil = ac;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem sMenu = (JMenuItem) e.getSource();
		switch (sMenu.getText()) {
		case "Extraire les données":
			break;
		case "Quitter l'application":
			this.fenetreAccueil.dispose();
			break;
		case "Se Connecter":
			FenetreConnexion fenetreConnexion = new FenetreConnexion();
			this.fenetreAccueil.getLayeredPane().add(fenetreConnexion);
			fenetreConnexion.setBounds(450, 200, 404, 300);
			fenetreConnexion.setVisible(true);
			break;
		case "Se Deconnecter":
			this.fenetreAccueil.disableItems();
			this.fenetreAccueil.getLblTooltip().setText("Pour commencer, connectez-vous !");
			this.fenetreAccueil.getBtnConnecter().setVisible(true);
			try {
				CictOracleDataSource.deconnecter();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "Mes biens":
			FenetreBiens fenetreBien = new FenetreBiens();
			this.fenetreAccueil.getLayeredPane().add(fenetreBien);
			fenetreBien.setBounds(300, 100, 700, 600);
			fenetreBien.setVisible(true);
			break;
		case "Mes Locations":
			FenetreLocations fenetreLocations = new FenetreLocations();
			this.fenetreAccueil.getLayeredPane().add(fenetreLocations);
			fenetreLocations.setBounds(300, 100, 700, 470);
			fenetreLocations.setVisible(true);
			break;
		case "Mes Assurances":
			FenetreAssurance fenetreAssurance = new FenetreAssurance();
			this.fenetreAccueil.getLayeredPane().add(fenetreAssurance);
			fenetreAssurance.setBounds(300, 100, 922, 301);
			fenetreAssurance.setVisible(true);
			break;
		case "Travaux":
			FenetreTravaux fenetreTravaux = new FenetreTravaux();
			this.fenetreAccueil.getLayeredPane().add(fenetreTravaux);
			fenetreTravaux.setBounds(300, 100, 922, 301);
			fenetreTravaux.setVisible(true);
			break;
		case "Total Immeuble":
			FenetreChargesBien fenetreChargesBien = new FenetreChargesBien();
			this.fenetreAccueil.getLayeredPane().add(fenetreChargesBien);
			fenetreChargesBien.setBounds(300, 100, 589, 503);
			fenetreChargesBien.setVisible(true);
			break;
		case "Charges locataires":
			FenetreChargesLocation fenetreChargesLocation = new FenetreChargesLocation();
			this.fenetreAccueil.getLayeredPane().add(fenetreChargesLocation);
			fenetreChargesLocation.setBounds(300, 100, 904, 342);
			fenetreChargesLocation.setVisible(true);
			break;
		case "Régulariser les charges":
			break;
		case "Revenus foncier":
			break;
		case "Solde de tout compte":
			FenetreSoldeToutCompte fenetreSoldeToutCompte = new FenetreSoldeToutCompte();
			this.fenetreAccueil.getLayeredPane().add(fenetreSoldeToutCompte);
			fenetreSoldeToutCompte.setBounds(300, 100, 542, 399);
			fenetreSoldeToutCompte.setVisible(true);
			break;
		case "Vos informations":
			FenetreInfos fenetreInfos = new FenetreInfos();
			this.fenetreAccueil.getLayeredPane().add(fenetreInfos);
			fenetreInfos.setBounds(300, 100, 524, 404);
			fenetreInfos.setVisible(true);
			break;
		default:
			break;
		}
	}

}
