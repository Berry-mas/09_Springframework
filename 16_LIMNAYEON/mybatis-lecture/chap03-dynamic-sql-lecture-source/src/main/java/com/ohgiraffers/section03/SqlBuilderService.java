package com.ohgiraffers.section03;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.section02.provider.SelectBuilderService;
import com.ohgiraffers.section02.provider.SqlBuilderMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class SqlBuilderService {
    public void registMenu(MenuDTO menuDTO) {

        SqlSession sqlSession = getSqlSession();
        SelectBuilderMapper mapper = sqlSession.getMapper(SelectBuilderMapper.class);

    }
}
