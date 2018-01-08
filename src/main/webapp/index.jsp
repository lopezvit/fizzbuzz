<%--
  Created by IntelliJ IDEA.
  User: alejandro
  Date: 08/01/2018
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fizz Buzz Game</title>
</head>
<body>
<h1>Welcomed to the amazing game of Fizz Buzz.</h1>

<p>To Start, write a number and press <em>Play</em>.</p>

<form method="get">
    <label for="input-fizz-buzz">
        Input box
        <input id="input-fizz-buzz" type="text" name="input-fizz-buzz" placeholder="eg: 1, 7, 5, 3">
    </label>
    <input type="submit" value="Play">
    <%
        String inputFizzBuzz = request.getParameter("input-fizz-buzz");
        if (inputFizzBuzz != null) {
    %>
    <%@ page import = "fi.serviceflow.fizzbuzz.ws.FizzBuzzServlet" %>
    <h2>The result of your last play!</h2>
    <%
        try {%>
    <strong><%= FizzBuzzServlet.fizzBuzz(inputFizzBuzz) %></strong>
    <%
            } catch (Exception e) {%>
    <p style="color:red"><%= e.getMessage() %></p>
            <%}
        }
    %>
</form>
</body>
</html>
