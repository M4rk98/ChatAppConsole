/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Diak
 */
public class ChatApp {

    /**
     * @param args the command line arguments
     */
    
    private static Map<String, User> users = new TreeMap<>();
    private static User user;
    
    public static void main(String[] args) {
        
        // TESZT Adatok (törölhető)
        
        User user1 = new User("Mark", "m4rk.gangel@gmail.com");
        User user2 = new User("Guest", "guest@gmail.com");
        
        Message message1 = new Message("Hello", user1, user2);
        
        Set<Message> messages = new HashSet<Message>();
        messages.add(message1);
        
        user1.setMessages_sent(messages);
        user2.setMessages_received(messages);
        
        users.put("m4rk.gangel@gmail.com", user1);
        users.put("guest@gmail.com", user2);
        
        System.out.println(users);
        
        // TESZT Adatok vége
        
        
        // Bekérés
        login();
        listMessagesByUser(user);

        Scanner sc = new Scanner(System.in);
        int muvelet;
        
        do {
            
            System.out.println("");
            System.out.println("Műveletek: \n [0] Új üzenet \n [1] Üzenetek listázása \n [2] Kilépés \n [3] Átjelentkezés");
            System.out.print("Művelet: ");
            muvelet = Integer.parseInt(sc.nextLine());

            switch(muvelet){
                case 0:
                    System.out.println("Új üzenet hozzáadás");
                    System.out.println("Címzett:");
                    String cimzett = sc.nextLine();

                    System.out.println("Üzenet szövege: ");
                    String uzenet = sc.nextLine();

                    System.out.println("Címzett: " + cimzett);
                    System.out.println("Üzenet: " + uzenet);

                    User u_cimzett = users.get(cimzett);

                    Message message = new Message(uzenet, user, u_cimzett);
                    u_cimzett.addMessageReceived(message);
                    user.addMessageSent(message);

                    break;
                case 2:
                    System.out.println("Kiléptél!");
                    break;
                case 1:
                    System.out.println("Üzenetek listázása");
                    listMessagesByUser(user);

                    break;
                case 3:
                    System.out.println("Átjelentkezés");
                    login();
                    listMessagesByUser(user);
            }
            
        } while(muvelet != 2);
        
    }
    
    public static void listMessagesByUser(User user)
    {
        System.out.println("");
        System.out.println("Elküldött üzenetek: ");
        System.out.println(user.getMessages_sent());
        
        System.out.println("");
        System.out.println("Fogadott üzenetek: ");
        System.out.println(user.getMessages_received());
    }
    
    public static void login()
    {
        
        do {
            System.out.print("Add meg az email címed: ");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();

            user = users.get(email);
            
            if(user == null) {
                System.out.println("Nincs ilyen felhasználó!");
            }
            
        } while(user == null);
        
    }
        
}
