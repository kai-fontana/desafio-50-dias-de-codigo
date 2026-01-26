package crud_tarefas;

import java.util.*;

public class Tarefas {
	Scanner input = new Scanner(System.in);
	protected HashMap<Long, String> tarefas;
	protected Tarefa tarefa;

	public void exibirMenu() {
		System.out.println("""
				-------------------------
				|    Menu das Tarefas   |
				|-----------------------|
				| 1- Criar uma tarefa;  |
				| 2- Listar as tarefas; |
				| 3- Editar uma tarefa; |
				| 4- Remover uma tarefa;|
				| 5- Buscar uma tarefa; |
				-------------------------
				""");
	}

	public void gerenciarTarefas() {
		int opcao;
		
		exibirMenu();
		opcao = input.nextInt();
		switch(opcao) {
			case 1:
				System.out.println("Você escolheu criar uma tarefa!");
				criarTarefa();
				break;
				
			default:
				System.out.println("Não foi possível realizar nenhuma das operações.");
				System.out.println("Tente novamente: ");
				gerenciarTarefas();
		}
	}

	public String criarTarefa() {
		Long id = tarefa.getId();

		System.out.println("Insira o título da tarefa: ");
		tarefa.setTitulo(input.nextLine());

		String titulo = tarefa.getTitulo();

		return tarefas.put(id, titulo);
	}

}