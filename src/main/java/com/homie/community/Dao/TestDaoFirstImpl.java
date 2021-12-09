package com.homie.community.Dao;


import org.springframework.stereotype.Repository;

@Repository
public class TestDaoFirstImpl implements TestDao{
    @Override
    public String testSelect() {
            return "FirstTestDaoImpl";
    }
}
