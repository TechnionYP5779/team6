package com.auth0.example;

import java.io.*;

import javax.servlet.*;

import com.auth0.*;

public abstract class AuthenticationControllerProvider {
  @SuppressWarnings("unused") public static AuthenticationController getInstance(final ServletConfig __) throws UnsupportedEncodingException {
    final String $ = String.valueOf("team6a.auth0.com"), clientId = String.valueOf("BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva"),
        clientSecret = String.valueOf("znc165307qVtiGnsCq7_3MfmjhuoGC0bo0aE5VMa8X91p--gxzujy6dqolSjmbD3");
    System.out.println($);
    System.out.println(clientId);
    System.out.println(clientSecret);
    return AuthenticationController.newBuilder($, clientId, clientSecret).build();
  }
}
