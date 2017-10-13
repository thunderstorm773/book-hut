package bookHut.services.impl;

import bookHut.entities.User;
import bookHut.models.bindingModels.LoginModel;
import bookHut.repositories.impl.UserRepositoryImpl;
import bookHut.services.api.UserService;
import bookHut.utils.MapperUtil;

public class UserServiceImpl implements UserService {

    @Override
    public void createUser(LoginModel loginModel) {
        if (loginModel != null) {
            User user = MapperUtil.getInstance().getModelMapper()
                    .map(loginModel, User.class);
            UserRepositoryImpl.getInstance().createUser(user);
        }
    }

    @Override
    public LoginModel findByUsernameAndPassword(String username, String password) {
        User user = UserRepositoryImpl.getInstance()
                .findByUsernameAndPassword(username, password);
        LoginModel loginModel = null;
        if (user != null) {
            loginModel = MapperUtil.getInstance().getModelMapper()
                    .map(user, LoginModel.class);
        }

        return loginModel;
    }

    @Override
    public boolean isUserExists(String username) {
        return UserRepositoryImpl.getInstance().isUserExists(username);
    }
}
