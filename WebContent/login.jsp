<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">@import "style.css";</style>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login to Bedhot Deals</title>
</head>
<body>
<%@ include file="sidebar.jsp"%>
<div id="normal" class="normal">
<%@ include file="header.jsp"%>
<p><img src="images/logo.png" />
<form action="dispatcher" method="post"> 
<table>
<tr><td><input type = "hidden" name="do" value="login">
	<tr><td>Email address:</td><td><input name="email" type="text" maxlength=50></td></tr>
	<tr><td>Password:</td><td><input name="password" type="password"></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" name="action" value="login"></TD></TR>
	<tr><td colspan="2" align="center"><input type="submit" name="action" value="register"></TD></TR>
	<tr><td colspan="2" align="center"><input type="submit" name="action" value="preg" title="provider register"></TD></TR>
	<tr><td colspan="2" align="center"><input type="submit" name="action" value="plog" title="provider login"></TD></TR>
</table>
</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>