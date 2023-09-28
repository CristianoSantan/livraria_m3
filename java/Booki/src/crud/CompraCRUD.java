package crud;

import java.util.Scanner;

import dao.CompraDAO;
import dao.LivroDAO;
import dao.UsuarioDAO;
import modelos.Compras;
import modelos.Livros;
import modelos.Usuarios;

public class CompraCRUD {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		CompraDAO compraDAO = new CompraDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		LivroDAO livroDAO = new LivroDAO();
		
		int opcao = 0, id = 0, id_livro = 0, id_usuario = 0; 
		
		String data_compra = "";
		
		do {
			
			System.out.println("\n============================== COMPRAS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a data da compra:");
				data_compra = s.nextLine();
				System.out.println("Digite o id do livro:");
				id_livro = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do usuario:");
				id_usuario = s.nextInt();
				s.nextLine();
				
				Usuarios usuario1 = usuarioDAO.readById(id_usuario);
				Livros livro1 = livroDAO.readById(id_livro);
				
				
				Compras compra1 = new Compras(data_compra, usuario1, livro1);
				
				
				compraDAO.create(compra1);
				break;
			case 2:
				
				for (Compras u : compraDAO.read()) {
					
					System.out.println(u.toString());
					
				}
				
				break;
			case 3:
				System.out.println("Digite o id da compra:");
				id = s.nextInt();
				s.nextLine();				
				System.out.println("Digite a data da compra:");
				data_compra = s.nextLine();
				System.out.println("Digite o id do livro:");
				id_livro = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do usuario:");
				id_usuario = s.nextInt();
				s.nextLine();
				
				Usuarios usuario2 = usuarioDAO.readById(id_usuario);
				Livros livro2 = livroDAO.readById(id_livro);
				
				
				Compras compra2 = new Compras(id, data_compra, usuario2, livro2);
				
				compraDAO.update(compra2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				compraDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Compras compra3 = compraDAO.readById(id);
				
				System.out.println(compra3.toString());
				break;
			default:
				System.out.println(opcao != 0 ? "Opção invalida, digite novamente" : "");
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

}
