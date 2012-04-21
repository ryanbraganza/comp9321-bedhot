<jsp:useBean id="customer" class="bedhot.beans.CustomerBean" scope="session" />
<jsp:useBean id="provider" class="bedhot.beans.ProviderBean" scope="session" />
<div id = "sidebar" class="sidebar">
<p><ul>
<li><a href="welcome.jsp">welcome</a></li>
<li><a href="about.jsp">about us</a></li>
<% if (customer.getId() !=0) { %>
<li><a href="logout.jsp">logout</a></li>
<li><a href="cart.jsp">view cart</a></li>
<% } else { %>
<li><a href="login.jsp">login</a></li>
<% } %>
<li><a href="search.jsp">search!</a></li>
<li><a href="checkout.jsp">checkout</a></li>
<li><a href="about.jsp">about us</a></li>
<% if (provider.getId() != 0) {%>
<li><a href="makeDeal.jsp">make a deal</a></li>
<% } %>
<li><a href="privacy.jsp">privacy policy</a></li>

</ul>

</div>