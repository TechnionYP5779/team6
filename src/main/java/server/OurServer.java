package server;

import java.io.*;
import java.net.*;

import com.sun.net.httpserver.*;

public class OurServer {
  static int port = 8000;

  public static class RootHandler implements HttpHandler {
    @Override public void handle(final HttpExchange x) throws IOException {
      final String response = "<h1>It's alive!</h1><h1>And the port is: " + port + "</h1>";
      x.sendResponseHeaders(200, response.getBytes().length);
      x.getResponseBody().write(response.getBytes());
      x.getResponseBody().close();
    }
  }

  public static void main(final String[] args) throws Exception {
    final HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    server.createContext("/", new RootHandler());
    server.setExecutor(null);
    server.start();
  }
}
