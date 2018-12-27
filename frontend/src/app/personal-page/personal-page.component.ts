import { Component, OnInit } from '@angular/core';
import { WebService } from '../web.service';

@Component({
  selector: 'app-personal-page',
  templateUrl: './personal-page.component.html',
  styleUrls: ['./personal-page.component.css']
})
export class PersonalPageComponent implements OnInit {

  constructor( private webService: WebService ) { }

  // email = '';
  // name = '';
  // rented = '';
  // loading = false;
  async ngOnInit() {
  // 	var userInfoRes = await this.webService.getUserInfo();
  // 	var rentedRes = await this.getuserRented();
  // 	if( rented == null ){
  // 		rented = [];
  // 	} else{
  // 		this.rented = JSON.parse(rented)
  // 	}
  // 	this.email = userInfoRes.email;
  // 	this.name = userInfoRes;
  }

}
