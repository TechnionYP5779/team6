package server;
import java.util.*;
import java.util.concurrent.*;

import javax.servlet.*;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.*;
import org.eclipse.jetty.webapp.*;

import com.auth0.example.*;
import com.auth0.example.auth0;
import com.auth0.json.auth.*;

public class JettyServer {
  public static void main(final String[] args) throws Exception {
    final Server server = new Server(8080);
    final WebAppContext webapp = new WebAppContext();
    String angularAppLocation = "frontend/dist/parking-renting-project";
    webapp.setContextPath("/");
    webapp.setDescriptor(angularAppLocation + "/WEB-INF/web.xml");
    webapp.setResourceBase(angularAppLocation);
    // webapp.addServlet(new ServletHolder(new HomeServlet()), "/portal/home");
    // webapp.addServlet(new ServletHolder(new LoginServlet()), "/login");
     webapp.addServlet(new ServletHolder(new CallbackServlet()), "/callback");
    // webapp.addServlet(new ServletHolder(new LogoutServlet()), "/logout");
    webapp.addServlet(new ServletHolder(new RootServlet()), "/root");
    webapp.addServlet(new ServletHolder(new LetSpotServlet()), "/logged/add/renting_spot");
    webapp.addServlet(new ServletHolder(new RemoveSpotServlet()), "/logged/remove/renting_spot");
    webapp.addServlet(new ServletHolder(new RentSpotServlet()), "/logged/rent/renting_spot");
    webapp.addServlet(new ServletHolder(new UnrentSpotServlet()), "/logged/unrent/renting_spot");
    webapp.addServlet(new ServletHolder(new SearchSpotsServlet()), "/logged/search/renting_spots");
    final FilterHolder holder1 = new FilterHolder(new Auth0Filter());
 
    
    
    holder1.setName("auth0filter");
    holder1.setInitParameter("param", "");
    webapp.addFilter(holder1, "/logged/*", EnumSet.allOf(DispatcherType.class));
    server.setHandler(webapp);
    server.start();
    auth0 test = new auth0();
    System.out.println("+++++++++++");
    TokenHolder x = test.loginTry();
    
    System.out.println(x.getAccessToken());
    System.out.println( test.tryInfo(x.getAccessToken()).getValues().toString());
    
    System.out.println("=============");
    TimeUnit.SECONDS.sleep(40);
    System.out.println("=============");
   test.logOutTry();
    server.join();
  }
}
