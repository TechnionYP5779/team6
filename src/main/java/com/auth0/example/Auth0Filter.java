package com.auth0.example;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.*;

import com.auth0.*;

import io.jsonwebtoken.*;

// import com.auth0.*;
//
// import parking.*;
/** Filter class to check if a valid session exists. This will be true if the
 * User Id is present. */
@WebFilter(urlPatterns = "/logged/*") public class Auth0Filter implements Filter {
  @Override public void init(final FilterConfig __) throws ServletException {
    /**/
  }

  /** Perform filter check on this request - verify the User Id is present.
   * @param request  the received request
   * @param response the response to send
   * @param next     the next filter chain **/
  @Override public void doFilter(final ServletRequest r, final ServletResponse response, final FilterChain next)
      throws IOException, ServletException {
    // we want both accessToken and idTokken
    if ((String) SessionUtils.get((HttpServletRequest) r, "accessToken") == null
        || (String) SessionUtils.get((HttpServletRequest) r, "idToken") == null) {
      ((HttpServletResponse) response).setHeader("Response", "ERROR");
      ((HttpServletResponse) response).setHeader("status", "400");
      ((HttpServletResponse) response).setStatus(400);
      ((HttpServletResponse) response).getWriter().write(new JSONObject().put("Desc", "no accessToken or idToken") + "");
      return;
    }
    // veryfing the signature of the idToken
    Jws<Claims> jws;
    try {
      jws = Jwts.parser().setSigningKey("https://team6a.auth0.com/.well-known/jwks.json")
          .parseClaimsJws((String) SessionUtils.get((HttpServletRequest) r, "idToken"));
    } catch (JwtException ¢) {
      ((HttpServletResponse) response).setHeader("Response", "ERROR");
      ((HttpServletResponse) response).getWriter().write(new JSONObject().put("Desc", ¢ + "") + "");
      return;
    }
    // validating the values of the idToken
    Date exp = jws.getBody().getExpiration();
    if ((exp == null || exp.after(new Date())) && "https://team6a.auth0.com/".equals(jws.getBody().getIssuer())
        && "BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva".equals(jws.getBody().getAudience()))
      next.doFilter(r, response);
    else {
      ((HttpServletResponse) response).setHeader("Response", "ERROR");
      ((HttpServletResponse) response).setHeader("status", "400");
      ((HttpServletResponse) response).setStatus(400);
      ((HttpServletResponse) response).getWriter().write(new JSONObject().put("Desc", "problem validating idToken") + "");
    }
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