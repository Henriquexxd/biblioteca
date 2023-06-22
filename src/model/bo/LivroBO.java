package model.bo;

import model.dao.LivroDAO;
import model.vo.LivroVO;
import view.paineis.TelaAlerta;

public class LivroBO {

	
	public LivroVO inserirNovoLivroBO(LivroVO novoLivro) {
		LivroDAO livroDAO = new LivroDAO();
		if(novoLivro.getTitulo().isBlank()) {
			TelaAlerta alerta  = new TelaAlerta("Por Favor, preencha os campos corretamente");
			alerta.setVisible(true);
			alerta.setModal(true);
		}
		
		return livroDAO.inserirNovoLivroDAO(novoLivro);
	}

}
