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
        <title>Atualizar Personagem</title>
        <link rel="stylesheet" href="./css/style.css" type="text/css"/>

    </head>
            <center>

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
        <br><br><br><h1>Atualizar Personagem</h1>
        <%
            Personagem per = (Personagem) request.getAttribute("per");
        %>
        <%if (per.getNome() != null) {%>

        <form action="controller_personagem" method="GET">
            ID..........: <%out.print(per.getId());%> <input type="hidden" name="ident" value="<%out.print(per.getId());%>"> <BR>
            Nome...: <input type="text" id="nome" name="nome" value="<%out.print(per.getNome());%>"> <BR>
            Conceito.......: <input type="text" id="conceito" name="conceito" value="<%out.print(per.getConceito());%>"> <BR>
            caracteristicas.......: <input type="text" id="caracteristicas" name="caracteristicas" value="<%out.print(per.getCaracteristicas());%>"> <BR>
            historico.......: <input type="text" id="historico" name="historico" value="<%out.print(per.getHistorico());%>"> <BR>
            equipamento.......: <input type="text" id="equipamento" name="equipamento" value="<%out.print(per.getEquipamento());%>"> <BR>
            defeito.......: <input type="text" id="defeito" name="defeito" value="<%out.print(per.getDefeito());%>"> <BR>
            ptheroi.......: <input type="number" id="ptheroi" name="ptheroi" value="<%out.print(per.getPtheroi());%>"> <BR>
            nvsaude.......: <input type="number" id="nvsaude" name="nvsaude" value="<%out.print(per.getNvsaude());%>"> <BR>
            proeza1.......: <input type="text" id="proeza1" name="proeza1" value="<%out.print(per.getProeza1());%>"> <BR>
            ptproeza1.......: <input type="number" id="ptproeza1" name="ptproeza1" value="<%out.print(per.getPtproeza1());%>"> <BR>
            proeza2.......: <input type="text" id="proeza2" name="proeza2" value="<%out.print(per.getProeza2());%>"> <BR>
            ptproeza2.......: <input type="number" id="ptproeza2" name="ptproeza2" value="<%out.print(per.getPtproeza2());%>"> <BR>
            proeza3.......: <input type="text" id="proeza3" name="proeza3" value="<%out.print(per.getProeza3());%>"> <BR>
            ptproeza3.......: <input type="number" id="ptproeza3" name="ptproeza3" value="<%out.print(per.getPtproeza3());%>"> <BR><BR>
            <input type="submit" name="op" value="EFETIVAR ATUALIZAÇÃO" style ="margin-bottom: 7px; background: #FFFF7B; padding: 5px; border-radius: 13px; text-align: center; width: 300px; height: 40px;">
        </form>
        <%} else {%>
        <h2>Personagem não encontrado.</h2>
        <%}%>
    </body>
        <button class="botao" onclick="document.location = 'http://localhost:8080/M2-2611/controller_personagem?op=CONSULTAR+TODOS'" style="margin-bottom: 7px; background: #FFFF7B; padding: 5px; border-radius: 13px; text-align: center; width: 300px; height: 40px;">VOLTAR</button> <p>

            </center>

</html>
