package com.example.demo.service.System.Notification;
import java.util.*;

import com.example.demo.service.System.Message.Message;
import com.example.demo.service.System.Message.Template_lang;
import javafx.util.Pair;
public class NotificationManager {
    PriorityQueue<Pair<Integer , String>> TopMailNotified ;
    PriorityQueue<Pair<Integer , String>> TopMobil ;
    PriorityQueue<Pair<Integer , Message>> TopTemplate ;
    HashMap<String , Integer> MailFrequency = new HashMap<>() , MobilFrequency = new HashMap<>() , TemplateFrequency = new HashMap<>();
    public static Queue<Notification> notificationQueue = new LinkedList<>();
    public static void GetFirstNotification() {
        if (!notificationQueue .isEmpty()) {
            // front element in the queue
            notificationQueue .peek().send() ;
            // delete front element from queue
            notificationQueue .poll() ;
        }
    }

}
