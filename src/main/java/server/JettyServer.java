package server;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.*;

import com.auth0.example.*;

public class JettyServer {
  public static void main(final String[] args) throws Exception {
    final Server server = new Server(8080);
    final ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);
    context.addServlet(new ServletHolder(new RootServlet()), "/root");
    context.addServlet(new ServletHolder(new HomeServlet()), "/portal/home");
    context.addServlet(new ServletHolder(new LoginServlet()), "/login");
    context.addServlet(new ServletHolder(new CallbackServlet()), "/callback");
    context.addServlet(new ServletHolder(new LogoutServlet()), "/logout");
    server.start();
  }
}
