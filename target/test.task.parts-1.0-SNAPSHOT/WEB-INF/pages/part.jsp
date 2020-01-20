<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PARTS</title>
</head>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<h2 align="center">Parts</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>necessity</th>
        <th>number</th>
    </tr>
    <c:forEach var="part" items="${partsList}">
        <tr>
            <td>${part.id}</td>
            <td>${part.name}</td>
            <td>${part.necessity}</td>
            <td>${part.number}</td>
            <td>
                <a href="/edit/${part.id}">edit</a>
                <a href="/delete/${part.id}">delete</a>
            </td>
        </tr>
    </c:forEach>

</table>

<p align="center">
<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>
</p>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new part</a>


</body>
</html>