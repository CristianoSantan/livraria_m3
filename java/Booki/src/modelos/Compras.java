package modelos;

public class Compras {

	private int id;
	private String data_compra;
	private double total_compra;
	private Usuarios usuario;
	private Livros livro;

	public Compras() {
	}

	public Compras(int id, String data_compra, Usuarios usuario, Livros livro) {
		this.id = id;
		this.data_compra = data_compra;
		this.total_compra = valorCompraMaisTaxa(livro.getPreco());
		this.usuario = usuario;
		this.livro = livro;
		
	}

	public Compras(String data_compra, Usuarios usuario, Livros livro) {
		this.data_compra = data_compra;
		this.total_compra = valorCompraMaisTaxa(livro.getPreco());
		this.usuario = usuario;
		this.livro = livro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData_compra() {
		return data_compra;
	}

	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}

	public double getTotal_compra() {
		return total_compra;
	}

	public void setTotal_compra(double total_compra) {
		this.total_compra = total_compra;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Livros getLivro() {
		return livro;
	}

	public void setLivro(Livros livro) {
		this.livro = livro;
	}
	
	public double valorCompraMaisTaxa(double preco) {
		this.total_compra = (preco * 0.15 ) + preco;
		
		return this.total_compra;
	}

	@Override
	public String toString() {
		return "Compras [id=" + id + ", data_compra=" + data_compra + ", total_compra=" + total_compra + ", usuario="
				+ usuario + ", livro=" + livro + "]";
	}

}
