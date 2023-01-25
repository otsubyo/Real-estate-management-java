package vue;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlleur.GestionFenetreAccueil;
import controlleur.GestionFenetreAccueilButton;
import controlleur.others.WindowEvents;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class FenetreAccueil extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// Autres
	private JPanel contentPane;
	private GestionFenetreAccueil gestionnaireAccueil;
	private GestionFenetreAccueilButton gestionnaireAccueilBtn;
	private WindowEvents we;
	
	// Menu Fichier
	private JMenuItem sMenuExtract;
	private JMenuItem sMenuQuitter;
	
	// Menu Connexion
	private JMenuItem sMenuSeConnecter;
	private JMenuItem sMenuSeDeconnecter;
	
	// Menu Gestion
	private JMenuItem sMenuBiens;
	private JMenuItem sMenuLocataires;
	private JMenuItem sMenuAssurances;
	private JMenuItem sMenuTravaux;
	
	// Menu Comptabilité
	private JMenuItem sMenuTotal;
	private JMenuItem sMenuLocataire;
	
	// Menu Edition
	private JMenuItem sMenuRegCharges;
	private JMenuItem sMenuSoldeCompte;
	private JLabel lblLogo;
	private JLabel lblBienvenue;
	private JLabel lblTooltip;

	private JButton btnConnecter;

	private JMenuItem sMenuInformations;

	private JMenuItem sMenuStatistique;

	private JMenuItem sMenuRevenusFoncier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAccueil frame = new FenetreAccueil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreAccueil() {
		this.we = new WindowEvents(this);
		addWindowListener(this.we);
		setResizable(false);
		setTitle("LOCAPLUS - Immobiliers");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FenetreAccueil.class.getResource("/data/home-button.png")));
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		this.gestionnaireAccueil = new GestionFenetreAccueil(this);
		this.gestionnaireAccueilBtn = new GestionFenetreAccueilButton(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFichier = new JMenu("Fichier");
		menuBar.add(menuFichier);
		
		sMenuExtract = new JMenuItem("Extraire les données");
		sMenuExtract.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/papier.png")));
		sMenuExtract.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		menuFichier.add(sMenuExtract);
		sMenuExtract.addActionListener(gestionnaireAccueil);
		
		sMenuQuitter = new JMenuItem("Quitter l'application");
		sMenuQuitter.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/marque-de-croix.png")));
		sMenuQuitter.setForeground(Color.RED);
		sMenuQuitter.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		menuFichier.add(sMenuQuitter);
		sMenuQuitter.addActionListener(gestionnaireAccueil);
		this.sMenuQuitter.setVisible(true);
		
		JMenu menuConnexion = new JMenu("Connexion");
		menuBar.add(menuConnexion);
		
		sMenuSeConnecter = new JMenuItem("Se Connecter");
		sMenuSeConnecter.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/exit.png")));
		menuConnexion.add(sMenuSeConnecter);
		sMenuSeConnecter.addActionListener(gestionnaireAccueil);
		
		sMenuSeDeconnecter = new JMenuItem("Se Deconnecter");
		sMenuSeDeconnecter.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/door.png")));
		menuConnexion.add(sMenuSeDeconnecter);
		sMenuSeDeconnecter.addActionListener(gestionnaireAccueil);
		
		JMenu menuGestion = new JMenu("Gestion");
		menuBar.add(menuGestion);
		
		sMenuBiens = new JMenuItem("Mes biens");
		sMenuBiens.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/immeuble-de-bureaux.png")));
		menuGestion.add(sMenuBiens);
		sMenuBiens.addActionListener(gestionnaireAccueil);
		
		sMenuLocataires = new JMenuItem("Mes Locations");
		sMenuLocataires.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/key-set.png")));
		menuGestion.add(sMenuLocataires);
		sMenuLocataires.addActionListener(gestionnaireAccueil);
		
		sMenuAssurances = new JMenuItem("Mes Assurances");
		sMenuAssurances.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/contrat.png")));
		menuGestion.add(sMenuAssurances);
		sMenuAssurances.addActionListener(gestionnaireAccueil);

		sMenuTravaux = new JMenuItem("Travaux");
		sMenuTravaux.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/mur-de-briques.png")));
		menuGestion.add(sMenuTravaux);
		sMenuTravaux.addActionListener(gestionnaireAccueil);
		
		JMenu sMenuComptabilite = new JMenu("Comptabilité");
		menuBar.add(sMenuComptabilite);
		
		sMenuTotal = new JMenuItem("Total Immeuble");
		sMenuTotal.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/money-management.png")));
		sMenuComptabilite.add(sMenuTotal);
		sMenuTotal.addActionListener(gestionnaireAccueil);
		
		sMenuLocataire = new JMenuItem("Charges locataires");
		sMenuLocataire.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/calculatrice.png")));
		sMenuComptabilite.add(sMenuLocataire);
		
		sMenuStatistique = new JMenuItem("Statistique");
		sMenuStatistique.setBackground(Color.WHITE);
		sMenuStatistique.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/stats.png")));
		sMenuComptabilite.add(sMenuStatistique);
		sMenuLocataire.addActionListener(gestionnaireAccueil);
		
		JMenu menuEdition = new JMenu("Edition");
		menuBar.add(menuEdition);
		
		sMenuRegCharges = new JMenuItem("Régulariser les charges");
		sMenuRegCharges.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/lister.png")));
		menuEdition.add(sMenuRegCharges);
		sMenuRegCharges.addActionListener(gestionnaireAccueil);
		
		sMenuSoldeCompte = new JMenuItem("Solde de tout compte");
		sMenuSoldeCompte.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/lister.png")));
		menuEdition.add(sMenuSoldeCompte);
		
		sMenuRevenusFoncier = new JMenuItem("Revenus foncier");
		sMenuRevenusFoncier.setIcon(new ImageIcon(FenetreAccueil.class.getResource("/data/lister.png")));
		menuEdition.add(sMenuRevenusFoncier);
		sMenuSoldeCompte.addActionListener(gestionnaireAccueil);
		
		JMenu menuInfos = new JMenu("Informations");
		menuBar.add(menuInfos);
		
		sMenuInformations = new JMenuItem("Vos informations");
		menuInfos.add(sMenuInformations);
		sMenuInformations.addActionListener(gestionnaireAccueil);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(2, 69, 163));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.disableItems();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogo = new JLabel(new ImageIcon(FenetreAccueil.class.getResource("/data/locaplus_logo.png")));
		lblLogo.setBounds(459, 92, 378, 242);
		contentPane.add(lblLogo);
		
		lblBienvenue = new JLabel("Bienvenue sur votre espace");
		lblBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenue.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblBienvenue.setForeground(Color.WHITE);
		lblBienvenue.setBounds(459, 361, 378, 54);
		contentPane.add(lblBienvenue);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(374, 344, 548, 19);
		contentPane.add(separator);
		
		btnConnecter = new JButton("Se connecter");
		btnConnecter.addActionListener(this.gestionnaireAccueilBtn);
		btnConnecter.setForeground(new Color(2, 69, 163));
		btnConnecter.setBackground(Color.WHITE);
		btnConnecter.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		btnConnecter.setBounds(591, 463, 110, 21);
		contentPane.add(btnConnecter);
		
		lblTooltip = new JLabel("Pour commencer, connectez-vous !");
		lblTooltip.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblTooltip.setForeground(Color.WHITE);
		lblTooltip.setHorizontalAlignment(SwingConstants.CENTER);
		lblTooltip.setBounds(459, 411, 378, 42);
		contentPane.add(lblTooltip);
		
		JLabel lblNewLabel = new JLabel(LocalDateTime.now().getHour() + " : " + LocalDateTime.now().getMinute());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(556, 47, 164, 35);
		contentPane.add(lblNewLabel);
	}

	public JLabel getLblTooltip() {
		return lblTooltip;
	}

	public JButton getBtnConnecter() {
		return btnConnecter;
	}
	
	public void enableItems() {
		this.sMenuExtract.setVisible(true);
		this.sMenuInformations.setVisible(true);
		this.sMenuSeConnecter.setVisible(false);
		this.sMenuSeDeconnecter.setVisible(true);
		this.sMenuBiens.setVisible(true);
		this.sMenuLocataires.setVisible(true);
		this.sMenuAssurances.setVisible(true);
		this.sMenuTravaux.setVisible(true);
		this.sMenuTotal.setVisible(true);
		this.sMenuLocataire.setVisible(true);
		this.sMenuRegCharges.setVisible(true);
		this.sMenuSoldeCompte.setVisible(true);
		this.sMenuStatistique.setEnabled(true);
		this.sMenuRevenusFoncier.setVisible(true);
	}
	
	public void disableItems() {
		this.sMenuRevenusFoncier.setVisible(false);
		this.sMenuInformations.setVisible(false);
		this.sMenuExtract.setVisible(false);
		this.sMenuSeConnecter.setVisible(true);
		this.sMenuSeDeconnecter.setVisible(false);
		this.sMenuBiens.setVisible(false);
		this.sMenuLocataires.setVisible(false);
		this.sMenuAssurances.setVisible(false);
		this.sMenuTravaux.setVisible(false);
		this.sMenuTotal.setVisible(false);
		this.sMenuLocataire.setVisible(false);
		this.sMenuRegCharges.setVisible(false);
		this.sMenuSoldeCompte.setVisible(false);
		this.sMenuStatistique.setVisible(false);
	}
}





