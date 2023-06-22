package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PainelSobreSistema extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelSobreSistema() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sobre o Sistema");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(200, 22, 158, 35);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema na sua vers\u00E3o 1.0");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(186, 90, 220, 53);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Desenvolvido por Henrique R. Martins e Arthur V. Ribeiro");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(86, 250, 379, 25);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Com Auxilio do Professor Vilmar C. P. Junior.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(123, 286, 311, 25);
		add(lblNewLabel_3);

	}

}
