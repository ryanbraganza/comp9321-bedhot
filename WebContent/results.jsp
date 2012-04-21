<jsp:useBean id="list" type="java.util.ArrayList" scope="request"></jsp:useBean>
<%@ page import="bedhot.beans.DealBean" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">@import "style.css";</style>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome to Bed Hot Deals!</title>
</head>
<body>
<%@ include file="sidebar.jsp"%>
<div id="normal" class="normal">
<%@ include file="header.jsp"%>
<p> deals listed are
<% for (DealBean deal : (List<DealBean>) list) { %>
<%= deal.getHotelName() + deal.getID() + deal.getInfo() + deal.getStart() + deal.getEnd() %>
<br />
<%} %>
</p></div>
</body>
</html>