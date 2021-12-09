package com.homie.community.Service;

import com.homie.community.Dao.UserMapper;
import com.homie.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
        @Autowired
    private UserMapper userMapper;

        public User selectUser(int userId){
            return userMapper.selectByID(userId);
        }


}
