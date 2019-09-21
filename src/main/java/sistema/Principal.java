package sistema;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import classes.Imovel;
import classes.ImovelDAO;

public class Principal {

	public static void main(String[] args) throws IOException {

		ImovelDAO imovelDAO = new ImovelDAO();
		Scanner ler = new Scanner(System.in);
		String entrada;

		do {
			System.out.println("_______________________________________\n");
			System.out.println(" Sistema gerenciador de imoveis:");
			System.out.println("_______________________________________\n");
			System.out.println(" 0.....Sair");
			System.out.println(" 1.....Criar novo registro");
			System.out.println(" 2.....Buscar todos os registros");
			System.out.println(" 3.....Pesquisar registro pelo Id");
			System.out.println(" 4.....Editar registro");
			System.out.println(" 5.....Remover registro");
			System.out.println("_______________________________________");
			entrada = ler.nextLine();

			switch (Integer.parseInt(entrada)) {

			case 0:
				System.out.println("\n----------------------");
				System.out.println("Aplicação finalizada...\nAté a próxima!");
				break;

			case 1: // Criar
				Imovel criarImovel = new Imovel();

				System.out.println("Descrição: ");
				String desc = ler.nextLine();

				System.out.println("Endereço: ");
				String end = ler.nextLine();

				System.out.println("Situação: ");
				String situacao = ler.nextLine();

				// imovel.setId(1); Incrementado automaticamente
				criarImovel.setDescricao(desc);
				criarImovel.setEndereco(end);
				criarImovel.setSituacao(situacao);

				imovelDAO.inserir(criarImovel);
				break;

			case 2: // Buscar por todos
				List<Imovel> buscarImovel = imovelDAO.buscarTodos();

				for (Imovel meuIimovel : buscarImovel) {
					System.out.println("\n______________\n");
					System.out.println("ID: " + meuIimovel.getId());
					System.out.println("DESCRIÇÃO: " + meuIimovel.getDescricao());
					System.out.println("ENDEREÇO: " + meuIimovel.getEndereco());
					System.out.println("SITUAÇÃO: " + meuIimovel.getSituacao());

				}
				break;

			case 3: // Buscar por id
				Imovel buscarImovelID = new Imovel();

				System.out.println("\nInforme o id do registro que deseja buscar:\n");
				entrada = ler.nextLine();
				buscarImovelID = imovelDAO.buscarPorID(Integer.parseInt(entrada));

				if (buscarImovelID == null) {
					System.out.println("Erro ao buscar registro com id: " + entrada);
					break;
				}

				System.out.println("\n______________\n");
				System.out.println("ID: " + buscarImovelID.getId());
				System.out.println("DESCRIÇÃO: " + buscarImovelID.getDescricao());
				System.out.println("ENDEREÇO: " + buscarImovelID.getEndereco());
				System.out.println("SITUAÇÃO: " + buscarImovelID.getSituacao());
				break;

			case 4: // Editar
				System.out.println("\nInforme o id do registro que deseja alterar:\n");
				entrada = ler.nextLine();
				buscarImovelID = imovelDAO.buscarPorID(Integer.parseInt(entrada));

				System.out.println("\n______________\n");
				System.out.println("ID: " + buscarImovelID.getId());
				System.out.println("DESCRIÇÃO: " + buscarImovelID.getDescricao());
				System.out.println("ENDEREÇO: " + buscarImovelID.getEndereco());
				System.out.println("SITUAÇÃO: " + buscarImovelID.getSituacao());
				System.out.println("\n______________\n");
				System.out.println("Informe os novos dados:\n");

				Imovel alterarImovel = new Imovel();

				System.out.println("Nova descrição: ");
				String novaDesc = ler.nextLine();

				System.out.println("Novo endereço: ");
				String novoEnd = ler.nextLine();

				System.out.println("Nova situação: ");
				String novaSituacao = ler.nextLine();

				alterarImovel.setId(buscarImovelID.getId());
				alterarImovel.setDescricao(novaDesc);
				alterarImovel.setEndereco(novoEnd);
				alterarImovel.setSituacao(novaSituacao);

				imovelDAO.alterar(alterarImovel);
				break;

			case 5: // Remover
				System.out.println("\nInforme o id do registro que deseja remover:\n");
				entrada = ler.nextLine();

				imovelDAO.removerById(Integer.parseInt(entrada));
				break;

			default:
				System.out.println("\n----------------------");
				System.out.println("Opção inválida!");
				System.out.println("----------------------\n");
				break;
			}

		} while (!entrada.equals("0"));

		ler.close();
	}
}