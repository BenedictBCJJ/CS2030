public class NameCard {
    final private String name;
    final private String email;

    NameCard (String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" + name + ", " + email + "}";
    }
}
