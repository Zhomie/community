package com.homie.community.Service;

import com.homie.community.Dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    @Qualifier("TDSI")
    private TestDao testDao;

    public String testfind(){
        return testDao.testSelect();
    }

}
