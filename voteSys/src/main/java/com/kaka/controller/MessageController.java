package com.kaka.controller;

import com.kaka.common.UtilCache;
import com.kaka.model.Message;
import com.kaka.model.MessageAndUser;
import com.kaka.model.User;
import com.kaka.service.MessageService;
import com.kaka.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("message")
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    private ModelAndView getListModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        List<Message> listMessage = messageService.getAllMessage();
        List<MessageAndUser> list  = new ArrayList<>();
        for(Message message:listMessage){
            MessageAndUser messageAndUser = new MessageAndUser();
            User user = userService.getUserById(message.getUserid());
            BeanUtils.copyProperties(message,messageAndUser);
            messageAndUser.setUser(user);
            list.add(messageAndUser);
        }

        modelAndView.setViewName("message/List.jsp");
        modelAndView.addObject("list",list);
        if(UtilCache.getUserid()!=null){
            modelAndView.addObject("userid",UtilCache.getUserid());
        }
        return modelAndView;
    }

    @RequestMapping("index")
    public ModelAndView index(){
       return getListModelAndView();
    }

    @RequestMapping("comment")
    public ModelAndView comment(String content){
        messageService.comment(content);
        return getListModelAndView();
    }

    //管理员操作
    @RequestMapping("list")
    public ModelAndView list(String keyword){
        ModelAndView modelAndView = new ModelAndView();
        List<Message> list = messageService.getAllMessage();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("AdminMessageManage/MessageList.jsp");
        if(keyword != null && keyword != ""){
            List<Message> listQuery = messageService.getQueryMessage(keyword);
            modelAndView.addObject("list",listQuery);
        }
        return modelAndView;
    }

    @RequestMapping("modifyMessage")
    public ModelAndView modifyMessage(int id){
        Message message = messageService.getMessageById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",message);
        modelAndView.setViewName("AdminMessageManage/MessageModify.jsp");
        return modelAndView;
    }

    @RequestMapping("modifyMessageDo")
    public ModelAndView modifyMessageDo(int id,String content){
        Message message = new Message(content);
        message.setId(id);
        messageService.updateMessage(message);
        ModelAndView modelAndView = new ModelAndView();
        List<Message> list = messageService.getAllMessage();
        modelAndView.setViewName("AdminMessageManage/MessageList.jsp");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @RequestMapping("deleteMessage")
    public ModelAndView deleteMessage(int id){
        messageService.deleteMessage(id);
        ModelAndView modelAndView = new ModelAndView();
        List<Message> list = messageService.getAllMessage();
        modelAndView.setViewName("AdminMessageManage/MessageList.jsp");
        modelAndView.addObject("list",list);
        return modelAndView;
    }



}
