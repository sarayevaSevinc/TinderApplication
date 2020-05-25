package MyProject.db;

import MyProject.entity.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageDb implements db<Message, String> {
    Connection sqlConnection;

    public MessageDb() {
        super();
        sqlConnection =SqlConnection.getConnection();
    }
    @Override
    public boolean add(Message message, String s) {
        try {
            PreparedStatement ps = sqlConnection.prepareStatement("Insert into "+ s+ " (sender_id, receiver_id, text, date) values(?,?,?,?)");
            ps.setInt(1,message.getSender_id());
            ps.setInt(2, message.getReveiver_id());
            ps.setString(3, message.getMessage());
            ps.setTimestamp(4, message.getDateTime2());
           return ps.execute();

        }
        catch (SQLException e){
            System.out.println("Problem Problem Problem");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Message> getOneByEmail(String username, String password) {
        return Optional.empty();
    }
public  List<Message> getAllMessageWithOnePerson(int sender_id, int receiver_id){
    List<Message> messages = new ArrayList<>();
        String sql = "Select * from messages where (sender_id=" + sender_id + " and receiver_id = " + receiver_id +
                ") or (receiver_id = " + sender_id + " and sender_id = " + receiver_id + ")";
        try {
            PreparedStatement ps = sqlConnection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                messages.add(new Message(resultSet.getInt("sender_id"),
                        resultSet.getInt("receiver_id"),
                        resultSet.getString("text"),
                        resultSet.getTimestamp("date")
                ));

        }} catch (SQLException ex){
            ex.printStackTrace();
        }
    return messages;
}

}
