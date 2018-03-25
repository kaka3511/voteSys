package com.kaka.controller;

import com.kaka.model.Notice;
import com.kaka.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        List<Notice> list = noticeService.getAllNotice();
        for(Notice notice:list){
            String originContent = notice.getContent();
            if(originContent.length() > 5){
                String tempContent = originContent.substring(0,6);
                tempContent +="......";
                notice.setContent(tempContent);
            }
        }
        modelAndView.addObject("list",list);
        modelAndView.setViewName("notice/PublicNotice.jsp");
        return modelAndView;
    }

    @RequestMapping("detail")
    public ModelAndView detail(int id){
        ModelAndView modelAndView = new ModelAndView();
        Notice notice = noticeService.getNoticeById(id);
        modelAndView.addObject("notice",notice);
        modelAndView.setViewName("notice/NoticeDetail.jsp");
        return modelAndView;
    }

    //管理员操作
    @RequestMapping("list")
    public ModelAndView list(String keyword){
        ModelAndView modelAndView = new ModelAndView();
        List<Notice> list = noticeService.getAllNotice();
        modelAndView.addObject("list",list);
        if(keyword != null && keyword != ""){
            List<Notice> listQuery = noticeService.getQueryNotice(keyword);
            modelAndView.addObject("list",listQuery);
        }
        modelAndView.setViewName("AdminNoticeManage/NoticeList.jsp");
        return modelAndView;
    }

    @RequestMapping("addNotice")
    public String addNotice(){
        return "AdminNoticeManage/NoticeAdd.jsp";
    }

    @RequestMapping("addNoticeDo")
    public ModelAndView addNoticeDo(String title,String content){
        ModelAndView modelAndView = new ModelAndView();
        Notice notice = new Notice(title,content);
        noticeService.addNotice(notice);
        List<Notice> list = noticeService.getAllNotice();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("AdminNoticeManage/NoticeList.jsp");
        return modelAndView;
    }

    @RequestMapping("modifyNotice")
    public ModelAndView modifyNotice(int id){
        Notice notice = noticeService.getNoticeById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("notice",notice);
        modelAndView.setViewName("AdminNoticeManage/NoticeModify.jsp");
        return modelAndView;
    }

    @RequestMapping("modifyNoticeDo")
    public ModelAndView modifyNoticeDo(int id,String title,String content){
        Notice notice = new Notice(title,content);
        notice.setId(id);
        noticeService.updateNotice(notice);
        ModelAndView modelAndView = new ModelAndView();
        List<Notice> list = noticeService.getAllNotice();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("AdminNoticeManage/NoticeList.jsp");
        return modelAndView;
    }

    @RequestMapping("deleteNotice")
    public ModelAndView deleteNotice(int id){
        noticeService.deleteNotice(id);
        ModelAndView modelAndView = new ModelAndView();
        List<Notice> list = noticeService.getAllNotice();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("AdminNoticeManage/NoticeList.jsp");
        return modelAndView;
    }


}
