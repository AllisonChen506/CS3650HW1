package com.company;

import java.util.*;
public class VotingService extends Question {
    Random random = new Random();
    Question ask;
    int type;

    public VotingService() {
        this.ask = new Question();
        this.type = -1;
    }

    public VotingService(Question var1, int var2) {
        this.ask = var1;
        this.type = var2;
    }

    public Question getQuestion() {
        return this.ask;
    }

    public int getType() {
        return this.type;
    }

    public void setQuestion(Question var1) {
        this.ask = var1;
    }

    public void setType(int var1) {
        this.type = var1;
    }

    public void makeMCQuestion() {
        this.ask.randomMCQuestion();
    }

    public void makeTFQuestion()
    {
        this.ask.makeTrueFalseQuestion();
    }

    public void printMCQuestion() {
        this.ask.printMCStats();
    }

    public void printTFquestion()
    {
        this.ask.printTFStats();
    }
}
