package view.paineis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaAlerta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnNewButton;
	private JLabel lblAlerta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaAlerta dialog = new TelaAlerta("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaAlerta(String mensagem) {
		setTitle("Aten\u00E7\u00E3o!");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 128, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setModal(true);		
		setResizable(false);
		setLocationRelativeTo(null);
		
		lblAlerta = new JLabel(mensagem);
		lblAlerta.setBounds(10, 101, 414, 77);
		contentPanel.add(lblAlerta);
		
		btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAlerta.this.dispose();
			}
		});
		btnNewButton.setBounds(166, 215, 89, 23);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\henrique.martins\\Desktop\\DD-VILMAR\\PROJETOS\\trabalhoBiblioteca\\src\\icons\\iconAlerta.png"));
		lblNewLabel.setBounds(190, 11, 65, 52);
		contentPanel.add(lblNewLabel);
	}
}
