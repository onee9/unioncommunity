package com.yjkstu.forum.dao;


import com.yjkstu.forum.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yjk
 * @version 1.0
 */
@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(
            @Param("userId") int userId,
            @Param("offset") int offset,
            @Param("limit") int limit);

    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用,则必须加别名.
    int selectDiscussRows(@Param("userId")int userId);

}
