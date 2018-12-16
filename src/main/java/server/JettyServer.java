package server;

import server.servlet.*;

import org.eclipse.jetty.server.Server;

import org.eclipse.jetty.servlet.*;
import com.auth0.example.*;

public class JettyServer {
  public static void main(String[] args) throws Exception {
    Server server = new Server(3000);
    new ServletContextHandler(server, "/").addServlet(RootServlet.class, "/");
    new ServletContextHandler(server, "/").addServlet(CallbackServlet.class, "/callback");
    new ServletContextHandler(server, "/").addServlet(HomeServlet.class, "/home");
    new ServletContextHandler(server, "/").addServlet(LoginServlet.class, "/login");
    new ServletContextHandler(server, "/").addServlet(LogoutServlet.class, "/logout");
    server.start();
  }
}
