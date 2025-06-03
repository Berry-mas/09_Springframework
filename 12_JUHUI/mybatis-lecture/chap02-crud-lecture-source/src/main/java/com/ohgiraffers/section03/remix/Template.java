package com.ohgiraffers.section03.remix;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

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

            // 컬럼명 : underscore 표기법 사용, 필드명 : camelcase 표기법 사용
            // 해당 규칙에 맞추어 컬럼명을 필드명으로 자동 매핑하는 설정
            configuration.setMapUnderscoreToCamelCase(true);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }
        return sqlSessionFactory.openSession(false);
    }
}
