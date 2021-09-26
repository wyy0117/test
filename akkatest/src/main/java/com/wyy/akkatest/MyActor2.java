package com.wyy.akkatest;

import akka.actor.AbstractActor;

/**
 * @Date: 2021/9/22
 * @Author: wyy
 */
public class MyActor2 extends AbstractActor {

    private String name;

    public MyActor2(String name) {
        this.name = name;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, msg -> {
                    System.out.println(name + " received msg: " + msg);
                    getSender().tell("I am " + name, self());
                })
                .matchAny(msg -> {
                    System.out.println("unknown type msg: " + msg);
                }).build();
    }
}
