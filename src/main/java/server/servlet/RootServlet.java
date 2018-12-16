package server.servlet;

import java.io.*;

import javax.servlet.http.*;

import org.eclipse.jetty.http.*;

@SuppressWarnings("serial") public class RootServlet extends HttpServlet {
  @Override protected void doGet(final HttpServletRequest __, final HttpServletResponse ¢) throws IOException {
    ¢.setStatus(HttpStatus.OK_200);
    ¢.getWriter().println("It's Alive, Jetty style this time.");
  }
}
