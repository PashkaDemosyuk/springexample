<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 18.12.2018
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="developerList" items="${developerList}">
        <tr>
            <td>Begin date project: ${developerList.beginDate}</td>
        </tr>
        <tr>
            <td>End date project: ${developerList.endDate}</td>
        </tr>
        <tr>
            <td>Project Manager: ${developerList.projectManager.login}</td>
        </tr>
        <tr>
            <td>Customer: ${developerList.customer}</td>
        </tr>
    </c:forEach>
    Salary for the last month: ${rate}
</table>
</body>
</html>
