/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

/**
 *
 * @author Diak
 */
public class Message {
    
    private String text;
    private User sentBy;
    private User sentTo;

    public Message(String text, User sentBy, User sentTo) {
        this.text = text;
        this.sentBy = sentBy;
        this.sentTo = sentTo;
    }

    @Override
    public String toString() {
        return "Message{" + "text=" + text + ", sentBy=" + sentBy.getName() + ", sentTo=" + sentTo.getName() + '}';
        //TODO: better print
        /*
                return "Feladó: " + sentBy.getName() + "\n Címzett: " + sentTo.getName() + "\n Üzenet: " + text + " \n\n";

        */
    }

    public String getText() {
        return text;
    }
    
    
    
}
