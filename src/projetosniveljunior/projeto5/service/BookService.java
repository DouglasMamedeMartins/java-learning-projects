package projetosniveljunior.projeto5.service;

import projetosniveljunior.projeto5.domain.Book;
import projetosniveljunior.projeto5.repository.BookRepository;

import java.util.List;
import java.util.Scanner;

public class BookService {
    private final BookRepository repository;
    private final Scanner scanner = new Scanner(System.in);
    private static final String BOOK_PRINT_FORMAT = "\n[%d] title: %s, author: %s, year: %s, ISBN: %s";

    public BookService(BookRepository repository) {
        this.repository = repository;
    }


    private void printBooks(List<Book> books) {
        int contador = 1;
        for (Book book : books) {
            String message = String.format(BOOK_PRINT_FORMAT + "%n", contador++,
                    book.getTitle(),
                    book.getAuthor(),
                    book.getYearOfPublication(),
                    book.getIsbn()
            );
            System.out.println(message);
        }
    }

    private void printBook(Book book) {
        String message = String.format(BOOK_PRINT_FORMAT + "%n", 1,
                book.getTitle(),
                book.getAuthor(),
                book.getYearOfPublication(),
                book.getIsbn());
        System.out.println(message);
    }

    private String readTitle() {
        System.out.print("Enter the title of the book: ");
        String book = scanner.nextLine();
        if (book.isEmpty()) {
            System.out.println("Book cannot be empty!");
            return null;
        }
        return book;
    }

    private String readAuthor() {
        System.out.print("Enter the name of author: ");
        String author = scanner.nextLine();

        if (author.isEmpty()) {
            System.out.println("Author cannot be empty!");
            return null;
        }

        return author;
    }

    private String readYearOfPublication() {
        System.out.print("Enter the year of publication: ");
        String yearOfPublication = scanner.nextLine();

        if (yearOfPublication.isEmpty() || !yearOfPublication.matches("\\d+")) {
            System.out.println("Year of publication cannot be empty and must contain only numbers!");
            return null;
        }

        return yearOfPublication;
    }


    private String readIsbn() {
        System.out.print("Enter the book's ISBN: ");
        String isbn = scanner.nextLine();

        if (isbn.isEmpty() || !isbn.matches("\\d{13}")) {
            System.out.println("Isbn must contain exactly 13 digits!");
            return null;
        }
        return isbn;
    }

    private void searchByTitle() {
        System.out.print("Enter the title name: ");
        String searchByTitle = scanner.nextLine();
        List<Book> found = repository.searchTitle(searchByTitle);
        if (found.isEmpty()) {
            System.out.println("Book not found!");
            return;
        }
        printBooks(found);
    }

    private void searchByYearOfPublication() {
        System.out.print("Enter the year of publication: ");
        String searchYearOfPublication = scanner.nextLine();
        List<Book> found = repository.searchYearOfPublication(searchYearOfPublication);
        if (found.isEmpty()) {
            System.out.println("Book not found!");
            return;
        }
        printBooks(found);
    }

    private void searchByAuthor() {
        System.out.print("Enter the author's name: ");
        String searchByAuthor = scanner.nextLine();
        List<Book> found = repository.searchAuthor(searchByAuthor);
        if (found.isEmpty()) {
            System.out.println("Book not found!");
            return;
        }
        printBooks(found);

    }

    private void searchByIsbn() {
        System.out.print("Enter the ISBN: ");
        String searchIsbn = scanner.nextLine();

        if (!searchIsbn.matches("\\d{13}")) {
            System.out.println("Invalid ISBN format!");
            return;
        }

        Book found = repository.searchByIsbn(searchIsbn);

        if (found == null) {
            System.out.println("Book not found!");
            return;
        }
        printBook(found);
    }


    public void create() {

        String title = readTitle();
        String author = readAuthor();
        String year = readYearOfPublication();
        String isbn = readIsbn();

        if (title == null || author == null || year == null || isbn == null) {
            System.out.println("Values cannot be null!");
            return;
        }

        Book existing = repository.searchByIsbn(isbn);
        if (existing != null) {
            System.out.println("A book with this ISBn already exists.");
            return;
        }

        Book book = new Book(title, author, year, isbn);
        repository.add(book);
        System.out.println("Book added successfully!\n");
    }

    public void listAll() {
        if (repository.listAll().isEmpty()) {
            System.out.println("Books not found!");
            return;
        }
        printBooks(repository.listAll());

    }

    public void search() {
        int numberOfOption;
        if (repository.listAll().isEmpty()) {
            System.out.println("There are no books to look for!");
            return;
        }


        do {
            System.out.println("\n1) Search by title");
            System.out.println("2) Search by author ");
            System.out.println("3) Search by year of publication");
            System.out.println("4) Search by ISBN");
            System.out.println("5) Exit");

            System.out.print("Which option do you want to use for search: ");
            numberOfOption = scanner.nextInt();
            scanner.nextLine();

            switch (numberOfOption) {
                case 1 -> searchByTitle();
                case 2 -> searchByAuthor();
                case 3 -> searchByYearOfPublication();
                case 4 -> searchByIsbn();
                case 5 -> System.out.println("Search System Closed");
                default -> System.out.println("Invalid option");
            }


        } while (numberOfOption != 5);

    }

    public void editBook() {
        if (repository.listAll().isEmpty()) {
            System.out.println("Books not found!");
            return;
        }
        listAll();

        System.out.print("Enter the book by ISBN you want to edit: ");
        String isbn = scanner.nextLine();

        if (!isbn.matches("\\d{13}")) {
            System.out.println("Invalid ISBN format. It must contain exactly 13 digits.");
            return;
        }

        Book book = repository.searchByIsbn(isbn);

        if (book == null) {
            System.out.println("Book not found with given ISBN.");
            return;
        }

        String newTitle = readTitle();
        String newAuthor = readAuthor();
        String newYear = readYearOfPublication();

        if (newTitle == null || newAuthor == null || newYear == null) {
            System.out.println("Invalid values. Edit canceled");
            return;
        }

        Book updated = new Book(newTitle, newAuthor, newYear, isbn);
        repository.update(book, updated);

        System.out.println("Book updated successfully!");
        System.out.println(updated);
    }

    public void removeBook() {
        if (repository.listAll().isEmpty()) {
            System.out.println("Books not found!");
            return;
        }
        System.out.print("Enter the book by ISBN you want to remove: ");
        String isbn = scanner.nextLine();

        if (!isbn.matches("\\d{13}")) {
            System.out.println("Invalid ISBN format. It must contain exactly 13 digits.");
            return;
        }

        Book book = repository.searchByIsbn(isbn);

        repository.remove(book);
        System.out.println("Book removed successfully!");
    }
}
