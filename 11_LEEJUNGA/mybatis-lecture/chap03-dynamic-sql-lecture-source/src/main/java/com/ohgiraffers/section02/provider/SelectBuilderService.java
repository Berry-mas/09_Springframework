package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class SelectBuilderService {
    /*
    * Service에서 오면
    * 일단 연결객체를 잘가지고있는지, 설정이 되어있는지 확인
    *
    * 적절한 Dao or repository의 요청 준비를 확인하고
    *
    * DML작업이 있을 경우 트랜잭션 처리를 고민해야하고
    *
    * 마지막으로 연결객체를 닫아준다.
    * */
    public void testSimpleStatement() {
        SqlSession sqlSession = getSqlSession();
        SelectBuilderMapper mapper = sqlSession.getMapper(SelectBuilderMapper.class);

        List<MenuDTO> menuList = mapper.selectAllMenu();

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }

        sqlSession.close();

    }

    public void testDynamicStatement(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        SelectBuilderMapper mapper = sqlSession.getMapper(SelectBuilderMapper.class);

        List<MenuDTO> menuList = mapper.selectMenuByNameOrCategory(searchCriteria);

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }

        sqlSession.close();
    }
}
