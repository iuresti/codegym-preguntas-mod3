<%@ page import="codegym.module3.models.Question" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Ivan.Uresti
  Date: 2/23/2024
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    if (request.getParameter("playerName") != null) {
        session.setAttribute("playerName", request.getParameter("playerName"));
    }

    Question question = (Question) request.getAttribute("nextQuestion");
%>

<h2>Bienvenido al juego <%=session.getAttribute("playerName")%>
</h2>


<c:choose>
    <c:when test="${question}">


        <h3>Perdiste la memoria</h3>
        <h1>¿Aceptas el reto?</h1>

        <form action="/preguntas/answer-provided" method="post" accept-charset="utf-8">
            <input type="radio" id="challengeAcceptedRadio" name="playerResponse" value="Si"><label
                for="challengeAcceptedRadio">Sí</label>
            <input type="radio" id="challengeRejectedRadio" name="playerResponse" value="No"><label
                for="challengeRejectedRadio">No</label>
            <button type="submit">Confirmar</button>
        </form>
    </c:when>
    <c:otherwise>
        <h3><%=question.getLabel()%>
        </h3>
        <h1><%=question.getQuestion() != null ? question.getQuestion() : ""%>
        </h1>

        <form action="answer-provided" method="post" accept-charset="utf-8">

            <c:forEach var="entry" items="${question.getAnswers()}">
                <input type="radio" name="playerResponse" value="<c:out value="${entry.key}"/>">
                <label><c:out value="${entry.key}"/>
            </label>
            </c:forEach>
            <button type="submit"><%=question.getQuestion() != null ? "Confirmar" : "Reiniciar"%>
            </button>
        </form>

    </c:otherwise>
</c:choose>

</body>
</html>
