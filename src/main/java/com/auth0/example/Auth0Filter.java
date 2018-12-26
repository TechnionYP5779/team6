package com.auth0.example;

import java.io.*;
import java.util.stream.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.*;

//import com.auth0.*;
//
//import parking.*;

/** Filter class to check if a valid session exists. This will be true if the
 * User Id is present. */
@WebFilter(urlPatterns = "/logged/*") public class Auth0Filter implements Filter {
  static String body = "";
  @Override public void init(final FilterConfig __) throws ServletException {//
  }

  /** Perform filter check on this request - verify the User Id is present.
   * @param r the received request
   * @param response the response to send
   * @param next     the next filter chain **/
/*  @Override public void doFilter(final ServletRequest r, final ServletResponse response, final FilterChain next)
      throws IOException, ServletException {
    if ((String) SessionUtils.get((HttpServletRequest) r, "accessToken") != null
        || (String) SessionUtils.get((HttpServletRequest) r, "idToken") != null) {
      next.doFilter(r, response);}
    else
      ((HttpServletResponse) response).sendRedirect("/");
  }
*/
  @Override public void doFilter(final ServletRequest r, final ServletResponse response, final FilterChain next)
      throws IOException, ServletException {
    BufferedReader br = r.getReader();
    body = br.lines().collect(Collectors.joining(System.lineSeparator()));
   JSONObject jbody = new JSONObject(body);
   if( !jbody.has("accessToken") || !jbody.has("idToken") || jbody.get("accessToken")==null || jbody.get("idToken")==null){
     ((HttpServletResponse)response).setHeader("Response", "ERROR");
     ((HttpServletResponse)response).getWriter().write(new JSONObject().put("Desc", "no accessToken or idToken") + "");
     ((HttpServletResponse) response).sendRedirect("/");
   }
   next.doFilter(r, response);
  }
  @Override public void destroy() {//
  }
}

  