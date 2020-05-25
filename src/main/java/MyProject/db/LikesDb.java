package MyProject.db;

import MyProject.entity.Like;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class LikesDb implements db<Like, String> {
    Connection sqlConnection;

    public LikesDb() {
        sqlConnection =SqlConnection.getConnection();
    }


    @Override
    public boolean add(Like like, String str) {
        try {
            PreparedStatement ps = sqlConnection.prepareStatement("Insert into "+ str+ " (user_id ,liked_user_id) values (?, ?) ");
         ps.setInt(1, like.getUserfrom());
         ps.setInt(2, like.getUserto());
         return ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Like> getOneByEmail(String username, String password) {
        return Optional.empty();
    }
}
