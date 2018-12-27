import { Component, OnInit } from '@angular/core';
import { RentSpotModel } from '../rent-spot'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { WebService } from '../web.service';
import { NgbDatepickerConfig, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

@Component({
	selector: 'app-rent-spot-form',
	templateUrl: './rent-spot-form.component.html',
	styleUrls: ['./rent-spot-form.component.css']
})
export class RentSpotFormComponent implements OnInit {

	error_msg = '';

	added = false;

	rentSpotForm: FormGroup;

	rentSpotModel: RentSpotModel = new RentSpotModel('', '', null, null, 0)

	constructor(private fb: FormBuilder, datepickerConfig: NgbDatepickerConfig, private webService: WebService) {

		// configuration of NgbDatepickerConfig (used for disable dates before today):
		const currentDate = new Date();
		datepickerConfig.minDate = { year: currentDate.getFullYear(), month: currentDate.getMonth() + 1, day: currentDate.getDate() };
		datepickerConfig.outsideDays = 'hidden';

		// init rentSpotForm (fields and validators):
		this.rentSpotForm = fb.group({
			floatLabel: 'auto',

			'address': this.fb.group({
				'city': ["", [Validators.required, Validators.pattern('[a-zA-Z ]*')]],
				'street': ["", [Validators.required, Validators.pattern('[a-zA-Z ]*')]],
				'spot_num': ["", [Validators.pattern('[0-9]*')]],
			}),

			'start_time': this.fb.group({
				'start_date': ["", [Validators.required]],
				'start_hour': ['', [Validators.required]],
			}),

			'end_time': this.fb.group({
				'end_date': ["", [Validators.required]],
				'end_hour': ['', [Validators.required]],
			}),

			'price': ["", [Validators.required, Validators.pattern('[0-9]+((.)[0-9]+)?')]],
		});
	}

	ngOnInit() { }

	async addNewSpot() {
		this. added = false;
		this.error_msg = '';
		this.rentSpotModel.city = this.rentSpotForm.value.address.city
		this.rentSpotModel.street = this.rentSpotForm.value.address.street
		this.rentSpotModel.spot_num = this.rentSpotForm.value.address.spot_num

		var startTime = new Date(
			this.rentSpotForm.value.start_time.start_date.year,
			this.rentSpotForm.value.start_time.start_date.month - 1,
			this.rentSpotForm.value.start_time.start_date.day,
			this.rentSpotForm.value.start_time.start_hour.hour,
			this.rentSpotForm.value.start_time.start_hour.minute)
		this.rentSpotModel.start_time = startTime

		var endTime = new Date(
			this.rentSpotForm.value.end_time.end_date.year,
			this.rentSpotForm.value.end_time.end_date.month - 1,
			this.rentSpotForm.value.end_time.end_date.day,
			this.rentSpotForm.value.end_time.end_hour.hour ,
			this.rentSpotForm.value.end_time.end_hour.minute)
		this.rentSpotModel.end_time = endTime

		this.rentSpotModel.price = this.rentSpotForm.value.price

		this.reset();

		console.log("The rent spot form was submitted: " + JSON.stringify(this.rentSpotModel))  // TODO: delete!

		var res = await this.webService.addSpot(this.rentSpotModel);
		if(res == null){
			this.added = true;
		}
		else{
			this.error_msg = res.Desc;
			// this.error = true
		}

		// for tests:
		// var sd = startTime;
		// console.log("sd: ", sd)
		// console.log("time: " + " yyyy=" + sd.getFullYear() + " mm=" + sd.getMonth() + " dd=" + sd.getDate() + " h=" + sd.getHours() + " m=" + sd.getMinutes())
	}

	reset() {
		this.rentSpotForm.reset();
	}

}
