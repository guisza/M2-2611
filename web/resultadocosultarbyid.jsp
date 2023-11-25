<%-- 
  Problema/Necessidades: Digitalização de Ficha de Personagem de RPG de Mesa
  Data: 17/11/2023
  Autor: Guilherme Assis, Gustavo Cunha, Pedro Braga
  Projeto: Ficha de Personagem de RPG de Mesa
--%>

<%@page import="model.Personagem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Cosultar By ID</title>
        <link rel="stylesheet" href="./css/style.css" type="text/css"/>
    </head>
    <body>
        <header>
            <div class="hright">
                <img src="./imagem/finn.jpg" alt="alt" width="40" height="40"/>
                <img src="./imagem/caroco.jpg" alt="alt" width="40" height="40"/>
                <img src="./imagem/jake.jpg" alt="alt" width="40" height="40"/>
            </div>
            <img src="./imagem/logo.webp" alt="alt" width="120" height="60"/>
            <div class="hright">
                <img src="./imagem/marceline.jpg" alt="alt" width="40" height="40"/>
                <img src="./imagem/reigelado.webp" alt="alt" width="40" height="40"/>
                <img src="./imagem/princesajujuba.webp" alt="alt" width="40" height="40"/>
            </div>
        </header>
    <center>
        <br><h1>Resultado Consultar By ID</h1><br><br><br>
        <%
            Personagem per = (Personagem) request.getAttribute("per");
        %>
        <%if (per.getNome() != null) {%>
        ID..........: <%out.print(per.getId());%> <BR>
        Nome...: <%out.print(per.getNome());%> <BR>
        Conceito.......: <%out.print(per.getConceito());%> <BR>
        caracteristicas.......: <%out.print(per.getCaracteristicas());%> <BR>
        historico.......: <%out.print(per.getHistorico());%> <BR>
        equipamento.......: <%out.print(per.getEquipamento());%> <BR>
        defeito.......: <%out.print(per.getDefeito());%> <BR>
        ptheroi.......: <%out.print(per.getPtheroi());%> <BR>
        nvsaude.......: <%out.print(per.getNvsaude());%> <BR>
        proeza1.......: <%out.print(per.getProeza1());%> <BR>
        ptproeza1.......: <%out.print(per.getPtproeza1());%> <BR>
        proeza2.......: <%out.print(per.getProeza2());%> <BR>
        ptproeza2.......: <%out.print(per.getPtproeza2());%> <BR>
        proeza3.......: <%out.print(per.getProeza3());%> <BR>
        ptproeza3.......: <%out.print(per.getPtproeza3());%> <BR>

        <%} else {%>
        <h2>Personagem não encontrado.</h2>
        <%}%>
    </body>
    <br><br><br>
    <button class="botao" onclick="document.location = 'http://localhost:8080/M2-2611/controller_personagem?op=CONSULTAR+TODOS'" style="margin-bottom: 7px; background: #FFFF7B; padding: 5px; border-radius: 13px; text-align: center; width: 300px; height: 40px;">VOLTAR</button> <p>

</center>

</html>
