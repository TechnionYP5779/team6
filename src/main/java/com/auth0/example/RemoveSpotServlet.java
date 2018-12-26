package com.auth0.example;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.*;

import parking.*;

@WebServlet(urlPatterns = { "/logged/remove/renting_spot" }) @SuppressWarnings("serial") public class RemoveSpotServlet extends HttpServlet {
  @Override protected void doPost(final HttpServletRequest r, final HttpServletResponse resp) throws ServletException, IOException {
    if (!"POST".equals(r.getMethod()))// should only be used for Post Requests
      return;
    // final String body =
    // r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    final String body = Auth0Filter.body;
    resp.setHeader("Access-Control-Allow-Origin", "*");
    try {
      OurSystem.removeParkingSpot(new JSONObject(new String(body)));
    } catch (final JSONException ¢) {
      resp.setHeader("Response", "ERROR");
      resp.getWriter().write(new JSONObject().put("Desc", ¢ + "") + "");
      return;
    }
    resp.setHeader("Response", "OK");
    resp.getWriter().write(new JSONObject() + "");
  }
}