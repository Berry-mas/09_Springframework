package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USERNAME = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    private static SqlSessionFactory sqlSessionFactory;

    // 단 한 번의 요청 당 1개의 SqlSession 객체가 필요하므로 필요 시 호출할 메소드
    public static SqlSession getSqlSession() {
        if (sqlSessionFactory == null) {
            Environment environment = new Environment(
                    "development",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD)
            );
            Configuration configuration = new Configuration(environment);
            configuration.addMapper(MenuMapper.class);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }
        return sqlSessionFactory.openSession(false);
    }
}
