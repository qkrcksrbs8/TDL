package com.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;//로그객체를 불러오기위한 클래스
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tdlPost.util.PagingUtil;
import com.board.dao.BoardDAO;
//댓글DB연결

import com.tdlLike.domain.*;

@Controller
@RequestMapping(value="/TDL/*")
public class BoardController {

		//로그객체를 생성 ->매개변수전달,요청을 받아서 제대로 처리 -> 콘솔에 출력(디버깅용)
		private Logger log=Logger.getLogger(this.getClass());//검사할 클래스명을 등록

		@Autowired
		private BoardDAO boardDAO;

	
	/**
	 * 게시판 조회
	 * @param currentPage
	 * @param keyField
	 * @param keyWord
	 * @return
	 */
	@RequestMapping("/boardList.do")
	public ModelAndView process
	   (@RequestParam(value="pageNum",defaultValue="1")int currentPage,
	    @RequestParam(value="keyField",defaultValue="")String keyField,
	    @RequestParam(value="keyWord",defaultValue="")String keyWord){

		//검색분야,검색어를 전달->parameteType="map"
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyField"		, keyField);	//검색분야
		map.put("keyWord"		, keyWord);		//검색어
		map.put("currentPage"	, currentPage);	//현재 페이지
		   
		//글 토탈 카운트
		int recodeCount = boardDAO.selectBoardCount(map);
		String url 		= "boardList.do";
		int blockCount	= 10;
		int pageCount 	= 3;
		
		//페이징 처리  1.현재페이지 2.총레코드수 3.페이지당 게시물수 4.블럭당 페이지수 5.요청명령어 
		PagingUtil page = new PagingUtil(currentPage, recodeCount, blockCount, pageCount, url);	
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());//마지막게시물번호
		
//		if(recodeCount > 0){
			List<Map<String, Object>> boardListMap = boardDAO.selectBoardList(map);

		
		ModelAndView  mav = new ModelAndView("boardList");
		mav.setViewName("TDL_POST/boardList");//boardList.jsp
		mav.addObject("count", recodeCount);//총레코드수
		mav.addObject("list", boardListMap);//레코드전체값
		mav.addObject("pagingHtml", page.getPagingHtml());//링크문자열을 전달
		System.out.println("자유게시판 끝");
		return mav;
	}
	
	
	// 자유게시판 게시물
	/**
	 * @param commandL
	 * @param result
	 * @param TP_num
	 * @param TU_id
	 * @param request
	 * @return
	 */
	@RequestMapping("/TDLPostContent.do")
	public ModelAndView process(@ModelAttribute("commandL") likeCommand commandL,BindingResult result,
								@RequestParam(value="TP_num",defaultValue="1") int TP_num,
								@RequestParam(value="TU_id",defaultValue="false") String TU_id, HttpServletRequest request) {

	
//	TdlCommand TDLPost=TDLPostDAO.selectTDLPost(TP_num);//int -> Integer

//	//여기부터는 댓글
//	int TPC_num=TP_num;
//	int countC=TDLCommentDAO.getRowCountC(TPC_num);
//			 
//	List<CommentCommand> listC = null;//null 체크
//	if(countC > 0){
//		System.out.println("여기는 DAO 호출 countC =>"+countC);
//		listC = TDLCommentDAO.listC(TPC_num);
//	}else{
//		listC = Collections.emptyList();
//		System.out.println("댓글 ListController클래스의 count="+countC);
//	}
//	  
//	commandL.setTL_id(TU_id);
//	commandL.setTL_PNUM(TP_num);
//	List<likeCommand> likeCheck=TDLLikeDAO.likeCheck(commandL);
	
	//1.조회수 증가 만들기
	/*
	*/  //1.이동할 페이지명 2.전달할 키명 3.전달할값
	ModelAndView mav=new ModelAndView("TDLPostContent"); 
	mav.setViewName("TDL_POST/TDLPostContent");
//	mav.addObject("article",TDLPost); 
//	mav.addObject("listC",listC);
//	mav.addObject("sumCountC",countC);
//	mav.addObject("likeCheck",likeCheck);
	return mav;
}
	
	
}


