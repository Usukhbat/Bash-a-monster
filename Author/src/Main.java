import java.util.Scanner;
class Author {
private String name;
private String email;
private char gender;
Author(String name, String email, char gender){
    this.name = name;
    this.email = email;
    this.gender = gender;
}
}
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scan.nextLine();
        System.out.println("Email: ");
        String email = scan.nextLine();
        System.out.println("Gender: ");
        char gender = scan.next();
        Author person = new Author(name, email, gender);

    }
}