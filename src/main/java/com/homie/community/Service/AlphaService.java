package com.homie.community.Service;

import com.homie.community.Dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;

    public String find(){
        return alphaDao.select();
    }

        public AlphaService(){
            System.out.println("实例化AlphaService。。。。");
        }

    //这个方法在构造器之后调用
        @PostConstruct
        public void init(){
            System.out.println("初始化AlphaService。。。。");
        }

        //在对象销毁之前调用一次
        @PreDestroy
        public void destroy(){
            System.out.println("销毁AlphaService....");
        }



}
