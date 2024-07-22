import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lista {
    private String nome;
    private Map<String, Boolean> finalizarTarefa = new HashMap<>();
    private List<String> tarefasFinalizadas = new ArrayList<String>();
    public List<String> tarefasNaoFinalizadas= new ArrayList<>();
    private boolean concluida = false;
    private List<String> tarefas = new ArrayList<String>();

    public Lista() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    Scanner sc = new Scanner(System.in);

    public void adicionar(String nome) {
        if (concluida) {
            System.out.println("A tarefa já está concluída!");
        }
        tarefas.add(nome);
        tarefasNaoFinalizadas.add(nome);
        System.out.println("Tarefa " + nome + " adicionada com sucesso!");
    }

    public void remover(String nome) {
        if (finalizarTarefa.containsKey(nome)) {
            tarefas.remove(nome);
        } else if (tarefas.contains(nome) && !finalizarTarefa.containsKey(nome)) {
            System.out.println("A tarefa ainda não foi concluída. Deseja realmente remover essa tarefa?");
            String op = sc.next();
            if (op.equals("n")) {
                System.out.println("Você cancelou essa operação!");
            } else {
                tarefas.remove(nome);
                System.out.println("Tarefa " + nome + " removida com sucesso!");
            }
        }
    }

    public void tarefaConcluida(String nome) {
        if (tarefas.contains(nome)) {
            System.out.println("Deseja concluir esta tarefa?");
            String op = sc.next();
            if (op.equals("n") || op.equals("não") || op.equals("nao")) {
                concluida = false;
            } else if(op.equals("s") || op.equals("sim")) {
                finalizarTarefa.put(nome, true);
                tarefasFinalizadas.add(nome);
                concluida = true;
                System.out.println("Tarefa marcada como concluída!");
            }
        }
        else {
            System.out.println("Esse nome não está na lista!");
            sc.nextLine();
        }
    }

    public void mostrarTarefasConcluidas(){
        for(String tarefa : tarefasFinalizadas){
            System.out.println(tarefa);
        }
    }

    public void mostrarTarefasNaoFinalizadas(){
        for(String tarefa : tarefas){
            if(!finalizarTarefa.containsKey(tarefa)){
                System.out.println(tarefa);
            }
        }
    }

    public void mostrarLista() {
        for (String tarefa : tarefas) {
            System.out.println(tarefa);
        }

    }
}
