import { Component, OnInit  } from '@angular/core';
import {  MatTableDataSource } from '@angular/material';
import { WebService } from '../web.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  loading = true
	userPersonalNickname;
	userPersonalEmail;
  // personal information
  userPersonalInformation: UserElement = { name: "myUsername",  email: "my@email.com" }

  // ownSpots table
  ownSpotsHeader: string[] = ['id', 'address', 'price', 'start_time', 'end_time', 'status', 'status_button'];
  OWN_SPOTS_DATA: SpotElement[] = [
    { id: 1, latitude: 32.6394776, longitude: 35.08386280000002, street: 'Arbel', building: 2, city: 'Yokeneam', start_time: 'st1', end_time: 'et2', price: 30, userId: 'myUsername', buyerId: 'b1' },
    { id: 2, latitude: 32.6388926, longitude: 35.08363489999999, street: 'Arbel', building: 5, city: 'Yokeneam', start_time: 'st2', end_time: 'et2', price: 50, userId: 'myUsername', buyerId: 'b2' },
    { id: 3, latitude: 32.641580, longitude: 35.084620, street: 'Habanyas ', building: 7, city: 'Yokeneam', start_time: 'st3', end_time: 'et3', price: 30, userId: 'myUsername', buyerId: '' },
  ];
  ownSpotsDataSource = null;

  // rentSpots table
  rentSpotsHeader: string[] = ['id', 'address', 'price', 'start_time', 'end_time', 'status', 'status_button'];
  RENT_SPOTS_DATA: SpotElement[] = [
    { id: 5, latitude: 32.640864011354665, longitude: 35.08543851418892, street: 'HaHatsbani', building: 20, city: 'Yokeneam', start_time: 'st5', end_time: 'et5', price: 40, userId: 'u2', buyerId: 'myUsername' },
    { id: 4, latitude: 32.63993094696561, longitude: 35.08529903932015, street: 'Dan', building: 4, city: 'Yokeneam', start_time: 'st4', end_time: 'et4', price: 45, userId: 'u3', buyerId: 'myUsername' },
  ];
  rentSpotsDataSource = null;


  constructor(private webService: WebService) { }


  async ngOnInit() {


    // personal information

    var userInformationRes = await this.webService.getUserInformation();
	this.userPersonalNickname = userInformationRes["name"]
	this.userPersonalEmail = userInformationRes["email"]

    // var userInformationRes = await this.webService.getUserInformation();
    // this.userPersonalInformation = JSON.parse('' + userInformationRes + '')

    // personal information 
    //var userInformationRes = await this.webService.getUserInformation();
    //this.userPersonalInformation = JSON.parse('' + userInformationRes + '')



     //ownSpots table
    var userOwnSpotsRes = await this.webService.getUserOwnSpots();
	console.log(userOwnSpotsRes);
    this.OWN_SPOTS_DATA = JSON.parse('' + userOwnSpotsRes + '')
	console.log(this.OWN_SPOTS_DATA);
    this.ownSpotsDataSource = new MatTableDataSource(this.OWN_SPOTS_DATA);

     //ownSpots table
     var userRentSpotsRes = await this.webService.getUserRentSpots();
	 console.log('here');
     this.RENT_SPOTS_DATA = JSON.parse('' + userRentSpotsRes + '')
	 console.log(this.RENT_SPOTS_DATA);
    this.rentSpotsDataSource = new MatTableDataSource(this.RENT_SPOTS_DATA);
	


    // this.rentSpotsDataSource.sort = this.sort;


    this.loading = false;

  }


  async deleteMySpot(spot: SpotElement) { // TODO: complete this
    var deleteSpotRes = await this.webService.deleteSpot(spot.id);
    var userOwnSpotsRes = await this.webService.getUserOwnSpots();
    this.OWN_SPOTS_DATA = JSON.parse('' + userOwnSpotsRes + '')
    this.ownSpotsDataSource = new MatTableDataSource(this.OWN_SPOTS_DATA);

  }

}

export interface UserElement {
  name: string;
  email: string;
}

export interface SpotElement {
  id: number;
  latitude: number;
  longitude: number;
  street: string;
  building: number;
  city: string;
  start_time: string;
  end_time: string;
  // distance: number;
  price: number;
  userId: string;
  buyerId: string;
}
