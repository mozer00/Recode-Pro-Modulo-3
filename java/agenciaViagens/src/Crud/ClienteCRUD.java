package Crud;

import java.util.Scanner;

import br.com.crud.dao.ClienteDAO;
import br.com.crud.model.Cliente;


public class ClienteCRUD {

	public static void main(String[] args) {

		try (Scanner s = new Scanner(System.in)) {
			ClienteDAO clienteDAO = new ClienteDAO();

			int opcao = 0, id=0;

			do {

				System.out.println("\n==================================== Cliente ==================================\n");
				System.out.println("1-CRIAR 	2-CONSULTAR 	3-ATUALIZAR 	4-DELETAR	5-CONSULTAR POR ID  	0-SAIR" );
				opcao = s.nextInt();
				s.nextLine();

				switch (opcao) {
				
				case 1:				
					System.out.println("Digite o nome do cliente: ");
					String nome = s.nextLine();

					System.out.println("Digite o CPF do cliente: ");
					String cpf = s.nextLine();

					System.out.println("Digite o Telefone do cliente: ");
					String tel = s.nextLine();

					Cliente cliente1 = new Cliente(nome, cpf, tel);

					clienteDAO.create(cliente1);				
					break;

				case 2:				
					for( Cliente c : clienteDAO.getClientes()) {
						System.out.println(c.toString());
					}

					clienteDAO.getClientes();
					break;

				case 3:
					System.out.println("Digite o ID: ");
					id = s.nextInt();
					s.nextLine();

					System.out.println("Digite o nome do cliente: ");
					nome = s.nextLine();

					System.out.println("Digite o CPF do cliente: ");
					cpf = s.nextLine();

					System.out.println("Digite o Telefone do cliente: ");
					tel = s.nextLine();
					Cliente cliente2 = new Cliente(id,nome,cpf,tel);
					clienteDAO.update(cliente2);
					break;

				case 4:
					System.out.println("Digite o ID para excluir: ");
					id = s.nextInt();
					s.nextLine();

					clienteDAO.removeById(id);
					break;

				case 5:
					System.out.println("Digite o ID para consultar: ");
					id = s.nextInt();
					s.nextLine();
					Cliente cliente3 =  clienteDAO.readById(id);

					System.out.println(cliente3.toString());
					break;

				default:
					break;
				}



			}while(opcao != 0);
		}
		System.out.println("Ate mais!");
	}

}
