import { Component, OnInit } from '@angular/core';
import { RentSpotModel } from '../rent-spot'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { WebService } from '../web.service';

@Component({
	selector: 'app-rent-spot-form',
	templateUrl: './rent-spot-form.component.html',
	styleUrls: ['./rent-spot-form.component.css']
})
export class RentSpotFormComponent implements OnInit {

	rentSpotForm: FormGroup;

	rentSpotModel: RentSpotModel = new RentSpotModel('', '', null, null, 0)

	constructor(private fb: FormBuilder, private webService: WebService) {
		this.rentSpotForm = fb.group({
			floatLabel: 'auto',
			'city': ["",
				[Validators.required,
				Validators.pattern('[a-zA-Z ]*')]
			],
			'street': ["",
				[Validators.required,
				Validators.pattern('[a-zA-Z ]*')]
			],
			'spot_num': ["",
				[Validators.pattern('[0-9]*')]
			],

			'start_date': ["",
				[Validators.required]
			],
			'start_hour': ["",
				[Validators.required]
			],

			'end_date': ["",
				[Validators.required]
			],
			'end_hour': ["",
				[Validators.required]
			],

			'price': ["",
				[Validators.required,
				Validators.pattern('[0-9]+((.)[0-9]+)?')]
			],
		});
	}

	ngOnInit() { }

	addNewSpot() {
		this.rentSpotModel.city = this.rentSpotForm.value.city
		this.rentSpotModel.street = this.rentSpotForm.value.street
		this.rentSpotModel.spot_num = this.rentSpotForm.value.spot_num

		var startDate = new Date(this.rentSpotForm.value.start_date);
		var startHourString = this.rentSpotForm.value.start_hour.split(':'); // [0]=hour, [1]=min
		var startTime = new Date(startDate.getFullYear(), startDate.getMonth(), startDate.getDate(), startHourString[0], startHourString[1])

		var endDate = new Date(this.rentSpotForm.value.end_date);
		var endHourString = this.rentSpotForm.value.end_hour.split(':'); // [0]=hour, [1]=min
		var endTime = new Date(endDate.getFullYear(), endDate.getMonth(), endDate.getDate(), endHourString[0], endHourString[1])

		this.rentSpotModel.start_time = startTime
		this.rentSpotModel.end_time = endTime

		this.rentSpotModel.price = this.rentSpotForm.value.price

		this.reset();
		console.log("The rent spot form was submitted: " + JSON.stringify(this.rentSpotModel))  // TODO: delete!
		this.webService.addSpot(JSON.stringify(this.rentSpotModel))

		// for tests:
		// console.log("time: " + " yyyy= " + sd.getFullYear() + " mm= " + sd.getMonth() + " dd= " + sd.getDate() + " h= " + sd.getHours() + " m= " + sd.getMinutes())
	}

	reset() {
		this.rentSpotForm.reset();
	}

}
