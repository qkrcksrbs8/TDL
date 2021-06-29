package com.tdlComment.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tdlComment.domain.*;
import com.tdlLike.domain.likeCommand;

@Repository
public class TDLCommentDAOImpl extends SqlSessionDaoSupport implements TDLCommentDAO {
	private Logger log=Logger.getLogger(this.getClass());
	//출력댓글 리스트에 담기
	public List<CommentCommand> listC(Integer TPC_num) {
		List<CommentCommand> listC=getSqlSession().selectList("selectListC",TPC_num);
		log.info("댓글 TDL_Comment-> ListDaoImpl 테스트중입니다.~ TPC_num =>"+TPC_num);
		return listC;
	}
	
	//총 출력댓글 개수
	public int getRowCountC(Integer TPC_num) {
		try {
			log.info("댓글 getRowCountC()호출됨!");
			return getSqlSession().selectOne("selectCountC",TPC_num);
		}catch(Exception e) {
			return TPC_num=0;
		}
	}
	
	//댓글 최대값 번호
	public int getNewNumC(Integer TPC_num) {
		int newnumC;
		try {
			log.info("댓글작성의 게시물번호 => "+TPC_num);
			newnumC=getSqlSession().selectOne("getNewNumC",TPC_num);
			log.info("댓글 최대값 => "+TPC_num);
		} catch (Exception e) {
			newnumC=0;
			log.info("댓글 첫 생성 ");
		}
		
		log.info(newnumC);
		log.info("댓글 getNewNumC()의 newnumC=>"+newnumC);
		return newnumC;
	}
	
	//댓글쓰기
	public void insertC(CommentCommand TDLComment) {
		getSqlSession().insert("insertTDLComment",TDLComment);
	}
	
	//댓글삭제
	public void deleteC(String TPC_num) {
		getSqlSession().delete("deleteC",TPC_num);
		
	}
	
	//좋아요 증가
	public void likeUp(String TPC_addr) {
		getSqlSession().update("likeUp",TPC_addr);
		
	}
	
	//좋아요 취소
	public void likeDown(String TPC_addr) {
		getSqlSession().update("likeDown",TPC_addr);
	}

}