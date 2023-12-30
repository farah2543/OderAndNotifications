package com.example.demo.service.System.Notification;

import java.util.Timer;
import java.util.TimerTask;

public class notificationManager {
    notificationManager() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("This message will repeat every 2 seconds in Java.");
            }
        }, 0, 2000);
    }
}
