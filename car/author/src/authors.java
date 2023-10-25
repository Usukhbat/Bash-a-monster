public class authors {
    private String name;
    private String email;
    private char gender;

    public authors(String name, String email, char gender) {
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
        this.email = email;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public String toString() {
        return name + " (" + gender + ") " + email;
    }
}
