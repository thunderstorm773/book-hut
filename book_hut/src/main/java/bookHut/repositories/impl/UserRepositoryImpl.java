package bookHut.repositories.impl;

import bookHut.entities.User;
import bookHut.repositories.api.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepository userRepository;

    private List<User> users;

    private Long currentIndex;

    private UserRepositoryImpl() {
        this.users = new ArrayList<>();
        this.currentIndex = 1L;
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }

        return userRepository;
    }

    @Override
    public void createUser(User user) {
        user.setId(this.currentIndex);
        this.currentIndex = this.currentIndex + 1L;
        this.users.add(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        Optional<User> candidateUser = this.users.stream()
                .filter(u -> u.getUsername().equals(username) &&
                        u.getPassword().equals(password)).findAny();
        User user = null;
        if (candidateUser.isPresent()) {
            user = candidateUser.get();
        }

        return user;
    }

    @Override
    public boolean isUserExists(String username) {
        return this.users.stream()
                .anyMatch(u -> u.getUsername().equals(username));
    }
}
