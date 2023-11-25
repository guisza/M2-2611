<%-- 
 * Problema/Necessidades: Digitalização de Ficha de Personagem de RPG de Mesa
 * Data: 17/11/2023
 * Autor: Guilherme Assis, Gustavo Cunha, Pedro Braga
 * Projeto: Ficha de Personagem de RPG de Mesa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Personagem"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/style.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Consultar Todos</title>
        <link rel="stylesheet" href="./css/todos.css"/>
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

        <h1>Todos os Personagens</h1><br>
        <%
            List<Personagem> lprod = (List<Personagem>) request.getAttribute("lprod");
        %>


        <table border="2" style="text-align: center;">
            <tr>
                <th>ID</th>
                <th>Nome do personagem</th>
                <th>Conceito do personagem</th>
                <th>Pontos "Heroi"</th>
                <th>Visualização completa</th>
                <th>Editar</th>
                <th>Remover</th>
            </tr>

            <%for (Personagem per : lprod) {%>
            <tr>                
                <td><%out.print(per.getId());%></td>
                <td><%out.print(per.getNome());%></td>
                <td><%out.print(per.getConceito());%></td>
                <td><%out.print(per.getPtheroi());%></td>
                <td align="center"><a href="http://localhost:8080/M2-2611/controller_personagem?op=CONSULTAR%20BY%20ID&ident=<%out.print(per.getId());%>"><img src="./imagem/plus.png""></a></td>
                <td align="center"><a href="http://localhost:8080/M2-2611/controller_personagem?op=ATUALIZAR&ident=<%out.print(per.getId());%>&nome<%out.print(per.getNome());%>&conceito<%out.print(per.getConceito());%>&caracteristicas<%out.print(per.getCaracteristicas());%>&historico<%out.print(per.getHistorico());%>&equipamento<%out.print(per.getEquipamento());%>&defeito<%out.print(per.getDefeito());%>&ptheroi<%out.print(per.getPtheroi());%>&nvsaude<%out.print(per.getNvsaude());%>&proeza1<%out.print(per.getProeza1());%>&proeza2<%out.print(per.getProeza2());%>&proeza3<%out.print(per.getProeza3());%>&ptproeza1<%out.print(per.getPtproeza1());%>&ptproeza2<%out.print(per.getPtproeza2());%>&ptproeza3<%out.print(per.getPtproeza3());%>" ><img src="./imagem/edit.png"></a></td>
                <td align="center"><a href="http://localhost:8080/M2-2611/controller_personagem?op=DELETAR&ident=<%out.print(per.getId());%>"><img src="./imagem/delete.png""></a></td>
            </tr>
            <%}%>

        </table>

    </body><br>
    <button class="botao" onclick="document.location = 'index.html'" style="margin-bottom: 7px; background: #FFFF7B; padding: 5px; border-radius: 13px; text-align: center; width: 300px; height: 40px;">VOLTAR</button> <p>
</center>

</html>
