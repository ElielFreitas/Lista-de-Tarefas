import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lista listaDeTarefas = new Lista();
        Scanner sc = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("***Lista de tarefas***");
            System.out.println("[1] Adicionar na lista");
            System.out.println("[2] Remover da lista");
            System.out.println("[3] Marcar como concluída");
            System.out.println("[4] Ver a lista completa");
            System.out.println("[5] Ver tarefas completadas");
            System.out.println("[6] Ver tarefas incompletas");
            System.out.println("[7] Sair");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("***Adicionar na lista***");
                    System.out.print("Informe a tarefa que deseja adicionar: ");
                    String tarefa = sc.nextLine();
                    listaDeTarefas.adicionar(tarefa);
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("***Remover da lista***");
                    System.out.print("Informe a tarefa que deseja remover: ");
                    tarefa = sc.nextLine();
                    listaDeTarefas.remover(tarefa);
                    break;
                case 3:
                    System.out.println("***Marcar uma tarefa como concluída***");
                    listaDeTarefas.mostrarLista();
                    System.out.print("Informe o nome da tarefa que deseja concluir:");
                    tarefa = sc.nextLine();
                    listaDeTarefas.tarefaConcluida(tarefa);
                    break;
                case 4:
                    System.out.println("***Ver a lista completa***");
                    listaDeTarefas.mostrarLista();
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("***Tarefas concluídas***");
                    listaDeTarefas.mostrarTarefasConcluidas();
                    break;
                case 6:
                    System.out.println("***Tarefas não concluídas***");
                    listaDeTarefas.mostrarTarefasNaoFinalizadas();

                    break;
                case 7:
                    rodando = false;
                    for (int i = 0; i < 5; i++) {
                        System.out.print(".");
                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println();
                    System.out.println("Programa finalizado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}