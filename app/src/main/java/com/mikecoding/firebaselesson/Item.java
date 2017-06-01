package com.mikecoding.firebaselesson;


public class Item {
    String name;
    boolean done;

    public Item() {}

    public Item(String name, boolean done) {
        this.name = name;
        this.done = done;
    }
    public void switchDone(){
        done = !done;
    }
}
