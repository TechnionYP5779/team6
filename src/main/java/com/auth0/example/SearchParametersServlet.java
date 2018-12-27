package com.auth0.example;

import java.io.*;
import java.util.stream.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.*;

import com.auth0.client.auth.*;

import parking.*;

@WebServlet(urlPatterns = { "/findSpotsByParamaters" }) @SuppressWarnings("serial") public class SearchParametersServlet
    extends HttpServlet {
  AuthAPI auth = new AuthAPI("team6a.auth0.com", "BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva",
      "znc165307qVtiGnsCq7_3MfmjhuoGC0bo0aE5VMa8X91p--gxzujy6dqolSjmbD3");

  @Override protected void doPost(final HttpServletRequest r, final HttpServletResponse resp) throws ServletException, IOException {
    if (!"POST".equals(r.getMethod()))// should only be used for Post Requests
      return;
    // final String body =
    // r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    final String body = r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    resp.setHeader("Access-Control-Allow-Origin", "*");
    String psList = "";
    try {
      psList = OurSystem.getParkingSpotsByParameters(new JSONObject(new String(body))) + "";
    } catch (final JSONException ¢) {
      resp.setHeader("Response", "ERROR");
      resp.setStatus(400);
      resp.getWriter().write(new JSONObject().put("Desc", ¢ + "") + "");
      return;
    }
    if (psList.equals(null)) {
      resp.setHeader("Response", "ERROR");
      resp.setStatus(400);
      resp.getWriter().write(new JSONObject().put("Desc", "Couldn't parse from JSONObject to string") + "");
      return;
    }
    resp.setHeader("Response", "OK");
    resp.setStatus(200);
    resp.getWriter().write(psList);
  }
}