package Java_DesignPatterns.BuilderPattern;

import java.util.*;

class User{

    private String id;
    private String name;
    private Boolean graduated;
    private Boolean gotJob;

    private User(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.graduated = builder.graduated;
        this.gotJob = builder.gotJob;

    }

    void show(){
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("Graduated: " + graduated);
        System.out.println("Got The Job: " + gotJob);
    }

    static class Builder{
        private String id;
        private String name;
        private Boolean graduated;
        private Boolean gotJob;

        Builder(String name){
            this.name = name;
        }

        Builder id(String id){
            this.id = id;
            return this;
        }

        Builder graduated(boolean ans){
            this.graduated = ans;
            return this;
        }


        Builder gotJob(boolean ans){
            this.gotJob = ans;
            return this;
        }

        User build(){
            return new User(this);
        }
    }
}


public class UserMain {
    public static void main(String[] args) {

        User user = new User.Builder("Mihir")
                .id("RA2311029010046")
                .graduated(true)
                .gotJob(true)
                .build();

        user.show();
    }
}