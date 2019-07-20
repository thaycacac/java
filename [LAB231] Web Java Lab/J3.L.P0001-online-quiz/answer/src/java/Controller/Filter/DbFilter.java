/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Filter;

import Helper.DbConnectionHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author minhndse04560
 */
public class DbFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            InitialContext initContext = new InitialContext();
            Context env = (Context) initContext.lookup("java://comp/env");
            
            String connectionUrl = (String) env.lookup("connectionUrl");
            String dbName = (String) env.lookup("dbname");
            String user = (String) env.lookup("user");
            String pass = (String) env.lookup("pass");
            DbConnectionHelper.initConnection(connectionUrl + ";databaseName=" + dbName, user, pass);
        } catch (Exception ex) {
            Logger.getLogger(DbFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //System.out.println("Filtering");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
