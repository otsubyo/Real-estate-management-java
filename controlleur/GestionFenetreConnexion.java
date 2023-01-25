package controlleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import vue.FenetreAccueil;
import vue.FenetreConnexion;

@SuppressWarnings("unused")
public class GestionFenetreConnexion implements ActionListener{
	private static FenetreConnexion fenetreConnexion;
	private static Timer t; 
	private static int val = 0;
	
	public GestionFenetreConnexion(FenetreConnexion fc) {
		fenetreConnexion = fc;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getText()) {
			case "Connexion":
				FenetreAccueil fenetreAccueil = (FenetreAccueil) fenetreConnexion.getTopLevelAncestor();
				
				try {
					CictOracleDataSource.creerAcces(GestionFenetreConnexion.fenetreConnexion.getLoginField().getText(), 
													GestionFenetreConnexion.fenetreConnexion.getPasswordField().getText());
					chargement();
					fenetreAccueil.enableItems();
					fenetreAccueil.getLblTooltip().setText("Utiliser le menu du dessus pour naviguer");
					fenetreAccueil.getBtnConnecter().setVisible(false);
					fenetreConnexion.getProgressBar().setVisible(true);
					fenetreConnexion.getLblConnexion().setVisible(true);
				} catch (SQLException exceptionConnexion) {
					JOptionPane.showMessageDialog(GestionFenetreConnexion.fenetreConnexion, 
												"Login ou mot de passe incorrect !",
												"Connexion Impossible",
												JOptionPane.ERROR_MESSAGE);
					GestionFenetreConnexion.fenetreConnexion.getLoginField().setText("");
					GestionFenetreConnexion.fenetreConnexion.getPasswordField().setText("");
				}
				break;
			case "Quitter":
				fenetreConnexion.dispose();
				break;
			default:
				break;
		}
	}
	
    public static void chargement() {
        t = null;
        // Augmenter la vitesse de chargement (en réduisant la valeur)
        t = new Timer(25,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	val++;
            	fenetreConnexion.getProgressBar().setValue(val);
            	switch (val) {
					case 20:
						fenetreConnexion.getLblConnexion().setText("Liaison ORM...");
						break;
					case 30:
						fenetreConnexion.getLblConnexion().setText("Vérification...");
						break;
					case 40:
	            		fenetreConnexion.getLblConnexion().setText("Chargement des données...");
						break;
					case 60:
						fenetreConnexion.getLblConnexion().setText("Activation des menus...");
						break;
					case 80:
						fenetreConnexion.getLblConnexion().setText("Préparation...");
						break;
					case 90:
						fenetreConnexion.getLblConnexion().setText("Terminée !");
	            		fenetreConnexion.getLblConnexion().setForeground(new Color(0, 128, 64));
						break;
					case 100:
						t.stop();
	            		val = 0;
	            		fenetreConnexion.dispose();
	            		break;
					default:
						break;
				}
            }
        });

        java.util.Timer tt = new java.util.Timer(false);
        tt.schedule(new TimerTask() {
            @Override
            public void run() {
                t.start();
            }
        }, 0);
    }
}
