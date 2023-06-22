package controller;

import model.bo.UsuarioBO;
import model.vo.UsuarioVO;
import view.paineis.TelaAlerta;

public class UsuarioController {
	
//	public UsuarioVO realizarLoginController(UsuarioVO usuarioVO) {
//		UsuarioBO usuarioBO = new UsuarioBO(); 
//		return usuarioBO.realizarLoginBO(usuarioVO);
//	}

	public UsuarioVO autenticarLoginController(String login, String senha) {
		UsuarioBO usuarioBO = new UsuarioBO();
				
		if(login == null || senha == null) {
			TelaAlerta alerta = new TelaAlerta("Por Favor, preencha os campos corretamente.");
			alerta.setVisible(true);
			alerta.setModal(true);
			
		}
		
		return usuarioBO.realizarLoginBO(login, senha);
	}

	

	

}
