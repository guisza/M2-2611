package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Personagem;
import model.PersonagemDao;

@WebServlet(name = "controller_personagem", urlPatterns = {"/controller_personagem"})
public class controller_personagem extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String op = request.getParameter("op");
            PersonagemDao pdao = new PersonagemDao();
            Personagem per = new Personagem();
            
           if (op.equals("CADASTRAR")) {      
               
                per.setNome(request.getParameter("nome"));
                per.setConceito(request.getParameter("conceito"));
                per.setCaracteristicas(request.getParameter("caracteristicas"));
                per.setHistorico(request.getParameter("historico"));
                per.setEquipamento(request.getParameter("equipamento"));
                per.setDefeito(request.getParameter("defeito"));
                per.setPtheroi(Integer.parseInt(request.getParameter("ptheroi")));
                per.setNvsaude(Integer.parseInt(request.getParameter("nvsaude")));
                per.setProeza1(request.getParameter("proeza1"));
                per.setProeza2(request.getParameter("proeza2"));
                per.setProeza3(request.getParameter("proeza3"));
                per.setPtproeza1(Integer.parseInt(request.getParameter("ptproeza1")));
                per.setPtproeza2(Integer.parseInt(request.getParameter("ptproeza2")));
                per.setPtproeza3(Integer.parseInt(request.getParameter("ptproeza3")));

                String msg = "Cadastrar";
                try {
                    pdao.cadastrar(per);
                    System.out.println("Cadastrado com sucesso!!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);

                }
            } else if (op.equals("DELETAR")) {
                
                per.setId(Integer.parseInt(request.getParameter("ident")));
                String msg = "Deletar";
                try {
                    pdao.deletar(per);
                    List<Personagem> lprod = pdao.consultarTodos();
                    request.setAttribute("lprod", lprod);
                    request.getRequestDispatcher("resconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } else if (op.equals("CONSULTAR BY ID")) {
                
                per.setId(Integer.parseInt(request.getParameter("ident")));
                try {
                    per = pdao.consultarById(per);
                    request.setAttribute("per", per);
                    request.getRequestDispatcher("resultadocosultarbyid.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR TODOS")) {
                
                try {
                    List<Personagem> lprod = pdao.consultarTodos();
                    request.setAttribute("lprod", lprod);
                    request.getRequestDispatcher("resconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }

            } else if (op.equals("ATUALIZAR")) {
                
                per.setId(Integer.parseInt(request.getParameter("ident")));
                try {
                    per = pdao.consultarById(per);
                    request.setAttribute("per", per);
                    request.getRequestDispatcher("resultadoconsultaratualizar.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }
            } else if (op.equals("EFETIVAR ATUALIZAÇÃO")) {
                
                per.setId(Integer.parseInt(request.getParameter("ident")));
                per.setNome(request.getParameter("nome"));
                per.setConceito(request.getParameter("conceito"));
                per.setCaracteristicas(request.getParameter("caracteristicas"));
                per.setHistorico(request.getParameter("historico"));
                per.setEquipamento(request.getParameter("equipamento"));
                per.setDefeito(request.getParameter("defeito"));
                per.setPtheroi(Integer.parseInt(request.getParameter("ptheroi")));
                per.setNvsaude(Integer.parseInt(request.getParameter("nvsaude")));
                per.setProeza1(request.getParameter("proeza1"));
                per.setProeza2(request.getParameter("proeza2"));
                per.setProeza3(request.getParameter("proeza3"));
                per.setPtproeza1(Integer.parseInt(request.getParameter("ptproeza1")));
                per.setPtproeza2(Integer.parseInt(request.getParameter("ptproeza2")));
                per.setPtproeza3(Integer.parseInt(request.getParameter("ptproeza3")));
                
                String msg = "Atualizar";
                try {
                    pdao.atualizar(per);
                    System.out.println("Atuaizado com sucesso!!");
                    List<Personagem> lprod = pdao.consultarTodos();
                    request.setAttribute("lprod", lprod);
                    request.getRequestDispatcher("resconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    msg = "Classe não encontrada";
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("/erro.jsp").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                    msg = "SQL mal formado";
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("/erro.jsp").forward(request, response);
                }catch (NumberFormatException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                    msg = "String vazia";
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("/erro.jsp").forward(request, response);
                }

            }
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
