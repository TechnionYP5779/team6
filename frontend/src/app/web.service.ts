import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders } from '@angular/common/http';


const httpOptions = {
  headers: new HttpHeaders({
    'Access-Control-Allow-Origin': 'http://localhost:8080/add/renting_spot'
  }),
};

@Injectable()
export class WebService {

BASE_URL = 'http://localhost:8080';
ADD_SPOT_URL = '/add/renting_spot';
SIGNUP_URL = 'https://team6a.auth0.com/dbconnections/signup';

client_id= 'BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva';
	
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
    console.log(res);
   })
}
}
