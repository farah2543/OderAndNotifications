package com.example.demo.service.System.Notification;

import com.example.demo.model.UserAccount;
import com.example.demo.service.System.Message.Message;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationManager {
    public static Queue<Notification> notificationQueue = new LinkedList<>();
    public static void GetFirstNotification() {
        if (!notificationQueue .isEmpty()) {
            // front element in the queue
            notificationQueue .peek().send() ;
            // delete front element from queue
            notificationQueue .poll() ;
        }else {
//            System.out.println("There is no current messages to send");
        }
    }
}
