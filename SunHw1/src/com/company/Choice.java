package com.company;

public class Choice {
    String selection;
    int counter;

    public Choice() {
        this.selection = null;
        this.counter = 0;
    }

    public Choice(String var1, int var2) {
        this.selection = var1;
        this.counter = var2;
    }

    public String getSelection() {
        return this.selection;
    }

    public int getCounter() {
        return this.counter;
    }

    public void add() {
        ++this.counter;
    }

    public void subtract() {
        --this.counter;
    }
}
