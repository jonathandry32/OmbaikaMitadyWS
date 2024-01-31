package com.vehicule.api.services;

import com.vehicule.api.entity.Message;
import com.vehicule.api.entity.User;
import com.vehicule.api.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService  {
    private final MessageRepository  messageRepository;

    @Autowired
    public MessageService (MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message sendMessage(User sender, User receiver, String messageText) {
        LocalDateTime currentDate = LocalDateTime.now();
        Message message = new Message(sender, receiver, messageText, currentDate);
        return messageRepository.save(message);
    }
    
    public List<Message> getMessageWith(Long userId1, Long userId2) {
        Sort sortByDateAsc = Sort.by(Sort.Order.asc("date"));
        return messageRepository.getMessageUserWith(userId1, userId2, sortByDateAsc);
    }
}
