package com.auth0.example;

import java.io.*;
import java.util.stream.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.*;

import com.auth0.client.auth.*;

import parking.*;

@WebServlet(urlPatterns = { "/logged/rent/renting_spot" }) @SuppressWarnings("serial") public class RentSpotServlet extends HttpServlet {
  AuthAPI auth = new AuthAPI("team6a.auth0.com", "BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva",
      "znc165307qVtiGnsCq7_3MfmjhuoGC0bo0aE5VMa8X91p--gxzujy6dqolSjmbD3");

  @Override protected void doPost(final HttpServletRequest r, final HttpServletResponse resp) throws ServletException, IOException {
    if (!"POST".equals(r.getMethod())) {
      return;
    }
    final String body;
    body = r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    resp.setHeader("Access-Control-Allow-Origin", "*");
    try {
      final JSONObject jo = new JSONObject(String.valueOf(body));
      jo.put("buyerId", auth.userInfo(r.getSession().getAttribute("accessToken") + "").execute().getValues().get("sub"));
      OurSystem.rentParkingSpot(jo);
    } catch (final JSONException ¢) {
      resp.setHeader("Response", "ERROR");
      resp.setStatus(400);
      resp.getWriter().write(new JSONObject().put("Desc", ¢ + "") + "");
      return;
    }
    resp.setHeader("Response", "OK");
    resp.setStatus(200);
    resp.getWriter().write(new JSONObject() + "");
  }
}
