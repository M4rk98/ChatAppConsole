/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Diak
 */
public class User {
    
    private String email;
    private String name;
    private Set<Message> messages_received;
    private Set<Message> messages_sent;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
        this.messages_received = new HashSet<>();
        this.messages_sent = new HashSet<>();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    
    public Set<Message> getMessages_received() {
        return messages_received;
    }

    public void setMessages_received(Set<Message> messages_received) {
        this.messages_received = messages_received;
    }

    public Set<Message> getMessages_sent() {
        return messages_sent;
    }

    public void setMessages_sent(Set<Message> messages_sent) {
        this.messages_sent = messages_sent;
    }
    
    public void addMessageSent(Message message) {
        this.messages_sent.add(message);
    }
    
    public void addMessageReceived(Message message) {
        this.messages_received.add(message);
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", nev=" + name + ", messages_received=" + messages_received + ", messages_sent=" + messages_sent + '}';
    }
    
    
    
    
    
    
}
