import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author{name='" + name + "', email='" + email + "', gender=" + gender + '}';
    }
}

class Book {
    private String title;
    private Author author; // En bok MÅSTE ha en författare

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author=" + author + '}';
    }
}

public class Main {
    private static List<Author> authorsList = new ArrayList<>();
    private static List<Book> booksList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    createAuthor();
                    break;
                case 2:
                    updateAuthorEmail();
                    break;
                case 3:
                    updateAuthorGender();
                    break;
                case 4:
                    showAllAuthors();
                    break;
                case 5:
                    createBook();
                    break;
                case 6:
                    sortAuthors();
                    break;
                case 7:
                    exitProgram();
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Skapa ny författare");
        System.out.println("2. Ändra författarens email");
        System.out.println("3. Ändra författarens kön");
        System.out.println("4. Visa alla författare");
        System.out.println("5. Skapa ny bok");
        System.out.println("6. Sortera författare");
        System.out.println("7. Avsluta");
    }

    private static int getChoice() {
        System.out.print("Välj ett alternativ: ");
        return scanner.nextInt();
    }

    private static void createAuthor() {
        System.out.println("Ange författarens namn:");
        String name = scanner.next();
        System.out.println("Ange författarens email:");
        String email = scanner.next();
        System.out.println("Ange författarens kön (m/f/n/a):");
        char gender = scanner.next().charAt(0);
        Author newAuthor = new Author(name, email, gender);
        authorsList.add(newAuthor);
    }

    private static void updateAuthorEmail() {
        System.out.println("Ange författarens namn för att ändra email:");
        String authorName = scanner.next();

        for (Author author : authorsList) {
            if (author.getName().equalsIgnoreCase(authorName)) {
                System.out.println("Ange ny email:");
                String newEmail = scanner.next();
                author.setEmail(newEmail);
                System.out.println("Email ändrad!");
                return;
            }
        }

        System.out.println("Författaren hittades inte.");
    }

    private static void updateAuthorGender() {
        System.out.println("Ange författarens namn för att ändra kön:");
        String authorName = scanner.next();

        for (Author author : authorsList) {
            if (author.getName().equalsIgnoreCase(authorName)) {
                System.out.println("Ange nytt kön (m/f/n/a):");
                char newGender = scanner.next().charAt(0);
                author.setGender(newGender);
                System.out.println("Kön ändrat!");
                return;
            }
        }

        System.out.println("Författaren hittades inte.");
    }

    private static void showAllAuthors() {
        System.out.println("Alla författare:");
        for (Author author : authorsList) {
            System.out.println(author);
        }
    }

    private static void createBook() {
        System.out.println("Ange bokens titel:");
        String title = scanner.next();
        System.out.println("Ange författarens namn för boken:");
        String authorName = scanner.next();

        Author bookAuthor = findAuthorByName(authorName);

        if (bookAuthor != null) {
            Book newBook = new Book(title, bookAuthor);
            booksList.add(newBook);
            System.out.println("Bok skapad!");
        } else {
            System.out.println("Författaren hittades inte.");
        }
    }

    private static Author findAuthorByName(String authorName) {
        for (Author author : authorsList) {
            if (author.getName().equalsIgnoreCase(authorName)) {
                return author;
            }
        }
        return null;
    }

    private static void sortAuthors() {
        System.out.println("Välj sorteringskriterium:");
        System.out.println("1. Namn");
        System.out.println("2. Email");
        System.out.println("3. Kön");
        int sortChoice = scanner.nextInt();

        switch (sortChoice) {
            case 1:
                Collections.sort(authorsList, Comparator.comparing(Author::getName));
                break;
            case 2:
                Collections.sort(authorsList, Comparator.comparing(Author::getEmail));
                break;
            case 3:
                Collections.sort(authorsList, Comparator.comparing(Author::getGender));
                break;
            default:
                System.out.println("Ogiltigt val för sortering.");
                return;
        }

        System.out.println("Författare sorterade!");
    }

    private static void exitProgram() {
        System.out.println("Avslutar programmet.");
        scanner.close();
        System.exit(0);
    }
}
