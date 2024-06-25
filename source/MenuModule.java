package source;

import java.util.Scanner;
import java.util.List;

public class MenuModule {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void printMainMenu() {
        System.out.println("\nWelcome to the Library!");
        boolean exit = false;
        while(!exit) {
            System.out.println();
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Books");
            System.out.println("4. Add to Favorite Books");
            System.out.println("5. List Favorite Books");
            System.out.println("6. List All Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 6:
                    listAllBooks();
                    break;
                case 0:
                    System.out.println("Bye Bye!");
                    exit = true;
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid choice, try again");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        Book book = new Book(title, author);
        library.addBookToLibrary(book);
        System.out.println("Book added successfully");
    }

    private static void listAllBooks() {
        List<Book> books = library.getBooks();
        System.out.println("All books that currently are in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
