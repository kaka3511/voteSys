package com.kaka.service;

import com.kaka.common.UtilCache;
import com.kaka.dao.MessageMapper;
import com.kaka.model.Message;
import com.kaka.model.MessageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public List<Message> getAllMessage(){
        return messageMapper.selectByExample(new MessageExample());
    }

    public void comment(String content){
        Message message = new Message();
        message.setDate(new Date());
        message.setUserid(UtilCache.getUserid());
        message.setContent(content);
        messageMapper.insert(message);
    }

    public Message getMessageById(int id){
        return messageMapper.selectByPrimaryKey(id);
    }

    public void updateMessage(Message message){
        messageMapper.updateByPrimaryKey(message);
    }

    public List<Message> getQueryMessage(String keyword){
        MessageExample example = new MessageExample();
        example.createCriteria().andContentLike("%"+keyword+"%");
        return messageMapper.selectByExample(example);
    }
    public void deleteMessage(int id){
        messageMapper.deleteByPrimaryKey(id);
    }

}
