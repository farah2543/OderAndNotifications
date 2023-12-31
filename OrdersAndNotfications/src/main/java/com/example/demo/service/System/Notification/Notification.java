package com.example.demo.service.System.Notification;

import com.example.demo.service.System.Message.Message;

public abstract class Notification {
    Message message ;
    Notification(Message message) {
        this.message = message ;
    }
    public abstract void send () ;
}
