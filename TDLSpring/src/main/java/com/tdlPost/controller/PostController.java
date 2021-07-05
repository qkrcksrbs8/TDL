package com.tdlPost.controller;

import java.io.File;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//�����Խ��� DB ����
import com.tdlPost.dao.TDLPostDAO;
import com.tdlPost.domain.TdlCommand;
import com.tdlPost.util.PagingUtil;
//���DB����
import com.tdlComment.dao.*;
import com.tdlComment.domain.*;

//���ƿ�DB����
import com.tdlLike.dao.*;
import com.tdlLike.domain.*;

@Controller
@RequestMapping(value="/TDL_POST/*")
public class PostController {

		//�αװ�ü�� ���� ->�Ű���������,��û�� �޾Ƽ� ����� ó�� -> �ֿܼ� ���(������)
		private Logger log=Logger.getLogger(this.getClass());//�˻��� Ŭ�������� ���
		@Autowired
		private TDLPostDAO TDLPostDAO;//byType�� �̿��ؼ� BoardDao ��ü�� �ڵ����� ��������ü
		@Autowired
		private TDLCommentDAO TDLCommentDAO;//��� DAO
		@Autowired
		private TDLLikeDAO TDLLikeDAO;//���ƿ� DAO
		
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
			
		//�ʱⰪ ����	
		if(TP_num==1) {
			TP_num=(Integer)request.getAttribute("TP_num");	
		}
		if(TU_id=="false") {
			TU_id=(String)request.getAttribute("TU_id");
		}

		//1.��ȸ�� ����  -> ��ȸ �� �Ϸ翡 1ȸ��
		TDLPostDAO.updateHit(TP_num);
		TdlCommand TDLPost=TDLPostDAO.selectTDLPost(TP_num);//int -> Integer

		//������ʹ� ���
		int TPC_num=TP_num;
		int countC=TDLCommentDAO.getRowCountC(TPC_num);
				 
		List<CommentCommand> listC = null;//null üũ
		if(countC > 0){
			System.out.println("����� DAO ȣ�� countC =>"+countC);
			listC = TDLCommentDAO.listC(TPC_num);
		}else{
			listC = Collections.emptyList();
			System.out.println("��� ListControllerŬ������ count="+countC);
		}
		
		commandL.setTL_id(TU_id);
		commandL.setTL_PNUM(TP_num);
		List<likeCommand> likeCheck=TDLLikeDAO.likeCheck(commandL);
		
		/*
		ModelAndView mav=new ModelAndView("boardView"); // ~ setViewName("boardView");
		mav.addObject("board",board); // request.setAttribute("board",board);
		return mav;
		*/  //1.�̵��� �������� 2.������ Ű�� 3.�����Ұ�
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
			log.debug("TdlCommand=>"+command);//�Է¹��� ���� ���
			//�αװ�ü��.debug(��´���ڸ� �Է�)
		}
		int TP_num = command.getTP_num();
		//�ۻ���
			System.out.println("������ TP_num =>"+TP_num);
			TDLPostDAO.delete(TP_num);
			System.out.println("���� ����! ");
		//return "redirect:��û��ɾ�"; =>return "�̵��� ��������"
			return "redirect:/TDL_POST/TDLPostList.do";
	}
	
	@RequestMapping("/TDLPostList.do")
	public ModelAndView process
	   (@RequestParam(value="pageNum",defaultValue="1")int currentPage,
	    @RequestParam(value="keyField",defaultValue="")String keyField,
	    @RequestParam(value="keyWord",defaultValue="")String keyWord){
		if(log.isDebugEnabled()){ //�αװ�ü�� �������������� �ƴ����� üũ
			System.out.println("����� ���� list.do");
			log.debug("currentPage : " + currentPage);//log.debug�޼��� ���
			log.debug("keyField : " + keyField);
			log.debug("keyWord : " + keyWord);
		}
		//�˻��о�,�˻�� ����->parameteType="map"
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyField", keyField);//�˻��о�
		map.put("keyWord", keyWord);//�˻���
		
		//�ѱ��� ���� �Ǵ� �˻��� ���� ����
		int recodeCount=TDLPostDAO.getRowCount(map);	    
		String url = "TDLPostList.do";
		int blockCount = 10;
		int pageCount = 3;
		//����¡ ó��  1.���������� 2.�ѷ��ڵ�� 3.�������� �Խù��� 4.���� �������� 5.��û��ɾ�
		PagingUtil page = new PagingUtil(currentPage, recodeCount, blockCount, pageCount, url);	
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());//�������Խù���ȣ
		
		List<TdlCommand> list = null;
		if(recodeCount > 0){
			System.out.println("����� DAO ȣ��");
			list = TDLPostDAO.list(map);
		}else{
			list = Collections.emptyList();
			System.out.println("ListControllerŬ������ count="+recodeCount);
		}
		
		ModelAndView  mav = new ModelAndView("TDLPostList");
		mav.setViewName("TDL_POST/TDLPostList");//TDLPostList.jsp
		mav.addObject("count", recodeCount);//�ѷ��ڵ��
		mav.addObject("list", list);//���ڵ���ü��
		mav.addObject("pagingHtml", page.getPagingHtml());//��ũ���ڿ��� ����
		System.out.println("�����Խ��� ��");
		return mav;
	}
	
	@RequestMapping(value="/TDLPostUpdate.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") TdlCommand command) {
		if(log.isDebugEnabled()) {
			log.debug("TdlCommand=>"+command);//�Է¹��� ���� ���
			//�αװ�ü��.debug(��´���ڸ� �Է�)
		}
		//��ȿ���˻�			

			//�۾��� ȣ��
			TDLPostDAO.update(command);
			System.out.println("�����Խ��� �ۼ��� TP_title =>"+command.getTP_title());
			System.out.println("�����Խ��� �ۼ��� TP_content =>"+command.getTP_content());

		//return "redirect:��û��ɾ�"; =>return "�̵��� ��������"
		return "redirect:/TDL_POST/TDLPostList.do";
	}

 //1.�ۼ��� ������ �̵�(Get���)
	@RequestMapping(value="/TDLPostUpdate.do",method=RequestMethod.GET)
	public ModelAndView form(@ModelAttribute("command")  TdlCommand command) {  //�޼������ ���Ƿ� �ۼ�
		System.out.println("������Ʈ ������ �̵� UpdateController  ȣ���!");
		int TP_num = command.getTP_num();
		if(log.isDebugEnabled()) {//�αװ�ü�� �۵����̶��(����׻���)
			log.debug("TP_num =>"+TP_num); //System.out.println("seq=>"+seq);
		}
		TDLPostDAO.selectTDLPost(TP_num);
		TdlCommand TDLPost=TDLPostDAO.selectTDLPost(TP_num);
		System.out.println("�� ���� => "+TDLPost.getTP_title());
		System.out.println("�� ���� =>"+TDLPost.getTP_content());
		
		//									1. �̵��� ������           2. Ű��     3. Ű��
		return new ModelAndView("TDL_POST/TDLPostUpdate","article",TDLPost);// ${board}
	}
	
	/*
	 * �ϳ��� ��û��ɾ�=>�ϳ��� ��Ʈ�ѷ��� ���X
	 * �ϳ��� ��Ʈ�ѷ�->�������� ��û��ɾ ����ؼ� ����� ����.
	 * ���� ��û��ɾ GET or POST���� ���������� �����ϴ� �Ӽ�
	 * method=RequestMethod.GET | method=RequestMethod.POST
	 */
	 //1.�۾��� ������ �̵�(Get���)
	@RequestMapping(value="/TDLPostWrite.do",method=RequestMethod.GET)
	public String form() {  //�޼������ ���Ƿ� �ۼ�
		System.out.println("�ٽ� ó������ ���� �Է¹ޱ����ؼ� form()ȣ���!");
		return "TDL_POST/TDLPostWrite";// return "�̵��� ��������'//definition name�� ����
	}
	
	//2.�����޼��� ���=>�ٽ� �ʱ�ȭ�� �����ϰ� ����->@ModelAttribute("Ŀ�ǵ尴ü ��Ī��")
	@ModelAttribute("command")
	public TdlCommand forBacking() { //��ȯ�� (DTO��) ������ �޼����
		System.out.println("forBacking()ȣ���!");
		return new TdlCommand();//BoardCommand bc=new BoardCommand();
	}
	//3.�Է��ؼ� ��ȿ���˻�->�����߻�
	//BindingResult->��ȿ���˻綧���� �ʿ�=>����������ü�� ����
	@RequestMapping(value="/TDLPostWrite.do",method=RequestMethod.POST)
	public String TDLPostWrite(@ModelAttribute("command") TdlCommand command,
			                       BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("TdlCommand=>"+command);//�Է¹��� ���� ���
			//�αװ�ü��.debug(��´���ڸ� �Է�)
		}
		//��ȿ���˻�			
			//�ִ밪+1
			int newNum=TDLPostDAO.getNewNumP()+1;
			System.out.println("newNum=>"+newNum);//1->2
			//�Խù���ȣ->���->����
			command.setTP_num(newNum);//2
			//�۾��� ȣ��
			TDLPostDAO.insert(command);
			System.out.println("�����Խ��� �۾��� TP_id =>"+command.getTP_id());
			System.out.println("�����Խ��� �۾��� TP_num =>"+command.getTP_num());
			System.out.println("�����Խ��� �۾��� TP_date =>"+command.getTP_date());
			System.out.println("�����Խ��� �۾��� TP_readcont =>"+command.getTP_readcount());
			System.out.println("�����Խ��� �۾��� TP_title =>"+command.getTP_title());
			System.out.println("�����Խ��� �۾��� TP_content =>"+command.getTP_content());

		//return "redirect:��û��ɾ�"; =>return "�̵��� ��������"
		return "redirect:/TDL_POST/TDLPostList.do";
	}
}


