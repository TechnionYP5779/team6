package com.auth0.example;

import java.io.*;
import java.util.stream.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.*;

import parking.*;

@WebServlet(urlPatterns = { "/logged/unrent/renting_spot" }) @SuppressWarnings("serial") public class UnrentSpotServlet extends HttpServlet {
  @Override protected void doPost(final HttpServletRequest r, final HttpServletResponse resp) throws ServletException, IOException {
    if (!"POST".equals(r.getMethod()))// should only be used for Post Requests
      return;
    // final String body =
    // r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    final String body = r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    resp.setHeader("Access-Control-Allow-Origin", "*");
    try {
      OurSystem.unrentParkingSpot(new JSONObject(new String(body)));
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
