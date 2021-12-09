package com.homie.community.Service;

import com.homie.community.Dao.DiscussPostMapper;
import com.homie.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
        @Autowired
    private DiscussPostMapper discussPostMapper;

        //返回的DiscussPost结果有一个外键UserId，我们显示的时候不能显示UserID，应该是用户名。
        //可以得到数据后，单独的，针对每一个DiscussPost单独的查一下User，把查到的User，与DiscussPost组合到一起返回给页面
        //看起来麻烦，将来使用redis缓存数据时方便，
        //第二种方式需要在提供一个业务方法，根据UserId，查到User
        //跟User有关的操作，可以在新建一个Servic，叫UserService
        public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit){
            return discussPostMapper.selectDiscussPosts(userId,offset,limit);
        }

        public int findDiscussPostRows(int userId){
            return discussPostMapper.selectDiscussPostRows(userId);
        }

}
