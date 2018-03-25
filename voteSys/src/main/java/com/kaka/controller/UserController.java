package com.kaka.controller;

import com.kaka.common.UtilCache;
import com.kaka.model.User;
import com.kaka.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
//注册
    @RequestMapping("register")
    public String register(){
        return "user/Register.jsp";
    }


    @RequestMapping("registerDo")
    public ModelAndView registerDo(String username,String password){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setType(1);
        userService.addUser(user);
        modelAndView.setViewName("user/LoginAfter.jsp");
        int userid = userService.getUserByUsername(username).getId();
        UtilCache.setUserid(userid);
        UtilCache.setUsername(username);
        modelAndView.addObject("userid",userid);
        modelAndView.addObject("username",username);
        return modelAndView;
    }

//登录
    @RequestMapping("login")
    public String login(){
        return "user/Login.jsp";
    }

    @RequestMapping("loginDo")
    public ModelAndView loginDo(String username,String password){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/Login.jsp");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean flag = userService.hasUser(user);
        if(flag){
            int userid = userService.getUserByUsername(username).getId();
            modelAndView.addObject("userid",userid);
            modelAndView.addObject("username",username);
            UtilCache.setUserid(userid);
            UtilCache.setUsername(username);
            modelAndView.setViewName("user/LoginAfter.jsp");
        }
        return modelAndView;
    }

//退出
    @RequestMapping("loginOut")
    public String loginOut(){
        UtilCache.setUserid(null);
        UtilCache.setUsername(null);
        return "home.jsp";
    }

//管理员请求
    //登录
    @RequestMapping("loginAdmin")
    public String loginAdmin(){
        return "admin/Login.jsp";
    }


    @RequestMapping("loginDoAdmin")
    public ModelAndView loginDoAdmin(String username,String password){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/Login.jsp");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean flag = userService.hasUser(user,0);
        if(flag){
            int userid = userService.getUserByUsername(username).getId();
            modelAndView.addObject("userid",userid);
            modelAndView.addObject("username",username);
            UtilCache.setUserid(userid);
            UtilCache.setUsername(username);
            modelAndView.setViewName("admin/LoginAfter.jsp");
        }
        return modelAndView;
    }


    //用户列表
    @RequestMapping("list")
    public ModelAndView list(String keyword){
        ModelAndView modelAndView = new ModelAndView();
        List<User> listAll = userService.getAllUser();
        modelAndView.addObject("list",listAll);
        if(keyword != null && keyword !=""){
            List<User> list = userService.getQueryUser(keyword);
            modelAndView.addObject("list",list);
        }
        modelAndView.setViewName("adminUserManage/UserList.jsp");
        return modelAndView;
    }

    //新增用户
    @RequestMapping("addUser")
    public String addUser(){
        return "adminUserManage/UserAdd.jsp";
    }


    @RequestMapping("addUserDo")
    public ModelAndView addUserDo(String username,String password){
        User user = new User(username,password);
        userService.addUser(user);
        ModelAndView modelAndView = new ModelAndView();
        List<User> list = userService.getAllUser();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("adminUserManage/UserList.jsp");
        return modelAndView;
    }

    //修改用户信息
    @RequestMapping("modifyUser")
    public ModelAndView modifyUser(int id){
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("adminUserManage/UserModify.jsp");
        return modelAndView;
    }

    @RequestMapping("modifyUserDo")
    public ModelAndView modifyUserDo(int id,String username,String password){
        User user = new User(username,password);
        user.setId(id);
        userService.updateUserById(user);
        ModelAndView modelAndView = new ModelAndView();
        List<User> list = userService.getAllUser();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("adminUserManage/UserList.jsp");
        return modelAndView;
    }

    //删除用户
    @RequestMapping("deleteUser")
    public ModelAndView  deleteUser(int id){
        userService.deleteUser(id);
        ModelAndView modelAndView = new ModelAndView();
        List<User> list = userService.getAllUser();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("adminUserManage/UserList.jsp");
        return modelAndView;
    }
}
