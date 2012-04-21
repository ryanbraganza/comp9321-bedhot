<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">@import "style.css";</style>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Make a deal!</title>
</head>
<body>


<%@ include file="sidebar.jsp"%>
<div id="normal" class="normal">
<%@ include file="header.jsp"%>
</div>
<%@ include file="footer.jsp"%>
<div id="normal">
<% if (provider.getId() != 0) { %>
<h1> let's make a deal, ok?</h1>
<form action="dispatcher" method="post">
<input type="hidden" name="do" value="
</form>
<% } else { %>
<a href="welcome.jsp"> you are not a provider.  what are you doing here?</a>
<% } %>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
