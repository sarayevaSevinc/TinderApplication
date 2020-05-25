package MyProject.service;
import MyProject.db.MessageDb;
import MyProject.entity.Message;

import java.util.Comparator;
import java.util.List;

public class MessageService {

    private final MessageDb db;


    public MessageService() {

        this.db = new MessageDb();

    }

    public boolean addMessage(int sender_id, int receiver_id, String text){
       Message message = new Message(sender_id, receiver_id, text);
       return this.db.add(message, "messages");
    }

    public List<Message> getMessageWithOnePerson(int sender_id, int receiver_id) {
        List<Message> allMessageWithOnePerson = db.getAllMessageWithOnePerson(sender_id, receiver_id);
        Comparator <Message> comparator = (o1, o2) -> o1.getDateTime().compareTo(o2.getDateTime());
        allMessageWithOnePerson.stream().sorted(comparator);
        return allMessageWithOnePerson;

    }



}
