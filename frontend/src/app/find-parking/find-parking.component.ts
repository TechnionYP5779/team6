/// <reference types="@types/googlemaps" />
declare let google: any;

import { Component, OnInit, ViewChild, ElementRef, NgZone } from '@angular/core';
import { MapsAPILoader } from '@agm/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSort, MatTableDataSource } from '@angular/material';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { WebService } from '../web.service';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatDialogConfig } from '@angular/material';
import { RentSpotDialogComponent } from '../rent-spot-dialog/rent-spot-dialog.component';
import { elementStyleProp } from '@angular/core/src/render3';
import { FormControl } from '@angular/forms';


@Component({
  selector: 'app-find-parking',
  templateUrl: './find-parking.component.html',
  styleUrls: ['./find-parking.component.css']
})
export class FindParkingComponent implements OnInit {

  //--- INIT LOCATION ----------------------------------------------------------------------------------------

  // shown location on the map
  shownlat: number;
  shownlng: number;

  // let the user to define his current location
  locationOptions: string[] = ['GPS location', 'Address', 'Technion'];
  selectedCurrLocOption: string = 'GPS location';

  // cuurent location (as defined by user choice)
  currlat: number;
  currlng: number;
  addressByForm = '';

  loading = true

  // technion location (used if browser doesn't support GPS)
  thecnionlat: number = 32.776520;
  thecnionlng: number = 35.022610;

  //--- DATABASE ---------------------------------------------------------------------------------------------

  displayedColumns: string[] = ['id', 'address', 'price'];
  //ELEMENT_DATA: SpotElement[] = null;
  ELEMENT_DATA: SpotElement[] = [
    { id: 1, latitude: 32.6394776, longitude: 35.08386280000002, street: 'Arbel', building: 2, city: 'Yokeneam', start_time: 'st', end_time: 'et', price: 30, userId: 'u1', buyerId: 'b1' },
    { id: 2, latitude: 32.6388926, longitude: 35.08363489999999, street: 'Arbel', building: 5, city: 'Yokeneam', start_time: 'st', end_time: 'et', price: 50, userId: 'u1', buyerId: 'b1' },
    { id: 3, latitude: 32.640864011354665, longitude: 35.08543851418892, street: 'HaHatsbani', building: 20, city: 'Yokeneam', start_time: 'st', end_time: 'et', price: 40, userId: 'u1', buyerId: 'b1' },
    { id: 4, latitude: 32.63993094696561, longitude: 35.08529903932015, street: 'Dan', building: 4, city: 'Yokeneam', start_time: 'st', end_time: 'et', price: 45, userId: 'u1', buyerId: 'b1' },
    { id: 5, latitude: 32.642645324221604, longitude: 35.08612632751465, street: 'Yarden', building: 62, city: 'Yokeneam', start_time: 'st', end_time: 'et', price: 45, userId: 'u1', buyerId: 'b1' },
  ];
  ELEMENT_DATA_FILTER: SpotElement[] = null;
  dataSource = null;

  //--- NGINIT & C'TOR ---------------------------------------------------------------------------------------

  @ViewChild(MatSort) sort: MatSort;

  @ViewChild("search") public searchElementRef: ElementRef;
  public searchControl: FormControl;
  addressIsValid: boolean = false;

  async ngOnInit() {
    this.findCurrentLocation();
    //var res = await this.webService.getSpots();
    //this.ELEMENT_DATA = JSON.parse('' + res + '')
    this.ELEMENT_DATA_FILTER = this.ELEMENT_DATA;
    this.dataSource = new MatTableDataSource(this.ELEMENT_DATA_FILTER);
    this.dataSource.sort = this.sort;

    this.loading = false;

    // create search FormControl
    this.searchControl = new FormControl();
    // load Places Autocomplete
    this.mapsAPILoader.load().then(() => {
      let autocomplete = new google.maps.places.Autocomplete(this.searchElementRef.nativeElement, { types: ["address"] });
      autocomplete.addListener("place_changed", () => {
        this.addressIsValid = false;
        this.ngZone.run(() => {
          // get the place result
          let place: google.maps.places.PlaceResult = autocomplete.getPlace();
          // verify result:
          if (place.geometry === undefined || place.geometry === null) {
            return;
          }
          // set latitude, longitude and zoom
          this.currlat = place.geometry.location.lat();
          this.currlng = place.geometry.location.lng();
          this.addressByForm = place.formatted_address;
          this.addressIsValid = true;
        });
      });
    });
  }

  constructor(private mapsAPILoader: MapsAPILoader, private ngZone: NgZone, private fb: FormBuilder, private webService: WebService, public rentDialog: MatDialog) {
    // init filterForm (fields and validators):
    this.filterForm = fb.group({
      floatLabel: 'auto',
      'maxPrice': ["", [Validators.pattern('[0-9]*')]],
      'maxDistance': ["", [Validators.pattern('[0-9]*')]],
      'locationOption': ["", [Validators.required]],
      'address': ["", []],
    });
  }

  //--- UPDATE LOCATION --------------------------------------------------------------------------------------

  findCurrentLocation() {
    this.previousMarker = null;
    if (this.selectedCurrLocOption == 'GPS location') {
      this.addressByForm = '';
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition((position) => {
          this.currlat = position.coords.latitude;
          this.currlng = position.coords.longitude;
          this.shownlat = this.currlat;
          this.shownlng = this.currlng;
        });
      } else { // unable to get current location, so use the Technion address instead
        alert("Geolocation is not supported by this browser.");
        this.changeCurrentLocationToTechnion()
      }
    } else if (this.selectedCurrLocOption == 'Technion') {
      this.addressByForm = '';
      this.changeCurrentLocationToTechnion()
    } else { // in case user define his address manially. 
      // only if address is not valid - use technion instead (else - use user address)
      if (!this.addressIsValid) {
        this.changeCurrentLocationToTechnion()
      }
    }
    this.shownlat = this.currlat;
    this.shownlng = this.currlng;
    this.centerMap(this.shownlat, this.shownlng);
  }

  changeCurrentLocationToTechnion() {
    this.currlat = this.thecnionlat;
    this.currlng = this.thecnionlng;
  }

  //--- FILTER --------------------------------------------------------------------------------------

  filterForm: FormGroup;
  filterElement: FilterElement = {
    locationOption: 'Address',
    maxDistance: -1, // meters
    maxPrice: -1,
    address: ''
  };

  filter() {
    this.filterElement.maxDistance = (this.filterForm.value.maxDistance == "" || this.filterForm.value.maxDistance == null) ? -1 : this.filterForm.value.maxDistance;
    this.filterElement.maxPrice = (this.filterForm.value.maxPrice == "" || this.filterForm.value.maxPrice == null) ? -1 : this.filterForm.value.maxPrice;
    this.filterElement.address = (this.filterElement.locationOption == 'Address') ? this.addressByForm : '';


    this.filterElement.locationOption = this.filterForm.value.locationOption;
    this.selectedCurrLocOption = this.filterForm.value.locationOption;

    if (this.selectedCurrLocOption == 'GPS location' || this.selectedCurrLocOption == 'Technion') {
      this.filterForm.controls['address'].reset()
    }

    this.findCurrentLocation();
    this.filterMarkers()
  }

  reset() {
    this.filterForm.reset();
    this.filterElement.maxDistance = -1;
    this.filterElement.maxPrice = -1;
    this.filterMarkers()
  }

  async filterMarkers() {
    this.ELEMENT_DATA_FILTER = [];
    this.loading = true;
    var res= await this.webService.findSpotsByParamaters(this.filterElement)
    if(res == null){
      this.ELEMENT_DATA_FILTER = [];
    }
    else{
      this.ELEMENT_DATA_FILTER=  JSON.parse('' + res + '')
    }
    
    this.loading = false

    const centerLoc = new google.maps.LatLng(this.currlat, this.currlng);
    for (let spot of this.ELEMENT_DATA) {
      const markerLoc = new google.maps.LatLng(spot.latitude, spot.longitude);
      // spot.distance = Math.round(google.maps.geometry.spherical.computeDistanceBetween(markerLoc, centerLoc));

      // if (((spot.distance <= this.filterElement.maxDistance) || (this.filterElement.maxDistance == -1)) &&

      if (((spot.price <= this.filterElement.maxPrice) || (this.filterElement.maxPrice == -1))) {
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

    dialogConfig.height = '450px';      /** size of dialog window */
    dialogConfig.width = '500px';

    dialogConfig.data = { /** pass data to dialog */
      id: this.selectedSpot.id,
      building: this.selectedSpot.building,
      city: this.selectedSpot.city,
      street: this.selectedSpot.street,
      end_time: this.selectedSpot.end_time,
      start_time: this.selectedSpot.start_time,
      price: this.selectedSpot.price,
    };

    /** open dialog */
    const dialogRef = this.rentDialog.open(RentSpotDialogComponent, dialogConfig);

    /** get data from dialog - empty for now */
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

  //--- SHOW MARKERS ON MAP  ------------------------------------------------------------------------

  protected map: any;

  protected mapReady(map) {
    this.map = map;
  }

  previousMarker = null;
  clickedMarker(infowindow) {
    if (this.previousMarker) {
      this.previousMarker.close();
    }
    this.previousMarker = infowindow;
  }

  findme() {
    this.centerMap(this.currlat, this.currlng);
  }

  centerMap(lat, lng) {
    if (this.map) {
      this.map.setCenter({ lat: lat, lng: lng });
      this.map.setZoom(17);
    }
  }

  getRecord(row) {
    this.centerMap(row.latitude, row.longitude);
    this.map.setZoom(19);
  }

}

//--- INTERFACES -----------------------------------------------------------------------------------

export interface SpotElement {
  id: number;
  latitude: number;
  longitude: number;
  street: string;
  building: number;
  city: string;
  start_time: string;
  end_time: string;
  // distance: number;
  price: number;
  userId: string;
  buyerId: string;
}

export interface FilterElement {
  locationOption: string
  maxDistance: number;
  maxPrice: number;
  address: string;
}