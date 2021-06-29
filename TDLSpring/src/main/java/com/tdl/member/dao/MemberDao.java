package com.tdl.member.dao;

import com.tdl.member.domain.MemberCommand;

public interface MemberDao {
	
		//ID중복체크
		public int checkId(String id);
		//회원가입
		public void register(MemberCommand mem);
		
		//로그인체크
		public int loginCheck(MemberCommand mem);
		
		//회원정보 가져오기
		public MemberCommand getMember(String TU_id);
		
		//회원수정
		public void updateMember(MemberCommand mem);
		
		//회원탈퇴할때 비교할 패스워드 가져오기
		public String getPasswd(String TU_id);
	
		//회원탈퇴
		public void deleteMember(String TU_id);
}


