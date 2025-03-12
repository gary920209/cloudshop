package src.java.com.model;

public class User{
    private final String username;

    public User(String username) {
        this.username = username.toLowerCase(); // store as lowercase for case-insensitive comparison
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            return username.equals(((User) obj).getUsername());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}