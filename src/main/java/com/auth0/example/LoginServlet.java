package com.auth0.example;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.auth0.*;

@WebServlet(urlPatterns = { "/login" }) public class LoginServlet extends HttpServlet {
  /**
  *
  */
  private static final long serialVersionUID = 1;
  private AuthenticationController authenticationController;
  private String domain;

  @Override public void init(final ServletConfig c) throws ServletException {
    super.init(c);
    domain = c.getServletContext().getInitParameter("com.auth0.domain");
    try {
      authenticationController = AuthenticationControllerProvider.getInstance(c);
    } catch (final UnsupportedEncodingException ¢) {
      throw new ServletException("Couldn't create the AuthenticationController instance. Check the configuration.", ¢);
    }
  }

  @Override protected void doGet(final HttpServletRequest r, final HttpServletResponse res) throws ServletException, IOException {
    res.sendRedirect(authenticationController.buildAuthorizeUrl(r, r.getScheme() + "://" + r.getServerName() + ":" + r.getServerPort() + "/callback")
        .withAudience(String.format("https://%s/userinfo", domain)).build());
  }
}
