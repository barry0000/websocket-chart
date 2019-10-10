package com.learn.charts.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@MessageMapping("/rooms")
public class MessageController {

    @SendTo("/topic/hhh/{roomid}")
    @MessageMapping("/talk/{roomid}")
    public Map<String,Object> sendMessage(SimpMessageHeaderAccessor headerAccessor,Map<String,Object> messageMap){
        return messageMap;
    }
}
