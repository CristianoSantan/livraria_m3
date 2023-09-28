package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Livros;

public class LivroDAO {
	// create
	public void create(Livros livro) {

		String sql = "insert into Livros (nome_livro, autor_livro, editora_livro, preco_livro) values (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, livro.getNome());
			pstm.setString(2, livro.getAutor());
			pstm.setString(3, livro.getEditora());
			pstm.setDouble(4, livro.getPreco());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// read
	public List<Livros> read() {
		List<Livros> Livros = new ArrayList<Livros>();
		String sql = "select * from Livros";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Livros livro = new Livros();

				livro.setId(rset.getInt("id_livro"));
				livro.setNome(rset.getString("nome_livro"));
				livro.setAutor(rset.getString("autor_livro"));
				livro.setEditora(rset.getString("editora_livro"));
				livro.setPreco(rset.getDouble("preco_livro"));

				Livros.add(livro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return Livros;
	}

	// update
	public void update(Livros livro) {
		String sql = "UPDATE Livros SET nome_livro = ?, autor_livro = ?, editora_livro = ?, preco_livro = ? WHERE id_livro = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, livro.getNome());
			pstm.setString(2, livro.getAutor());
			pstm.setString(3, livro.getEditora());
			pstm.setDouble(4, livro.getPreco());
			pstm.setInt(5, livro.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM Livros WHERE id_livro = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readById
	public Livros readById(int id) {
		Livros livro = new Livros();
		String sql = "select * from Livros WHERE id_livro = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			livro.setId(rset.getInt("id_livro"));
			livro.setNome(rset.getString("nome_livro"));
			livro.setAutor(rset.getString("autor_livro"));
			livro.setEditora(rset.getString("editora_livro"));
			livro.setPreco(rset.getDouble("preco_livro"));
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return livro;
	}


}
