package com.homie.community.Dao;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
//加上@Primary拥有更高的优先级
@Primary
public class AlphaDaoMybatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "Mybatis";
    }
}
