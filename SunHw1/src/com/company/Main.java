package com.company;

public class Main extends VotingService{

    public Main() {
    }

    public static void main(String[] var0) {
        VotingService var1 = new VotingService();
        //multiple choice question
        System.out.println("Multiple Choice");
        var1.makeMCQuestion();
        var1.printMCQuestion();
        System.out.println("");
        //true/false question
        System.out.println("True/False Choice");
        var1.makeTFQuestion();
        var1.printTFquestion();
    }
}
