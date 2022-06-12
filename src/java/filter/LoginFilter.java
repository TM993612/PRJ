/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import dao.DAO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Account;

/**
 *
 * @author Tra My
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/carts","/checkout","/updateQuantity", "/admin/*"})
public class LoginFilter implements Filter {

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        //kiem tra login
        Account account = (Account) session.getAttribute("account");
        if (account != null) { //da dang nhap
            chain.doFilter(request, response);
        }else{
            //check cookie
             Cookie[] cookies = req.getCookies();
        String username = null;
        String password = null;
        
        for (Cookie cooky : cookies) {
            if(cooky.getName().equals("username") ){
                username = cooky.getValue();
            }
            if(cooky.getName().equals("password") ){
                password = cooky.getValue();
            }
            if(username != null && password != null){
                break;
            }
        }
        if(username != null && password != null){
            Account accountLogin = new DAO().login(username, password);
            if(account != null){//cookie hop le
                session.setAttribute("account", account);
                chain.doFilter(request, response);
                return;
            }
        }
        res.sendRedirect("http://localhost:8080/Project_Tea/login");
        }
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        
    }
    
}
