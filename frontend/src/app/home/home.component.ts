import { Component, OnInit } from '@angular/core';
import { WebService } from '../web.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private webService : WebService) { }
   total;
   freetoday;
   totalfree;
   loading = true;
   async ngOnInit() {
	   var res = await this.webService.GetDetailRoot();
	   this.loading = false;
	   this.total = res["total"]
	   this.freetoday = res["free_today"]
	   this.totalfree = res["free_all"]
  }

}
