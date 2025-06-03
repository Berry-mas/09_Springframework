package com.ohgriaffers.section01.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    /*
    * SqlSessionFactory : 애플리케이션이 실행되는 동안 존재해야 하며, 여러 차례 다시 빌드하지 않는 것이 좋다.
    * 즉 singleton 패턴을 활용하는 것이 가장 좋다.
    * */
    private static SqlSessionFactory sqlSessionFactory;

    // 단 한 번의 요청 당 1개의 SqlSession 객체가 필요하므로 필요 시 호출할 메소드
    public static SqlSession getSqlSession() {
        if (sqlSessionFactory == null) {
            String resource = "config/mybatis-config.xml";

            try {
                /*
                * SqlSessionFactoryBuilder : SqlSessionFactory 생성 후
                * 유지할 필요가 없으므로 메소드 스코프로 생성한다.
                * */
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory.openSession(false);
    }
}
