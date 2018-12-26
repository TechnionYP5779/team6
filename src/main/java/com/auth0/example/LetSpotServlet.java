package com.auth0.example;

import java.io.*;
// import java.util.stream.*;
import java.util.stream.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.*;

import com.auth0.client.auth.*;

import parking.*;

@WebServlet(urlPatterns = { "/logged/add/renting_spot" }) @SuppressWarnings("serial") public class LetSpotServlet extends HttpServlet {
  AuthAPI auth = new AuthAPI("team6a.auth0.com", "BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva",
      "znc165307qVtiGnsCq7_3MfmjhuoGC0bo0aE5VMa8X91p--gxzujy6dqolSjmbD3");

  @Override protected void doPost(final HttpServletRequest r, final HttpServletResponse resp) throws ServletException, IOException {
    if (!"POST".equals(r.getMethod()))// should only be used for Post Requests
      return;
    resp.setHeader("Access-Control-Allow-Origin", "*");
    // final String body =
    // r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    final String body = r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    System.out.println("========");
    System.out.println(body);
    System.out.println("========");
    try {
      final JSONObject jo = new JSONObject(new String(body));
      jo.put("userId", auth.userInfo(r.getSession().getAttribute("accessToken") + "").execute().getValues().get("sub"));
    //  System.out.println(body);
  //    System.out.println(jo + "");
      System.out.println(auth.userInfo(r.getSession().getAttribute("accessToken") + "").execute().getValues().keySet() + "");
      OurSystem.addParkingSpot(jo);
    } catch (final JSONException ¢) {
      resp.setHeader("Response", "ERROR");
      resp.getWriter().write(new JSONObject().put("Desc", ¢ + "") + "");
      return;
    }
    resp.setHeader("Response", "OK");
    resp.getWriter().write(new JSONObject() + "");
  }
}
