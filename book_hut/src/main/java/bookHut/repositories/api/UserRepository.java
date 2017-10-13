package bookHut.repositories.api;

import bookHut.entities.User;

public interface UserRepository {

    void createUser(User user);

    User findByUsernameAndPassword(String username, String password);

    boolean isUserExists(String username);
}
