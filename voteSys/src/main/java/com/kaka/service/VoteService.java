package com.kaka.service;

import com.kaka.dao.VoteMapper;
import com.kaka.dao.VotesubMapper;
import com.kaka.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteMapper voteMapper;

    @Autowired
    private VotesubMapper votesubMapper;

    public List<VoteAndSub> getAllVote(){
        List<Vote> listVote = voteMapper.selectByExample(new VoteExample());
        List<VoteAndSub> list = new ArrayList<>();
        for(Vote vote:listVote){
            VoteAndSub voteAndSub = new VoteAndSub();
            VotesubExample votesubExample = new VotesubExample();
            votesubExample.createCriteria().andVoteidEqualTo(vote.getId());
            List<Votesub> listVoteSub = votesubMapper.selectByExample(votesubExample);
            BeanUtils.copyProperties(vote,voteAndSub);
            voteAndSub.setSubs(listVoteSub);
            list.add(voteAndSub);
        }
        return list;
    }

    public List<VoteAndSub> getQueryVote(String keyword){
        VoteExample example = new VoteExample();
        example.createCriteria().andTitleLike("%"+keyword+"%");
        List<Vote> listVote = voteMapper.selectByExample(example);
        List<VoteAndSub> list = new ArrayList<>();
        for(Vote vote:listVote){
            VoteAndSub voteAndSub = new VoteAndSub();
            VotesubExample votesubExample = new VotesubExample();
            votesubExample.createCriteria().andVoteidEqualTo(vote.getId());
            List<Votesub> listVoteSub = votesubMapper.selectByExample(votesubExample);
            BeanUtils.copyProperties(vote,voteAndSub);
            voteAndSub.setSubs(listVoteSub);
            list.add(voteAndSub);
        }
        return list;
    }

    public VoteAndSub getOneVote(int id){
        VoteAndSub voteAndSub = new VoteAndSub();
        Vote vote = voteMapper.selectByPrimaryKey(id);
        List<VoteAndSub> list = new ArrayList<>();

        VotesubExample votesubExample = new VotesubExample();
        votesubExample.createCriteria().andVoteidEqualTo(id);
        List<Votesub> listVoteSub = votesubMapper.selectByExample(votesubExample);
        BeanUtils.copyProperties(vote,voteAndSub);
        voteAndSub.setSubs(listVoteSub);
        list.add(voteAndSub);
        return voteAndSub;
    }

    public void addVote(int voteid,int subid){
        VotesubExample example = new VotesubExample();
        example.createCriteria().andVoteidEqualTo(voteid).andIdEqualTo(subid);
        Votesub votesub = votesubMapper.selectByExample(example).get(0);
        votesub.setQuantity(votesub.getQuantity()+1);
        votesubMapper.updateByPrimaryKey(votesub);
    }

    public void save(String title,String[] subs){
        Vote vote = new Vote(title);
        voteMapper.insert(vote);
        VoteExample example = new VoteExample();
        example.createCriteria().andTitleEqualTo(title);
        int voteid = voteMapper.selectByExample(example).get(0).getId();
        for(String str:subs){
            Votesub votesub  = new Votesub(voteid,str);
            votesubMapper.insert(votesub);
        }
    }

    public Votesub getOneSub(int id){
        return votesubMapper.selectByPrimaryKey(id);
    }

    public void updateSub(Votesub votesub){
        votesubMapper.updateByPrimaryKey(votesub);
    }

    public void deleteVote(int id){
        voteMapper.deleteByPrimaryKey(id);
    }

    public Vote getOneVoteFotTitle(int id){
        return voteMapper.selectByPrimaryKey(id);
    }

    public void updateVoteTitle(Vote vote){
        voteMapper.updateByPrimaryKey(vote);
    }
}
