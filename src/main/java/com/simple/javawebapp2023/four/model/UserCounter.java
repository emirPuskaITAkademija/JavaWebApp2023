package com.simple.javawebapp2023.four.model;

public class UserCounter {
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
