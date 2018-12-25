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
    JSONObject loginInfo = new JSONObject(body);
    AuthRequest request = auth.login(loginInfo.getString("username"), loginInfo.getString("password"), "Username-Password-Authentication").setScope("openid contacts");
    resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
    try {
      TokenHolder holder = request.execute();
      UserInfo info = auth.userInfo(holder.getAccessToken()).execute();
      resp.setHeader("Response", "OK");
      JSONObject tokens = new JSONObject();
      tokens.put("accessToken", holder.getAccessToken());
      tokens.put("idToken", holder.getIdToken());
      tokens.put("name", info.getValues().get("name"));
      tokens.put("email", info.getValues().get("email"));
      resp.getWriter().write(tokens + "");
    } catch (Auth0Exception ¢) {
      resp.setHeader("Response", "ERROR");
      resp.getWriter().write(¢ + "");
      return;
    }
  }
}
