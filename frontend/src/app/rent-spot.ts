export class RentSpotModel {

	constructor(
		public city: string,
		public street: string,
		public start_time: Date,
		public end_time: Date,
		public price: number,
		public spot_num?: number,
	) { }

}
