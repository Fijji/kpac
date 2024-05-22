<%--
  Created by IntelliJ IDEA.
  User: kpota
  Date: 22.05.2024
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>K-PAC List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/dhtmlx.css' />">
    <script src="<c:url value='/resources/dhtmlx.js' />"></script>
</head>
<body>
<h1>K-PAC List</h1>
<table id="kpacGrid" class="dhtmlxGrid">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Creation Date</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="kpac" items="${kpacs}">
        <tr>
            <td>${kpac.id}</td>
            <td>${kpac.title}</td>
            <td>${kpac.description}</td>
            <td>${kpac.creationDate}</td>
            <td><a href="deleteKpac?id=${kpac.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    // Initialize DHTMLX Grid
    dhtmlXGridObject("kpacGrid").init();
</script>
</body>
</html>

