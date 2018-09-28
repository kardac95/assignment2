package main;

import message.Message;
import protobuf.MessageProtoBuf;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Message m = new Message(
                "123",
                "kalle",
                "kalle's greatness",
                "yoyoyoyoyoyoyoyoyo",
                "kalle is the greatest");

        //MessageProtoBuf.Message message = MessageProtoBuf.Message.newBuilder(m).build();

        //System.out.println(message.getAttachments());

        MessageProtoBuf.Message message =
                MessageProtoBuf.Message.newBuilder()
                        .setId("123")
                        .setSender("kalle")
                        .setTopic("kalle's greatness")
                        .setContent("yoyoyoyoyoyoyoyoyo")
                        .setAttachments("kalle is the greatest")
                        .setTimestamp(new Date().getTime())
                        .build();

        System.out.println(message.getAttachments());


    }
}
