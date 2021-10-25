package pl.carwebapp.model;

public class ChatMessage {

    private MessageType type;

    private String content;

    private String sender;

    private String time;

    public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getTime() {
        return time;
    }
}
