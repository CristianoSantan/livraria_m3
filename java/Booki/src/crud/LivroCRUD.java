package crud;

import java.util.Scanner;

import dao.LivroDAO;
import modelos.Livros;

public class LivroCRUD {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		LivroDAO livroDAO = new LivroDAO();
		
		int opcao = 0, id = 0; 
		
		String nome = "", autor = "", editora = "";
		
		double preco = 0;
		
		
		do {
			
			System.out.println("\n============================== LIVROS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o autor:");
				autor = s.nextLine();
				System.out.println("Digite a editora:");
				editora = s.nextLine();
				System.out.println("Digite a preco:");
				preco = s.nextDouble();
				s.nextLine();
				
				Livros livro1 = new Livros(nome, autor, editora, preco);
				
				livroDAO.create(livro1);
				break;
			case 2:
				
				for (Livros u : livroDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o autor:");
				autor = s.nextLine();
				System.out.println("Digite a editora:");
				editora = s.nextLine();
				System.out.println("Digite a preco:");
				preco = s.nextDouble();
				
				
				Livros livro2 = new Livros(id, nome, autor, editora, preco);
				
				livroDAO.update(livro2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				livroDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Livros livro3 = livroDAO.readById(id);
				
				System.out.println(livro3.toString());
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();
	}

}

