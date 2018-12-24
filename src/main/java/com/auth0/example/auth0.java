package com.auth0.example;

import com.auth0.client.auth.*;
import com.auth0.exception.*;
import com.auth0.json.auth.*;
import com.auth0.net.*;

public class auth0 {
  
  AuthAPI auth = new AuthAPI("team6a.auth0.com", "BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva",
      "znc165307qVtiGnsCq7_3MfmjhuoGC0bo0aE5VMa8X91p--gxzujy6dqolSjmbD3");

  public TokenHolder loginTry() {

    
    
    AuthRequest request = auth.login("blablabla@gmail.com", "BlaBlaBla1", "Username-Password-Authentication").setScope("openid contacts");
//        .setAudience("https://team6a.auth0.com/api/v2").setScope("openid contacts");
    try {
      return request.execute();
      

    } catch (APIException exception) {
      System.out.println(exception.getError());
      System.out.println(exception.getDescription());
      return null;
    } catch (Auth0Exception exception) {
      
      System.out.println(exception.toString());
      return null;
    }
  }
  
  public void logOutTry() {
  
  auth.logoutUrl("http://localhost:8080", true)
      .useFederated(true).
      build();
  }
  
  public UserInfo tryInfo(String token) {
    Request<UserInfo> request = auth.userInfo(token);
    try {
        UserInfo info = request.execute();
        // info.getValues();
        return info;
    } catch (APIException exception) {
        // api error
      return null;
    } catch (Auth0Exception exception) {
        // request error
      return null;
    }
  }
  
}
