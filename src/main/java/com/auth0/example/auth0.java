package com.auth0.example;

import com.auth0.client.auth.*;
import com.auth0.exception.*;
import com.auth0.json.auth.*;
import com.auth0.net.*;

public class auth0 {
  
  AuthAPI auth = new AuthAPI("team6a.auth0.com", "BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva",
      "znc165307qVtiGnsCq7_3MfmjhuoGC0bo0aE5VMa8X91p--gxzujy6dqolSjmbD3");

  public TokenHolder loginTry() {

    
    
    AuthRequest $ = auth.login("blablabla@gmail.com", "BlaBlaBla1", "Username-Password-Authentication").setScope("openid contacts");
//        .setAudience("https://team6a.auth0.com/api/v2").setScope("openid contacts");
    try {
      return $.execute();
      

    } catch (APIException ¢) {
      System.out.println(¢.getError());
      System.out.println(¢.getDescription());
      return null;
    } catch (Auth0Exception ¢) {
      
      System.out.println(¢ + "");
      return null;
    }
  }
  
  public void logOutTry() {
  
  auth.logoutUrl("http://localhost:8080", true)
      .useFederated(true).
      build();
  }
  
  public UserInfo tryInfo(String token) {
    Request<UserInfo> $ = auth.userInfo(token);
    try {
      return $.execute();
    } catch (@SuppressWarnings("unused") Auth0Exception exception) {
      return null;
    }
  }
  
}
