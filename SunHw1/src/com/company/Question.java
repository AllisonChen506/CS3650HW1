package com.company;


import java.util.ArrayList;
import java.util.Random;

public class Question extends Student {
    Random random = new Random();
    ArrayList<Student> listStudent;
    ArrayList<Choice> allChoice;

    public Question(){
        this.listStudent = new ArrayList<Student>();
        this.allChoice = new ArrayList<Choice>();
    }

    public Question(ArrayList<Student> listS, ArrayList<Choice> listA){
        this.listStudent = listS;
        this.allChoice = listA;
    }

    public ArrayList<Student> getStudentList(){
        return this.listStudent;
    }

    public ArrayList<Choice> getAllChoice(){
        return this.allChoice;
    }

    public void randomMCQuestion(){
        //every multiple choice question has 4 options
        String[] options = {"A", "B", "C", "D"};
        int count = 0;
        int rng = random.nextInt(4);
        //random generate answers into the list
        Choice temp = new Choice(options[rng], 0);
        this.allChoice.add(temp);
        while(count != 3){
            rng = random.nextInt(4);
            temp = new Choice(options[rng], 0);
            for(int i = 0; i < this.allChoice.size(); i++){
                boolean found = false;
                for(int j = 0; j < this.allChoice.size(); j++){
                    if(this.allChoice.get(j).getSelection() == temp.getSelection()){
                        found = true;
                    }
                }
                if(found){
                    break;
                }
                else{
                    this.allChoice.add(temp);
                    count++;
                }
            }
        }
        int students = random.nextInt(100);
        count = 0;
        Choice hold = this.allChoice.get(random.nextInt(4));
        Student tempS = new Student(this.randomString(), hold);
        this.listStudent.add(tempS);
        hold.add();
        while(count != students){
            hold = this.allChoice.get(random.nextInt(4));
            tempS = new Student(this.randomString(), hold);
            for(int i = 0; i < this.listStudent.size(); i++){
                boolean found = false;
                //this checks to see if the student has answered before
                for(int j = 0; j < this.listStudent.size(); j++){
                    if(this.listStudent.get(j).getID().equals(tempS.getID())){
                        found = true;
                    }
                    //if the student with same id is found then need to make sure the math is still correct
                    if(found){
                        Choice grab = this.listStudent.get(j).changeAns(tempS.getAns());
                        hold.add();
                        grab.subtract();
                        break;
                    }
                }
                if(!found){
                    this.listStudent.add(tempS);
                    hold.add();
                    count++;
                }
            }
        }
        return;
    }

    public void printMCStats(){
        for(int i = 0; i < 4; i++){
            Choice temp = this.allChoice.get(i);
            System.out.println(temp.getSelection() +":"+ temp.getCounter());
        }
    }

    public String randomString(){
        //this generates the student ID, instead of using UUID
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int length = 12;
        for(int i = 0; i < length; i++)
        {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            stringBuilder.append(randomChar);
        }
        String randomString = stringBuilder.toString();
        return randomString;
    }

    //using the same logic as mc question, tf questions was made
    public void makeTrueFalseQuestion()
    {
        allChoice.clear();
        String[] options = {"True", "False"};
        int count = 0;
        int rng = random.nextInt(2);
        Choice temp = new Choice(options[rng], 0);
        this.allChoice.add(temp);
        while(count != 2){
            rng = random.nextInt(2);
            temp = new Choice(options[rng], 0);
            //
            for(int i = 0; i < this.allChoice.size(); i++){
                boolean found = false;
                if(this.allChoice.get(i).getSelection() == temp.getSelection()){
                        found = true;
                }
                if(found){
                    break;
                }
                else{
                    this.allChoice.add(temp);
                    count++;
                }
            }
        }
        int students = random.nextInt(100);
        count = 0;
        Choice hold = this.allChoice.get(random.nextInt(2));
        Student tempS = new Student(this.randomString(), hold);
        this.listStudent.add(tempS);
        hold.add();
        while(count != students){
            hold = this.allChoice.get(random.nextInt(2));
            tempS = new Student(this.randomString(), hold);
            for(int i = 0; i < this.listStudent.size(); i++){
                boolean found = false;
                for(int j = 0; j < this.listStudent.size(); j++){
                    if(this.listStudent.get(j).getID().equals(tempS.getID())){
                        found = true;
                    }
                    if(found){
                        Choice grab = this.listStudent.get(j).changeAns(tempS.getAns());
                        hold.add();
                        grab.subtract();
                        break;
                    }
                }
                if(!found){
                    this.listStudent.add(tempS);
                    hold.add();
                    count++;
                }
            }
        }
        return;

    }

    public void printTFStats(){
        for(int i = 0; i < 2; i++){
            Choice temp = this.allChoice.get(i);
            System.out.println(temp.getSelection() +":"+ temp.getCounter());
        }
    }


}
