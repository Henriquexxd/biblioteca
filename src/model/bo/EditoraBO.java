package model.bo;

import java.util.List;

import exception.CamposInvalidosException;
import model.dao.EditoraDAO;
import model.dao.EnderecoDAO;
import model.vo.EditoraVO;

public class EditoraBO {

	public List<EditoraVO> consultarTodasEditoras(List<EditoraVO> consultarTodos) {
		EditoraDAO editoraDAO = new EditoraDAO();
		return editoraDAO.consultarTodasEditoras(consultarTodos);
	}

	public EditoraVO inserirNovaEditoraBO(EditoraVO novaEditora) throws CamposInvalidosException {
		EditoraDAO novaEditoraDAO = new EditoraDAO();
		EnderecoDAO novoEnderecoDAO = new EnderecoDAO();

		if (novaEditora.getNome().isBlank() && novaEditora.getCnpj().isBlank() && novaEditora.getTelefone().isBlank()) {
			throw new CamposInvalidosException("O preenchimento de TODOS os campos é obrigatório.");
		}
		if (novaEditoraDAO.existeRegistroDeEditoraPorNome(novaEditora.getNome())) {
			throw new CamposInvalidosException("Já existe Editora com esse NOME.");
		}
		if (novaEditoraDAO.existeRegistroDeEditoraPorCnpj(novaEditora.getCnpj())) {
			throw new CamposInvalidosException("Já existe Editora com esse CNPJ.");
		}
		if (novaEditoraDAO.existeRegistroDeEditoraPorTelefone(novaEditora.getTelefone())) {
			throw new CamposInvalidosException("Já existe Editora com esse TELEFONE.");
		}
		if (novoEnderecoDAO.existeRegistroDeEditoraPorCepENumero(novaEditora.getEnderecoVO().getCep(),
				novaEditora.getEnderecoVO().getNumero())) {
			throw new CamposInvalidosException("Já existe uma Editora nesse ENDEREÇO");
		} else {
			novaEditora = novaEditoraDAO.salvar(novaEditora);
		}

		return novaEditora;
	}

}
