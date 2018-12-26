package com.auth0.example;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns = { "/logged/logout" }) @SuppressWarnings("serial") public class ServerSideLogoutServlet extends HttpServlet {
  @Override protected void doGet(final HttpServletRequest r, final HttpServletResponse response) throws ServletException, IOException {
    if (r.getSession() != null)
      r.getSession().invalidate();
    response.sendRedirect("/");
  }
}
