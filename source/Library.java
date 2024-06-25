package source;

import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<Book> books;
    private List<Book> borrowedBooks;
    private List<Book> favoriteBooks;

    public Library() {
        this.books = new ArrayList<>();
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
        if (books.contains(book) && !borrowedBooks.contains(book)) {
            books.remove(book);
            borrowedBooks.add(book);
        }
    }

    public void addBookToFavorites(Book book) {
        if (books.contains(book) && !favoriteBooks.contains(book)) {
            favoriteBooks.add(book);
        }
    }
}
