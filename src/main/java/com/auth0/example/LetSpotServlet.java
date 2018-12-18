package com.auth0.example;

import java.io.*;
import java.util.stream.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

// import org.json.*;
@WebServlet(urlPatterns = { "/add/renting_spot" }) @SuppressWarnings("serial") public class LetSpotServlet extends HttpServlet {
  @Override protected void doPost(final HttpServletRequest r, final HttpServletResponse resp) throws ServletException, IOException {
    if (!"POST".equals(r.getMethod()))// should only be used for Post Requests
      return;
    final String body = r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    // System.getInstance().add(new JSONObject(new String(body)));
    resp.setHeader("Response", "OK");
    resp.getWriter().write("JSON recieved: " + body);
  }
}
