package com.auth0.example;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.auth0.*;

/** Filter class to check if a valid session exists. This will be true if the
 * User Id is present. */
@WebFilter(urlPatterns = "/logged/*") public class Auth0Filter implements Filter {
  @Override public void init(final FilterConfig __) throws ServletException {//
  }

  /** Perform filter check on this request - verify the User Id is present.
   * @param r the received request
   * @param response the response to send
   * @param next     the next filter chain **/
  @Override public void doFilter(final ServletRequest r, final ServletResponse response, final FilterChain next)
      throws IOException, ServletException {
    if ((String) SessionUtils.get((HttpServletRequest) r, "accessToken") != null
        || (String) SessionUtils.get((HttpServletRequest) r, "idToken") != null)
      next.doFilter(r, response);
    else
      ((HttpServletResponse) response).sendRedirect("/");
  }

  @Override public void destroy() {//
  }
}
