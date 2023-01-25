package vue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controlleur.GestionFenetreConnexion;

import javax.swing.JProgressBar;

public class FenetreConnexion extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTextField loginField;
	private JPasswordField passwordField;
	private GestionFenetreConnexion gestionConnexion;
	private static JProgressBar progressBar = new JProgressBar();
	private JLabel lblConnexion;

	/**
	 * Create the frame.
	 */
	public FenetreConnexion() {
		getContentPane().setForeground(new Color(0, 128, 64));
		this.gestionConnexion= new GestionFenetreConnexion(this);
		setBorder(new LineBorder(new Color(3, 102, 235), 3));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		
		JLabel welcLabel = new JLabel("Bienvenue");
		welcLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		welcLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcLabel.setBounds(119, 10, 153, 50);
		getContentPane().add(welcLabel);
		
		JLabel loginLabel = new JLabel("Login : ");
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginLabel.setBounds(38, 87, 74, 20);
		getContentPane().add(loginLabel);
		
		JLabel pwdLabel = new JLabel("Mot de passe : ");
		pwdLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdLabel.setBounds(38, 117, 115, 27);
		getContentPane().add(pwdLabel);
		
		loginField = new JTextField();
		loginField.setBounds(153, 90, 153, 19);
		getContentPane().add(loginField);
		loginField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 123, 153, 19);
		getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBackground(Color.WHITE);
		btnConnexion.addActionListener(this.gestionConnexion);
		btnConnexion.setBounds(95, 181, 98, 21);
		getContentPane().add(btnConnexion);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBackground(Color.WHITE);
		btnQuitter.setIcon(new ImageIcon(FenetreConnexion.class.getResource("/data/marque-de-croix.png")));
		btnQuitter.addActionListener(this.gestionConnexion);
		btnQuitter.setBounds(225, 181, 98, 21);
		getContentPane().add(btnQuitter);
		progressBar.setStringPainted(true);
		progressBar.setValue(0); 
		progressBar.setForeground(new Color(0, 128, 64));
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(119, 225, 146, 15);
		progressBar.setVisible(false);
		getContentPane().add(progressBar);
		
		lblConnexion = new JLabel("Connexion...");
		lblConnexion.setFont(new Font("Verdana", Font.BOLD, 10));
		lblConnexion.setForeground(new Color(189, 0, 4));
		lblConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnexion.setBounds(10, 240, 378, 20);
		lblConnexion.setVisible(false);
		getContentPane().add(lblConnexion);
		setFrameIcon(new ImageIcon(FenetreConnexion.class.getResource("/data/home-button_16px.png")));
		setTitle("Se connecter");
		setBounds(100, 100, 404, 300);
	}

	public JLabel getLblConnexion() {
		return lblConnexion;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JTextField getPasswordField() {
		return passwordField;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}
}
