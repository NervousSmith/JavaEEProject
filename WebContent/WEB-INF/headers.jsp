<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="project.javaee.UserBean"%>
    <%
    	if (session.getAttribute("currentSessionUser") == null){
    %>
	<%@include file="guestHeader.jsp"%>
	<%
    	}else if (session.getAttribute("currentSessionUser") != null){
	%> 
	<%@include file="userHeader.jsp"%>
	<%} %>