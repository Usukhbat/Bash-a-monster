import java.util.Scanner;
public class authors {
    String name;
    String email;
    char gender;

    authors(String name, String email, char gender) {
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

    public void setEmail(String email) {
        author.email = email;
    }

    public static char setGender(String genderChoice) {
        if (genderChoice.equalsIgnoreCase("m")){
            char gender = 'm';
        }
        if (genderChoice.equalsIgnoreCase("f")){
            char gender = 'f';
        }
        return gender;
    }

    public String toString() {
        System.out.println(author.name + " (" + author.gender + ") " + author.email);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, enter your name to begin: ");
        String name = scan.nextLine();
        System.out.println("Choose your gender, [M] Male or [F] Female: ");
        String genderChoice = scan.nextLine();
        char gender = setGender(genderChoice);
        System.out.println("Next, write your email: ");
        String email = scan.nextLine();
        authors author = new authors(name, email, gender);
    }
}
