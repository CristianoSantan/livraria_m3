package modelos;

public class Livros {

	private int id;
	private String nome;
	private String autor;
	private String editora;
	private double preco;

	public Livros() {
	}

	public Livros(int id, String nome, String autor, String editora, double preco) {
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.editora = editora;
		this.preco = preco;
	}

	public Livros(String nome, String autor, String editora, double preco) {
		this.nome = nome;
		this.autor = autor;
		this.editora = editora;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Livros [id=" + id + ", nome=" + nome + ", autor=" + autor + ", editora=" + editora + ", preco=" + preco
				+ "]";
	}

}
