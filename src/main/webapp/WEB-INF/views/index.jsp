<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 17.09.2020
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
    <title>Article Manager Home</title>
</head>

<body>

<div align="center">
    <h1>Article List</h1>
    <a href="new">New Article </a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>No</th>
            <th>Name</th>
            <th>Description</th>
            <th>Date</th>
            <th>Storage Place</th>
            <th>Reserved</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${articles}" var="article" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${article.name}</td>
                <td>${article.decription}</td>
                <td>${article.date}</td>
                <td>${article.storage_place}</td>
                <td>${article.reserved}</td>
                <td>
                    <a href="edit?id=${article.id}">Edit</a>
                    &nbsp;&nbsp;
                    <a href="delete?id=${article.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
