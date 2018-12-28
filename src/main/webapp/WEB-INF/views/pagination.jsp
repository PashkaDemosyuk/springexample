<%--
  Created by IntelliJ IDEA.
  User: pashk
  Date: 28.12.2018
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <th>ID</th>
    <th>LOGIN</th>
    <th>PASSWORD</th>
    <th>EXPERIENCE</th>
    <th>DIRTHDAY</th>
<c:forEach var="developerList" items="${developerList}">
    <tr>
        <td> ${developerList[0]}</td>
        <td> ${developerList[1]}</td>
        <td> ${developerList[2]}</td>
        <td> ${developerList[3]}</td>
        <td> ${developerList[4]}</td>
    </tr>
</c:forEach>
</table>

</body>
</html>
