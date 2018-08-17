package com.vivi.bugTracking.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory factory = null;
    public static SqlSessionFactory getSqlSessionFactory(){

        if(factory == null){
            InputStream config = MyBatisUtil.class.getClassLoader().getResourceAsStream("applicationContext.xml");
            factory = new SqlSessionFactoryBuilder().build(config);

        }
        return factory;
    }
}
