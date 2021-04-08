package net.games.snack.model.repository;

import net.games.snack.model.User;
import net.games.snack.model.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class HardCodedUserRepository implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public HardCodedUserRepository() {
        users.put("sam.truscott", new User("sam.truscott", "sam.truscott@ig.com"));
        users.put("will.lahr", new User("will.lahr", "wolahr@lahrtowers.co.uk"));
        users.put("tom.hunt", new User("tom.hunt", "tom@hunt.com"));
    }

    @Override
    public User login(String username) {
        User user = users.get(username);
        if (user == null) {
            user = User.NULL_USER;
        }
        return user;
    }
}
