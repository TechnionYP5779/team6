package com.auth0.example;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.auth0.*;

@WebServlet(urlPatterns = { "/portal/home" }) @SuppressWarnings("serial") public class HomeServlet extends HttpServlet {
  @Override protected void doGet(final HttpServletRequest r, final HttpServletResponse res) throws ServletException, IOException {
    final String accessToken = (String) SessionUtils.get(r, "accessToken"), idToken = (String) SessionUtils.get(r, "idToken");
    if (accessToken != null)
      r.setAttribute("userId", accessToken);
    else if (idToken != null)
      r.setAttribute("userId", idToken);
    r.getRequestDispatcher("/dist/parking-renting-project/index.html").forward(r, res);
  }
}
