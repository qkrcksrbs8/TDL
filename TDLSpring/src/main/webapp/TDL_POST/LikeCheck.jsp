<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 

<%
	System.out.println("댓글 ajax 이동성공");
 	response.setContentType("text/xml;charset=utf-8");
	String TU_id=request.getParameter("TU_id");
	String Comment=request.getParameter("Comment");
	System.out.println("댓글 받은 값 => "+TU_id+Comment);
%>


