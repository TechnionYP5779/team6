package com.auth0.example;

import java.io.*;
//import java.util.stream.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import parking.OurSystem;

 import org.json.*;

import com.auth0.client.auth.*;

@WebServlet(urlPatterns = { "/logged/add/renting_spot" }) @SuppressWarnings("serial") public class LetSpotServlet extends HttpServlet {
  AuthAPI auth = new AuthAPI("team6a.auth0.com", "BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva",
      "znc165307qVtiGnsCq7_3MfmjhuoGC0bo0aE5VMa8X91p--gxzujy6dqolSjmbD3");
  
  @Override protected void doPost(final HttpServletRequest r, final HttpServletResponse resp) throws ServletException, IOException {
    if (!"POST".equals(r.getMethod()))// should only be used for Post Requests
      return;
    
    resp.setHeader("Access-Control-Allow-Origin","*");
    //final String body = r.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    String body = Auth0Filter.body;
    System.out.println("========");
    System.out.println(body);
    System.out.println("========");
    try {
      JSONObject jo = new JSONObject(new String(body));
      jo.put("userId",auth.userInfo(jo.getString("accessToken")).execute().getValues().get("sub"));
      System.out.println(body);
      System.out.println(jo.toString());
      System.out.println(auth.userInfo(jo.getString("accessToken")).execute().getValues().keySet().toString());
      OurSystem.addParkingSpot(jo);
    } catch ( JSONException ¢) {
      resp.setHeader("Response", "ERROR");
      resp.getWriter().write(new JSONObject().put("Desc", ¢ + "") + "");
      return;
    }
    resp.setHeader("Response", "OK");
    resp.getWriter().write(new JSONObject() + "");
  }
}
