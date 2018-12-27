import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders } from '@angular/common/http';
import { RentSpotModel } from './rent-spot'
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
RENT_URL = 'logged/rent/renting_spot'
SEARCH_SPOTS_URL = 'someurl'   //TODO: change
	
client_id = 'BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva'  

id_token = null;
access_token = null;


  	constructor(private http: HttpClient) { }

  	async addSpot(rent: RentSpotModel){
      var body = {
          city: rent.city,
          street: rent.street,
          start_time: rent.start_time,
          end_time: rent.end_time,
          price: rent.price,
          spot_num: ''
        }
      if(rent.spot_num){
        body.spot_num = rent.spot_num.toString();
      }
      console.log(JSON.stringify( body))
  		await this.http.post(this.BASE_URL+this.ADD_SPOT_URL, body).subscribe(res=>{
  			console.log(JSON.stringify(res));	
  			return "successfully add a new spot"
  		},
  		err=>{
  			return err
  		}
  		);
      return null
  	}

    PostSignUp(form){
        var signUpHeades={
        headers: new HttpHeaders( { 'content-type': 'application/json' }),
      }
      var body={

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
      return x;
    }
    catch (error) {
      return error.Desc;
    }
}

  async getSpots(){
    var body = {}

    try{
      var res = await this.http.post(this.BASE_URL + this.GET_SPOT_URL, body).toPromise();
      return JSON.stringify(res);
    }
    catch(error){
      return JSON.stringify(error);
    }  
  }


  async postRent(spot){
    var body = {
      id: spot
    }
    try{
      var res = await this.http.post(this.BASE_URL + this.RENT_URL, body).toPromise();
      return null;
    }
    catch(error){
      return 'error';
    } 
  }

  postLogOut(){
    var body = {}
    this.http.get(this.BASE_URL + this.LOGOUT, body).toPromise();
    this.access_token = null;
    this.id_token = null;

  }

 async findSpotsByParamaters(toSearch){

    try{
      var res = await this.http.post(this.BASE_URL + this.SEARCH_SPOTS_URL, toSearch).toPromise();
      return JSON.stringify(res);
    }
    catch(error){
      return null;
    }  

  }


} 
