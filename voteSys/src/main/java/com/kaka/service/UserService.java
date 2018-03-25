package com.kaka.service;

import com.kaka.dao.UserMapper;
import com.kaka.model.User;
import com.kaka.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserById(int id){
        return userMapper.selectByPrimaryKey(id);
    }

    public void addUser(User user){
        userMapper.insert(user);
    }

    public User getUserByUsername(String username){
        User user = new User();
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        user = userMapper.selectByExample(example).get(0);
        return user;
    }

    public boolean hasUser(User user){
        boolean flag = false;
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername())
                .andPasswordEqualTo(user.getPassword());
        int size = userMapper.selectByExample(example).size();
        if(size > 0)
            flag = true;
        return flag;
    }

    public List<User> getAllUser(){
        return userMapper.selectByExample(new UserExample());
    }

    public boolean hasUser(User user,int type){
        boolean flag = false;
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername())
                .andPasswordEqualTo(user.getPassword()).andTypeEqualTo(type);
        int size = userMapper.selectByExample(example).size();
        if(size > 0)
            flag = true;
        return flag;
    }

    public List<User> getQueryUser(String keyword){
        UserExample example = new UserExample();
        if(keyword != null)
            example.createCriteria().andUsernameLike("%"+keyword+"%");
        return userMapper.selectByExample(example);
    }

    public void updateUserById(User user){
        userMapper.updateByPrimaryKey(user);
    }

    public void deleteUser(int id){
        userMapper.deleteByPrimaryKey(id);
    }
}
