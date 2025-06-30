package projetosniveljunior.projeto5.repository;

import projetosniveljunior.projeto5.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
    }

    public List<Book> listAll() {
        return books;
    }

    public List<Book> searchTitle(String title) {
        List<Book> found = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                found.add(book);
            }
        }
        return found;
    }

    public List<Book> searchAuthor(String author) {
        List<Book> found = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                found.add(book);
            }
        }
        return found;
    }

    public List<Book> searchYearOfPublication(String yearOfPublication) {
        List<Book> found = new ArrayList<>();

        for (Book book : books) {
            if (book.getYearOfPublication().equals(yearOfPublication)) {
                found.add(book);
            }
        }
        return found;
    }


    public Book searchByIsbn(String isbn) {

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }


    public void remove(Book book) {
        books.remove(book);
    }

    public void update(Book original, Book updated) {
        int index = books.indexOf(original);
        if (index != -1) {
            books.set(index, updated);
        }
    }

    public int size() {
        return books.size();
    }
}
