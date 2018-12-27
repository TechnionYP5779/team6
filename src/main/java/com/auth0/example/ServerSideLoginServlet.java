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

@WebServlet(urlPatterns = { "/login" }) @SuppressWarnings("serial") public class ServerSideLoginServlet extends HttpServlet {
  AuthAPI auth = new AuthAPI("team6a.auth0.com", "BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva",
      "znc165307qVtiGnsCq7_3MfmjhuoGC0bo0aE5VMa8X91p--gxzujy6dqolSjmbD3");

  @Override protected void doPost(final HttpServletRequest r, final HttpServletResponse resp) throws ServletException, IOException {
    if (!"POST".equals(r.getMethod()))// should only be used for Post Requests
      return;
    final String body = r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    final JSONObject loginInfo = new JSONObject(body);
    final AuthRequest request = auth.login(loginInfo.getString("username"), loginInfo.getString("password"), "Username-Password-Authentication")
        .setScope("openid");
    // resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
    try {
      final TokenHolder holder = request.execute();
      final UserInfo info = auth.userInfo(holder.getAccessToken()).execute();
      System.out.println(info.getValues().keySet().toString());
      System.out.println(info.getValues().values().toString());
      resp.setHeader("Response", "OK");
      resp.setStatus(200);
      final JSONObject tokens = new JSONObject();
      r.getSession().setAttribute("accessToken", holder.getAccessToken());
      r.getSession().setAttribute("idToken", holder.getIdToken());
      tokens.put("name", info.getValues().get("nickname"));
      tokens.put("email", info.getValues().get("email"));
      resp.getWriter().write(tokens + "");
    } catch (final Auth0Exception ¢) {
      resp.setHeader("Response", "ERROR");
      resp.setStatus(400);
      resp.getWriter().write(new JSONObject().put("Desc", ¢ + "") + "");
      return;
    }
  }
}
