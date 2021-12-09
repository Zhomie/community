package com.homie.community.Dao;


import org.springframework.stereotype.Repository;

@Repository("TDSI")
public class TestDaoSecondImpl implements TestDao{

    @Override
    public String testSelect() {
        return "TestDaoSecondImpl";
    }
}
