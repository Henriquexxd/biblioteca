package controller;


import model.bo.LivroBO;
import model.vo.LivroVO;
import view.paineis.TelaAlerta;

public class LivroController {

//	UsuarioBO usuarioBO = new UsuarioBO();
//	
//	if(login == null || senha == null) {
//		TelaAlerta alerta = new TelaAlerta("Por Favor, preencha os campos corretamente.");
//		alerta.setVisible(true);
//		alerta.setModal(true);
//		
//	}
//	
//	return usuarioBO.realizarLoginBO(login, senha);
	
	
	public LivroVO inserirNovoLivroController(LivroVO novoLivro) {
		LivroBO livroBO = new LivroBO();
		if(novoLivro != null) {
			TelaAlerta alerta = new TelaAlerta("Por Favor, preencha os campos corretamente.");
			alerta.setVisible(true);
			alerta.setModal(true);
		}
		
		return livroBO.inserirNovoLivroBO(novoLivro);
	}

}
