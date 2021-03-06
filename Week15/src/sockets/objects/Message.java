package sockets.objects;

import java.io.Serializable;

public class Message implements Serializable {
    private String sender;
    private String payload;

    public Message(String sender, String payload) {
        this.sender = sender;
        this.payload = payload;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
