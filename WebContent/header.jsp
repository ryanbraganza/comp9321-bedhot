
<div id="header" class="header">
<% if (customer.getId() == 0 && provider.getId() == 0) {%>
You are not logged in.

<a href="login.jsp">login</a>|<% } else {%>
<% if (customer.getId() != 0) {%>
Welcome <%= customer.getEmail()%>
<%} %>
<% } %>
<% if (provider.getId() != 0) {%>
Welcome, <%= provider.getEmail() %>
<%} %>
<a href="welcome.jsp">go home</a>
</div>