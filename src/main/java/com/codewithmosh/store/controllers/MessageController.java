package com.codewithmosh.store.controllers;

import com.codewithmosh.store.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* carlpeters created on 02/05/2025 inside the package - com.codewithmosh.store.controllers */
@RestController
public class MessageController {
//    @RequestMapping("/message")
//    public String getMessage() {
//        return "Hello, this is a message from the server!";
//    }

    @RequestMapping("/message")
    public Message getMessage() {
        return new Message("Hello, this is a new message from the server!");
    }
}
