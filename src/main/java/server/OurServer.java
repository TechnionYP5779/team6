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
  // TODO: implement filter mechanism against wrong requests
  /**
   * 
   * @fluent.ly.Package server
   * @fluent.ly.Since 4 Dec 2018
   * @fluent.ly.Author Idan Hadad
   */
  public static class PostHandler implements HttpHandler {
    @Override public void handle(final HttpExchange x) throws IOException {
    //this handler right now should only pare post requests
      if(!"POST".equals(x.getRequestMethod())) 
        return;
      //I expect to recieve a header  with the client name this test
      if(!x.getRequestHeaders().containsKey("client_name"))
        return;
      String clName = x.getRequestHeaders().getFirst("client_name");
      byte[] body= new byte[256]; //expected input max sized 256 bytes
      if (x.getRequestBody().read(body) == -1) //couldn't read
          return;
      //body should now contain a messege which i will "encrypt"
      String response = "<h1>Client name is:" + clName + "</h1><h1> Encrypted input is:" + new StringBuilder(body + "").reverse() + "</h1>";
      x.sendResponseHeaders(444, response.getBytes().length);
      x.getResponseBody().write(response.getBytes());
      x.getResponseBody().close();
      
    }
  }

  public static void main(final String[] args) throws Exception {
    final HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    server.createContext("/", new RootHandler());
    server.createContext("/postTest", new PostHandler());
    server.setExecutor(null);
    server.start();
   
  }
}
