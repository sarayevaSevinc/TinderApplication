package MyProject.service;

import MyProject.db.UserDb;
import MyProject.entity.User;

import java.sql.SQLException;
import java.util.List;

public class RegisterService {
    private final String NAME="users";
    UserDb userDb ;

    public RegisterService() {
        this.userDb = new UserDb();
    }

    public String register(User u) throws SQLException {

        List<User> users = userDb.getAll();
        if (users.stream().anyMatch(user -> user.getEmail().equals(u.getEmail()))) {
            return "<label class=\"warning\">This email has already used!</label>\n";
        } else {
            userDb.add(u, NAME);
            return "<label class=\"success\">Successfully registered!</label>\n";
        }
    }
    }
