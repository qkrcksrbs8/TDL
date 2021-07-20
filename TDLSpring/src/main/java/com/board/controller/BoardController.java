package com.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;//�αװ�ü�� �ҷ��������� Ŭ����
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tdlPost.util.PagingUtil;
import com.board.dao.BoardDAO;
//���DB����

import com.tdlLike.domain.*;

@Controller
@RequestMapping(value="/TDL/*")
public class BoardController {

		//�αװ�ü�� ���� ->�Ű���������,��û�� �޾Ƽ� ����� ó�� -> �ֿܼ� ���(������)
		private Logger log=Logger.getLogger(this.getClass());//�˻��� Ŭ�������� ���

		@Autowired
		private BoardDAO boardDAO;

	
	/**
	 * �Խ��� ��ȸ
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

		//�˻��о�,�˻�� ����->parameteType="map"
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyField"		, keyField);	//�˻��о�
		map.put("keyWord"		, keyWord);		//�˻���
		map.put("currentPage"	, currentPage);	//���� ������
		   
		//�� ��Ż ī��Ʈ
		int recodeCount = boardDAO.selectBoardCount(map);
		String url 		= "boardList.do";
		int blockCount	= 10;
		int pageCount 	= 3;
		
		//����¡ ó��  1.���������� 2.�ѷ��ڵ�� 3.�������� �Խù��� 4.���� �������� 5.��û��ɾ� 
		PagingUtil page = new PagingUtil(currentPage, recodeCount, blockCount, pageCount, url);	
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());//�������Խù���ȣ
		
//		if(recodeCount > 0){
			List<Map<String, Object>> boardListMap = boardDAO.selectBoardList(map);

		
		ModelAndView  mav = new ModelAndView("boardList");
		mav.setViewName("TDL_POST/boardList");//boardList.jsp
		mav.addObject("count", recodeCount);//�ѷ��ڵ��
		mav.addObject("list", boardListMap);//���ڵ���ü��
		mav.addObject("pagingHtml", page.getPagingHtml());//��ũ���ڿ��� ����
		System.out.println("�����Խ��� ��");
		return mav;
	}
	
	
	// �����Խ��� �Խù�
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

//	//������ʹ� ���
//	int TPC_num=TP_num;
//	int countC=TDLCommentDAO.getRowCountC(TPC_num);
//			 
//	List<CommentCommand> listC = null;//null üũ
//	if(countC > 0){
//		System.out.println("����� DAO ȣ�� countC =>"+countC);
//		listC = TDLCommentDAO.listC(TPC_num);
//	}else{
//		listC = Collections.emptyList();
//		System.out.println("��� ListControllerŬ������ count="+countC);
//	}
//	  
//	commandL.setTL_id(TU_id);
//	commandL.setTL_PNUM(TP_num);
//	List<likeCommand> likeCheck=TDLLikeDAO.likeCheck(commandL);
	
	//1.��ȸ�� ���� �����
	/*
	*/  //1.�̵��� �������� 2.������ Ű�� 3.�����Ұ�
	ModelAndView mav=new ModelAndView("TDLPostContent"); 
	mav.setViewName("TDL_POST/TDLPostContent");
//	mav.addObject("article",TDLPost); 
//	mav.addObject("listC",listC);
//	mav.addObject("sumCountC",countC);
//	mav.addObject("likeCheck",likeCheck);
	return mav;
}
	
	
}


