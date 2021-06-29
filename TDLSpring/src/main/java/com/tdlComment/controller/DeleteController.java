package com.tdlComment.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tdlComment.dao.TDLCommentDAO;
import com.tdlComment.domain.CommentCommand;


@Controller
public class DeleteController {
        //Logger객체=>제대로 입력했는지 체크해서 그 결과를 콘솔에 출력
	   //                      시켜주는 객체
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLCommentDAO TDLCommentDAO;
	 

	//BindingResult->유효성검사때문에 필요=>에러정보객체를 저장
	@RequestMapping(value="/TDL_Comment/TDLCommentDelete.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("commandC") CommentCommand commandC,
			                       BindingResult result,
			                       @RequestParam(value="likeAddr")String TP_addr,
			                       @RequestParam(value="TP_id")String TP_id,
			                       @RequestParam(value="TP_num")int TP_num,				                     
				                     @RequestParam(value="TU_id")String TU_id) {
		
		log.info("여기는댓글삭제라구!"+TP_num+"   "+TU_id);
		if(log.isDebugEnabled()) {
			log.info("댓글삭제 시작");
			log.debug("CommentCommand=>"+commandC);//입력받은 값을 출력
			//로그객체명.debug(출력대상자를 입력)
		}
		String TPC_addr = TP_addr;
		//글삭제 
			log.info("댓글 삭제할 TP_addr =>"+TP_addr);
			TDLCommentDAO.deleteC(TP_addr);
			log.info("댓글 삭제 성공! ");
		//return "redirect:요청명령어"; =>return "이동할 페이지명"
			return "redirect:/TDL_POST/TDLPostContent.do?TP_num="+TP_num+"&TP_id='"+TP_id+"'&TU_id='"+TU_id+"'";
	}
}

