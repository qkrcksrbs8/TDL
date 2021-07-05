package com.tdlPost.controller;

import java.io.File;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//자유게시판 DB 연결
import com.tdlPost.dao.TDLPostDAO;
import com.tdlPost.domain.TdlCommand;
import com.tdlPost.util.PagingUtil;
//댓글DB연결
import com.tdlComment.dao.*;
import com.tdlComment.domain.*;

//좋아요DB연결
import com.tdlLike.dao.*;
import com.tdlLike.domain.*;

@Controller
@RequestMapping(value="/TDL_POST/*")
public class PostController {

		//로그객체를 생성 ->매개변수전달,요청을 받아서 제대로 처리 -> 콘솔에 출력(디버깅용)
		private Logger log=Logger.getLogger(this.getClass());//검사할 클래스명을 등록
		@Autowired
		private TDLPostDAO TDLPostDAO;//byType을 이용해서 BoardDao 객체를 자동으로 의존성객체
		@Autowired
		private TDLCommentDAO TDLCommentDAO;//댓글 DAO
		@Autowired
		private TDLLikeDAO TDLLikeDAO;//좋아요 DAO
		
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
			
		//초기값 설정	
		if(TP_num==1) {
			TP_num=(Integer)request.getAttribute("TP_num");	
		}
		if(TU_id=="false") {
			TU_id=(String)request.getAttribute("TU_id");
		}

		//1.조회수 증가  -> 조회 수 하루에 1회만
		TDLPostDAO.updateHit(TP_num);
		TdlCommand TDLPost=TDLPostDAO.selectTDLPost(TP_num);//int -> Integer

		//여기부터는 댓글
		int TPC_num=TP_num;
		int countC=TDLCommentDAO.getRowCountC(TPC_num);
				 
		List<CommentCommand> listC = null;//null 체크
		if(countC > 0){
			System.out.println("여기는 DAO 호출 countC =>"+countC);
			listC = TDLCommentDAO.listC(TPC_num);
		}else{
			listC = Collections.emptyList();
			System.out.println("댓글 ListController클래스의 count="+countC);
		}
		
		commandL.setTL_id(TU_id);
		commandL.setTL_PNUM(TP_num);
		List<likeCommand> likeCheck=TDLLikeDAO.likeCheck(commandL);
		
		/*
		ModelAndView mav=new ModelAndView("boardView"); // ~ setViewName("boardView");
		mav.addObject("board",board); // request.setAttribute("board",board);
		return mav;
		*/  //1.이동할 페이지명 2.전달할 키명 3.전달할값
		ModelAndView mav=new ModelAndView("TDLPostContent"); 
		mav.setViewName("TDL_POST/TDLPostContent");
		mav.addObject("article",TDLPost); 
		mav.addObject("listC",listC);
		mav.addObject("sumCountC",countC);
		mav.addObject("likeCheck",likeCheck);
		return mav;
	}
		
	@RequestMapping(value="/TDLPostDelete.do",method=RequestMethod.GET)
	public String submit(@ModelAttribute("command") TdlCommand command,
			                       BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("TdlCommand=>"+command);//입력받은 값을 출력
			//로그객체명.debug(출력대상자를 입력)
		}
		int TP_num = command.getTP_num();
		//글삭제
			System.out.println("삭제할 TP_num =>"+TP_num);
			TDLPostDAO.delete(TP_num);
			System.out.println("삭제 성공! ");
		//return "redirect:요청명령어"; =>return "이동할 페이지명"
			return "redirect:/TDL_POST/TDLPostList.do";
	}
	
	@RequestMapping("/TDLPostList.do")
	public ModelAndView process
	   (@RequestParam(value="pageNum",defaultValue="1")int currentPage,
	    @RequestParam(value="keyField",defaultValue="")String keyField,
	    @RequestParam(value="keyWord",defaultValue="")String keyWord){
		if(log.isDebugEnabled()){ //로그객체가 디버깅모드상태인지 아닌지를 체크
			System.out.println("여기는 보드 list.do");
			log.debug("currentPage : " + currentPage);//log.debug메서드 사용
			log.debug("keyField : " + keyField);
			log.debug("keyWord : " + keyWord);
		}
		//검색분야,검색어를 전달->parameteType="map"
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyField", keyField);//검색분야
		map.put("keyWord", keyWord);//검색어
		
		//총글의 갯수 또는 검색된 글의 갯수
		int recodeCount=TDLPostDAO.getRowCount(map);	    
		String url = "TDLPostList.do";
		int blockCount = 10;
		int pageCount = 3;
		//페이징 처리  1.현재페이지 2.총레코드수 3.페이지당 게시물수 4.블럭당 페이지수 5.요청명령어
		PagingUtil page = new PagingUtil(currentPage, recodeCount, blockCount, pageCount, url);	
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());//마지막게시물번호
		
		List<TdlCommand> list = null;
		if(recodeCount > 0){
			System.out.println("여기는 DAO 호출");
			list = TDLPostDAO.list(map);
		}else{
			list = Collections.emptyList();
			System.out.println("ListController클래스의 count="+recodeCount);
		}
		
		ModelAndView  mav = new ModelAndView("TDLPostList");
		mav.setViewName("TDL_POST/TDLPostList");//TDLPostList.jsp
		mav.addObject("count", recodeCount);//총레코드수
		mav.addObject("list", list);//레코드전체값
		mav.addObject("pagingHtml", page.getPagingHtml());//링크문자열을 전달
		System.out.println("자유게시판 끝");
		return mav;
	}
	
	@RequestMapping(value="/TDLPostUpdate.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") TdlCommand command) {
		if(log.isDebugEnabled()) {
			log.debug("TdlCommand=>"+command);//입력받은 값을 출력
			//로그객체명.debug(출력대상자를 입력)
		}
		//유효성검사			

			//글쓰기 호출
			TDLPostDAO.update(command);
			System.out.println("자유게시판 글수정 TP_title =>"+command.getTP_title());
			System.out.println("자유게시판 글수정 TP_content =>"+command.getTP_content());

		//return "redirect:요청명령어"; =>return "이동할 페이지명"
		return "redirect:/TDL_POST/TDLPostList.do";
	}

 //1.글수정 폼으로 이동(Get방식)
	@RequestMapping(value="/TDLPostUpdate.do",method=RequestMethod.GET)
	public ModelAndView form(@ModelAttribute("command")  TdlCommand command) {  //메서드명은 임의로 작성
		System.out.println("업데이트 페이지 이동 UpdateController  호출됨!");
		int TP_num = command.getTP_num();
		if(log.isDebugEnabled()) {//로그객체가 작동중이라면(디버그상태)
			log.debug("TP_num =>"+TP_num); //System.out.println("seq=>"+seq);
		}
		TDLPostDAO.selectTDLPost(TP_num);
		TdlCommand TDLPost=TDLPostDAO.selectTDLPost(TP_num);
		System.out.println("글 제목 => "+TDLPost.getTP_title());
		System.out.println("글 내용 =>"+TDLPost.getTP_content());
		
		//									1. 이동할 페이지           2. 키명     3. 키값
		return new ModelAndView("TDL_POST/TDLPostUpdate","article",TDLPost);// ${board}
	}
	
	/*
	 * 하나의 요청명령어=>하나의 컨트롤러만 사용X
	 * 하나의 컨트롤러->여러개의 요청명령어를 등록해서 사용이 가능.
	 * 같은 요청명령어를 GET or POST으로 전송할지를 결정하는 속성
	 * method=RequestMethod.GET | method=RequestMethod.POST
	 */
	 //1.글쓰기 폼으로 이동(Get방식)
	@RequestMapping(value="/TDLPostWrite.do",method=RequestMethod.GET)
	public String form() {  //메서드명은 임의로 작성
		System.out.println("다시 처음부터 값을 입력받기위해서 form()호출됨!");
		return "TDL_POST/TDLPostWrite";// return "이동할 페이지명'//definition name과 동일
	}
	
	//2.에러메세지 출력=>다시 초기화가 가능하게 설정->@ModelAttribute("커맨드객체 별칭명")
	@ModelAttribute("command")
	public TdlCommand forBacking() { //반환형 (DTO형) 임의의 메서드명
		System.out.println("forBacking()호출됨!");
		return new TdlCommand();//BoardCommand bc=new BoardCommand();
	}
	//3.입력해서 유효성검사->에러발생
	//BindingResult->유효성검사때문에 필요=>에러정보객체를 저장
	@RequestMapping(value="/TDLPostWrite.do",method=RequestMethod.POST)
	public String TDLPostWrite(@ModelAttribute("command") TdlCommand command,
			                       BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("TdlCommand=>"+command);//입력받은 값을 출력
			//로그객체명.debug(출력대상자를 입력)
		}
		//유효성검사			
			//최대값+1
			int newNum=TDLPostDAO.getNewNumP()+1;
			System.out.println("newNum=>"+newNum);//1->2
			//게시물번호->계산->저장
			command.setTP_num(newNum);//2
			//글쓰기 호출
			TDLPostDAO.insert(command);
			System.out.println("자유게시판 글쓰기 TP_id =>"+command.getTP_id());
			System.out.println("자유게시판 글쓰기 TP_num =>"+command.getTP_num());
			System.out.println("자유게시판 글쓰기 TP_date =>"+command.getTP_date());
			System.out.println("자유게시판 글쓰기 TP_readcont =>"+command.getTP_readcount());
			System.out.println("자유게시판 글쓰기 TP_title =>"+command.getTP_title());
			System.out.println("자유게시판 글쓰기 TP_content =>"+command.getTP_content());

		//return "redirect:요청명령어"; =>return "이동할 페이지명"
		return "redirect:/TDL_POST/TDLPostList.do";
	}
}


