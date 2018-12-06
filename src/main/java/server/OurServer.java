package server;

import java.io.*;
import java.net.*;
import java.util.*;

import org.json.*;

import com.sun.net.httpserver.*;

/** @fluent.ly.Package server
 * @fluent.ly.Since 6 Dec 2018
 * @fluent.ly.Author Idan Hadad
 * @fluent.ly.ClassDesc A class Representing our server, at the begining it is
 *                      local <br>
 *                      and saved on the machine, later it will be hosted. The
 *                      server currently hosts <br>
 *                      the parking object sets as well. Later it will be hosted
 *                      somewhere else. */
// TODO: implement filter mechanism against wrong requests
public class OurServer {
  static int port = 8000;
  static Set<JSONObject> rentingSpots = new HashSet<>();

  /** @fluent.ly.Package server
   * @fluent.ly.Since 6 Dec 2018
   * @fluent.ly.Author Idan Hadad
   * @fluent.ly.ClassDesc a handler for every route not defined. */
  public static class RootHandler implements HttpHandler {
    @Override public void handle(final HttpExchange x) throws IOException {
      final String response = "<h1>It's alive!</h1><h1>And the port is: " + port + "</h1>";
      x.sendResponseHeaders(200, response.getBytes().length);
      x.getResponseBody().write(response.getBytes());
      x.getResponseBody().close();
    }
  }

  /** @fluent.ly.Package server
   * @fluent.ly.Since 6 Dec 2018
   * @fluent.ly.Author Idan Hadad
   * @fluent.ly.ClassDesc A handler to test the sever responding with a basic
   *                      implemention. Will be removed. */
  // TODO: remove this once the server is ready
  public static class PostHandler implements HttpHandler {
    @Override public void handle(final HttpExchange x) throws IOException {
      if (!"POST".equals(x.getRequestMethod()) || !x.getRequestHeaders().containsKey("client_name"))
        return;
      final String clName = x.getRequestHeaders().getFirst("client_name");
      final byte[] body = new byte[256];
      if (x.getRequestBody().read(body) == -1)
        return;
      final String response = "<h1>Client name is:" + clName + "</h1><h1> Encrypted input is:" + new StringBuilder(new String(body).trim()).reverse()
          + "</h1>"; // lgtm // [java/print-array]
      x.sendResponseHeaders(444, response.getBytes().length);
      x.getResponseBody().write(response.getBytes());
      x.getResponseBody().close();
    }
  }

  /** @fluent.ly.Package server
   * @fluent.ly.Since 6 Dec 2018
   * @fluent.ly.Author Idan Hadad
   * @fluent.ly.ClassDesc A handler in charge to respond to renting spaces and
   *                      saving them on the server. Later will be changed to save
   *                      it on another, non local host. */
  public static class AddRentingSpotHandler implements HttpHandler {
    @Override public void handle(final HttpExchange x) throws IOException {
      if (!"POST".equals(x.getRequestMethod()))// should only be used for Post Requests
        return;
      final byte[] body = new byte[256]; // assuming this is the size limit of the string, may increase later
      if (x.getRequestBody().read(body) == -1) {
        final String response = "ERROR";
        x.sendResponseHeaders(444, response.getBytes().length);
        x.getResponseBody().write(response.getBytes());
        x.getResponseBody().close();
        return;
      }
      rentingSpots.add(new JSONObject(new String(body)));
      final String response = "OK";
      x.sendResponseHeaders(444, response.getBytes().length);
      x.getResponseBody().write(response.getBytes());
      x.getResponseBody().close();
    }
  }

  /** @fluent.ly.Package server
   * @fluent.ly.Since 6 Dec 2018
   * @fluent.ly.Author Idan Hadad
   * @fluent.ly.ClassDesc A handler in charge to respond to renting spaces request
   *                      and <br>
   *                      Bringing them to the front end, in JSON string form.
   *                      Later will be changed to <br>
   *                      enable filtering. */
  public static class GetRentingSpotHandler implements HttpHandler {
    @Override public void handle(final HttpExchange x) throws IOException {
      String response;
      if (rentingSpots.isEmpty())
        response = "[]";
      else {
        StringBuilder responseSB = new StringBuilder("[");
        for (final JSONObject rentingSpot : rentingSpots)
          responseSB = responseSB.append(rentingSpot + "").append(",");
        response = responseSB.deleteCharAt(responseSB.length() - 1).append("]") + "";
      }
      x.sendResponseHeaders(555, response.getBytes().length);
      x.getResponseBody().write(response.getBytes());
      x.getResponseBody().close();
    }
  }

  public static void main(final String[] args) throws Exception {
    final HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    server.createContext("/", new RootHandler());
    server.createContext("/postTest", new PostHandler());
    server.createContext("/add/renting_spot", new AddRentingSpotHandler());
    server.createContext("/get/renting_spots", new GetRentingSpotHandler());
    server.setExecutor(null);
    server.start();
  }
}
