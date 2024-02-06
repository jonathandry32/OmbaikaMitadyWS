package com.vehicule.api.repository;

import com.vehicule.api.entity.Message;
import com.vehicule.api.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

    @Query("{$or: [ { 'sender._id': ?0, 'receiver._id': ?1 }, { 'sender._id': ?1, 'receiver._id': ?0 } ] }")
    List<Message> getMessageUserWith(Long userId1, Long userId2, Sort sort);
    
    @Query("{$or: [{'sender.id': ?0}, {'receiver.id': ?0}]}")
    List<Message> findBySenderOrReceiveroui(Long userId);
//    List<Message> findBySenderOrReceiver(User sender, User receiver);
}
