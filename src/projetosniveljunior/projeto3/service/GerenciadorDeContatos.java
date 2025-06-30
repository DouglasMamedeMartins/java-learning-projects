package projetosniveljunior.projeto3.service;

import projetosniveljunior.projeto3.domain.Contato;
import projetosniveljunior.projeto3.repository.ContatoRepository;

import java.util.List;
import java.util.Scanner;

public class GerenciadorDeContatos {
    private final ContatoRepository repository;
    private final Scanner scanner = new Scanner(System.in);
    private final String fraseContato = "\n [%d] nome: %s, telefone: %s, email: %s";

    public GerenciadorDeContatos(ContatoRepository repository) {
        this.repository = repository;
    }

    private String lerNome() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        if (nome.isEmpty()) {
            System.out.println("Nome não pode estar vazio!");
            return null;
        }
        return nome;
    }

    private String lerTelefone() {
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();
        if (!telefone.matches("\\d+")) {
            System.out.println("Telefone inválido, digite apenas números!");
            return null;
        }
        return telefone;
    }

    private String lerEmail() {
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        if (!email.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            System.out.println("Email inválido!");
            return null;
        }
        return email;
    }

    public void cadastrarContato() {
        Contato contato = new Contato();

        String nome = lerNome();
        if (nome == null) return;
        contato.setNome(nome);

        String telefone = lerTelefone();
        if (telefone == null) return;
        contato.setTelefone(telefone);

        String email = lerEmail();
        if (email == null) return;
        contato.setEmail(email);


        repository.adicionar(contato);
        System.out.println("Contato cadastrado com sucesso!");
    }

    public void listarContatos() {
        List<Contato> contatos = repository.listar();

        if (contatos.isEmpty()) {
            System.out.println("Não tem contatos para exibir, digite a opção 1 para cadastrar um novo contato!");
            return;
        }
        int contador = 1;
        for (Contato contatoTotal : contatos) {
            System.out.printf((fraseContato) + "%n", contador++, contatoTotal.getNome(), contatoTotal.getTelefone(), contatoTotal.getEmail());
        }
    }

    public void buscarContato() {
        System.out.print("Digite o nome que deseja buscar: ");
        String nomeBuscado = scanner.nextLine().toLowerCase();

        List<Contato> encontrados = repository.buscarPorNome(nomeBuscado);
        if (encontrados.isEmpty()) {
            System.out.println("Nenhum contato encontrado com esse nome.");
            return;
        }

        int contador = 1;

        for (Contato c : encontrados) {
            if (c.getNome().toLowerCase().contains(nomeBuscado)) {
                System.out.printf((fraseContato) + "%n", contador++, c.getNome(), c.getTelefone(), c.getEmail());
            }
        }
    }

    public void editarContato() {
        listarContatos();
        if (repository.quantidadeContatos() == 0) return;

        System.out.print("\nEscolha qual contato deseja editar (pelo número): ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice < 1 || indice > repository.quantidadeContatos()) {
            System.out.println("valor do índice inválido!");
            return;
        }

        Contato contato = repository.buscarPorIndice(indice - 1);

        System.out.print("Digite o novo nome (ou ENTER para manter): ");
        String novoNome = scanner.nextLine();

        if (!novoNome.isEmpty()) {
            contato.setNome(novoNome);
        }

        System.out.print("Digite o novo telefone (ou ENTER para manter): ");
        String novoTelefone = scanner.nextLine();
        if (!novoTelefone.isEmpty()) {
            if (novoTelefone.matches(("\\D+"))) {
                contato.setTelefone(novoTelefone);
            } else {
                System.out.println("Telefone inválido, mantendo o anterior.");
            }
        }

        System.out.print("Digite o novo email (ou ENTER para manter): ");

        String novoEmail = scanner.nextLine();
        if (!novoEmail.isEmpty()) {
            if (novoEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                contato.setEmail(novoEmail);
            } else {
                System.out.println("Email inválido, mantendo o anterior.");
            }
        }

        System.out.println("Contato editado com sucesso!");

    }

    public void removerContato() {
        listarContatos();

        if (repository.quantidadeContatos() == 0) return;

        System.out.print("\nEscolha qual contato deseja remover(pelo número): ");
        int indiceDoContato = scanner.nextInt();
        scanner.nextLine();

        if (indiceDoContato < 1 || indiceDoContato > repository.quantidadeContatos()) {
            System.out.println("Valor do indice inválido!");
            return;
        }

        Contato contatoParaRemover = repository.buscarPorIndice(indiceDoContato - 1);

        repository.remove(contatoParaRemover);
        System.out.println("Contato removido com sucesso!");
    }
}
