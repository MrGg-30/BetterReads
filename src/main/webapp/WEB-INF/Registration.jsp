<%--
  Created by IntelliJ IDEA.
  User: GG
  Date: 8/4/2021
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Better Reads</title>
</head>
<body>

<form action="register" method="post">
    <table style="width: 25%">
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="first_name" /></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="last_name" /></td>
        </tr>
        <tr>
            <td>Userame:</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" /></td>
        </tr>
    </table>
    <input type="submit" value="Register" />
</form>

</body>
</html>