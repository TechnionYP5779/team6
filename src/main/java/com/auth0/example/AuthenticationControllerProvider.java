package com.auth0.example;

import java.io.*;

import javax.servlet.*;

import com.auth0.*;

public abstract class AuthenticationControllerProvider {
  @SuppressWarnings("unused") public static AuthenticationController getInstance(final ServletConfig __) throws UnsupportedEncodingException {
    return AuthenticationController.newBuilder(__.getServletContext().getInitParameter("com.auth0.domain"),
        __.getServletContext().getInitParameter("com.auth0.clientId"), __.getServletContext().getInitParameter("com.auth0.clientSecret")).build();
  }
}
