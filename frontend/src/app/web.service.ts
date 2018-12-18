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



}
