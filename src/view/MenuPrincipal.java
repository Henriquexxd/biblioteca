package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import model.vo.UsuarioVO;
import view.paineis.PainelCadastroEditora;
import view.paineis.PainelCadastroUsuario;
import view.paineis.PainelEmprestimos;
import view.paineis.PainelMeusEmprestimos;
import view.paineis.TelaLogin;
import view.paineis.PainelEmprestimoConsultar;
import view.paineis.PainelCadastroLivro;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenu mnCadastro;
	private JMenuItem mntmCadastrarLeitro;
	private JMenuItem mntmCadastrarLivros;
	private JMenuItem mntmCadastrarEditora;
	private JMenu mnEmprestimos;
	private JMenuItem mntmMeusEmprestimos;
	private JMenu mnConsultas;
	private JMenu mnRelatorios;
	private JMenuItem mntmRelatorioLivrosCadastrados;
	private JMenuItem mntmRelatorioLivrosPorAutor;
	private JMenuItem mntmRelatorioLivrosPorGenero;
	private JMenuItem mntmRelatorioLivrosPorEditora;
	private JMenu mnSair;
	private JMenuItem mntmSobreSistema;
	private JMenuItem mntmSair;
	private JMenuBar menuBar;
	private JMenuItem mntmConsultarEmprestimo;
	
	//Instanciação dos painéis no menu principal
	private PainelCadastroUsuario painelCadastroLeitor;
	private PainelCadastroEditora painelCadastroEditora;
	private PainelCadastroLivro painelCadastroLivro;
	private PainelMeusEmprestimos painelEmprestimosNovo;
	private PainelEmprestimos painelEmprestimos;
	private PainelEmprestimoConsultar painelEmprestimoConsultar;
	
	private UsuarioVO usuarioAutenticado;
	private JMenuItem mntmNewMenuItem;
	
	/**
	 * Create the frame.
	 */
	public MenuPrincipal(UsuarioVO usuario) {
		this.usuarioAutenticado = usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 617);
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCadastro = new JMenu("CADASTROS");
		menuBar.add(mnCadastro);
		
		mntmCadastrarLeitro = new JMenuItem("Cadastrar Usu\u00E1rio");
		mntmCadastrarLeitro.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				painelCadastroLeitor = new PainelCadastroUsuario();
				setContentPane(painelCadastroLeitor);
				revalidate();
				
			}
		});
		mnCadastro.add(mntmCadastrarLeitro);
		
		mntmCadastrarLivros = new JMenuItem("Cadastrar Livros");
		mntmCadastrarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroLivro = new PainelCadastroLivro();
				setContentPane(painelCadastroLivro);
				revalidate();
			}
		});
		
		mnCadastro.add(mntmCadastrarLivros);
		
		mntmCadastrarEditora = new JMenuItem("Cadastrar Editora");
		mntmCadastrarEditora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroEditora = new PainelCadastroEditora();
				setContentPane(painelCadastroEditora);
				revalidate();
			}
		});
		mnCadastro.add(mntmCadastrarEditora);
		
		mnEmprestimos = new JMenu("EMPRESTIMOS");
		menuBar.add(mnEmprestimos);
		
		mntmMeusEmprestimos = new JMenuItem("Meus Empr\u00E9stimos");
		mntmMeusEmprestimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelEmprestimos = new PainelEmprestimos();
				setContentPane(painelEmprestimos);
				revalidate();
			}
		});
		mnEmprestimos.add(mntmMeusEmprestimos);
		
		mntmConsultarEmprestimo = new JMenuItem("Consultar Empr\u00E9stimo");
		mntmConsultarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelEmprestimoConsultar = new PainelEmprestimoConsultar();
				setContentPane(painelEmprestimoConsultar);
				revalidate();
			}
		});
		mnEmprestimos.add(mntmConsultarEmprestimo);
		
		mnConsultas = new JMenu("CONSULTAS");
		menuBar.add(mnConsultas);
		
		mntmNewMenuItem = new JMenuItem("CONSULTAR");
		mnConsultas.add(mntmNewMenuItem);
		
		mnRelatorios = new JMenu("RELATORIOS");
		menuBar.add(mnRelatorios);
		
		mntmRelatorioLivrosCadastrados = new JMenuItem("Relat\u00F3rio de Livros Cadastrados");
		mnRelatorios.add(mntmRelatorioLivrosCadastrados);
		
		mntmRelatorioLivrosPorAutor = new JMenuItem("Relat\u00F3rio de Livros por Autor");
		mnRelatorios.add(mntmRelatorioLivrosPorAutor);
		
		mntmRelatorioLivrosPorGenero = new JMenuItem("Relat\u00F3rio de Livros por G\u00EAnero");
		mnRelatorios.add(mntmRelatorioLivrosPorGenero);
		
		mntmRelatorioLivrosPorEditora = new JMenuItem("Relat\u00F3rio de Livros por Editora");
		mnRelatorios.add(mntmRelatorioLivrosPorEditora);
		
		mnSair = new JMenu("SAIR");
		menuBar.add(mnSair);
		
		mntmSobreSistema = new JMenuItem("Sobre o Sistema");
		mnSair.add(mntmSobreSistema);
		
		mntmSair = new JMenuItem("Sair");
		mnSair.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		//TODO verificar as permissoes do usuario autenticado e mostrar / esconder os componenetes
	}

}
