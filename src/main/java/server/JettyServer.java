package server;

import server.servlet.*;

import org.eclipse.jetty.server.Server;

import org.eclipse.jetty.servlet.*;

public class JettyServer {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    new ServletContextHandler(server, "/").addServlet(RootServlet.class, "/");
    server.start();
  }
}
