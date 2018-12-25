package server;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.*;
import org.eclipse.jetty.webapp.*;

import com.auth0.example.*;

public class JettyServer {
  public static void main(final String[] args) throws Exception {
    final Server server = new Server(8080);
    final WebAppContext webapp = new WebAppContext();
    String angularAppLocation = "frontend/dist/parking-renting-project";
    webapp.setContextPath("/");
    webapp.setDescriptor(angularAppLocation + "/WEB-INF/web.xml");
    webapp.setResourceBase(angularAppLocation);
    // final FilterHolder holder = new FilterHolder(new Auth0Filter());
    // holder.setName("auth0filter");
    // holder.setInitParameter("param", "");
    // webapp.addFilter(holder, "/portal/*", EnumSet.allOf(DispatcherType.class));
    // webapp.addServlet(new ServletHolder(new HomeServlet()), "/portal/home");
    // webapp.addServlet(new ServletHolder(new LoginServlet()), "/login");
    // webapp.addServlet(new ServletHolder(new CallbackServlet()), "/callback");
    // webapp.addServlet(new ServletHolder(new LogoutServlet()), "/logout");
    webapp.addServlet(new ServletHolder(new RootServlet()), "/root");
    webapp.addServlet(new ServletHolder(new LetSpotServlet()), "/add/renting_spot");
    server.setHandler(webapp);
    server.start();
    server.join();
  }
}
