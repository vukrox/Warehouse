<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 17.09.2020
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

    <script>
        $(function () {
            $("#creationDate").datepicker({
                dateFormat: 'yy-mm-dd',
                changeMonth:true,
                changeYear:true
            }).datepicker('setDate', '0');
        })
    </script>

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
                <td>Creation Date</td>
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
