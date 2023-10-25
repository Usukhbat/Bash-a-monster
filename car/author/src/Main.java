import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<authors> authors = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Skapa ny författare");
            System.out.println("2. Ändra författarens email");
            System.out.println("3. Ändra författarens kön");
            System.out.println("4. Visa alla författare");
            System.out.println("5. Avsluta");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Ange författarens namn:");
                    String name = scanner.nextLine();
                    System.out.println("Ange författarens email:");
                    String email = scanner.nextLine();
                    System.out.println("Ange författarens kön (m/f/n/a):");
                    char gender = scanner.next().charAt(0);
                    authors newAuthor = new authors(name, email, gender);
                    authors.add(newAuthor);
                    break;

                case 2:
                    System.out.println("Ange författarens namn för att ändra email:");
                    String authorName = scanner.nextLine();

                    for (authors author : authors) {
                        if (author.getName().equalsIgnoreCase(authorName)) {
                            System.out.println("Ange ny email:");
                            String newEmail = scanner.nextLine();
                            author.setEmail(newEmail);
                            System.out.println("Email ändrad!");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Ange författarens namn för att ändra kön:");
                    authorName = scanner.nextLine();

                    for (authors author : authors) {
                        if (author.getName().equalsIgnoreCase(authorName)) {
                            System.out.println("Ange nytt kön (m/f/n/a):");
                            char newGender = scanner.next().charAt(0);
                            author.setGender(newGender);
                            System.out.println("Kön ändrat!");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Alla författare:");
                    for (authors author : authors) {
                        System.out.println(author.toString());
                    }
                    break;

                case 5:
                    System.out.println("Avslutar programmet.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }
}