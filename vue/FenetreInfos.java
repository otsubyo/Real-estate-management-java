package vue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class FenetreInfos extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame.
	 */
	public FenetreInfos() {
		setTitle("Infos");
		setFrameIcon(new ImageIcon(FenetreInfos.class.getResource("/data/home-button_16px.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
	    setBounds(100, 100, 524, 404);
	    getContentPane().setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("INFORMATION DE L'APPLICATION");
	    lblNewLabel.setForeground(new Color(0, 0, 160));
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
	    lblNewLabel.setBounds(10, 10, 492, 51);
	    getContentPane().add(lblNewLabel);
	    
	    JTextPane txtpnApplicationDeGestion = new JTextPane();
	    txtpnApplicationDeGestion.setEditable(false);
	    txtpnApplicationDeGestion.setBackground(Color.WHITE);
	    txtpnApplicationDeGestion.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
	    txtpnApplicationDeGestion.setText("Application de gestion immobilier crée par la société LOCAPLUS \r\n\r\nContributeurs: \r\n- ANRIFOU Amdjad\r\n- BOUNOUA Yahya\r\n- PREMI Carl\r\n- KAYA Baran\r\n- DAURE Thomas");
	    txtpnApplicationDeGestion.setBounds(21, 154, 278, 211);
	    getContentPane().add(txtpnApplicationDeGestion);
	    
	    JLabel lblNewLabel_1 = new JLabel("");
	    lblNewLabel_1.setIcon(new ImageIcon(FenetreInfos.class.getResource("/data/key-set_blue_126px.png")));
	    lblNewLabel_1.setBounds(344, 185, 135, 152);
	    getContentPane().add(lblNewLabel_1);
	    
	    JSeparator separator = new JSeparator();
	    separator.setBackground(new Color(0, 0, 160));
	    separator.setBounds(10, 71, 492, 2);
	    getContentPane().add(separator);
	}
}