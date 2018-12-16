package server.servlet;

import java.io.*;

import javax.servlet.http.*;

import org.eclipse.jetty.http.*;

import com.auth0.*;

@SuppressWarnings("serial") public class RootServlet extends HttpServlet {
  @Override protected void doGet(final HttpServletRequest __, final HttpServletResponse ¢) throws IOException {
    ¢.setStatus(HttpStatus.OK_200);
    ¢.getWriter().println("It's Alive, Jetty style this time.");
    
//    String domain = getServletConfig().getServletContext().getInitParameter("com.auth0.domain");
//    String clientId = getServletConfig().getServletContext().getInitParameter("com.auth0.clientId");
//    String clientSecret = getServletConfig().getServletContext().getInitParameter("com.auth0.clientSecret");

//    AuthenticationController controller = AuthenticationController.newBuilder(domain, clientId, clientSecret)
//                    .build();
//    
  }
}
