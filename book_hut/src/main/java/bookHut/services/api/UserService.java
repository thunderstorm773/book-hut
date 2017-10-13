package bookHut.services.api;

import bookHut.models.bindingModels.LoginModel;

public interface UserService {

    void createUser(LoginModel loginModel);

    LoginModel findByUsernameAndPassword(String username, String password);

    boolean isUserExists(String username);
}
