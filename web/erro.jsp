<%-- 
  Problema/Necessidades: Digitalização de Ficha de Personagem de RPG de Mesa
  Data: 17/11/2023
  Autor: Guilherme Assis, Gustavo Cunha, Pedro Braga
  Projeto: Ficha de Personagem de RPG de Mesa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Falha na operação</title>
    </head>
    <body>
        <%
           String msg = (String) request.getAttribute("message");
        %>
        <h1><%out.println(msg);%> não realizado</h1>
    </body>
</html>
