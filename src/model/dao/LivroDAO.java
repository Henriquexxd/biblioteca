package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.LivroVO;

public class LivroDAO {

	public LivroVO inserirNovoLivroDAO(LivroVO novoLivro) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "dsd";
		LivroVO livroVO =null;
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				livroVO = new LivroVO();
				
				
			}
			
			
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query");
			System.out.println("Erro: " +erro.getMessage());
			
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		return livroVO;
	}

}
