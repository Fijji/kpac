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
    <title>K-PAC Set List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/dhtmlx.css' />">
    <script src="<c:url value='/resources/dhtmlx.js' />"></script>
</head>
<body>
<h1>K-PAC Set List</h1>
<table id="kpacSetGrid" class="dhtmlxGrid">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="kpacSet" items="${kpacSets}">
        <tr>
            <td>${kpacSet.id}</td>
            <td>${kpacSet.title}</td>
            <td><a href="deleteKpacSet?id=${kpacSet.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    // Initialize DHTMLX Grid
    dhtmlXGridObject("kpacSetGrid").init();
</script>
</body>
</html>

