package com.kafka.comsumer.dominio;


import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Message {

    @Id
    private ObjectId _id;

    private String message;
    private String consumer;

}
