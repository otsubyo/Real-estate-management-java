package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import vue.*;

public class GestionFenetreAccueilButton implements ActionListener{
	private FenetreAccueil fenetreAccueil;
	
	
	public GestionFenetreAccueilButton(FenetreAccueil ac) {
		this.fenetreAccueil = ac;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonConnexion = (JButton) e.getSource();
		switch (buttonConnexion.getText()) {
		case "Se connecter":
			FenetreConnexion fenetreConnexion = new FenetreConnexion();
			this.fenetreAccueil.getLayeredPane().add(fenetreConnexion);
			fenetreConnexion.setBounds(450, 200, 404, 300);
			fenetreConnexion.setVisible(true);
			break;
		default:
			break;
		}
	}

}
