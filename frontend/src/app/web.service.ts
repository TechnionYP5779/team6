import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders } from '@angular/common/http';




const httpOptions = {
  headers: new HttpHeaders({
    'Access-Control-Allow-Origin':  'http://localhost:8000/*'
  }),
};

@Injectable()
export class WebService {

	BASE_URL = 'http://localhost:8000';
  	constructor(private http: HttpClient) { }



}
