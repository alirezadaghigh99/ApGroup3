package Model.USER.network_models;

import java.io.Serializable;

public class Message implements Serializable {
    private String text;
    private String from;

    public String getText() {
        return text;
    }

    public String getFrom() {
        return from;
    }


    public Message(String text, String from) {
        this.text = text;
        this.from = from;
    }

    @Override
    public String toString() {
        return from + " : " + text;
    }
}
