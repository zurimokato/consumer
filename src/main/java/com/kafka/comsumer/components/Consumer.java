package com.kafka.comsumer.components;

import com.google.gson.Gson;
import com.kafka.comsumer.dominio.Message;
import com.kafka.comsumer.repository.MessageRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class Consumer {

    private  final MessageRepository messageRepository;


    public Consumer(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @KafkaListener(topics = "my_topic", groupId = "my_group")
    public void consume(String message) {

        Gson gson = new Gson();
        Message messageObj = gson.fromJson(message, Message.class);
        if(messageObj != null){
            messageRepository.save(messageObj);
        }



    }
}
