package source;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MenuModule {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void printMainMenu() {
        System.out.println("\nWelcome to the Library!");
        boolean exit = false;
        while(!exit) {
            System.out.println();
            System.out.println("1. Add book");
            System.out.println("2. Search books");
            System.out.println("3. List all books in the library");
            System.out.println("4. List your borrowed books");
            System.out.println("5. List your favorite Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    listAllBooks();
                    break;
                case 4:
                    listBorrowedBooks();
                    break;
                case 5:
                    listFavoriteBooks();
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

    private static void searchBook() {
        System.out.println("Would you like to search by the author or by the title?");
        System.out.println("1. Search by the author");
        System.out.println("2. Search by the title");
        System.out.println("0. Go back");

        boolean back = false;
        while (!back) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    searchBooks("author");
                    back = true;
                    break;
                case 2:
                    searchBooks("title");
                    back = true;
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice, try again");
            }
        }
    }

    private static void searchBooks(String searchType) {
        boolean back2 = false;
        while (!back2) {
            String searchPrompt = (searchType.equals("author")) ? "Enter author name to search: " : "Enter book title to search: ";
            System.out.print(searchPrompt);
            String userInput = scanner.nextLine().toLowerCase();
            List<Book> books = library.getBooks();
            List<Book> matchedBooks = new ArrayList<>();

            for (Book book : books) {
                String attribute = (searchType.equals("author")) ? book.getAuthor().toLowerCase() : book.getTitle().toLowerCase();
                if (attribute.contains(userInput)) {
                    matchedBooks.add(book);
                }
            }

            if (matchedBooks.isEmpty()) {
                System.out.print("No matches found. Try again? (Y/N): ");
                String tryAgain = scanner.nextLine();
                if (!tryAgain.equalsIgnoreCase("Y")) {
                    back2 = true;
                }
            } else {
                displayAndInteract(matchedBooks, "borrow");
                back2 = true;
            }
        }
    }

    private static void displayAndInteract(List<Book> matchedBooks, String interaction) {
        System.out.println("Results:");
        for (int i = 0; i < matchedBooks.size(); i++) {
            System.out.println((i + 1) + ". " + matchedBooks.get(i));
        }
    
        String interactionPrompt = (interaction.equals("borrow")) ? "\nEnter the book number to borrow it or '0' to go back" : "\nEnter the book number to add it to favorites or '0' to go back";
        System.out.println(interactionPrompt);
        boolean back = false;
        while (!back) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
    
            if (choice > 0 && choice <= matchedBooks.size()) {
                Book bookToInteract = matchedBooks.get(choice - 1);
                if (interaction.equals("borrow")) {
                    if (!library.getBorrowedBooks().contains(bookToInteract)) {
                        library.borrowBook(bookToInteract);
                        System.out.println("You have borrowed: " + bookToInteract);
                        System.out.println();
                    } else {
                        System.out.println("You have already borrowed this book!");
                    }
                    back = true;
                } else {
                    if (!library.getFavoriteBooks().contains(bookToInteract)) {
                        library.addBookToFavorites(bookToInteract);
                        System.out.println("You have added to favorites: " + bookToInteract);
                        System.out.println();
                    } else {
                        System.out.println("You have already added this book to favorites!");
                    }
                    back = true;
                }
            } else if (choice == 0) {
                back = true;
            } else {
                System.out.println("Invalid choice, try again");
            }
        }
    }

    private static void listAllBooks() {
        List<Book> books = library.getBooks();

        displayAndInteract(books, "borrow");
        
        printMainMenu();
    }

    private static void listBorrowedBooks() {
        List<Book> borrowedBooks = library.getBorrowedBooks();

        displayAndInteract(borrowedBooks, "favorite");

        printMainMenu();
    }

    private static void listFavoriteBooks() {
        List<Book> favoriteBooks = library.getFavoriteBooks();

        System.out.println("Your favorite books:");
        for (int i = 0; i < favoriteBooks.size(); i++) {
            System.out.println((i + 1) + ". " + favoriteBooks.get(i));
        }

        System.out.print("\nPress any key to return ");
        scanner.nextLine();
        printMainMenu();
    }
    
}
