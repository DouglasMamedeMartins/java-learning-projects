package projetosniveljunior.projeto4.repository;

import projetosniveljunior.projeto4.domain.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaRepository {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public List<Tarefa> listar() {
        return tarefas;
    }

    public List<Tarefa> buscarPorTitulo(String termo) {
        List<Tarefa> encontradas = new ArrayList<>();

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                encontradas.add(tarefa);
            }
        }
        return encontradas;
    }

    public void remove(int indice) {
        tarefas.remove(indice - 1);
    }

    public Tarefa obterPorIndice(int indice) {
        return tarefas.get(indice - 1);
    }

    public int tamanho() {
        return tarefas.size();
    }
}
