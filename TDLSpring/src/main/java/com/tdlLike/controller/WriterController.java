package com.tdlLike.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//댓글DB
import com.tdlComment.dao.*;
import com.tdlComment.domain.*;

//좋아요DB
import com.tdlLike.dao.*;
import com.tdlLike.domain.*;


@Controller
public class WriterController {
        //Logger객체=>제대로 입력했는지 체크해서 그 결과를 콘솔에 출력
	   //                      시켜주는 객체
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLLikeDAO TDLLikeDAO;//좋아요 DAO
	
	@Autowired
	private TDLCommentDAO TDLCommentDAO;//댓글DAO
	 
	
	@RequestMapping(value="/TDLLike/TDLLikeUp.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("commandL") likeCommand commandL,BindingResult result,
								 @RequestParam(value="TP_num")int TP_num,
			                     @RequestParam(value="TPC_addr")String TPC_addr,
			                     @RequestParam(value="TU_id")String TU_id) {
	
			System.out.println("여기는 좋아요 시작");
			System.out.println("TP_num =>"+TP_num);
			System.out.println("TP_id =>"+TPC_addr);
			System.out.println("TU_id =>"+TU_id);

			String addr=TPC_addr+TU_id;
			commandL.setTL_addrL(addr);// 좋아요의 일련번호 -> 댓글일련번호+유저아이디
			commandL.setTL_id(TU_id);//유저아이디
			commandL.setTL_addrC(TPC_addr);//댓글일련번호
			commandL.setTL_PNUM(TP_num);//자유게시판 게시물 번호 
			TDLLikeDAO.insertLike(commandL);
			TDLCommentDAO.likeUp(TPC_addr);
			try{
				
				System.out.println("좋아요 성공!!!");
			}catch(Exception e) {
				System.out.println("좋아요 실패!!!");
			}
			
			System.out.println("좋아요 TL_addr =>"+commandL.getTL_addrL());
			System.out.println("좋아요 TL_id =>"+commandL.getTL_id());
			System.out.println("좋아요 TL_like =>"+commandL.getTL_addrC());
			System.out.println("좋아요 TL_PNUM =>"+commandL.getTL_PNUM());

		return "redirect:/TDL_POST/TDLPostList.do";
	}
}

