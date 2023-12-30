package com.example.demo.service.System.Authentication;

import com.example.demo.model.Account;

abstract public class Authorization {
    public abstract void signUp (Account account) ;
    public abstract void signIn (Account account) ;
}
