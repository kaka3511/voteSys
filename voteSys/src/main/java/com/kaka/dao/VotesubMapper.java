package com.kaka.dao;

import com.kaka.model.Votesub;
import com.kaka.model.VotesubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VotesubMapper {
    int countByExample(VotesubExample example);

    int deleteByExample(VotesubExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Votesub record);

    int insertSelective(Votesub record);

    List<Votesub> selectByExample(VotesubExample example);

    Votesub selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Votesub record, @Param("example") VotesubExample example);

    int updateByExample(@Param("record") Votesub record, @Param("example") VotesubExample example);

    int updateByPrimaryKeySelective(Votesub record);

    int updateByPrimaryKey(Votesub record);
}