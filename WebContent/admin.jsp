<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ page import="bedhot.dao.DAOFactory"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome admin. Please do not be here if you are not admin</title>
</head>
<body>
<p><ul>
<%
	List<String> everything = DAOFactory.getInstance().getDealDAO()
			.listAll();
	for (int i=0; i < everything.size(); i++) {
%> <li><%= everything.get(i) %>
<% } %></ul>
</body>
</html>