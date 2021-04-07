package net.games.snack.model.repository;

import net.games.snack.model.User;
import net.games.snack.model.UserRepository;
import org.junit.Before;
import org.junit.Test;

public class HardCodedRepositoryTest {
    private UserRepository userRepository;

    @Before
    public void setup() {
        userRepository = new HardCodedUserRepository();
    }

    @Test
    public void when_userIsRegistered_then_userIsReturned() {
        User user = userRepository.login("tom.hunt");
        assert !user.isNullUser() && user.getUsername().equals("tom.hunt");
    }

    @Test
    public void when_userIsNotRegistered_then_nullUserIsReturned() {
        User user = userRepository.login("doesNotExist");
        assert user.isNullUser();
    }
}
