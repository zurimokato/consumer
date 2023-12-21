package com.kafka.comsumer.controller;


import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Set;
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/")
    public Object health() {
        Set<String>listNames;
        AdminClient adminClient=null;
        try{
            adminClient = AdminClient.create(Collections.singletonMap("bootstrap.servers", "localhost:9092"));
            ListTopicsResult listTopicsResult = adminClient.listTopics();
            listNames=listTopicsResult.names().get();

        }catch (Exception e){
            e.printStackTrace();
            return e;
        }finally {
            if(adminClient!=null)
                adminClient.close();

        }

        // Iterate over the topics

        return listNames;
    }

    @GetMapping("/2")
    public String saludo(){
        return "HOLA";
    }

}
