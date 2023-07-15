package model.bo;

import model.vo.EnderecoVO;
import model.vo.UsuarioVO;
import view.paineis.TelaAlerta;

import java.util.List;

import exception.CamposInvalidosException;
import exception.ClienteComEnderecoException;
import model.dao.EnderecoDAO;
import model.dao.UsuarioDAO;

public class UsuarioBO {
	
	public UsuarioVO realizarLoginBO(String login, String senha) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if(login.isBlank() || senha.isBlank())
		{
			TelaAlerta alerta = new TelaAlerta("Por Favor, preencha os campos corretamente.");
			alerta.setVisible(true);
			alerta.setModal(true);
		}
		return usuarioDAO.realizarLoginDAO(login, senha);
	}

	public UsuarioVO inserirNovoUsuarioBO(UsuarioVO novoUsuario) throws CamposInvalidosException {
		UsuarioDAO novoUsuarioDAO = new UsuarioDAO();
		if(novoUsuario.getNome().isBlank()
		&& novoUsuario.getCpf().isBlank()
		&& novoUsuario.getDtCadastro() == null
		&& novoUsuario.getLogin().isBlank()
		&& novoUsuario.getSenha().isBlank()
		&& novoUsuario.getTelefone().isBlank()) {
			throw new CamposInvalidosException("O preenchimento de todos os campos é obrigatório.");
		}
		if(novoUsuarioDAO.existeRegistroPorCpf(novoUsuario.getCpf())) {
			throw new CamposInvalidosException("CPF JA ESTA SENDO USADO.");
		}
		if(novoUsuarioDAO.existeRegistroPorLogin(novoUsuario.getLogin())) {
			throw new CamposInvalidosException("Usuário já está sendo usado.");
		}else {
			novoUsuario = novoUsuarioDAO.salvar(novoUsuario);
			
		}
		return novoUsuario;
	}

	public List<UsuarioVO> consultarTodosUsuarios() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.consultarTodosUsuarios();
	}


	public static boolean excluir(int idUsuario) throws ClienteComEnderecoException {
		UsuarioDAO excluirUsuarioDAO = new UsuarioDAO();
		EnderecoDAO excluirEnderecoDAO = new EnderecoDAO();
		
		UsuarioVO usuarioBuscado = excluirUsuarioDAO.consultarUsuarioPorID(idUsuario);
		
		//testando o idendereco
		int idEnderecoUsuario = usuarioBuscado.getEnderecoVO().getIdEndereco();
		System.out.println(idEnderecoUsuario);
		// ---------------------
		
		boolean idEnderecoUsuarioBuscado = excluirEnderecoDAO.excluirEndereco(idEnderecoUsuario);
		if(idEnderecoUsuarioBuscado == true) {
			System.out.println("sou foda");
		}

		if(usuarioBuscado.getEnderecoVO().getIdEndereco() == 0 ) {
			throw new ClienteComEnderecoException("Usuario nao possui Endereco");			
		}
		
		return excluirUsuarioDAO.excluir(idUsuario);
	}
	

		

}
