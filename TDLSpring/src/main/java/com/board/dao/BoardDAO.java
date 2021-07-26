package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardDAO {

	@Autowired
	SqlSessionDaoSupport SqlSession;

	public int selectBoardCount(Map<String, Object> param){
		return SqlSession.getSqlSession().selectOne("boardCount",param);
	}
	
	public List<Map<String, Object>> selectBoardList(Map<String, Object> param){
		return SqlSession.getSqlSession().selectList("boardList",param);
	}
}
