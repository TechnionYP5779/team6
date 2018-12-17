import { Component, OnInit } from '@angular/core';
import {RentSpot} from '../rent-spot';
import { WebService } from '../web.service';

@Component({
  selector: 'app-rent-spot-form',
  templateUrl: './rent-spot-form.component.html',
  styleUrls: ['./rent-spot-form.component.css']
})
export class RentSpotFormComponent implements OnInit {

 	Hours = [
			' ' ,
		  	'00:00' ,
			'01:00' ,
			'02:00' ,
			'03:00' ,
			'04:00' ,
			'05:00' ,
			'06:00' ,
			'07:00' ,
			'08:00' ,
			'09:00' ,
			'10:00' ,
			'11:00' ,
			'12:00' ,
			'13:00' ,
			'14:00' ,
			'15:00' ,
			'16:00' ,
			'17:00'	,
			'18:00' ,
			'19:00' ,
			'20:00' ,
			'21:00' ,
			'22:00' ,
			'23:00' ,
			'24:00' 
			]

	submitted = false

	model = new RentSpot('','','','',0)

 	constructor(private webService : WebService ) { }

 	// constructor( ) { }

  	ngOnInit() { }

	onSubmit(){ 
		this.submitted = true
	}		

	get diagnostic() {
	 	return JSON.stringify(this.model); 
	}

	 newSpot(){
		// fill with a post request
		// this.webService.addSpot(JSON.stringify(this.model))
		// console.log(JSON.stringify(x));
	}

}

