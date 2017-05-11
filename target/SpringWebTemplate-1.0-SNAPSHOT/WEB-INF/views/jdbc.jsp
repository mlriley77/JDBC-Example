<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MichaelRiley
  Date: 5/11/17
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JDBC Demo</title>
</head>
<body>
<h1>DB Results</h1>

<table>

    <!-- using for each to loop through my arraylist -->

    <c:forEach items="${addStuff}" var="list">
        <tr>
        <td><c:out value ="${list}"></c:out></td>
        </tr>

    </c:forEach>
</table>


</body>
</html>
