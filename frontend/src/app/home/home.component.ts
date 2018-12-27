import { Component, OnInit } from '@angular/core';
import { WebService } from '../web.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private webService : WebService) { }

  ngOnInit() {
	  var jo = this.webService.GetDetailRoot();
	  var jop = JSON.parse('' + jo + '')
  }

}
