<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 17.12.2018
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create Developer</h1>
<form:form action="/myapp/add/developer" method="POST"  commandName='developer-entity'>
    <table>
        <tr>
            <td><form:label path="login">Developer name:</form:label></td>
            <td><form:input path="login" /></td>
        </tr>
        <tr>
            <td><form:label path="password">Password:</form:label></td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td><form:label path="experience">Experience:</form:label></td>
            <td><form:input path="experience" /></td>
        </tr>
        <tr>
            <td><form:label path="birthday">Birthday:</form:label></td>
            <td><form:input path="birthday"  />
            </td>
        </tr>
        <tr>
            <td><form:label path="address.street">Address Street:</form:label></td>
            <td><form:input path="address.street"/></td>
        </tr>
        <tr>
            <td><form:label path="address.roomNumber">Address roomNumber:</form:label></td>
            <td><form:input path="address.roomNumber"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
${message}

<h1>Create Position</h1>
<form:form action="/myapp/add/position" method="POST"  commandName="position-entity">
    <table>
        <tr>
            <td><form:label path="positionName"> Position: </form:label></td>
            <td><form:input path="positionName" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
<h1>Create Developer Position </h1>
<form:form action="/myapp/add/developer_positions" method="POST"  commandName="position_developer-entity">
    <table>
        <tr>
            <td><form:label path="developer.id"> Developer_id: </form:label></td>
            <td><form:input path="developer.id" /></td>
        </tr>
        <tr>
            <td><form:label path="position.id"> Position_id: </form:label></td>
            <td><form:input path="position.id" /></td>
        </tr>
        <tr>
            <td><form:label path="salary"> Salary: </form:label></td>
            <td><form:input path="salary" /></td>
        </tr>
        <tr>
            <td><form:label path="month"> Date salary: </form:label></td>
            <td><form:input path="month" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
<h1>Create Project</h1>
<form:form action="/myapp/add/project" method="POST"  commandName="project-entity">
    <table>
        <tr>
            <td><form:label path="beginDate"> Begin date: </form:label></td>
            <td><form:input path="beginDate" /></td>
        </tr>
        <tr>
            <td><form:label path="endDate"> End date: </form:label></td>
            <td><form:input path="endDate" /></td>
        </tr>
        <tr>
            <td><form:label path="customer"> Customer: </form:label></td>
            <td><form:input path="customer" /></td>
        </tr>
        <tr>
            <td><form:label path="projectManager.id"> Project manager id: </form:label></td>
            <td><form:input path="projectManager.id" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
<h1>Create Project Position </h1>
<form:form action="/myapp/add/project_position" method="POST"  commandName="proj_dev_pos-entity">
    <table>
        <tr>
            <td><form:label path="project.id"> Project id: </form:label></td>
            <td><form:input path="project.id" /></td>
        </tr>
        <tr>
            <td><form:label path="devPos.id"> Developer position id: </form:label></td>
            <td><form:input path="devPos.id" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
<h1>Delete Developer</h1>
<form:form action="/myapp/delete/developer" method="POST"  commandName="developer-delete-entity">
    <table>
        <tr>
            <td><form:label path="id"> Developer id: </form:label></td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
<h1>Developer By Project</h1>
<form:form action="/myapp/add/find/project" method="POST"  >
    <table>
        <tr>
            <td><label > Project id: </label></td>
            <td><input type="text" name="proj" /></td>
        </tr>
        <tr>
            <td><label > limit: </label></td>
            <td><input type="text" name="lim" /></td>
        </tr>
        <tr>
            <td><label > Page num: </label></td>
            <td><input type="text" name="pagenum" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
