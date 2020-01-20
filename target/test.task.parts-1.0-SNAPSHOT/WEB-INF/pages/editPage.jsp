<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty part.name}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty part.name}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty part.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty part.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty part.name}">
        <input type="hidden" name="id" value="${part.id}">
    </c:if>
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="necessity">Necessity</label>
    <input type="text" name="necessity" id="necessity">
    <label for="number">Number</label>
    <input type="text" name="number" id="number">
    <c:if test="${empty part.name}">
        <input type="submit" value="Add new part">
    </c:if>
    <c:if test="${!empty part.name}">
        <input type="submit" value="Edit part">
    </c:if>
</form>
</body>
</html>