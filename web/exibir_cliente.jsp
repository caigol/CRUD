<%-- 
    Document   : exibir_cliente
    Created on : 11/06/2020, 20:00:06
    Author     : caigo
--%>
<%@page import="model.Cliente" %>
<%@page import="java.util.ArrayList"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exibir Clientes</title>
        <style>
            table{
                border-collapse: collapse; 
            }
            table, td, th{
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <h1>Exibir resultados da consulta</h1>
        <div id="conteudo">
            <%
              ArrayList lista = (ArrayList) request.getAttribute("lista");
            %>
            
            <table>
                <tr id="tabela">
                    <th>ID:</th>
                    <th>Nome:</th>
                    <th>Telefone:</th>
                    <th>E-mail:</th>
                    <th>Idade:</th>
                    <th>Ações:</th>
                </tr>
                <%
                    for(int indice = 0; indice < lista.size(); indice++){
                        Cliente cliente = (Cliente) lista.get(indice);
                 %>
                 <tr id="tabela">
                     <td><%=cliente.getId()%></td>
                     <td><%=cliente.getNome()%></td>
                     <td><%=cliente.getTelefone()%></td>
                     <td><%=cliente.getEmail()%></td>
                     <td><%=cliente.getIdade()%></td>
                     <td><a href="Controle?flag=apagarcliente&id=<%=cliente.getId()%>">Excluir</a>
                      /  <a href="Controle?flag=consultarclienteid&id=<%=cliente.getId()%>">Atualizar</a>
                     </td>
                 </tr>
                 <%
                    } 
                 %>
            </table>
            <p><a href="index.html">Início</a></p>
        </div>
    </body>
</html>
