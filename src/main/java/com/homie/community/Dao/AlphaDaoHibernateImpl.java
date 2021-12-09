package com.homie.community.Dao;

import org.springframework.stereotype.Repository;


//它用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean。
@Repository("alphaDaoHibernateImpl")
public class AlphaDaoHibernateImpl  implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
