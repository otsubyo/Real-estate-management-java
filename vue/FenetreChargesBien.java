package vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class FenetreChargesBien extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableau;

	/**
	 * Create the frame.
	 */
	public FenetreChargesBien() {
		setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setFrameIcon(new ImageIcon(FenetreChargesBien.class.getResource("/data/money-management.png")));
		setTitle("Charge immeuble");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel fenTitre = new JLabel("Charges d'un Immeuble");
		fenTitre.setHorizontalAlignment(SwingConstants.CENTER);
		fenTitre.setBounds(10, 11, 555, 30);
		fenTitre.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		contentPane.setLayout(null);
		contentPane.add(fenTitre);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setBounds(130, 273, 59, 16);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(UIManager.getColor("Button.background"));
		textArea_1.setBounds(130, 300, 59, 16);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBackground(UIManager.getColor("Button.background"));
		textArea_2.setBounds(130, 327, 59, 16);
		contentPane.add(textArea_2);
		
		JLabel lblEauxPourcentages = new JLabel("Eaux");
		lblEauxPourcentages.setBounds(22, 278, 94, 14);
		contentPane.add(lblEauxPourcentages);
		
		JLabel lblOrdureMenagerePourcentages = new JLabel("Ordure Menagere");
		lblOrdureMenagerePourcentages.setBounds(22, 304, 94, 14);
		contentPane.add(lblOrdureMenagerePourcentages);
		
		JLabel lblGazPourcentages = new JLabel("Gaz");
		lblGazPourcentages.setBounds(22, 332, 98, 14);
		contentPane.add(lblGazPourcentages);
		
		JLabel lblElectricitePourcentages = new JLabel("Electricite");
		lblElectricitePourcentages.setBounds(22, 359, 94, 14);
		contentPane.add(lblElectricitePourcentages);
		
		
		
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setBounds(10, 230, 215, 219);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pourcentages");
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 195, 14);
		panel_1_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBackground(UIManager.getColor("Button.background"));
		textArea_3.setBounds(121, 128, 59, 16);
		panel_1_1.add(textArea_3);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setBounds(109, 179, 89, 23);
		panel_1_1.add(btnAnnuler);
		
		JButton btnValider = new JButton("Modifier");
		btnValider.setBackground(Color.WHITE);
		btnValider.setBounds(10, 179, 89, 23);
		panel_1_1.add(btnValider);
		btnValider.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        dispose(); // ferme la fenêtre courante
		    }
		});
		btnAnnuler.addActionListener(this);
		btnAnnuler.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        dispose(); // ferme la fenêtre courante
		    }
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 555, 152);
		contentPane.add(scrollPane);
		
		tableau = new JTable();
		tableau.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tableau);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 128));
		separator.setBounds(195, 51, 188, 7);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Insérer");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(FenetreChargesBien.class.getResource("/data/add-button.png")));
		btnNewButton.setBounds(235, 411, 94, 21);
		contentPane.add(btnNewButton);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(Color.WHITE);
		btnSupprimer.setIcon(new ImageIcon(FenetreChargesBien.class.getResource("/data/marque-de-croix.png")));
		btnSupprimer.setBounds(339, 411, 112, 21);
		contentPane.add(btnSupprimer);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBackground(Color.WHITE);
		btnQuitter.setIcon(new ImageIcon(FenetreChargesBien.class.getResource("/data/log-out.png")));
		btnQuitter.setBounds(461, 411, 104, 21);
		contentPane.add(btnQuitter);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(237, 245, 245));
		panel.setBounds(235, 230, 330, 171);
		contentPane.add(panel);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}