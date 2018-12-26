/// <reference types="@types/googlemaps" />
declare let google: any;

import { Component, OnInit, ViewChild } from '@angular/core';
import { MapsAPILoader } from '@agm/core';
import { MatRadioModule, MatRadioButton, MatRadioChange } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSort, MatTableDataSource } from '@angular/material';
import { WebService } from '../web.service';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatDialogConfig } from '@angular/material';
import { RentSpotDialogComponent } from '../rent-spot-dialog/rent-spot-dialog.component';
import { elementStyleProp } from '@angular/core/src/render3';


@Component({
  selector: 'app-find-parking',
  templateUrl: './find-parking.component.html',
  styleUrls: ['./find-parking.component.css']
})
export class FindParkingComponent implements OnInit {

  //--- INIT LOCATION ----------------------------------------------------------------------------------------

  // let the user to define his current location
  defineCurrLocOptions: string[] = ['GPS location', 'Technion']; // need to add "choose by address"
  selectedCurrLocOption: string = 'GPS location';

  // cuurent location (as defined by user choice)
  currlat: number;
  currlng: number;

  // technion location (used if browser doesn't support GPS)
  thecnionlat: number = 32.776520;
  thecnionlng: number = 35.022610;

  //--- DATABASE ---------------------------------------------------------------------------------------------

  // fake DB TODO: updete this!!!

  displayedColumns: string[] = ['id', 'address', 'price', 'distance'];
  ELEMENT_DATA: SpotElement[] = null;
  // [
  //   { id: 1, lat: this.thecnionlat - 0.00230, lng: this.thecnionlng + 0.00200, distance: -1, price: 40 },
  //   { id: 2, lat: this.thecnionlat + 0.00150, lng: this.thecnionlng + 0.00200, distance: -1, price: 70 },
  //   { id: 3, lat: this.thecnionlat + 0.00065, lng: this.thecnionlng + 0.00065, distance: -1, price: 30 },
  //   { id: 4, lat: this.thecnionlat - 0.00075, lng: this.thecnionlng - 0.00070, distance: -1, price: 50 },
  //   { id: 5, lat: this.thecnionlat + 0.00150, lng: this.thecnionlng - 0.00150, distance: -1, price: 40 },
  //   { id: 6, lat: this.thecnionlat - 0.00075, lng: this.thecnionlng + 0.00045, distance: -1, price: 45 },
  //   { id: 7, lat: this.thecnionlat - 0.00175, lng: this.thecnionlng + 0.00145, distance: -1, price: 40 },
  //   { id: 8, lat: this.thecnionlat + 0.00045, lng: this.thecnionlng - 0.00165, distance: -1, price: 30 },
  //   { id: 9, lat: this.thecnionlat + 0.00180, lng: this.thecnionlng - 0.00020, distance: -1, price: 20 },
  //   { id: 10, lat: this.thecnionlat + 0.00125, lng: this.thecnionlng - 0.00080, distance: -1, price: 80 },
  // ];
  ELEMENT_DATA_FILTER: SpotElement[] = null;
  dataSource = null;

  //--- NGINIT & C'TOR ---------------------------------------------------------------------------------------

  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() {
    this.findCurrentLocation();
    var res = this.webService.getSpots();
    this.ELEMENT_DATA = JSON.parse('[' + res + ']')
    this.ELEMENT_DATA_FILTER = this.ELEMENT_DATA;
    this.dataSource = new MatTableDataSource(this.ELEMENT_DATA_FILTER);
    this.dataSource.sort = this.sort;
  }


  constructor(private mapsAPILoader: MapsAPILoader, private fb: FormBuilder, private webService: WebService, public rentDialog: MatDialog) {
    // init filterForm (fields and validators):
    this.filterForm = fb.group({
      floatLabel: 'auto',
      'maxPrice': ["", [Validators.pattern('[0-9]*')]],
      'maxDistance': ["", [Validators.pattern('[0-9]*')]],
      'locationOption': ["", [Validators.required]],
    });
  }

  getAddress(lat: number, lng: number): string {
    if (navigator.geolocation) {
      let geocoder = new google.maps.Geocoder();
      let latlng = new google.maps.LatLng(lat, lng);
      let request = { latLng: latlng };
      let res = '(lat=' + lat + ',lng=' + lng + ')'
      geocoder.geocode(request, (results, status) => {
        if (status == google.maps.GeocoderStatus.OK && results[0]) {
          //console.log("************ results[0].formatted_address", results[0].formatted_address)
          res = results[0].formatted_address
        }
      });
      return res
    }
  }

  //--- UPDATE LOCATION --------------------------------------------------------------------------------------

  findCurrentLocation() {
    if (this.selectedCurrLocOption == 'GPS location') {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition((position) => {
          this.currlat = position.coords.latitude;
          this.currlng = position.coords.longitude;
        });
      } else { // unable to get current location, so use the Technion address instead
        alert("Geolocation is not supported by this browser.");
        this.changeCurrentLocationToTechnion()
      }
    } else if (this.selectedCurrLocOption == 'Technion') {
      this.changeCurrentLocationToTechnion()
    } else { // in case user define his address manially. for now use technion
      this.changeCurrentLocationToTechnion()
    }
  }

  changeCurrentLocationToTechnion() {
    this.currlat = this.thecnionlat;
    this.currlng = this.thecnionlng;
    //this.getAddress(this.currlat, this.currlng)
  }

  //--- FILTER --------------------------------------------------------------------------------------

  filterForm: FormGroup;
  filterElement: FilterElement = {
    locationOption: 'GPS location',
    maxDistance: -1, // meters
    maxPrice: -1,
  };
  locationOptions: string[] = ['GPS location', 'Technion']; // need to add "choose by address"

  filter() {
    this.filterElement.locationOption = this.filterForm.value.locationOption;

    this.filterElement.maxDistance = (this.filterForm.value.maxDistance == "" || this.filterForm.value.maxDistance == null) ? -1 : this.filterForm.value.maxDistance;
    this.filterElement.maxPrice = (this.filterForm.value.maxPrice == "" || this.filterForm.value.maxPrice == null) ? -1 : this.filterForm.value.maxPrice;

    this.selectedCurrLocOption = this.filterForm.value.locationOption;

    this.findCurrentLocation();
    this.filterMarkers()
  }

  reset() {
    this.filterForm.reset();
    this.filterElement.maxDistance = -1;
    this.filterElement.maxPrice = -1;
    this.filterMarkers()
  }

  filterMarkers() {
    this.ELEMENT_DATA_FILTER = [];

    const centerLoc = new google.maps.LatLng(this.currlat, this.currlng);
    for (let spot of this.ELEMENT_DATA) {
      const markerLoc = new google.maps.LatLng(spot.lat, spot.lng);
      spot.distance = Math.round(google.maps.geometry.spherical.computeDistanceBetween(markerLoc, centerLoc));

      if (((spot.distance <= this.filterElement.maxDistance) || (this.filterElement.maxDistance == -1)) &&
        ((spot.price <= this.filterElement.maxPrice) || (this.filterElement.maxPrice == -1))) {
        this.ELEMENT_DATA_FILTER.push(spot);
      }

    }

    this.dataSource = new MatTableDataSource(this.ELEMENT_DATA_FILTER);
    this.dataSource.sort = this.sort;
  }

  //--- RENT SPOT -----------------------------------------------------------------------------------

  selectedSpot: SpotElement = null;

  rentSpot(spot: SpotElement) {
    console.log("you choose to rent: ", spot);
    this.selectedSpot = spot;
    this.openRentDialog();
    this.selectedSpot = null;
  }

  openRentDialog(): void {

    /** config dialog */
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;   /** the user will not be able to close the dialog just by clicking outside of it */
    dialogConfig.autoFocus = false;     /** the focus will not be set automatically on the first form field of the dialog */

    dialogConfig.height = '500px';      /** size of dialog window */
    dialogConfig.width = '500px';

    dialogConfig.data = { /** pass data to dialog */
      id: this.selectedSpot.id,
      price: this.selectedSpot.price,
      lat: this.selectedSpot.lat,
      lng: this.selectedSpot.lng,
      address: this.getAddress(this.selectedSpot.lat, this.selectedSpot.lng),
    };

    /** open dialog */
    const dialogRef = this.rentDialog.open(RentSpotDialogComponent, dialogConfig);

    /** get data from dialog - empty for no */
    dialogRef.afterClosed().subscribe(result => {
      if (result != null) {
        if (result == 'rent') {
          console.log('The rent dialog was closed - *with* renting');
        }
        else if (result == 'close') {
          console.log('The rent dialog was closed - *without* renting');
        }
      }
    });
  }



}

//--- INTERFACES -----------------------------------------------------------------------------------

export interface SpotElement {
  id: number;
  lat: number;
  lng: number;
  street: string;
  building: number;
  city: string;
  start_time: string;
  end_time: string
  distance: number;
  price: number;
}

export interface FilterElement { // TODO: add date
  locationOption: string
  maxDistance: number;
  maxPrice: number;
}