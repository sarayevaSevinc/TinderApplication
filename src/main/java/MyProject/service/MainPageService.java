package MyProject.service;

import MyProject.db.UserDb;
import MyProject.entity.User;

import java.sql.SQLException;
import java.util.List;

public class MainPageService {
    private final UserDb userDb;


    public MainPageService() {
        userDb = new UserDb();
    }

    public  List<User> allUsersExceptLikedDislikedOnes(int id) throws SQLException {
        return userDb.getUsersToDisplay(id);
    }
    public  List<User> all(int id) throws SQLException {
        return userDb.getAllWithId(id);
    }
    public  List<User> allLikedOnes(int id) throws SQLException {
        return userDb.getAllLikedOnes(id);
    }
}
