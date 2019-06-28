<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% session=request.getSession();
	session.setAttribute("email", );
	
	
%>
	<pre>
	id:      <s:property value="id"/>
	Name:    <s:property value="name"/>
	Email:   <s:property value="email"/>
	Password:<s:property value="password"/>
	</pre>
</body>
</html>