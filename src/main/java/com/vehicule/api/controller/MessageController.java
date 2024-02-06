package com.vehicule.api.controller;

import com.vehicule.api.entity.Message;
import com.vehicule.api.entity.User;
import com.vehicule.api.repository.MessageRepository;
import com.vehicule.api.repository.UserRepository;
import com.vehicule.api.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.bson.types.ObjectId;
import java.util.Optional;

@RestController
public class MessageController {
    private final MessageService messageService;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    
    @Autowired
    public MessageController(MessageService messageService, MessageRepository messageRepository,UserRepository userRepository){
        this.messageService = messageService;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/messages")
    public List<Message> getMessage(Long me,Long other) {
        return messageService.getMessageWith(me, other);
    }
    
    @GetMapping("/messages/users")
    public List<User> getMessages(Long me) {
        return messageService.getUsersWithMessages(me);
    }

    @PostMapping("/message/{me}/{other}")
    public Message sendMessage(@PathVariable Long me,@PathVariable Long other,String messages){
        User userme = userRepository.findById(me).get();
        User userother = userRepository.findById(other).get();
        return messageService.sendMessage(userme,userother,messages);
    }
}
