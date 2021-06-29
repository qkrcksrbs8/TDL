package com.tdl.member.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.tdl.member.domain.*;

//SqlSessionDaoSupport 상속받는 이유 -> SqlSession객체를 자동으로 반환 getSqlSession()
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

	//ID중복체크
	public int checkId(String id) {
		// TODO Auto-generated method stub
		int check = 0;
		System.out.println("checkId메서드실행"+id);		
		String Idcheck=getSqlSession().selectOne("checkId",id);
		System.out.println("checkId메서드=>"+Idcheck);
		if(Idcheck!=null) {
			check=1;
		}
		System.out.println("checkId메서드check=>"+check);
		return check;
	}
	//회원가입
	public void register(MemberCommand mem) {
		// TODO Auto-generated method stub
		getSqlSession().insert("register",mem);
		getSqlSession().insert("justLog",mem);
	}
	//로그인체크
	public int loginCheck(MemberCommand mem) {
		// TODO Auto-generated method stub
		int check=0;
		MemberCommand loginCheck=getSqlSession().selectOne("loginCheck",mem);
		System.out.println("loginCheck=>"+loginCheck);
		if(loginCheck!=null) {
			check=1;
		}		
		return check;
	}
	//회원정보 가져오기
	public MemberCommand getMember(String TU_id) {
		// TODO Auto-generated method stub
		MemberCommand mem = getSqlSession().selectOne("mypage",TU_id);
		
		return mem;
	}
	//회원수정
	public void updateMember(MemberCommand mem) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateMember",mem);
		
		System.out.println("updateMember잘실행됨!");
	}
	
	//회원탈퇴 비교 패스워드 가져오기
	public String getPasswd(String TU_id) {
		// TODO Auto-generated method stub
		String TU_passwd=getSqlSession().selectOne("getPasswd",TU_id);
		
		return TU_passwd;
	}
	
	//회원탈퇴
	public void deleteMember(String TU_id) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteMember",TU_id);
	}
	
}
