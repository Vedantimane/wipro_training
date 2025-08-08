package com.wipro.servedemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/httpserv")
public class HTTPServletDemo extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("-- do get---"); 
  
        PrintWriter out = resp.getWriter();
        out.print("<h1>Hello  from HTTP servlet</h1>");
    }
}
