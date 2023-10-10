package Crud;

import java.util.Scanner;

import br.com.crud.dao.DestinoDAO;
import br.com.crud.model.Destino;

public class DestinoCRUD {

	public static void main(String[] args) {

		try (Scanner s = new Scanner(System.in)) {
			DestinoDAO destinoDAO = new DestinoDAO();
			
			String cidadedestino, nomedestino;
			double valor;
			
			int opcao = 0, id = 0;
			
			do {
				
				System.out.println("\n==================================== Destino ==================================\n");
				System.out.println("1-CRIAR 	2-CONSULTAR 	3-ATUALIZAR 	4-DELETAR	5-CONSULTAR POR ID  	0-SAIR" );
				opcao = s.nextInt();
				s.nextLine();

				switch (opcao) {

				case 1:
					System.out.println("Digite o valor da passagem: ");
					valor = s.nextFloat();
					
					System.out.println("Digite a cidade de destino: ");
					cidadedestino = s.next();
					
					System.out.println("Digite o país do destino: ");
					nomedestino = s.next();


					Destino destino1 = new Destino(valor, cidadedestino, nomedestino);

					destinoDAO.create(destino1);						
					break;

				case 2:					
					for( Destino c : destinoDAO.getDestinos()) {
						System.out.println(c.toString());
					}

					destinoDAO.getDestinos();
					break;

				case 3:
					System.out.println("Digite o ID: ");
					id = s.nextInt();
					s.nextLine();

					System.out.println("Digite o valor da passagem: ");
					valor = s.nextFloat();

					System.out.println("Digite a cidade de destino: ");
					cidadedestino = s.next();

					System.out.println("Digite o país do destino: ");
					nomedestino = s.next();
					Destino destino2 = new Destino(id,valor,cidadedestino,nomedestino);
					destinoDAO.update(destino2);
					break;

				case 4:
					System.out.println("Digite o ID para excluir: ");
					id = s.nextInt();
					s.nextLine();

					destinoDAO.removeById(id);
					break;

				case 5:
					System.out.println("Digite o ID para consultar: ");
					id = s.nextInt();
					s.nextLine();
					Destino destino3 =  destinoDAO.readById(id);

					System.out.println(destino3.toString());

					break;

				default:
					break;
				}

			}while (opcao != 0);
		}

		System.out.println("Ate mais!");
	}
}
