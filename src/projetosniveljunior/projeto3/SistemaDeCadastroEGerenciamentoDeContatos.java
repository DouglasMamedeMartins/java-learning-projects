package projetosniveljunior.projeto3;

import projetosniveljunior.projeto3.menu.MenuService;
import projetosniveljunior.projeto3.repository.ContatoRepository;
import projetosniveljunior.projeto3.service.GerenciadorDeContatos;

import java.util.Scanner;

public class SistemaDeCadastroEGerenciamentoDeContatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContatoRepository repository = new ContatoRepository();
        GerenciadorDeContatos gerenciador = new GerenciadorDeContatos(repository);
        MenuService menu = new MenuService(gerenciador, scanner);

        menu.exibirMenu();
        scanner.close();
    }
}

