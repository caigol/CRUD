/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author caigo
 */
@WebServlet(name = "Controle", urlPatterns = {"/Controle"})
public class Controle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       String nome, tel, email, mensagem;
       int idade;
       String flag = request.getParameter("flag");
       
       if(flag.equalsIgnoreCase("salvarcli")){
           nome = request.getParameter("nome");
           tel = request.getParameter("tel");
           idade = Integer.parseInt(request.getParameter("idade"));
           email = request.getParameter("email");
           
           Cliente cli = new Cliente();
           cli.setIdade(idade);
           cli.setEmail(email);
           cli.setNome(nome);
           cli.setTelefone(tel);
           
           ClienteDAO dao = new ClienteDAO();
           int r = dao.conectar();
           
           if(r == 0){
               mensagem = "Erro ao se conectar ao banco de dados";
               request.setAttribute("mensagem", mensagem);
               RequestDispatcher d = request.getRequestDispatcher("erro.jsp");
               d.forward(request, response);
           }else{
               r = dao.salvarCliente(cli);
               if (r == 1){
                   mensagem = "Cliente Cadastrado!!!";
                   request.setAttribute("mensagem", mensagem);
                   RequestDispatcher d = request.getRequestDispatcher("cadastrosucesso.jsp");
                   d.forward(request, response);
               }else{
                   mensagem = "Ocorreu um erro ao inserir o Cliente";
                   request.setAttribute("mensagem", mensagem);
                   RequestDispatcher d = request.getRequestDispatcher("erro.jsp");
                   d.forward(request, response);
               }
               dao.desconectar();
           }
       }else if(flag.equalsIgnoreCase("consultarclientenome")){
           nome = request.getParameter("nome");
           
           ClienteDAO dao = new ClienteDAO();
           int r = dao.conectar();
           if(r == 0){
               mensagem = "Erro na conexão com o BD";
               request.setAttribute("mensagem", mensagem);
               RequestDispatcher d = request.getRequestDispatcher("erro.jsp");
               d.forward(request, response);
           }else{
               ArrayList lista = dao.consultarClienteNome(nome);
               if(!lista.isEmpty()){
                   request.setAttribute("lista", lista);
                   RequestDispatcher d = request.getRequestDispatcher("exibir_cliente.jsp");
                   d.forward(request, response);
                   return;
               }else{
                   mensagem = "Usuário não encontrado!!!";
                   request.setAttribute("mensagem", mensagem);
                   RequestDispatcher d = request.getRequestDispatcher("cadastrosucesso.jsp");
               }
               dao.desconectar();
           }
        }else if(flag.equalsIgnoreCase("consultarclienteid")){
           String id = request.getParameter("id");
           
           ClienteDAO dao = new ClienteDAO();
           int r = dao.conectar();
           if(r == 0){
               mensagem = "Erro na conexão com o BD";
               request.setAttribute("mensagem", mensagem);
               RequestDispatcher d = request.getRequestDispatcher("erro.jsp");
               d.forward(request, response);
           }else{
               ArrayList lista = dao.consultarClienteId(id);
               if(!lista.isEmpty()){
                   request.setAttribute("lista", lista);
                   RequestDispatcher d = request.getRequestDispatcher("atualizar_cliente.jsp");
                   d.forward(request, response);
                   return;
               }else{
                   mensagem = "Usuário não encontrado!!!";
                   request.setAttribute("mensagem", mensagem);
                   RequestDispatcher d = request.getRequestDispatcher("cadastrosucesso.jsp");
               }
               dao.desconectar();
           }
        }else if(flag.equalsIgnoreCase("consultartodosclientes")){
            ClienteDAO dao = new ClienteDAO();
            int r = dao.conectar();
            if(r == 0){
                mensagem = "Erro na conexão com o BD";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher d = request.getRequestDispatcher("erro.jsp");
                d.forward(request, response);
            }else{
                ArrayList lista = dao.ConsultarTodosCliente();
                if(!lista.isEmpty()){
                    request.setAttribute("lista", lista);
                    RequestDispatcher d = request.getRequestDispatcher("exibir_cliente.jsp");
                    d.forward(request, response);
                    return;
                }else{
                    mensagem = "Nenhum usuário encontrado!!!";
                    request.setAttribute("mensagem", mensagem);
                    RequestDispatcher d = request.getRequestDispatcher("cadastrosucesso.jsp");
                    d.forward(request, response);
                }
                dao.desconectar();
            }
            
       }else if(flag.equalsIgnoreCase("apagarcliente")){
           String id = request.getParameter("id");
           
           ClienteDAO dao = new ClienteDAO();
           dao.conectar();
           int r = dao.apagarCliente(id);
           
           if(r == 1){
                mensagem = "Usuário excluído!!!";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher d = request.getRequestDispatcher("cadastrosucesso.jsp");
                d.forward(request, response);
           }else{
                mensagem = "Erro ao excluir!!!";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher d = request.getRequestDispatcher("erro.jsp");
                d.forward(request, response);
           }
           dao.desconectar();
       }else if(flag.equalsIgnoreCase("atualizarcli")){
           nome = request.getParameter("nome");
           tel = request.getParameter("tel");
           idade = Integer.parseInt(request.getParameter("idade"));
           email = request.getParameter("email");
           int id = Integer.parseInt(request.getParameter("id"));
           
           Cliente cli = new Cliente();
           cli.setIdade(idade);
           cli.setEmail(email);
           cli.setNome(nome);
           cli.setTelefone(tel);
           cli.setId(id);
           
           ClienteDAO dao = new ClienteDAO();
           int r = dao.conectar();
           
           if(r == 0){
               mensagem = "Erro ao se conectar ao banco de dados";
               request.setAttribute("mensagem", mensagem);
               RequestDispatcher d = request.getRequestDispatcher("erro.jsp");
               d.forward(request, response);
           }else{
               r = dao.atualizarCliente(cli);
               if (r == 1){
                   mensagem = "Cliente Atualizado!!!";
                   request.setAttribute("mensagem", mensagem);
                   RequestDispatcher d = request.getRequestDispatcher("cadastrosucesso.jsp");
                   d.forward(request, response);
               }else{
                   mensagem = "Ocorreu um erro ao atualizar o Cliente";
                   request.setAttribute("mensagem", mensagem);
                   RequestDispatcher d = request.getRequestDispatcher("erro.jsp");
                   d.forward(request, response);
               }
               dao.desconectar();
           }
       }
       
       else{
                mensagem = "Erro na FLAG";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher d = request.getRequestDispatcher("erro.jsp");
                d.forward(request, response);
            }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
