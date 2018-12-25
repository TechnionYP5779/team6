package com.auth0.example;

import java.io.*;
import java.util.stream.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import parking.OurSystem;

 import org.json.*;
@WebServlet(urlPatterns = { "/logged/add/renting_spot" }) @SuppressWarnings("serial") public class LetSpotServlet extends HttpServlet {
  @Override protected void doPost(final HttpServletRequest r, final HttpServletResponse resp) throws ServletException, IOException {
    if (!"POST".equals(r.getMethod()))// should only be used for Post Requests
      return;
    
    resp.setHeader("Access-Control-Allow-Origin","*");final String body = r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    try {
      OurSystem.addParkingSpot(new JSONObject(new String(body)));
    } catch ( JSONException ¢) {
      resp.setHeader("Response", "ERROR");
      resp.getWriter().write(¢ + "");
      return;
    }
    resp.setHeader("Response", "OK");
    resp.getWriter().write("");
  }
}
