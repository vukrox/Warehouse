<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 17.09.2020
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>New / Edit Article</title>
</head>
<body>
<div align="center">
    <h1>New / Edit Article</h1>
    <form:form action="save" method="post" modelAttribute="article">
        <table cellpadding="5">
            <form:hidden path="id"/>
            <tr>
                <td>Name</td>
                <td><form:input path="name"/></td>
            </tr>

            <tr>
                <td>Description</td>
                <td><form:input path="description"/></td>
            </tr>

            <tr>
                <td>CreationDate</td>
                <td><form:input path="creationDate"/></td>
            </tr>

            <tr>
                <td>Place of storage</td>
                <td><form:input path="storagePlace"/></td>
            </tr>

            <tr>
                <td>reserved</td>
                <td><form:input path="reserved"/></td>
            </tr>
            <tr>
               <td colspan="2" align="center">
                <input type="submit" value="Save"/>
               </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
