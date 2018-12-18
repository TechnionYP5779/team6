package server;

import java.util.*;

import javax.servlet.*;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.*;
import org.eclipse.jetty.webapp.*;

import com.auth0.example.*;

public class JettyServer {
  public static void main(final String[] args) throws Exception {
    final Server server = new Server(8080);
    final WebAppContext webapp = new WebAppContext();
    webapp.setDescriptor("src/main/java/server/WEB-INF/web.xml");
    webapp.setResourceBase("src/main/java/server/WEB-INF/");
    webapp.setContextPath("/");
    server.setHandler(webapp);
    final FilterHolder holder = new FilterHolder(new Auth0Filter());
    holder.setName("auth0filter");
    holder.setInitParameter("param", "a");
    webapp.addFilter(holder, "/portal/*", EnumSet.allOf(DispatcherType.class));
    webapp.addServlet(new ServletHolder(new RootServlet()), "/root");
    webapp.addServlet(new ServletHolder(new HomeServlet()), "/portal/home");
    webapp.addServlet(new ServletHolder(new LoginServlet()), "/login");
    webapp.addServlet(new ServletHolder(new CallbackServlet()), "/callback");
    webapp.addServlet(new ServletHolder(new LogoutServlet()), "/logout");
    server.start();
    server.join();
  }
}
