<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">@import "style.css";</style>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Search!</title>
</head>
<body>

<%@ include file="sidebar.jsp"%>
<div id="normal" class="normal">
<%@ include file="header.jsp"%>
<%-- main content --%>
<h1> Search for a hotel</h1>
<form action="dispatcher" method="get">
<label>description contains: <input type="text" name="desc"></label>
<input type="submit" name="do" value="search">

</form>
</div>
<%@ include file="footer.jsp"%>

</body>
</html>
