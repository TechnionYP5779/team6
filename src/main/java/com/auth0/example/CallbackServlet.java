package com.auth0.example;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.auth0.*;
/** The Servlet endpoint used as the callback handler in the OAuth 2.0
 * authorization code grant flow. It will be called with the authorization code
 * after a successful login. */
@WebServlet(urlPatterns = { "/callback" }) @SuppressWarnings("serial") public class CallbackServlet extends HttpServlet {
  private String redirectOnSuccess;
  private String redirectOnFail;
  private AuthenticationController authenticationController;

  /** Initialize this servlet with required configuration.
   * <p>
   * Parameters needed on the Local Servlet scope:
   * <ul>
   * <li>'com.auth0.redirect_on_success': where to redirect after a successful
   * authentication.</li>
   * <li>'com.auth0.redirect_on_error': where to redirect after a failed
   * authentication.</li>
   * </ul>
   * Parameters needed on the Local/Global Servlet scope:
   * <ul>
   * <li>'com.auth0.domain': the Auth0 domain.</li>
   * <li>'com.auth0.client_id': the Auth0 Client id.</li>
   * <li>'com.auth0.client_secret': the Auth0 Client secret.</li>
   * </ul>
   */
  
  @Override public void init(final ServletConfig c) throws ServletException {
    super.init(c);
    redirectOnSuccess = "/portal/home";
    redirectOnFail = "/login";
    try {
      authenticationController = AuthenticationControllerProvider.getInstance(c);
    } catch (final UnsupportedEncodingException ¢) {
      throw new ServletException("Couldn't create the AuthenticationController instance. Check the configuration.", ¢);
    }
  }

  /** Process a call to the redirect_uri with a GET HTTP method.
   * @param r   the received request with the tokens (implicit grant) or the
   *            authorization code (code grant) in the parameters.
   * @param res the response to send back to the server.
   * @throws IOException
   * @throws ServletException */
  
  @Override public void doGet(final HttpServletRequest r, final HttpServletResponse res) throws IOException, ServletException {
    handle(r, res);
  }

  /** Process a call to the redirect_uri with a POST HTTP method. This occurs if
   * the authorize_url included the 'response_mode=form_post' value. This is
   * disabled by default. On the Local Servlet scope you can specify the
   * 'com.auth0.allow_post' parameter to enable this behaviour.
   * @param r the received request with the tokens (implicit grant) or the
   *            authorization code (code grant) in the parameters.
   * @param res the response to send back to the server.
   * @throws IOException
   * @throws ServletException */
  
  @Override public void doPost(final HttpServletRequest r, final HttpServletResponse res) throws IOException, ServletException {
    handle(r, res);
  }

  private void handle(final HttpServletRequest r, final HttpServletResponse res) throws IOException {
    try {
      final Tokens tokens = authenticationController.handle(r);
      SessionUtils.set(r, "accessToken", tokens.getAccessToken());
      SessionUtils.set(r, "idToken", tokens.getIdToken());
      res.sendRedirect(redirectOnSuccess);
    } catch (final IdentityVerificationException ¢) {
      ¢.printStackTrace();
      res.sendRedirect(redirectOnFail);
    }
  }
}
