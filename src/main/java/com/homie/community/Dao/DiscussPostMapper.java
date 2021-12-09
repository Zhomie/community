package com.homie.community.Dao;

import com.homie.community.entity.DiscussPost;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    //userId,首页查询不用userId的，因为查询所有人的都能查到
    //userId，是留给个人主页的功能，就是查询我发布的帖子等
    //不想传入这个值，就把他设为0
        List<DiscussPost> selectDiscussPosts(int userId,int offset/*起始行行号*/,int limit);
    /*
     *  @param  给参数起别名，若sql里需要动态条件，且只有一个参数，一定要加
     *      在<if>中使用，则必须加别名
     * */
        int selectDiscussPostRows(@Param("userId") int userId);


}
