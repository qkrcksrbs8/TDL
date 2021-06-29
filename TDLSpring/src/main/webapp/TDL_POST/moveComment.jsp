<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  System.out.println("--------------------출력");
	request.setAttribute("TP_num", request.getAttribute("TP_num"));
	request.setAttribute("TP_id", request.getAttribute("TP_id"));
	request.setAttribute("TU_id", request.getAttribute("TU_id"));
	int TP_num=(Integer)request.getAttribute("TP_num");
	String TP_id =(String)request.getAttribute("TP_id");
	String TU_id =(String)request.getAttribute("TU_id");
	response.sendRedirect(request.getContextPath()+"/TDL_POST/TDLPostContent.do?TP_num="+TP_num+"&TP_id='"+TP_id+"'&TU_id='"+TU_id+"'");
%>
  
