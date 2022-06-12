/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Account;

/**
 *
 * @author Tra My
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

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
        //Kiem tra cookie, hop le thi dang nhap luon va chuyen den trang home
//        Cookie[] cookies = request.getCookies();
//        String username = null;
//        String password = null;
//        
//        for (Cookie cooky : cookies) {
//            if(cooky.getName().equals("username") ){
//                username = cooky.getValue();
//            }
//            if(cooky.getName().equals("password") ){
//                password = cooky.getValue();
//            }
//            if(username != null && password != null){
//                break;
//            }
//        }
//        if(username != null && password != null){
//            Account account = new DAO().login(username, password);
//            if(account != null){//cookie hop le
//                request.getSession().setAttribute("account", account);
//                response.sendRedirect("home");
//                return;
//            }
//        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        //Check login
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean remember = request.getParameter("remember") !=null;
        
        //check username va pass
        Account account = new DAO().login(username,password);
        //hop le --> luu len session
        if(account != null){
            //remember
            if(remember){
                Cookie usernameCookie = new Cookie("username", username);
                usernameCookie.setMaxAge(60*60*24*2); //sau 2 ngay xoa Cookie
                Cookie passwordCookie = new Cookie("password", password);
                passwordCookie.setMaxAge(60*60*24*2); 
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }
            request.getSession().setAttribute("account", account);
            response.sendRedirect("home");
        }else{
        //khong hop le --> tra ve loi
            request.setAttribute("error", "Login failed! Check your username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
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
