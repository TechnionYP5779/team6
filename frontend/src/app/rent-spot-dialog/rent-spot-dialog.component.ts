import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatDialogConfig } from '@angular/material';
import { WebService } from '../web.service';

@Component({
  selector: 'app-rent-spot-dialog',
  templateUrl: './rent-spot-dialog.component.html',
  styleUrls: ['./rent-spot-dialog.component.css']
})
export class RentSpotDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<RentSpotDialogComponent>, @Inject(MAT_DIALOG_DATA) public spot: SpotElement, private webService: WebService) { }


  ngOnInit() {
  }

  close(): void {
    this.dialogRef.close('close');
  }

  async rent(spotId) {
    var res = await this.webService.postRent(spotId);
    if(res == null){
      this.dialogRef.close('rent');
    } else {
      alert('error');
    }
  }
}


export interface SpotElement {
  id: number;
  street: string;
  building: number;
  city: string;
  start_time: string;
  end_time: string;
  distance: number;
  price: number;
}