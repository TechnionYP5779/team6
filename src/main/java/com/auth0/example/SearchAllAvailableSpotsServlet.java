package com.auth0.example;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.*;

import parking.*;

@WebServlet(urlPatterns = { "/logged/search/all/renting_spots" }) @SuppressWarnings("serial") public class SearchAllAvailableSpotsServlet
    extends HttpServlet {
  @Override protected void doPost(final HttpServletRequest r, final HttpServletResponse resp) throws ServletException, IOException {
    if (!"POST".equals(r.getMethod()))// should only be used for Post Requests
      return;
    resp.setHeader("Access-Control-Allow-Origin", "*");
    String psList = "";
    try {
      psList = OurSystem.getAllAvailableParkingSpots() + "";
    } catch (final JSONException ¢) {
      resp.setHeader("Response", "ERROR");
      resp.getWriter().write(new JSONObject().put("Desc", ¢ + "") + "");
      return;
    }
    if (psList.equals(null)) {
      resp.setHeader("Response", "ERROR");
      resp.getWriter().write(new JSONObject().put("Desc", "Couldn't parse from JSONObject to string") + "");
      return;
    }
    resp.setHeader("Response", "OK");
    resp.getWriter().write(psList);
  }
}
