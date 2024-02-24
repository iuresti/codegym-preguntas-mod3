<%--
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
        if(request.getParameter("playerName") != null){
            session.setAttribute("playerName", request.getParameter("playerName"));
        }
    %>

    <h2>Bienvenido al juego <%=session.getAttribute("playerName")%></h2>

  <h3>Perdiste la memoria</h3>
  <h1>¿Aceptas el reto?</h1>

  <form action="game.jsp" method="post">
      <input type="radio" id="challengeAcceptedRadio" name="challengeDecision" value="true"><label for="challengeAcceptedRadio">Sí</label>
      <input type="radio" id="challengeRejectedRadio" name="challengeDecision" value="false"><label for="challengeRejectedRadio">No</label>
      <button type="submit">Confirmar</button>
  </form>

</body>
</html>
