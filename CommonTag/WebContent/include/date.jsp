<%@page import="java.util.Date,java.text.SimpleDateFormat" %>
<strong>
	<%=request.getParameter("str") %>
	当前时间是:<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) %>
</strong>
<br/>