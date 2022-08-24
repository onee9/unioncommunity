package com.yjkstu.forum;

import com.yjkstu.forum.dao.DiscussPostMapper;
import com.yjkstu.forum.dao.UserMapper;
import com.yjkstu.forum.entity.DiscussPost;
import com.yjkstu.forum.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

/**
 * @author yjk
 * @version 1.0
 */

@SpringBootTest
@ContextConfiguration(classes = SpringbootUnioncommunityApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);
    }

    @Test
    public void testInserUser(){

        User user = new User();
        user.setUsername("text");
        user.setPassword("12456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcode.com/100.png");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        System.out.println(row);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser(){
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150,"http://www.nowcode.com/101.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150,"hello");
        System.out.println(rows);

    }

 /*   @Test
    public void testselectPost(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for (DiscussPost post : list){
            System.out.println(post);
        }
        int rows = discussPostMapper.selectDiscussRows(149);
        System.out.println(rows);
    }
*/




}
