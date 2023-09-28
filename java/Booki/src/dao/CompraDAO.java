package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Compras;
import modelos.Livros;
import modelos.Usuarios;

public class CompraDAO {
	// create
	public void create(Compras compra) {

		String sql = "insert into Compras (data_compra, id_livro, id_usuario, total_compra) values (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, compra.getData_compra());
			pstm.setInt(2, compra.getLivro().getId());
			pstm.setInt(3, compra.getUsuario().getId());
			pstm.setDouble(4, compra.getTotal_compra());

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
	public List<Compras> read() {
		List<Compras> Compras = new ArrayList<Compras>();
		String sql = "select * from usuario_livro order by id_compra";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Compras compra = new Compras();
				Livros livro = new Livros();
				Usuarios usuario = new Usuarios();

				compra.setId(rset.getInt("id_compra"));
				compra.setData_compra(rset.getString("data_compra"));
				compra.setTotal_compra(rset.getDouble("total_compra"));

				livro.setId(rset.getInt("id_livro"));
				livro.setNome(rset.getString("nome_livro"));
				livro.setAutor(rset.getString("autor_livro"));
				livro.setEditora(rset.getString("editora_livro"));
				livro.setPreco(rset.getDouble("preco_livro"));

				usuario.setId(rset.getInt("id_usuario"));
				usuario.setNome(rset.getString("nome_usuario"));
				usuario.setEmail(rset.getString("email_usuario"));
				usuario.setSenha(rset.getString("senha_usuario"));

				compra.setLivro(livro);
				compra.setUsuario(usuario);

				Compras.add(compra);
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

		return Compras;
	}

	// update
	public void update(Compras compra) {
		String sql = "UPDATE Compras SET data_compra = ?, total_compra = ?, id_livro = ?, id_usuario = ? WHERE id_compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, compra.getData_compra());
			pstm.setDouble(2, compra.getTotal_compra());
			pstm.setInt(3, compra.getLivro().getId());
			pstm.setInt(4, compra.getUsuario().getId());
			pstm.setInt(5, compra.getId());

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
		String sql = "DELETE FROM Compras WHERE id_compra = ?";

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
	public Compras readById(int id) {
		Compras compra = new Compras();
		String sql = "select * from usuario_livro WHERE id_compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			Livros livro = new Livros();
			Usuarios usuario = new Usuarios();

			compra.setId(rset.getInt("id_compra"));
			compra.setData_compra(rset.getString("data_compra"));
			compra.setTotal_compra(rset.getDouble("total_compra"));

			livro.setId(rset.getInt("id_livro"));
			livro.setNome(rset.getString("nome_livro"));
			livro.setAutor(rset.getString("autor_livro"));
			livro.setEditora(rset.getString("editora_livro"));
			livro.setPreco(rset.getDouble("preco_livro"));

			usuario.setId(rset.getInt("id_usuario"));
			usuario.setNome(rset.getString("nome_usuario"));
			usuario.setEmail(rset.getString("email_usuario"));
			usuario.setSenha(rset.getString("senha_usuario"));

			compra.setLivro(livro);
			compra.setUsuario(usuario);

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
		return compra;
	}
}
