package com.yjkstu.forum.service;

import com.yjkstu.forum.dao.DiscussPostMapper;
import com.yjkstu.forum.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yjk
 * @version 1.0
 */
@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId,int offset, int limit){
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }

    public int findDiscussPosRows(int userId){
        return discussPostMapper.selectDiscussRows(userId);
    }
}
