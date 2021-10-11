package pl.carwebapp.model;

public class ChatMessage {

    private String type;
    private String content;
    private String sender;
    private String time;

    public ChatMessage() {
    }

    public ChatMessage(String type, String content, String sender, String time) {
        this.type = type;
        this.content = content;
        this.sender = sender;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
