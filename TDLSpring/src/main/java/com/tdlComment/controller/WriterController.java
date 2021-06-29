package com.tdlComment.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.tdlComment.dao.*;
import com.tdlComment.domain.*;


@Controller
public class WriterController {
        //Logger객체=>제대로 입력했는지 체크해서 그 결과를 콘솔에 출력
	   //                      시켜주는 객체
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLCommentDAO TDLCommentDAO;//댓글 DAO
	 
	
	@RequestMapping(value="/TDL_Comment/TDLCommentWrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("commandC") CommentCommand commandC,
									BindingResult result,
			                     @RequestParam(value="TP_num")int TP_num,
			                     @RequestParam(value="TP_id")String TP_id,
			                     @RequestParam(value="TU_id")String TU_id,HttpServletRequest request) {
	
		if(log.isDebugEnabled()) {
			log.info("여기는 댓글작성 시작");
			log.info("TP_num =>"+TP_num);
			log.info("TP_id =>"+TP_id);
			log.info("TU_id =>"+TU_id);
			log.debug("CommentCommand=>"+commandC);//입력받은 값을 출력
			//로그객체명.debug(출력대상자를 입력)
		}
			
			int TPC_num=TP_num;
			String id="테스트";
			commandC.setTPC_id(id);
			commandC.setTPC_num(TP_num);
			//최대값+1
			log.info("TPC_num =>"+TPC_num);
			int newNumC=TDLCommentDAO.getNewNumC(TPC_num)+1;
			log.info("newNumC=>"+newNumC);//1->2
			//게시물번호->계산->저장
			//String addr =자유게시물번호+"c"+최대값 번호+"c"+댓글구분번호;
			String addr=TP_num+"c"+newNumC+"c"+0;
			commandC.setTPC_addr(addr);
			commandC.setTPC_ref(newNumC);//2
			
			//글쓰기 호출
			log.info("댓글 작성 TPC_id =>"+commandC.getTPC_id());
			log.info("댓글 작성 TPC_num =>"+commandC.getTPC_num());
			log.info("댓글 작성 TPC_content =>"+commandC.getTPC_content());
			log.info("게시물넘버 보내주기 =>"+TP_num);
			TDLCommentDAO.insertC(commandC);
			log.info("댓글 작성 TPC_date =>"+commandC.getTPC_date());
			
			request.setAttribute("TP_num", TP_num);
			request.setAttribute("TP_id", TP_id);
			request.setAttribute("TU_id", TU_id);
			return "redirect:/TDL_POST/TDLPostContent.do?TP_num="+TP_num+"&TP_id='"+TP_id+"'&TU_id='"+TU_id+"'";
	}
}

