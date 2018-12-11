export class RentSpot {

	constructor(
		public city: string,
		public street: string,
		public start_time: string,
		public end_time: string,
		public price: number,
		public spot_num?: number,
		) { }

}
