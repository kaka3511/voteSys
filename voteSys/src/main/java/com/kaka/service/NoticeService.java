package com.kaka.service;

import com.kaka.dao.NoticeMapper;
import com.kaka.model.Notice;
import com.kaka.model.NoticeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    public List<Notice> getAllNotice(){
        List<Notice> list = noticeMapper.selectByExample(new NoticeExample());
        return list;
    }

    public Notice getNoticeById(int id){
        Notice notice = noticeMapper.selectByPrimaryKey(id);
        return notice;
    }
    public List<Notice> getQueryNotice(String keyword){
        NoticeExample example = new NoticeExample();
        example.createCriteria().andTitleLike("%"+keyword+"%");
        List<Notice> list = noticeMapper.selectByExample(example);
        return list;
    }

    public void addNotice(Notice notice){
        noticeMapper.insert(notice);
    }

    public void updateNotice(Notice notice){
        noticeMapper.updateByPrimaryKey(notice);
    }

    public void deleteNotice(int id){
        noticeMapper.deleteByPrimaryKey(id);
    }
}
