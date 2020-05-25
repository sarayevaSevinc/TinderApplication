package MyProject.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private  int id;
    private   int sender_id;
    private  int reveiver_id;
    private  String message;
    private Timestamp dateTime;

    public Message(int sender_id, int reveiver_id, String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.sender_id = sender_id;
        this.reveiver_id = reveiver_id;
        this.message = message;
        this.dateTime =Timestamp.valueOf(LocalDateTime.now());
    }
    public Message(int sender_id, int reveiver_id, String message, Timestamp dateTime) {
        this.sender_id = sender_id;
        this.reveiver_id = reveiver_id;
        this.message = message;
        this.dateTime = dateTime;
    }
    public int getId() {
        return id;
    }
    public int getSender_id() {
        return sender_id;
    }

    public int getReveiver_id() {
        return reveiver_id;
    }

    public String getMessage() {
        return message;
    }

    public Timestamp getDateTime2() {
        return dateTime;
    }

    public String getDateTime() {
        return dateTime.toString();
    }
}
