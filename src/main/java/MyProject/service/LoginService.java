package MyProject.service;

import MyProject.db.UserDb;
import MyProject.entity.User;

import java.util.Optional;

public class LoginService {
    private final UserDb userDb;

    public LoginService() {
        userDb = new UserDb();
    }

    public Optional<User> checkUser(String email, String password) {
        return userDb.getOneByEmail(email, password);
    }
    public Optional<User> getUser(int id) {
        return userDb.getUser(id);
    }

    public boolean isUserValid(String email, String password) {
        return  checkUser(email, password).isPresent();
    }
}