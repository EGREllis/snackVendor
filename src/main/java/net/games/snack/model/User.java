package net.games.snack.model;

public class User {
    public static final User NULL_USER = new User("", "") {
        @Override
        public boolean isNullUser() {
            return true;
        }
    };
    private final String username;
    private final String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean isNullUser() {
        return false;
    }

    @Override
    public String toString() {
        return "User("+username+")";
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof User) {
            User other = (User)obj;
            result = this.username.equals(other.username) && this.email.equals(other.email);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
