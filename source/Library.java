package source;

import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<Book> books;
    private List<Book> borrowedBooks;
    private List<Book> favoriteBooks;

    public Library() {
        this.books = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
        this.favoriteBooks = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public void addBookToLibrary(Book book) {
        books.add(book);
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        books.remove(book);
    }

    public void addBookToFavorites(Book book) {
        favoriteBooks.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}
