<%-- 
    Document   : apagar_cliente
    Created on : 18/06/2020, 20:14:04
    Author     : caigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deletar</title>
    </head>
    <body>
        <h1>Apagar Clientes pelo ID</h1>
        <fieldset>
            <legend>Deletar</legend>
            <form action="Controle">
                <input type="hidden" name="flag" value="apagarcliente">
                <p><label>ID: </label>
                    <input type="number" name="id" size="10">
                </p>
                <p>
                    <input type="submit" value="Apagar">
                </p>
            </form>
            <p><a href="index.html">Início</a></p>
        </fieldset>
    </body>
</html>
