import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatDialogConfig } from '@angular/material';

@Component({
  selector: 'app-rent-spot-dialog',
  templateUrl: './rent-spot-dialog.component.html',
  styleUrls: ['./rent-spot-dialog.component.css']
})
export class RentSpotDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<RentSpotDialogComponent>, @Inject(MAT_DIALOG_DATA) public spot: SpotElement) { }


  ngOnInit() {
  }

  close(): void {
    this.dialogRef.close('close');
  }

  rent(): void {
    this.dialogRef.close('rent');
  }
}


export interface SpotElement {
  id: number;
  lat: number;
  lng: number;
  address: string;
  distance: number;
  price: number;
}