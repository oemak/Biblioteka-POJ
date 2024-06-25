package source;

public class Main {
    public static void main(String[] args) {
        MenuModule.library.addBookToLibrary(new Book("Pan Tadeusz", "Adam Mickiewiecz"));
        MenuModule.library.addBookToLibrary(new Book("Ferdydurke", "Witold Gombrowicz"));
        MenuModule.library.addBookToLibrary(new Book("Quo vadis", "Henryk Sienkiewicz"));
        MenuModule.library.addBookToLibrary(new Book("Lalka", "Bolesław Prus"));
        MenuModule.library.addBookToLibrary(new Book("Chłopi", "Władysław Reymont"));
        MenuModule.library.addBookToLibrary(new Book("Solaris", "Stanisław Lem"));
        MenuModule.library.addBookToLibrary(new Book("Katedra", "Jacek Dukaj"));
        MenuModule.library.addBookToLibrary(new Book("Wesele", "Stanisław Wyspiański"));
        MenuModule.library.addBookToLibrary(new Book("Balladyna", "Juliusz Słowacki"));
        MenuModule.library.addBookToLibrary(new Book("Proces", "Franz Kafka"));

        MenuModule.printMainMenu();
    }
}
