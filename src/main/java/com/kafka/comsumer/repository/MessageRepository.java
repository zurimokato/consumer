package com.kafka.comsumer.repository;

import com.kafka.comsumer.dominio.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, String> {
}
