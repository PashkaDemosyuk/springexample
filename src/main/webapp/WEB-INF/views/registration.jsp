<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 16.12.2018
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/myapp/add/projectmanager" method="POST"  commandName="projectManager-entity">
    <form:label path="login">Username:</form:label>
    <form:input path="login" />
    <form:label path="password">Password:</form:label>
    <form:input path="password" />
    <input type="submit" value="Submit"/>
</form:form>
${message}
</body>
</html>
