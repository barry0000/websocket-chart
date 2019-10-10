package com.learn.charts.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/single/{roomid}")
    public ModelAndView showMessage(@PathVariable String roomid, HttpSession session){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("roomid",roomid);
        simpMessagingTemplate.convertAndSend("/topic/newPerson/"+roomid,"游客"+session.getId()+"加入了群聊");
        return new ModelAndView("/aaa",resultMap);
    }
}
