/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Category;
import models.Product;

/**
 *
 * @author Tra My
 */
@WebServlet(name = "ManagerController", urlPatterns = {"/manageProduct"})
public class ManagerController extends HttpServlet {

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
        HttpSession session = request.getSession();
//        Account account = session.getParameter("account");
        DAO dao = new DAO();
        List<Category> listC = dao.getAllCategory();
        List<Product> listP = dao.getAllProduct();
        request.setAttribute("listC", listC);
        String indexPage = request.getParameter("index");
        if(indexPage == null){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

//        Phan trang theo cach thong thuong, k dung OFF_SET
//        int page = 1;
//        String pageStr = request.getParameter("page");
//        if(pageStr != null){
//            page=Integer.parseInt(pageStr);
//        }
//        final int PAGE_SIZE = 6;
//        request.setAttribute("listP", listP.subList((page-1)*PAGE_SIZE, page*PAGE_SIZE));
        int count = dao.getTotalProduct();
        int endPage = count / 6;
        if (count % 6 != 0) { //khi chia trang du thi + 1
            endPage++;
        }

        listP = dao.pagingProduct(index);
        
        
        
        request.setAttribute("endP", endPage);
        request.setAttribute("listP", listP);
        request.getSession().setAttribute("urlHistory", "home");
        request.setAttribute("tag", index);
        request.getRequestDispatcher("ManageProduct.jsp").forward(request, response);
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