package com.boardtarefas.controller;

import com.boardtarefas.model.Task;
import com.boardtarefas.model.TaskStatus;
import com.boardtarefas.service.TaskService;
import java.util.Scanner;

public class TaskBoardApp {

    private static TaskService service = new TaskService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        do {
            System.out.println("\n=== Board de Tarefas ===");
            System.out.println("1. Criar nova tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Atualizar status de tarefa");
            System.out.println("4. Remover tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
                continue;
            }

            switch(opcao) {
                case 1:
                    criarTarefa(scanner);
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    atualizarStatus(scanner);
                    break;
                case 4:
                    removerTarefa(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while(opcao != 0);
        scanner.close();
    }

    private static void criarTarefa(Scanner scanner) {
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        Task task = service.criarTask(titulo, descricao);
        System.out.println("Tarefa criada com sucesso: " + task);
    }

    private static void listarTarefas() {
        System.out.println("\n=== Lista de Tarefas ===");
        for(Task task: service.listarTasks()) {
            System.out.println(task);
        }
    }

    private static void atualizarStatus(Scanner scanner) {
        System.out.print("Digite o ID da tarefa: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return;
        }

        System.out.println("Escolha o novo status:");
        for (TaskStatus status : TaskStatus.values()) {
            System.out.println(status.ordinal() + " - " + status);
        }
        System.out.print("Opção: ");
        int statusOpcao;
        try {
            statusOpcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida.");
            return;
        }
        
        if(statusOpcao < 0 || statusOpcao >= TaskStatus.values().length) {
            System.out.println("Status inválido.");
        } else {
            TaskStatus novoStatus = TaskStatus.values()[statusOpcao];
            boolean atualizado = service.atualizarStatusTask(id, novoStatus);
            if(atualizado) {
                System.out.println("Status atualizado com sucesso.");
            } else {
                System.out.println("Tarefa não encontrada.");
            }
        }
    }

    private static void removerTarefa(Scanner scanner) {
        System.out.print("Digite o ID da tarefa para remover: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return;
        }
        boolean removido = service.removerTask(id);
        if(removido) {
            System.out.println("Tarefa removida com sucesso.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }
}
