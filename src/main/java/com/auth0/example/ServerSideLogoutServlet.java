package com.auth0.example;

import java.io.*;
import java.util.stream.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.*;

import com.auth0.client.auth.*;
import com.auth0.exception.*;
import com.auth0.json.auth.*;
import com.auth0.net.*;

@WebServlet(urlPatterns = { "/logged/logout" }) @SuppressWarnings("serial") public class ServerSideLogoutServlet extends HttpServlet {
  @Override protected void doGet(final HttpServletRequest r, final HttpServletResponse response) throws ServletException, IOException {
    if (r.getSession() != null)
      r.getSession().invalidate();
    response.sendRedirect("/");
  }
}
