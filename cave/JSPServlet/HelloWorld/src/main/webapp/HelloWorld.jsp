<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World JSP!</h1>
        <%="Hello World JSP from Java<br />"%>
        <%
            Date today = new java.util.Date();
            String text = "Today's date is : " + today.toString();
            out.println(text);
        %>
    </body>
</html>
