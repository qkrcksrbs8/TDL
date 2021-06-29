package com.tdl.member.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;//@Controller ?뼱?끂?뀒?씠?뀡
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;//@RequestMapping
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tdl.member.dao.MemberDao;
import com.tdl.member.domain.MemberCommand;



@Controller
public class MemberController  {

	private Logger log=Logger.getLogger(this.getClass());//SelectListController
	
	@Autowired
	private MemberDao memberDao;
	

	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	public String register(MemberCommand mem){
		memberDao.register(mem);
		return "TDL_MEMBER/complete";
	}

	@RequestMapping("/idcheck.do")
	@ResponseBody
	public Map<Object, Object> checkId(@RequestBody String id) {		
		System.out.println("checkId1=>"+id);
		int check = memberDao.checkId(id);
		System.out.println("checkId(check)=>"+check);						
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("cnt", check);
        return map;
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(@RequestParam("TU_id")String TU_id ,@RequestParam("TU_passwd")String TU_passwd
						,HttpServletRequest request) throws Throwable{
		System.out.println("login=>"+TU_id+"   "+TU_passwd);	
		MemberCommand mem = new MemberCommand();
		HttpSession session = request.getSession();
		mem.setTU_id(TU_id);
		mem.setTU_passwd(TU_passwd);
		System.out.println("===========여기 잘 나와용");
		int check = memberDao.loginCheck(mem);
		System.out.println("check=>"+check);
		if(check==1) {
			session.setAttribute("TU_id", TU_id);
			return "in/index";
		}else {
			request.setAttribute("check", "1");
			return "TDL_MEMBER/login";
		}
		
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) throws Throwable{
		request.getSession().invalidate();
		return "in/index";
	}
	
	@RequestMapping("/mypage.do")
	public String mypage(HttpServletRequest request) throws Throwable{
		MemberCommand mem = new MemberCommand();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String id = (String)session.getAttribute("TU_id");
		System.out.println("mypage TU_id=>"+id);
		mem = memberDao.getMember(id);
		
		request.setAttribute("TU_name", mem.getTU_name());
		request.setAttribute("TU_gender", mem.getTU_gender());
		request.setAttribute("TU_email", mem.getTU_email());
		request.setAttribute("TU_phone", mem.getTU_phone());
		
		return "TDL_MEMBER/mypage";
		
	}
	
	@RequestMapping("/MemberUpdateForm.do")
	public String mypageUpdateForm(HttpServletRequest request) throws Throwable{
		MemberCommand mem = new MemberCommand();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String id = (String)session.getAttribute("TU_id");
		System.out.println("mypage TU_id=>"+id);
		mem = memberDao.getMember(id);
		
		request.setAttribute("TU_name", mem.getTU_name());
		request.setAttribute("TU_gender", mem.getTU_gender());
		request.setAttribute("TU_email", mem.getTU_email());
		request.setAttribute("TU_phone", mem.getTU_phone());
		
		return "TDL_MEMBER/MemberUpdateForm";
		
	}
	
	@RequestMapping(value="/updateMember.do",method=RequestMethod.POST)
	public String updateMember(MemberCommand mem,HttpServletRequest request){
		HttpSession session = request.getSession();			
		mem.setTU_id((String)session.getAttribute("TU_id"));
		memberDao.updateMember(mem);
		System.out.println("성공"+mem.getTU_id());
		return "in/index";
	}
	
	@RequestMapping(value="/deleteMember.do",method=RequestMethod.POST)
	public String deleteMember(@RequestParam("TU_passwd")String TU_passwd,HttpServletRequest request){
		HttpSession session = request.getSession();			
		String TU_id = (String)session.getAttribute("TU_id");
		String passwd = memberDao.getPasswd(TU_id);
		
		System.out.println(passwd+"   "+TU_passwd);
		if(passwd.equals(TU_passwd)) {
			memberDao.deleteMember(TU_id);
			request.getSession().invalidate();
			return "in/index";
		}else {
			request.setAttribute("check", "1");
			return "TDL_MEMBER/MemberDeleteForm";
		}
		
		
	}
}




