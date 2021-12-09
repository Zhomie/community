package com.homie.community;


import com.homie.community.Dao.DiscussPostMapper;
import com.homie.community.Dao.UserMapper;
import com.homie.community.entity.DiscussPost;
import com.homie.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest{

    @Autowired
    private  UserMapper userMapper;
    @Test
    public void testSelectUser(){

        User user = userMapper.selectByID(101);
        System.out.println(user);


         user = userMapper.selectByName("liubei");
        System.out.println(user);


         user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);

    }
    @Test
    public void TestInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setEmail("123456@test.com");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        //搞一个默认路径
        user.setHeaderUrl("http://www.homie.com/101.png");
        user.setSalt("abc");
        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }
    @Test
    public void testUpdateUser(){
        int rows = userMapper.updateStatus(150,1);
        System.out.println(rows);

        rows = userMapper.updatePassword(150,"hello");
        System.out.println(rows);

        rows = userMapper.updateHeader(150,"http://www.homie.com/110.png");
        System.out.println(rows);
    }

        @Autowired
        private DiscussPostMapper discussPostMapper;
    @Test
    public void testdiscusspost(){

        List<DiscussPost>  list   = discussPostMapper.selectDiscussPosts(0,1,10);

        int rows = discussPostMapper.selectDiscussPostRows(0);
        for (DiscussPost discussPost: list) {
            System.out.println(discussPost);
        }
        System.out.println(rows);
    }

}
