package net.games.snack.model;

// Domain Driven Design (Eric Evans)
public interface UserRepository {
    User login(String username);
}
