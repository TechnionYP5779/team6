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
    webapp.setDescriptor("frontend/WEB-INF/web.xml");
    webapp.setResourceBase("frontend/");
    webapp.setContextPath("/");
    server.setHandler(webapp);
    
    //webapp.setWelcomeFiles(new String[] { "index.html", "index.htm", "index.jsp" });
    //ServletHolder holderPwd = new ServletHolder("default", HomeServlet.class);
    //holderPwd.setInitParameter("resourceBase","frontend/");
    //holderPwd.setInitParameter("dirAllowed","true");
    //webapp.addServlet(holderPwd,"/");
    
    
    final FilterHolder holder = new FilterHolder(new Auth0Filter());
    holder.setName("auth0filter");
    holder.setInitParameter("param", "a");
    webapp.addFilter(holder, "/portal/*", EnumSet.allOf(DispatcherType.class));
    webapp.addServlet(new ServletHolder(new RootServlet()), "/root");
    webapp.addServlet(new ServletHolder(new HomeServlet()), "/portal/home");
    webapp.addServlet(new ServletHolder(new LoginServlet()), "/login");
    webapp.addServlet(new ServletHolder(new CallbackServlet()), "/callback");
    webapp.addServlet(new ServletHolder(new LogoutServlet()), "/logout");
    webapp.addServlet(new ServletHolder(new LetSpotServlet()), "/add/renting_spot");
    server.start();
    server.join();
  }
}
