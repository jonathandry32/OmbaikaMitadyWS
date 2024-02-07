package com.vehicule.api.services;

import com.vehicule.api.entity.Message;
import com.vehicule.api.entity.User;
import com.vehicule.api.repository.MessageRepository;
import com.vehicule.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

@Service
public class MessageService  {
    private final MessageRepository  messageRepository;
    private final UserRepository  userRepository;

    @Autowired
    public MessageService (MessageRepository messageRepository,UserRepository  userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
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
    
    public List<User> getUsersWithMessages(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new ArrayList<>();
        }
        List<Message> messages = messageRepository.findBySenderOrReceiveroui(userId);
        Set<User> uniqueUsers = new HashSet<>();

        for (Message message : messages) {
            if (!message.getSender().getId().equals(userId)) {
                uniqueUsers.add(message.getSender());
            }
            if (!message.getReceiver().getId().equals(userId)) {
                uniqueUsers.add(message.getReceiver());
            }
        }

        return new ArrayList<>(uniqueUsers);
    }
}
