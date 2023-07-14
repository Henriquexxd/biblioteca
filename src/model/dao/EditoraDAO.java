package model.dao;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.EditoraVO;
import model.vo.EnderecoVO;

public class EditoraDAO {

	public List<EditoraVO> consultarTodasEditoras(List<EditoraVO> consultarTodos) {
		List<EditoraVO> editoras = new ArrayList<EditoraVO>();
		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM EDITORA";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				EditoraVO editoraConsultado = montarEditoraComResultadoDoBanco(resultado);
				editoras.add(editoraConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todas Editoras.");
			System.out.println("Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return editoras;
	}

	private EditoraVO montarEditoraComResultadoDoBanco(ResultSet resultado) throws SQLException {
		EditoraVO editoraBuscado = new EditoraVO();

		editoraBuscado.setIdEditora(resultado.getInt("ideditora"));
		editoraBuscado.setNome(resultado.getString("nome"));
		editoraBuscado.setCnpj(resultado.getString("cnpj"));
		editoraBuscado.setTelefone(resultado.getString("telefone"));

		int idEnderecoDaEditora = resultado.getInt("idendereco");
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		EnderecoVO enderecoVO = enderecoDAO.consultarPorId(idEnderecoDaEditora);
		editoraBuscado.setEnderecoVO(enderecoVO);

		return editoraBuscado;
	}

	public EditoraVO consultarPorIdEditora(int idEditoraDoLivro) {
		EditoraVO idEditoraDoLivroConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM EDITORA " + " WHERE IDEDITORA = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			query.setInt(1, idEditoraDoLivro);
			ResultSet resultado = query.executeQuery();
			if (resultado.next()) {
				idEditoraDoLivroConsultado = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out
					.println("Erro ao buscar editora com o id: + " + idEditoraDoLivro + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return idEditoraDoLivroConsultado;
	}

	private EditoraVO converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		EditoraVO idEditoraDoLivroConsultado = new EditoraVO();
		idEditoraDoLivroConsultado.setIdEditora(resultado.getInt("ideditora"));
		idEditoraDoLivroConsultado.setNome(resultado.getString("nome"));
		idEditoraDoLivroConsultado.setCnpj(resultado.getString("cnpj"));
		idEditoraDoLivroConsultado.setTelefone(resultado.getString("telefone"));

		return idEditoraDoLivroConsultado;
	}

	public boolean existeRegistroDeEditoraPorNome(String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		System.out.println(nome);
		String query = "SELECT nome FROM EDITORA WHERE nome = '" + nome + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao Executar a Query que verifica a existência de NOME por editora.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public boolean existeRegistroDeEditoraPorCnpj(String cnpj) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		System.out.println(cnpj);
		String query = "SELECT nome FROM EDITORA WHERE cnpj = '" + cnpj + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao Executar a Query que verifica a existência de CNPJ por editora.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public boolean existeRegistroDeEditoraPorTelefone(String telefone) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		System.out.println(telefone);
		String query = "SELECT nome FROM EDITORA WHERE cnpj = '" + telefone + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao Executar a Query que verifica a existência de TELEFONE por editora.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}
}