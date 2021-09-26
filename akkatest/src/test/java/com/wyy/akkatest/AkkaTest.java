package com.wyy.akkatest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Date: 2021/9/22
 * @Author: wyy
 */
public class AkkaTest {

    @Test
    public void send() throws IOException {
        ActorSystem actorSystem = ActorSystem.create("system");
        ActorRef actor1Ref = actorSystem.actorOf(Props.create(MyActor1.class, "actor1"),"actor1");

        ActorRef actor2Ref = actorSystem.actorOf(Props.create(MyActor2.class, "actor2"),"actor2");
        actor1Ref.tell("hello word", actor2Ref);

        System.out.println();
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("main thread");
        ActorSystem actorSystem = ActorSystem.create("system");
        ActorRef actor1Ref = actorSystem.actorOf(Props.create(MyActor1.class, "actor1"),"actor1");

        ActorRef actor2Ref = actorSystem.actorOf(Props.create(MyActor2.class, "actor2"),"actor2");
        actor1Ref.tell("hello word", actor2Ref);

    }
}
