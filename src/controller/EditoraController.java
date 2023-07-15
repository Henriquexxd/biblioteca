package controller;

import java.util.List;

import exception.CamposInvalidosException;
import model.bo.EditoraBO;
import model.vo.EditoraVO;

public class EditoraController {

	public List<EditoraVO> consultarTodasEditoras(List<EditoraVO> consultarTodos) {
		EditoraBO editoraBO = new EditoraBO(); 
		return editoraBO.consultarTodasEditoras(consultarTodos);
	}

	public EditoraVO inserirNovaEditoraController(EditoraVO novaEditora) throws CamposInvalidosException {
		EditoraBO editoraBO = new EditoraBO();
		return editoraBO.inserirNovaEditoraBO(novaEditora);
	}

}
