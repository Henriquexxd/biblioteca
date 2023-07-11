package model.bo;

import model.vo.UsuarioVO;
import view.paineis.TelaAlerta;

import java.util.List;

import exception.CamposInvalidosException;
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
			throw new CamposInvalidosException("O preenchimento de todos os campos � obrigat�rio.");
		}
		if(novoUsuarioDAO.existeRegistroPorCpf(novoUsuario.getCpf())) {
			throw new CamposInvalidosException("CPF JA ESTA SENDO USADO PORRA.");
		}
		if(novoUsuarioDAO.existeRegistroPorLogin(novoUsuario.getLogin())) {
			throw new CamposInvalidosException("Usu�rio j� est� sendo usado.");
		}else {
			novoUsuario = novoUsuarioDAO.salvar(novoUsuario);
			
		}
		return novoUsuario;
	}

	public List<UsuarioVO> consultarTodosUsuarios() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.consultarTodosUsuarios();
	}
	
	public UsuarioVO verificarExistenciaDeLoginBO(String login) {
		return null;
	}
	

		

}
