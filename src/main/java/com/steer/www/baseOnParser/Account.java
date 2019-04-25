package com.steer.www.baseOnParser;

import java.util.ArrayList;
import java.util.List;

public class Account {


    private String name;
    private int footballCount;
    private Friend friend;
    private List<Ball> balls;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFootballCount(int footballCount) {
        this.footballCount = footballCount;
    }

    public void addFriend(Friend friend) {
        this.friend = friend;
    }

    public void addBall(Ball ball) {
        if (this.balls == null){
            this.balls = new ArrayList<Ball>();
        }
        this.balls.add(ball);
    }

    public int getFootballCount() {
        return footballCount;
    }

    public Friend getFriend() {
        return friend;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public static void read(){
        System.out.println("i am read !!");
    }
}