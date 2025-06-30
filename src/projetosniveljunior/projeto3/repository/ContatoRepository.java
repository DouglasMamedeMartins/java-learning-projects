package projetosniveljunior.projeto3.repository;

import projetosniveljunior.projeto3.domain.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoRepository {
    private final List<Contato> contatos = new ArrayList<>();

    public void adicionar(Contato contato) {
        contatos.add(contato);
    }

    public List<Contato> listar() {
        return contatos;
    }

    public Contato buscarPorIndice(int indice) {
        if (indice >= 0 && indice < contatos.size()) {
            return contatos.get(indice);
        }
        return null;
    }

    public void remove(Contato contato) {
        contatos.remove(contato);
    }

    public List<Contato> buscarPorNome(String nome) {
        List<Contato> encontrados = new ArrayList<>();
        for (Contato c : contatos) {
            if (c.getNome().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(c);
            }
        }
        return encontrados;
    }

    public int quantidadeContatos() {
        return contatos.size();
    }


}
