package server;

import java.io.*;

import javax.servlet.http.*;

import org.eclipse.jetty.http.*;
import org.json.*;

import fluent.ly.*;
import parking.*;

@SuppressWarnings("serial") public class RootServlet extends HttpServlet {
  @Override protected void doGet(final HttpServletRequest __, final HttpServletResponse ¢) throws IOException {
    if (!"GET".equals(__.getMethod()))// should only be used for Post Requests
      return;
    //¢.getWriter().println("It's Alive, Jetty style this time.");
    int total, free_all, free_today;
    total = OurSystem.countAllParkingSpots();
    free_all = OurSystem.countAvailableParkingSpots();
    free_today = OurSystem.countAvailableSpotsToday();
    try {
      final JSONObject jo = new JSONObject();
      jo.put("total", total);
      jo.put("free_all", free_all);
      jo.put("free_today", free_today);
      ¢.getWriter().print(jo);
    } catch (final JSONException e) {
      ¢.setHeader("Response", "ERROR");
      ¢.getWriter().write(new JSONObject().put("Desc", e + "") + "");
      return;
    }
    ¢.setStatus(HttpStatus.OK_200);
    ¢.setHeader("Response", "OK");
    
  }
}
