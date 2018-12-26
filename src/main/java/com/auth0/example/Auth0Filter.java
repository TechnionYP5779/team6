package com.auth0.example;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.*;

import com.auth0.*;

// import com.auth0.*;
//
// import parking.*;
/** Filter class to check if a valid session exists. This will be true if the
 * User Id is present. */
@WebFilter(urlPatterns = "/portal/*") public class Auth0Filter implements Filter {
  @Override public void init(final FilterConfig __) throws ServletException {
  }

  /** Perform filter check on this request - verify the User Id is present.
   * @param request  the received request
   * @param response the response to send
   * @param next     the next filter chain **/
  @Override public void doFilter(final ServletRequest r, final ServletResponse response, final FilterChain next)
      throws IOException, ServletException {
    if ((String) SessionUtils.get((HttpServletRequest) r, "accessToken") != null
        || (String) SessionUtils.get((HttpServletRequest) r, "idToken") != null)
      next.doFilter(r, response);
    else
      ((HttpServletResponse) response).setHeader("Response", "ERROR");
    ((HttpServletResponse) response).getWriter().write(new JSONObject().put("Desc", "no accessToken and idToken") + "");
    ((HttpServletResponse) response).sendRedirect("/");
  }

  // @Override public void doFilter(final ServletRequest r, final ServletResponse
  // response, final FilterChain next)
  // throws IOException, ServletException {
  // body =
  // r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
  // try {
  // final JSONObject jbody = new JSONObject(body);
  // if (body.contains("\"accessToken\":null") ||
  // body.contains("\"idToken\":null") || !jbody.has("accessToken") ||
  // !jbody.has("idToken")) {
  // ((HttpServletResponse) response).setHeader("Response", "ERROR");
  // ((HttpServletResponse) response).getWriter().write(new
  // JSONObject().put("Desc", "no accessToken or idToken") + "");
  // ((HttpServletResponse) response).sendRedirect("/");
  // return;
  // }
  // next.doFilter(r, response);
  // } catch (final JSONException ¢) {
  // ((HttpServletResponse) response).setHeader("Response", "ERROR");
  // ((HttpServletResponse) response).getWriter().write(new
  // JSONObject().put("Desc", ¢ + "") + "");
  // ((HttpServletResponse) response).sendRedirect("/");
  // return;
  // }
  // }
  @Override public void destroy() {//
  }
}