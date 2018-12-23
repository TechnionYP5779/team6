package com.auth0.example;

import java.io.*;
import java.sql.*;
import java.util.stream.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import parking.OurSystem;

 import org.json.*;
@WebServlet(urlPatterns = { "/unrent/renting_spot" }) @SuppressWarnings("serial") public class UnrentSpotServlet extends HttpServlet {
  @Override protected void doPost(final HttpServletRequest r, final HttpServletResponse resp) throws ServletException, IOException {
    if (!"POST".equals(r.getMethod()))// should only be used for Post Requests
      return;
    final String body = r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    resp.setHeader("Access-Control-Allow-Origin","*");
    try {
      OurSystem.unrentParkingSpot(new JSONObject(new String(body)));
    } catch (SQLException | JSONException ¢) {
      resp.setHeader("Response", "ERROR");
      resp.getWriter().write(¢ + "");
      return;
    }
    resp.setHeader("Response", "OK");
    resp.getWriter().write("");
  }
}
