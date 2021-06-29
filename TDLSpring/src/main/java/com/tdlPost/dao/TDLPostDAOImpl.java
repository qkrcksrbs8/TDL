package com.tdlPost.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tdlPost.domain.*;

@Repository
public class TDLPostDAOImpl extends SqlSessionDaoSupport implements TDLPostDAO {

	//
	public List<TdlCommand> list(Map<String, Object> map) {
		List<TdlCommand> list=getSqlSession().selectList("selectList",map);
		System.out.println("TDL_POST -> ListDaoImpl 테스트중입니다.~");
		return list;
	}

	//게시물 수
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		System.out.println("getRowCount()호출됨!");
		return getSqlSession().selectOne("selectCount",map);
	}

	//글 마지막번호 -> max(TP_num)
	public int getNewNumP() {
		int newnum=(Integer)getSqlSession().selectOne("getNewNumP");
		System.out.println("getNewNumP()의 newnum=>"+newnum);
		return newnum;
	}
	
	//글 작성
	public void insert(TdlCommand TDLPost) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertTDLPost",TDLPost);
	}
	
	//조회수 증가
	public void updateHit(Integer TP_num) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateHit",TP_num);
	}
	
	//글 상세보기
	public TdlCommand selectTDLPost(Integer TP_num) {
		// TODO Auto-generated method stub
		return (TdlCommand)getSqlSession().selectOne("selectTDLPost",TP_num);
	}
	
	//글삭제
	public void delete(Integer TP_num) {
		getSqlSession().delete("delete",TP_num);
	}
	
	//글수정
	public void update(TdlCommand TDLPost) {
		// TODO Auto-generated method stub
		getSqlSession().update("updatePost",TDLPost);
	}
	
	
}
