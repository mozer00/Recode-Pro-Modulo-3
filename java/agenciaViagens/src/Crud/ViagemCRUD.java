package Crud;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.crud.dao.ClienteDAO;
import br.com.crud.dao.DestinoDAO;
import br.com.crud.dao.ViagemDAO;
import br.com.crud.model.Cliente;
import br.com.crud.model.Destino;
import br.com.crud.model.Viagem;

public class ViagemCRUD {

	public static void main(String[] args) throws ParseException {
		try (Scanner s = new Scanner(System.in)) {
			
			ViagemDAO viagemDAO = new ViagemDAO();
			ClienteDAO clienteDAO = new ClienteDAO();
			DestinoDAO destinoDAO = new DestinoDAO();
			String dataIda, dataVolta;
			double valorDiaria;
			
			int opcao = 0, id = 0, id_cliente = 0, id_destino = 0 ;
			
			do {
				
				System.out.println("\n==================================== Viagem ==================================\n");
				System.out.println("1-CRIAR 	2-CONSULTAR 	3-ATUALIZAR 	4-DELETAR	5-CONSULTAR POR ID  	0-SAIR" );
				opcao = s.nextInt();
				s.nextLine();

				switch (opcao) {

				case 1:
					System.out.println("Digite o valor da diaria: ");
					valorDiaria = s.nextFloat();
					
					System.out.println("Digite a data da ida. EX: DD/MM/YYYY ");
					dataIda = s.next();	
					
					Date Ida = new SimpleDateFormat("dd/MM/yyyy").parse(dataIda);
																	
					System.out.println("Digite a data da volta. EX: DD/MM/YYYY ");
					dataVolta = s.next();
					Date Volta = new SimpleDateFormat("dd/MM/yyyy").parse(dataVolta);
										
					System.out.println("Digite o ID do cliente: ");
					id_cliente = s.nextInt();
					s.nextLine();
					
					System.out.println("Digite o ID do destino: ");
					id_destino = s.nextInt();
					s.nextLine();
					
					Cliente cliente1 = clienteDAO.readById(id_cliente);
					Destino destino1 = destinoDAO.readById(id_destino);
					
					
					Viagem viagem1 = new Viagem(valorDiaria, Ida, Volta,destino1, cliente1);

					viagemDAO.create(viagem1);						
					break;

				case 2:					
					for( Viagem c : viagemDAO.getviagens()) {						
						System.out.println(c.toString());
					}
					
					break;

				case 3:
					
					System.out.println("id viagem");
					id = s.nextInt();
					s.nextLine();
					
					//Viagem viagemAtt = new Viagem();				
					//viagemAtt = viagemDAO.readById(id);
					
										
					
					System.out.println("Digite o valor da diaria: ");
					valorDiaria = s.nextDouble();
					
					System.out.println("Digite a data da ida: ");
					dataIda = s.next();	
					Date Ida1 = new SimpleDateFormat("dd/MM/yyyy").parse(dataIda);
																				
					System.out.println("Digite a data da volta: ");
					dataVolta = s.next();
					Date Volta1 = new SimpleDateFormat("dd/MM/yyyy").parse(dataVolta);
					
					
									
					Viagem viagem2 = new Viagem(id, valorDiaria, Ida1, Volta1);
					viagemDAO.update(viagem2);
					break;
					

				case 4:
					System.out.println("Digite o ID para excluir: ");
					id = s.nextInt();
					s.nextLine();

					viagemDAO.removeById(id);
					break;

				case 5:
					System.out.println("Digite o ID para consultar: ");
					id = s.nextInt();
					s.nextLine();
					Viagem viagem3 =  viagemDAO.readById(id);

					System.out.println(viagem3.toString());

					break;

				default:
					break;
				}

			}while (opcao != 0);
		}

		System.out.println("Ate mais!");
	}
	

}
