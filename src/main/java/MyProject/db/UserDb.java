package MyProject.db;

import MyProject.entity.Like;
import MyProject.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDb implements db<User, String> {
    Connection sqlConnection;

    public UserDb() {
        super();
        sqlConnection =SqlConnection.getConnection();
    }

    @Override
    public boolean add(User user, String str) {
        try {
            PreparedStatement preparedStatement = sqlConnection.prepareStatement("Insert into " + str + " (username,gender, " +
                    "password," +
                    "email," +
                    "photo, position) values (?,?,?,?,?,?)");

            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getUrlPhoto());
            preparedStatement.setString(6, user.getPosition());
            return preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<User> getOneByEmail(String email, String password) {
        try {
            PreparedStatement preparedStatement = sqlConnection.prepareStatement("Select * from users where email =?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString("password").equals(password)) {
                    User user = new User(resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("gender"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            resultSet.getString("photo"),
                            resultSet.getString("position"));
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
    public List<User> getAll() throws SQLException {
        PreparedStatement preparedStatement = sqlConnection.prepareStatement("Select * from users");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> allUsers = new ArrayList<>();
        while (resultSet.next()) {
            int idx= resultSet.getInt("id");
            String username = resultSet.getString("username");
            String gender = resultSet.getString("gender");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String photo = resultSet.getString("photo");
            String position = resultSet.getString("position");
            allUsers.add(new User(idx,username, gender, password, email, photo, position));
        }
        return allUsers;
    }

    public List<User> getAllWithId(int id) throws SQLException {


        List<User> allUsers = new ArrayList<>();
        return allUsers.stream().filter(user -> user.getId() != id).collect(Collectors.toList());
    }
    public  List<User> getAllLikedOnes(int user_id) throws SQLException {
        String QUERY = "select distinct  u.*  from users u  where u.id  in(select liked_user_id from likes where user_id=" + user_id + ")";
        PreparedStatement stmt = sqlConnection.prepareStatement(QUERY);
        ResultSet outcome = stmt.executeQuery();
        List<User> users = new ArrayList<>();
        while (outcome.next()) {
            int id = outcome.getInt("id");
            String email = outcome.getString("email");
            String name = outcome.getString("username");
            String gender = outcome.getString("gender");
            String password = outcome.getString("password");
            String position = outcome.getString("position");
            String picture_url = outcome.getString("photo");
            users.add(new User(id,name, gender, password,email, picture_url, position));
        }
        return users;
    }

    public Optional<User> getUser(int id){
        String sql = "select * from users where id=" + id;
        try {
            PreparedStatement ps = sqlConnection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                User user = new User(rs.getInt("id"),
                      rs.getString("username"),
               rs.getString("gender"),
                rs.getString("password"),
                rs.getString("email"),
                 rs.getString("photo"),
                 rs.getString("position"));
                return  Optional.of(user);
            }

        } catch (SQLException ex){
            ex.printStackTrace();

        }
        return Optional.empty();
    }
    public  List<User> getUsersToDisplay(int user_id) throws SQLException {
        String QUERY = "select distinct  u.*  from users u  where" +
                " u.id not in(select liked_user_id from likes where user_id=" + user_id + ") and " +
                "u.id not in(select liked_user_id from dislikes where user_id="+user_id+" )and " +
                "u.id<>" + user_id;
        PreparedStatement stmt = sqlConnection.prepareStatement(QUERY);
        ResultSet outcome = stmt.executeQuery();
        List<User> users = new ArrayList<>();
        while (outcome.next()) {
            int id = outcome.getInt("id");
            String email = outcome.getString("email");
            String name = outcome.getString("username");
            String position = outcome.getString("position");
            String gender = outcome.getString("gender");
            String password = outcome.getString("password");
            String picture_url = outcome.getString("photo");
            users.add(new User(id, name, gender, password,email, picture_url, position));
        }
        return users;
    }

    }

