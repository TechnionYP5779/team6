import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders } from '@angular/common/http';
import * as auth0 from 'auth0-js';



const httpOptions = {
  headers: new HttpHeaders({
    'Access-Control-Allow-Origin': 'http://localhost:8080'
  }),
};

@Injectable()
export class WebService {

BASE_URL = 'http://localhost:8080';
ADD_SPOT_URL = '/logged/add/renting_spot';
SIGNUP_URL = 'https://team6a.auth0.com/dbconnections/signup';
LOGIN_URL = '/login';
LOGOUT = '/logged/logout';
GET_SPOT_URL = '/logged/search/all/renting_spots'
GET_SPOT_BY_LOCATION_URL = '/logged/search/some/renting_spots'
	
client_id = 'BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva'  

id_token = null;
access_token = null;


  	constructor(private http: HttpClient) { }

  	addSpot(rent){
  		this.http.post(this.BASE_URL+this.ADD_SPOT_URL, rent).subscribe(res=>{
  			console.log(JSON.stringify(res));	
  			alert("successfully add a new spot")
  		},
  		err=>{
  			alert("an error occurred. please try again")
  		}
  		);
  	}

    PostSignUp(form){
        var signUpHeades={
        headers: new HttpHeaders( { 'content-type': 'application/json' }),
      }
      var body={
       client_id: this.client_id,
       email: form.email,
       password: form.password,
       connection: 'Username-Password-Authentication',
      user_metadata: { name: form.name ,username: form.username },
       json: true,
     };

       console.log(body);
     this.http.post(this.SIGNUP_URL,body,signUpHeades).subscribe( res=>{
      console.log(res);   //TODO: delete
     })
  }



  async PostLogIn(user){
    var body = {
      username: user.email,
      password: user.password
    }
    console.log(JSON.stringify(body))
    console.log(this.BASE_URL + this.LOGIN_URL)
    try{
    var x = await this.http.post(this.BASE_URL + this.LOGIN_URL, body).toPromise()
    this.id_token = x['idToken']
    this.access_token = x['accessToken'];
    return x;
    }
    catch (error) {
      return 'wrong email or password';
    }
}

  async getSpots(){
    var body = {
      accessToken: this.access_token,
      idToken: this.id_token
    }

    try{
      var res = await this.http.post(this.BASE_URL + this.GET_SPOT_URL, body).toPromise();
      return JSON.stringify(res);
    }
    catch(error){
      return 'logged out';
    }  
  }
} 
