package com.kaka.controller;

import com.kaka.common.UtilCache;
import com.kaka.model.Vote;
import com.kaka.model.VoteAndSub;
import com.kaka.model.Votesub;
import com.kaka.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("vote")
@Controller
public class VoteController {
    @Autowired
    private VoteService voteService;

    private ModelAndView getListModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        List<VoteAndSub> list = voteService.getAllVote();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("vote/List.jsp");
        if(UtilCache.getUserid()!=null){
            modelAndView.addObject("userid",UtilCache.getUserid());
        }
        return modelAndView;
    }

    @RequestMapping("index")
    public ModelAndView index(){
        return getListModelAndView();
    }

    @RequestMapping("detail")
    public ModelAndView detail(int id){
        ModelAndView modelAndView = new ModelAndView();
        VoteAndSub voteAndSub = voteService.getOneVote(id);
        modelAndView.addObject("voteAndSub",voteAndSub);
        modelAndView.setViewName("vote/Detail.jsp");
        if(UtilCache.getUserid()!=null){
            modelAndView.addObject("userid",UtilCache.getUserid());
        }
        return modelAndView;
    }

    @RequestMapping("addVote")
    public ModelAndView addVote(int voteid,int subid){
        voteService.addVote(voteid,subid);

        return getListModelAndView();
    }

    //管理员操作
    @RequestMapping("list")
    public ModelAndView list(String keyword){
        ModelAndView modelAndView = new ModelAndView();
        List<VoteAndSub> list = voteService.getAllVote();
        modelAndView.addObject("list",list);
        if(keyword != null && keyword != ""){
            List<VoteAndSub> listQuery = voteService.getQueryVote(keyword);
            modelAndView.addObject("list",listQuery);
        }
        modelAndView.setViewName("AdminVoteManage/VoteList.jsp");
        if(UtilCache.getUserid()!=null){
            modelAndView.addObject("userid",UtilCache.getUserid());
        }
        return modelAndView;
    }

    @RequestMapping("addVoteOne")
    public String addVoteOne(){
        return "AdminVoteManage/VoteAdd.jsp";
    }

    @RequestMapping("addVoteDo")
    public ModelAndView addVoteDo(String title,String subs0,
                                  String subs1,String subs2,String subs3){
        String[] subs = new String[]{
                subs0,subs1,subs2,subs3
        };
        voteService.save(title,subs);
        return getListModelAndView();
    }

    @RequestMapping("modifyVote")
    public ModelAndView modifyVote(int id){
        Votesub votesub = voteService.getOneSub(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("votesub",votesub);
        modelAndView.setViewName("AdminVoteManage/VoteModify.jsp");
        return modelAndView;
    }

    @RequestMapping("modifyVoteDo")
    public ModelAndView modifyVoteDo(int id,String content,int quantity){
        Votesub votesub = voteService.getOneSub(id);
        votesub.setContent(content);
        votesub.setQuantity(quantity);
        voteService.updateSub(votesub);
        ModelAndView modelAndView = new ModelAndView();
        List<VoteAndSub> list = voteService.getAllVote();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("AdminVoteManage/VoteList.jsp");
        return modelAndView;
    }

    @RequestMapping("modifyVoteTitle")
    public ModelAndView modifyVoteTitle(int id){
        Vote vote = voteService.getOneVoteFotTitle(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vote",vote);
        modelAndView.setViewName("AdminVoteManage/VoteModifyTitle.jsp");
        return modelAndView;
    }

    @RequestMapping("modifyVoteTitleDo")
    public ModelAndView modifyVoteTitleDo(int id,String title){
        Vote vote = voteService.getOneVoteFotTitle(id);
        vote.setTitle(title);
        voteService.updateVoteTitle(vote);
        ModelAndView modelAndView = new ModelAndView();
        List<VoteAndSub> list = voteService.getAllVote();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("AdminVoteManage/VoteList.jsp");
        return modelAndView;
    }

    @RequestMapping("deleteVote")
    public ModelAndView deleteVote(int id){
        voteService.deleteVote(id);
        ModelAndView modelAndView = new ModelAndView();
        List<VoteAndSub> list = voteService.getAllVote();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("AdminVoteManage/VoteList.jsp");
        return modelAndView;
    }

}
