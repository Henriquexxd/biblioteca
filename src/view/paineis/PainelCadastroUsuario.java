package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class PainelCadastroUsuario extends JPanel {
	private JTextField textFieldDataCadastro;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;
	private JTextField textFieldTelefone;
	private JTextField textFieldCpf;
	private JTextField textFieldNome;
	private JTextField textFieldEstado;
	private JTextField textFieldCidade;
	private JTextField textFieldBairro;
	private JTextField textFieldCep;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldPais;
	private JLabel lblNewLabel;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JLabel lblDataCadastro;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JLabel lblNewLabel_1;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblRua;
	private Component lblNumero;
	private JLabel lblPais;
	private JButton btnCadastrar;
	private JSeparator separator;

	/**
	 * Create the panel.
	 */
	public PainelCadastroUsuario() {
		setBackground(new Color(255, 128, 0));
		setForeground(new Color(128, 128, 64));
		setLayout(null);

		lblNewLabel = new JLabel("Cadastro de Usu\u00E1rio");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(146, 22, 194, 30);
		add(lblNewLabel);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(31, 72, 88, 14);
		add(lblNome);

		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(31, 105, 88, 14);
		add(lblCpf);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(31, 140, 88, 14);
		add(lblTelefone);

		lblDataCadastro = new JLabel("Data Cadastro:");
		lblDataCadastro.setBounds(31, 171, 88, 14);
		add(lblDataCadastro);

		lblLogin = new JLabel("Login:");
		lblLogin.setBounds(31, 203, 88, 14);
		add(lblLogin);

		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(31, 233, 88, 14);
		add(lblSenha);

		textFieldDataCadastro = new JTextField();
		textFieldDataCadastro.setBounds(118, 166, 204, 20);
		add(textFieldDataCadastro);
		textFieldDataCadastro.setColumns(10);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(118, 198, 204, 20);
		add(textFieldLogin);
		textFieldLogin.setColumns(10);

		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(118, 230, 204, 20);
		add(textFieldSenha);
		textFieldSenha.setColumns(10);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(118, 133, 204, 20);
		add(textFieldTelefone);
		textFieldTelefone.setColumns(10);

		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(118, 100, 204, 20);
		add(textFieldCpf);
		textFieldCpf.setColumns(10);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(118, 69, 204, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);

		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBounds(118, 557, 204, 23);
		add(btnCadastrar);
		
		separator = new JSeparator();
		separator.setBounds(10, 261, 437, 2);
		add(separator);
		
		lblNewLabel_1 = new JLabel("Endere\u00E7o");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(175, 272, 155, 20);
		add(lblNewLabel_1);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(33, 346, 56, 14);
		add(lblEstado);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(31, 382, 58, 14);
		add(lblCidade);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(33, 417, 56, 14);
		add(lblBairro);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(33, 452, 56, 14);
		add(lblCep);
		
		lblRua = new JLabel("Rua:");
		lblRua.setBounds(33, 490, 56, 14);
		add(lblRua);
		
		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(31, 527, 58, 14);
		add(lblNumero);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(119, 345, 203, 20);
		add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(119, 381, 203, 20);
		add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(119, 416, 203, 20);
		add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		textFieldCep = new JTextField();
		textFieldCep.setBounds(119, 451, 203, 20);
		add(textFieldCep);
		textFieldCep.setColumns(10);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(119, 489, 203, 20);
		add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(119, 526, 203, 20);
		add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		lblPais = new JLabel("Pais");
		lblPais.setBounds(31, 309, 46, 14);
		add(lblPais);
		
		textFieldPais = new JTextField();
		textFieldPais.setBounds(118, 306, 204, 20);
		add(textFieldPais);
		textFieldPais.setColumns(10);

	}
}
