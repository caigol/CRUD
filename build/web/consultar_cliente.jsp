<%-- 
    Document   : consultar_cliente
    Created on : 11/06/2020, 19:59:53
    Author     : caigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta</title>
    </head>
    <body>
        <h1>Consultar Clientes pelo nome</h1>
        <form method="get" action="Controle">
            <input type="hidden" name="flag" value="consultarclientenome">
            <p>
                <label>Nome: </label>
                <input type="text" name="nome" size="50">
                <input type="submit" value="Buscar">
            </p>
        </form>
 
        <h1>Consultar todos os Clientes cadastrados</h1>
        <form method="get" action="Controle">
            <input type="hidden" name="flag" value="consultartodosclientes">
            <input type="submit" value="Buscar">
        </form>
        <p><a href="index.html">Início</a></p>
    </body>
</html>
