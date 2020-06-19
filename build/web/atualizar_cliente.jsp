<%-- 
    Document   : atualizar_cliente
    Created on : 18/06/2020, 21:20:58
    Author     : caigo
--%>

<%@page import="model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar</title>
    </head>
    <body>
         <%
              ArrayList lista = (ArrayList) request.getAttribute("lista");
         %>
        <div>
                       <h1>CRUD</h1>
            <fieldset>
                <legend>Atualizar Cliente</legend>
                 <%
                    for(int indice = 0; indice < lista.size(); indice++){
                        Cliente cliente = (Cliente) lista.get(indice);
                 %>
                <form action="Controle" method="post">
                    <input type="hidden" name="flag" value="atualizarcli">
                    <p> ID:<input type="text" name="id" size="8" value="<%=cliente.getId()%>" readonly> </p>
                    <p> Nome: <input type="text" name="nome" size="30" value="<%=cliente.getNome()%>"> </p>
                    <p> Telefone: <input type="text" name="tel" size="15" value="<%=cliente.getTelefone()%>"> </p>
                    <p> Idade: <input type="text" name="idade" size="8" value="<%=cliente.getIdade()%>"> </p>
                    <p> E-mail: <input type="text" name="email" size="15" value="<%=cliente.getEmail()%>"> </p>
                    <p> <input type="submit" value="Enviar">
                        <input type="reset" value="Limpar">
                    </p>    
                </form>
                 <%
                    }
                        %>
                <p><a href="index.html">Início</a></p>        
            </fieldset>
        </div>
    </body>
</html>
