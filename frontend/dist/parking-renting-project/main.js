(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule, routingComponents */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "routingComponents", function() { return routingComponents; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _home_home_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./home/home.component */ "./src/app/home/home.component.ts");
/* harmony import */ var _find_parking_find_parking_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./find-parking/find-parking.component */ "./src/app/find-parking/find-parking.component.ts");
/* harmony import */ var _become_host_become_host_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./become-host/become-host.component */ "./src/app/become-host/become-host.component.ts");
/* harmony import */ var _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./not-found/not-found.component */ "./src/app/not-found/not-found.component.ts");







var routes = [
    { path: '', component: _home_home_component__WEBPACK_IMPORTED_MODULE_3__["HomeComponent"] },
    { path: 'find-parking', component: _find_parking_find_parking_component__WEBPACK_IMPORTED_MODULE_4__["FindParkingComponent"] },
    { path: 'become-host', component: _become_host_become_host_component__WEBPACK_IMPORTED_MODULE_5__["BecomeHostComponent"] },
    { path: '**', component: _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_6__["NotFoundComponent"] },
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());

var routingComponents = [_home_home_component__WEBPACK_IMPORTED_MODULE_3__["HomeComponent"], _find_parking_find_parking_component__WEBPACK_IMPORTED_MODULE_4__["FindParkingComponent"], _become_host_become_host_component__WEBPACK_IMPORTED_MODULE_5__["BecomeHostComponent"], _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_6__["NotFoundComponent"]];


/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-navbar></app-navbar>\n\n<router-outlet></router-outlet>\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'parking-renting-project';
    }
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_material_radio__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/material/radio */ "./node_modules/@angular/material/esm5/radio.es5.js");
/* harmony import */ var _angular_material_select__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/material/select */ "./node_modules/@angular/material/esm5/select.es5.js");
/* harmony import */ var _angular_material_table__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/material/table */ "./node_modules/@angular/material/esm5/table.es5.js");
/* harmony import */ var _angular_material_sort__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/material/sort */ "./node_modules/@angular/material/esm5/sort.es5.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var _agm_core__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @agm/core */ "./node_modules/@agm/core/index.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _navbar_navbar_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./navbar/navbar.component */ "./src/app/navbar/navbar.component.ts");
/* harmony import */ var _home_home_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./home/home.component */ "./src/app/home/home.component.ts");
/* harmony import */ var _become_host_become_host_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./become-host/become-host.component */ "./src/app/become-host/become-host.component.ts");
/* harmony import */ var _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./not-found/not-found.component */ "./src/app/not-found/not-found.component.ts");
/* harmony import */ var _sign_up_sign_up_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./sign-up/sign-up.component */ "./src/app/sign-up/sign-up.component.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _rent_spot_form_rent_spot_form_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./rent-spot-form/rent-spot-form.component */ "./src/app/rent-spot-form/rent-spot-form.component.ts");
/* harmony import */ var _web_service__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./web.service */ "./src/app/web.service.ts");
// external imports:













// local imports:










var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_3__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_14__["AppComponent"],
                _navbar_navbar_component__WEBPACK_IMPORTED_MODULE_15__["NavbarComponent"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_13__["routingComponents"],
                _home_home_component__WEBPACK_IMPORTED_MODULE_16__["HomeComponent"],
                _become_host_become_host_component__WEBPACK_IMPORTED_MODULE_17__["BecomeHostComponent"],
                _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_18__["NotFoundComponent"],
                _sign_up_sign_up_component__WEBPACK_IMPORTED_MODULE_19__["SignUpComponent"],
                _login_login_component__WEBPACK_IMPORTED_MODULE_20__["LoginComponent"],
                _rent_spot_form_rent_spot_form_component__WEBPACK_IMPORTED_MODULE_21__["RentSpotFormComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_2__["BrowserAnimationsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClientModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_5__["ReactiveFormsModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatDialogModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatFormFieldModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatInputModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatIconModule"],
                _angular_material_select__WEBPACK_IMPORTED_MODULE_8__["MatSelectModule"],
                _angular_material_radio__WEBPACK_IMPORTED_MODULE_7__["MatRadioModule"],
                _angular_material_table__WEBPACK_IMPORTED_MODULE_9__["MatTableModule"],
                _angular_material_sort__WEBPACK_IMPORTED_MODULE_10__["MatSortModule"],
                _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_11__["NgbModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_13__["AppRoutingModule"],
                _agm_core__WEBPACK_IMPORTED_MODULE_12__["AgmCoreModule"].forRoot({
                    apiKey: 'AIzaSyDQSACUeONioHKwbzWqEmL35YqRAbgnjeQ',
                    libraries: ['geometry']
                })
            ],
            exports: [
                _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatButtonModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatFormFieldModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatInputModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormsModule"]
            ],
            providers: [_web_service__WEBPACK_IMPORTED_MODULE_22__["WebService"]],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_14__["AppComponent"]],
            entryComponents: [_login_login_component__WEBPACK_IMPORTED_MODULE_20__["LoginComponent"], _sign_up_sign_up_component__WEBPACK_IMPORTED_MODULE_19__["SignUpComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/become-host/become-host.component.css":
/*!*******************************************************!*\
  !*** ./src/app/become-host/become-host.component.css ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2JlY29tZS1ob3N0L2JlY29tZS1ob3N0LmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/become-host/become-host.component.html":
/*!********************************************************!*\
  !*** ./src/app/become-host/become-host.component.html ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-rent-spot-form></app-rent-spot-form>\n"

/***/ }),

/***/ "./src/app/become-host/become-host.component.ts":
/*!******************************************************!*\
  !*** ./src/app/become-host/become-host.component.ts ***!
  \******************************************************/
/*! exports provided: BecomeHostComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BecomeHostComponent", function() { return BecomeHostComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var BecomeHostComponent = /** @class */ (function () {
    function BecomeHostComponent() {
    }
    BecomeHostComponent.prototype.ngOnInit = function () {
    };
    BecomeHostComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-become-host',
            template: __webpack_require__(/*! ./become-host.component.html */ "./src/app/become-host/become-host.component.html"),
            styles: [__webpack_require__(/*! ./become-host.component.css */ "./src/app/become-host/become-host.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], BecomeHostComponent);
    return BecomeHostComponent;
}());



/***/ }),

/***/ "./src/app/find-parking/find-parking.component.css":
/*!*********************************************************!*\
  !*** ./src/app/find-parking/find-parking.component.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "/** split page to 2 columns */\n\n.container {\n    margin-top: 10px;\n    margin-left: unset; \n  }\n\n.row:after {\n    content: \"\";\n    display: table;\n    clear: both;\n  \n  }\n\n.column-split {\n    float: left;\n    width: 50%;\n    padding-left: 15px;\n    padding-right: 15px;\n  }\n\n/** map */\n\nagm-map {\n    height: 600px;\n    width: 600px;\n  }\n\n.example-radio-group {\n    display: inline-flex;\n    flex-direction: column;\n  }\n\n.example-radio-button {\n    margin: 5px;\n  }\n\n.example-selected-value {\n    margin: 15px 0;\n  }\n\n/** table */\n\n.mat-table {\n    width: 550px;\n  }\n\n.mat-form-field{\n    width:400px;\n  }\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZmluZC1wYXJraW5nL2ZpbmQtcGFya2luZy5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLDhCQUE4Qjs7QUFFOUI7SUFDSSxpQkFBaUI7SUFDakIsbUJBQW1CO0dBQ3BCOztBQUVEO0lBQ0UsWUFBWTtJQUNaLGVBQWU7SUFDZixZQUFZOztHQUViOztBQUVEO0lBQ0UsWUFBWTtJQUNaLFdBQVc7SUFDWCxtQkFBbUI7SUFDbkIsb0JBQW9CO0dBQ3JCOztBQUdELFVBQVU7O0FBRVY7SUFDRSxjQUFjO0lBQ2QsYUFBYTtHQUNkOztBQUVEO0lBQ0UscUJBQXFCO0lBQ3JCLHVCQUF1QjtHQUN4Qjs7QUFFRDtJQUNFLFlBQVk7R0FDYjs7QUFFRDtJQUNFLGVBQWU7R0FDaEI7O0FBRUQsWUFBWTs7QUFFWjtJQUNFLGFBQWE7R0FDZDs7QUFFRDtJQUNFLFlBQVk7R0FDYiIsImZpbGUiOiJzcmMvYXBwL2ZpbmQtcGFya2luZy9maW5kLXBhcmtpbmcuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi8qKiBzcGxpdCBwYWdlIHRvIDIgY29sdW1ucyAqL1xuXG4uY29udGFpbmVyIHtcbiAgICBtYXJnaW4tdG9wOiAxMHB4O1xuICAgIG1hcmdpbi1sZWZ0OiB1bnNldDsgXG4gIH1cbiAgIFxuICAucm93OmFmdGVyIHtcbiAgICBjb250ZW50OiBcIlwiO1xuICAgIGRpc3BsYXk6IHRhYmxlO1xuICAgIGNsZWFyOiBib3RoO1xuICBcbiAgfVxuICBcbiAgLmNvbHVtbi1zcGxpdCB7XG4gICAgZmxvYXQ6IGxlZnQ7XG4gICAgd2lkdGg6IDUwJTtcbiAgICBwYWRkaW5nLWxlZnQ6IDE1cHg7XG4gICAgcGFkZGluZy1yaWdodDogMTVweDtcbiAgfVxuICBcbiAgXG4gIC8qKiBtYXAgKi9cbiAgXG4gIGFnbS1tYXAge1xuICAgIGhlaWdodDogNjAwcHg7XG4gICAgd2lkdGg6IDYwMHB4O1xuICB9XG5cbiAgLmV4YW1wbGUtcmFkaW8tZ3JvdXAge1xuICAgIGRpc3BsYXk6IGlubGluZS1mbGV4O1xuICAgIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XG4gIH1cbiAgXG4gIC5leGFtcGxlLXJhZGlvLWJ1dHRvbiB7XG4gICAgbWFyZ2luOiA1cHg7XG4gIH1cbiAgXG4gIC5leGFtcGxlLXNlbGVjdGVkLXZhbHVlIHtcbiAgICBtYXJnaW46IDE1cHggMDtcbiAgfVxuICBcbiAgLyoqIHRhYmxlICovXG4gIFxuICAubWF0LXRhYmxlIHtcbiAgICB3aWR0aDogNTUwcHg7XG4gIH1cblxuICAubWF0LWZvcm0tZmllbGR7XG4gICAgd2lkdGg6NDAwcHg7XG4gIH0iXX0= */"

/***/ }),

/***/ "./src/app/find-parking/find-parking.component.html":
/*!**********************************************************!*\
  !*** ./src/app/find-parking/find-parking.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n\n  <!-- Title -->\n  <h2>Find parking spot</h2>\n\n\n  <!-- split page to 2 columns: table on the left and map on the right -->\n  <div class=\"row\">\n\n    <!-- FEFT -------------------------------------------------------------------------------------->\n    <div class=\"column-split\" id=\"table\">\n\n      <!-- Form (left) ----------------------------------------------------------------------------->\n      <div class=\"container\" [formGroup]=\"filterForm\">\n\n        <div>\n          <mat-form-field class=\"form-field\">\n            <mat-label>Max distance from your location</mat-label>\n            <input matInput placeholder=\"max distance\" formControlName=\"maxDistance\">\n          </mat-form-field>\n        </div>\n\n        <div>\n          <mat-form-field class=\"form-field\">\n            <mat-label>Max price</mat-label>\n            <input matInput placeholder=\"max price\" formControlName=\"maxPrice\">\n          </mat-form-field>\n        </div>\n\n        <div>\n          <mat-form-field>\n            <mat-label>Choose how to determine your current location</mat-label>\n            <mat-select placeholder=\"location options\" formControlName=\"locationOption\" required>\n              <mat-option *ngFor=\"let option of locationOptions\" [value]=\"option\">\n                {{option}}\n              </mat-option>\n            </mat-select>\n          </mat-form-field>\n        </div>\n\n      </div>\n\n      <button type=\"button\" (click)=\"filter()\" [disabled]=\"!filterForm.valid\">Submit</button>\n      <button type=\"button\" (click)=\"reset()\">Reset (show all spot)</button>\n\n\n      <!-- Table (left) ---------------------------------------------------------------------------->\n      <table mat-table [dataSource]=\"dataSource\" class=\"mat-elevation-z8\" matSort >\n\n        <!-- ID Column -->\n        <ng-container matColumnDef=\"id\">\n          <th mat-header-cell *matHeaderCellDef mat-sort-header> ID </th>\n          <td mat-cell *matCellDef=\"let element\"> {{element.id}} </td>\n        </ng-container>\n\n        <!-- Latitude Column -->\n        <ng-container matColumnDef=\"lat\">\n          <th mat-header-cell *matHeaderCellDef> Latitude </th>\n          <td mat-cell *matCellDef=\"let element\"> {{element.lat}} </td>\n        </ng-container>\n\n        <!-- longitude Column -->\n        <ng-container matColumnDef=\"lng\">\n          <th mat-header-cell *matHeaderCellDef> longitude </th>\n          <td mat-cell *matCellDef=\"let element\"> {{element.lng}} </td>\n        </ng-container>\n\n        <!-- Distance Column -->\n        <ng-container matColumnDef=\"distance\">\n          <th mat-header-cell *matHeaderCellDef mat-sort-header> Distance </th>\n          <td mat-cell *matCellDef=\"let element\">  {{element.distance == -1 ? '---' : element.distance}} </td>\n        </ng-container>\n\n        <!-- Price Column -->\n        <ng-container matColumnDef=\"price\">\n          <th mat-header-cell *matHeaderCellDef mat-sort-header> Price </th>\n          <td mat-cell *matCellDef=\"let element\"> {{element.price}} </td>\n        </ng-container>\n\n        <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n        <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n      </table>\n\n    </div>\n\n    <!-- RIGHT ------------------------------------------------------------------------------------->\n    <div class=\"column-split\" id=\"map\">\n\n      <!-- The map (right) ------------------------------------------------------------------------->\n      <agm-map [zoom]='17' [latitude]=\"currlat\" [longitude]=\"currlng\">\n\n        <!-- Marker for current location -->\n        <agm-marker [latitude]=\"currlat\" [longitude]=\"currlng\" [iconUrl]=\"'../../assets/img/blue-dot.png'\">\n          <agm-info-window>Your current location</agm-info-window>\n        </agm-marker>\n\n        <!-- Markers for all avaiable spot -->\n        <agm-marker *ngFor=\"let spot of ELEMENT_DATA_FILTER; let i=index\" [latitude]=\"+spot.lat\" [longitude]=\"+spot.lng\"\n          [label]=\"spot.id.toString()\">\n          <agm-info-window>parking spot {{i}}</agm-info-window>\n        </agm-marker>\n\n\n      </agm-map>\n\n    </div>\n\n\n  </div>\n\n\n</div>"

/***/ }),

/***/ "./src/app/find-parking/find-parking.component.ts":
/*!********************************************************!*\
  !*** ./src/app/find-parking/find-parking.component.ts ***!
  \********************************************************/
/*! exports provided: FindParkingComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FindParkingComponent", function() { return FindParkingComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _agm_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @agm/core */ "./node_modules/@agm/core/index.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _web_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../web.service */ "./src/app/web.service.ts");

/// <reference types="@types/googlemaps" />





var FindParkingComponent = /** @class */ (function () {
    function FindParkingComponent(mapsAPILoader, fb, webService) {
        this.mapsAPILoader = mapsAPILoader;
        this.fb = fb;
        this.webService = webService;
        //--- INIT LOCATION ----------------------------------------------------------------------------------------
        // let the user to define his current location
        this.defineCurrLocOptions = ['GPS location', 'Technion']; // need to add "choose by address"
        this.selectedCurrLocOption = 'GPS location';
        // technion location (used if browser doesn't support GPS)
        this.thecnionlat = 32.776520;
        this.thecnionlng = 35.022610;
        //--- DATABASE ---------------------------------------------------------------------------------------------
        // fake DB TODO: updete this!!!
        this.displayedColumns = ['id', 'lat', 'lng', 'price', 'distance'];
        this.ELEMENT_DATA = null;
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
        this.ELEMENT_DATA_FILTER = null;
        this.dataSource = null;
        this.filterElement = {
            locationOption: 'GPS location',
            maxDistance: -1,
            maxPrice: -1,
        };
        this.locationOptions = ['GPS location', 'Technion']; // need to add "choose by address"
        // init filterForm (fields and validators):
        this.filterForm = fb.group({
            floatLabel: 'auto',
            'maxPrice': ["", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].pattern('[0-9]*')]],
            'maxDistance': ["", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].pattern('[0-9]*')]],
            'locationOption': ["", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]],
        });
    }
    FindParkingComponent.prototype.ngOnInit = function () {
        this.findCurrentLocation();
        var res = this.webService.getSpots();
        this.ELEMENT_DATA = JSON.parse('[' + res + ']');
        this.ELEMENT_DATA_FILTER = this.ELEMENT_DATA;
        this.dataSource = new _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatTableDataSource"](this.ELEMENT_DATA_FILTER);
        this.dataSource.sort = this.sort;
    };
    //--- UPDATE LOCATION --------------------------------------------------------------------------------------
    FindParkingComponent.prototype.findCurrentLocation = function () {
        var _this = this;
        if (this.selectedCurrLocOption == 'GPS location') {
            console.log("~~~~~~~~ findCurrentLocation: gps");
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function (position) {
                    _this.currlat = position.coords.latitude;
                    _this.currlng = position.coords.longitude;
                });
            }
            else { // unable to get current location, so use the Technion address instead
                alert("Geolocation is not supported by this browser.");
                this.changeCurrentLocationToTechnion();
            }
        }
        else if (this.selectedCurrLocOption == 'Technion') {
            this.changeCurrentLocationToTechnion();
        }
        else { // in case user define his address manially. for now use technion
            this.changeCurrentLocationToTechnion();
        }
    };
    FindParkingComponent.prototype.changeCurrentLocationToTechnion = function () {
        console.log("~~~~~~~~ changeCurrentLocationToTechnion");
        this.currlat = this.thecnionlat;
        this.currlng = this.thecnionlng;
    };
    FindParkingComponent.prototype.filter = function () {
        console.log("~~~~~~~~ filter");
        this.filterElement.locationOption = this.filterForm.value.locationOption;
        this.filterElement.maxDistance = (this.filterForm.value.maxDistance == "" || this.filterForm.value.maxDistance == null) ? -1 : this.filterForm.value.maxDistance;
        this.filterElement.maxPrice = (this.filterForm.value.maxPrice == "" || this.filterForm.value.maxPrice == null) ? -1 : this.filterForm.value.maxPrice;
        this.selectedCurrLocOption = this.filterForm.value.locationOption;
        this.findCurrentLocation();
        this.filterMarkers();
    };
    FindParkingComponent.prototype.reset = function () {
        this.filterForm.reset();
        this.filterElement.maxDistance = -1;
        this.filterElement.maxPrice = -1;
        this.filterMarkers();
    };
    FindParkingComponent.prototype.filterMarkers = function () {
        console.log("~~~~~~~~ filterMarkers");
        this.ELEMENT_DATA_FILTER = [];
        var centerLoc = new google.maps.LatLng(this.currlat, this.currlng);
        for (var _i = 0, _a = this.ELEMENT_DATA; _i < _a.length; _i++) {
            var spot = _a[_i];
            var markerLoc = new google.maps.LatLng(spot.lat, spot.lng);
            spot.distance = Math.round(google.maps.geometry.spherical.computeDistanceBetween(markerLoc, centerLoc));
            if (((spot.distance <= this.filterElement.maxDistance) || (this.filterElement.maxDistance == -1)) &&
                ((spot.price <= this.filterElement.maxPrice) || (this.filterElement.maxPrice == -1))) {
                this.ELEMENT_DATA_FILTER.push(spot);
            }
        }
        this.dataSource = new _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatTableDataSource"](this.ELEMENT_DATA_FILTER);
        this.dataSource.sort = this.sort;
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])(_angular_material__WEBPACK_IMPORTED_MODULE_4__["MatSort"]),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatSort"])
    ], FindParkingComponent.prototype, "sort", void 0);
    FindParkingComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-find-parking',
            template: __webpack_require__(/*! ./find-parking.component.html */ "./src/app/find-parking/find-parking.component.html"),
            styles: [__webpack_require__(/*! ./find-parking.component.css */ "./src/app/find-parking/find-parking.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_agm_core__WEBPACK_IMPORTED_MODULE_2__["MapsAPILoader"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormBuilder"], _web_service__WEBPACK_IMPORTED_MODULE_5__["WebService"]])
    ], FindParkingComponent);
    return FindParkingComponent;
}());



/***/ }),

/***/ "./src/app/home/home.component.css":
/*!*****************************************!*\
  !*** ./src/app/home/home.component.css ***!
  \*****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2hvbWUvaG9tZS5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/home/home.component.html":
/*!******************************************!*\
  !*** ./src/app/home/home.component.html ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  home works!\n</p>\n"

/***/ }),

/***/ "./src/app/home/home.component.ts":
/*!****************************************!*\
  !*** ./src/app/home/home.component.ts ***!
  \****************************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return HomeComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var HomeComponent = /** @class */ (function () {
    function HomeComponent() {
    }
    HomeComponent.prototype.ngOnInit = function () {
    };
    HomeComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-home',
            template: __webpack_require__(/*! ./home.component.html */ "./src/app/home/home.component.html"),
            styles: [__webpack_require__(/*! ./home.component.css */ "./src/app/home/home.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "./src/app/login/login.component.css":
/*!*******************************************!*\
  !*** ./src/app/login/login.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".mat-dialog-content {\n    display: flex;\n    flex-direction: column;\n}\n  \n.mat-dialog-content > * {\n    width: 100%;\n}\n  \n.btn-primary, .btn-secondary {\n  width:130px;\n  margin-left: 20px;\n  margin-right: 20px;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbG9naW4vbG9naW4uY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtJQUNJLGNBQWM7SUFDZCx1QkFBdUI7Q0FDMUI7O0FBRUQ7SUFDSSxZQUFZO0NBQ2Y7O0FBRUQ7RUFDRSxZQUFZO0VBQ1osa0JBQWtCO0VBQ2xCLG1CQUFtQjtDQUNwQiIsImZpbGUiOiJzcmMvYXBwL2xvZ2luL2xvZ2luLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIubWF0LWRpYWxvZy1jb250ZW50IHtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XG59XG4gIFxuLm1hdC1kaWFsb2ctY29udGVudCA+ICoge1xuICAgIHdpZHRoOiAxMDAlO1xufVxuXG4uYnRuLXByaW1hcnksIC5idG4tc2Vjb25kYXJ5IHtcbiAgd2lkdGg6MTMwcHg7XG4gIG1hcmdpbi1sZWZ0OiAyMHB4O1xuICBtYXJnaW4tcmlnaHQ6IDIwcHg7XG59Il19 */"

/***/ }),

/***/ "./src/app/login/login.component.html":
/*!********************************************!*\
  !*** ./src/app/login/login.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!-- Title -->\n<h2 style=\"text-align:center\" mat-dialog-title>Login</h2>\n<div *ngIf=\"username\"> Error: {{error}} </div>\n<!-- Content -->\n<div mat-dialog-content [formGroup]=\"loginForm\">\n\n  <!-- UserName -->\n  <mat-form-field>\n    <input matInput placeholder=\"email\" formControlName=\"email\" required>\n  </mat-form-field>\n\n  <!-- Password -->\n  <mat-form-field>\n    <input matInput placeholder=\"Password\" formControlName=\"password\" required [type]=\"hidePassword ? 'password' : 'text'\">\n    <mat-icon matSuffix (click)=\"hidePassword = !hidePassword\">{{hidePassword ? 'visibility_off' : 'visibility'}}</mat-icon>\n  </mat-form-field>\n\n</div>\n\n<!-- Bottons -->\n<div mat-dialog-actions align=\"center\">\n\n  <button type=\"button\" class=\"btn btn-primary\" (click)=\"login()\" [disabled]=\"!loginForm.valid\">Login</button>\n\n  <button type=\"button\" class=\"btn btn-secondary\" (click)=\"close()\">Close</button>\n\n  <p> <br>\n    Don’t have an account?\n    <button type=\"button\" class=\"btn btn-link\" (click)=\"signUp()\">Sign Up</button>\n  </p>\n\n</div>"

/***/ }),

/***/ "./src/app/login/login.component.ts":
/*!******************************************!*\
  !*** ./src/app/login/login.component.ts ***!
  \******************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _web_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../web.service */ "./src/app/web.service.ts");





var LoginComponent = /** @class */ (function () {
    function LoginComponent(webService, fb, dialogRef, data) {
        this.webService = webService;
        this.fb = fb;
        this.dialogRef = dialogRef;
        this.loginpModel = {
            email: 'Guest',
            password: '',
            closeOption: ''
        };
        this.hidePassword = true; /* hide password as default */
        this.logged = false;
        this.error = null;
        this.loginForm = fb.group({
            hideRequired: true,
            floatLabel: 'auto',
            'email': ["",
                [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].email]
            ],
            'password': ["",
                [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]]
        });
        /** get the input to dialog - empty for now. use: "var = data.fieldname;" */
    }
    LoginComponent.prototype.ngOnInit = function () { };
    LoginComponent.prototype.login = function () {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var res, result;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0:
                        this.loginpModel.email = this.loginForm.value.email;
                        this.loginpModel.password = this.loginForm.value.password;
                        this.loginpModel.closeOption = 'login';
                        console.log("The login form was submitted: " + JSON.stringify(this.loginpModel)); // TODO: delete!
                        return [4 /*yield*/, this.webService.PostLogIn(this.loginpModel)];
                    case 1:
                        res = _a.sent();
                        console.log(res);
                        if (res == 'wrong email or password') {
                            this.error = res;
                            return [2 /*return*/];
                        }
                        if (res['name']) {
                            this.error = null;
                            result = { closeOption: 'login', username: res['name'] };
                            this.dialogRef.close(result);
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    LoginComponent.prototype.close = function () {
        this.dialogRef.close();
        console.log("The login form closed"); // TODO: delete!
    };
    LoginComponent.prototype.signUp = function () {
        this.loginpModel.closeOption = 'signup';
        this.dialogRef.close(this.loginpModel);
        console.log("The login form was closed and then open sign up form"); // TODO: delete!
    };
    LoginComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-login',
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/login/login.component.html"),
            styles: [__webpack_require__(/*! ./login.component.css */ "./src/app/login/login.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__param"](3, Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_2__["MAT_DIALOG_DATA"])),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_web_service__WEBPACK_IMPORTED_MODULE_4__["WebService"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormBuilder"], _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogRef"], Object])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "./src/app/navbar/navbar.component.css":
/*!*********************************************!*\
  !*** ./src/app/navbar/navbar.component.css ***!
  \*********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".navbar {\n    width: 100%;\n    background-color: #555;\n    overflow: auto;\n}\n  \n/* Navbar links */\n  \n.navbar a {\n    float: left;\n    text-align: center;\n    color: white;\n}\n  \n/* Navbar links on mouse-over */\n  \n.navbar a:hover {\n    background-color: #000;\n}\n  \n/* Current/active navbar link */\n  \n.active {\n    font-weight:bold;\n}\n  \n.nav-item{\n    align-self: center;\n    padding: 8px\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbmF2YmFyL25hdmJhci5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksWUFBWTtJQUNaLHVCQUF1QjtJQUN2QixlQUFlO0NBQ2xCOztBQUVELGtCQUFrQjs7QUFDbEI7SUFDSSxZQUFZO0lBQ1osbUJBQW1CO0lBQ25CLGFBQWE7Q0FDaEI7O0FBRUQsZ0NBQWdDOztBQUNoQztJQUNJLHVCQUF1QjtDQUMxQjs7QUFFRCxnQ0FBZ0M7O0FBQ2hDO0lBQ0ksaUJBQWlCO0NBQ3BCOztBQUVEO0lBQ0ksbUJBQW1CO0lBQ25CLFlBQVk7Q0FDZiIsImZpbGUiOiJzcmMvYXBwL25hdmJhci9uYXZiYXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5uYXZiYXIge1xuICAgIHdpZHRoOiAxMDAlO1xuICAgIGJhY2tncm91bmQtY29sb3I6ICM1NTU7XG4gICAgb3ZlcmZsb3c6IGF1dG87XG59XG4gIFxuLyogTmF2YmFyIGxpbmtzICovXG4ubmF2YmFyIGEge1xuICAgIGZsb2F0OiBsZWZ0O1xuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcbiAgICBjb2xvcjogd2hpdGU7XG59XG4gIFxuLyogTmF2YmFyIGxpbmtzIG9uIG1vdXNlLW92ZXIgKi9cbi5uYXZiYXIgYTpob3ZlciB7XG4gICAgYmFja2dyb3VuZC1jb2xvcjogIzAwMDtcbn1cblxuLyogQ3VycmVudC9hY3RpdmUgbmF2YmFyIGxpbmsgKi9cbi5hY3RpdmUge1xuICAgIGZvbnQtd2VpZ2h0OmJvbGQ7XG59IFxuXG4ubmF2LWl0ZW17XG4gICAgYWxpZ24tc2VsZjogY2VudGVyO1xuICAgIHBhZGRpbmc6IDhweFxufSJdfQ== */"

/***/ }),

/***/ "./src/app/navbar/navbar.component.html":
/*!**********************************************!*\
  !*** ./src/app/navbar/navbar.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\n\n  <!-- Brand / Logo -->\n  <!-- TODO: update name + logo -->\n  <a class=\"navbar-brand\" routerLink=\"\" style=\"font-size:x-large\">\n    <img src=\"../../assets/img/parking-logo-white.png\" width=\"35\" height=\"35\" alt=\"logo\">\n    Parking Renting\n  </a>\n\n  <!-- Collapsing The Navigation Bar -->\n  <button class=\"navbar-toggler\" type=\"button\" (click)=\"toggleNavbar()\" data-target=\"#mainNavBar\">\n    <span class=\"navbar-toggler-icon\"></span>\n  </button>\n\n  <!-- The NavBar -->\n  <div class=\"collapse navbar-collapse show\" [ngClass]=\"{ 'show': navbarOpen }\" id=\"mainNavBar\">\n\n    <!-- Left: Find Parking, Become a Host -->\n    <ul class=\"navbar-nav mr-auto\">\n\n      <li class=\"nav-item\">\n        <a class=\"nav-link\" routerLink=\"\" routerLinkActive=\"active current\" [routerLinkActiveOptions]=\"{exact: true}\">\n          Home\n        </a>\n      </li>\n\n      <li class=\"nav-item\">\n        <a class=\"nav-link\" routerLink=\"/find-parking\" routerLinkActive=\"active current\">\n          Find Parking\n        </a>\n      </li>\n\n      <li class=\"nav-item\">\n        <a class=\"nav-link\" routerLink=\"/become-host\" routerLinkActive=\"active current\">\n          Become a Host\n        </a>\n      </li>\n\n    </ul>\n\n    <!-- Right: SignUp, Login -->\n    <ul class=\"nav navbar-nav navbar-right\">\n\n      <li class=\"nav-item\">\n        <a *ngIf=\"username\">\n          Welcome {{username}}\n        </a>\n      </li>\n\n      <li class=\"nav-item\" *ngIf=\"!userIsLogin\">\n        <button type=\"button\" class=\"btn btn-light\" (click)=\"openLoginDialog()\" style=\"width: 110px\">\n          <span class=\"fa fa-sign-in\"></span>\n          Login\n        </button>\n      </li>\n\n      <li class=\"nav-item\" *ngIf=\"userIsLogin\">\n        <button type=\"button\" class=\"btn btn-light\" (click)=\"logout()\" style=\"width: 110px\">\n          <span class=\"fa fa-sign-out\"></span>\n          Logout\n        </button>\n      </li>\n\n      <li class=\"nav-item\">\n        <button type=\"button\" class=\"btn btn-light\" (click)=\"openSignUpDialog()\" style=\"width: 110px\">\n          <span class=\"fa fa-user\"></span>\n          Sign Up\n        </button>\n      </li>\n\n    </ul>\n\n  </div>\n\n</nav>"

/***/ }),

/***/ "./src/app/navbar/navbar.component.ts":
/*!********************************************!*\
  !*** ./src/app/navbar/navbar.component.ts ***!
  \********************************************/
/*! exports provided: NavbarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NavbarComponent", function() { return NavbarComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _sign_up_sign_up_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../sign-up/sign-up.component */ "./src/app/sign-up/sign-up.component.ts");





var NavbarComponent = /** @class */ (function () {
    function NavbarComponent(loginDialog, signUpDialog) {
        this.loginDialog = loginDialog;
        this.signUpDialog = signUpDialog;
        this.navbarOpen = false;
        this.username = 'Guest';
        this.userIsLogin = false; // TODO: use service instead
    }
    NavbarComponent.prototype.toggleNavbar = function () {
        this.navbarOpen = !this.navbarOpen;
    };
    NavbarComponent.prototype.ngOnInit = function () {
    };
    NavbarComponent.prototype.openLoginDialog = function () {
        var _this = this;
        /** config dialog */
        var dialogConfig = new _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogConfig"]();
        dialogConfig.disableClose = true; /** the user will not be able to close the dialog just by clicking outside of it */
        dialogConfig.autoFocus = false; /** the focus will not be set automatically on the first form field of the dialog */
        dialogConfig.height = '350px'; /** size of dialog window */
        dialogConfig.width = '500px';
        dialogConfig.data = {}; /** pass data to dialog - empty for now */
        /** open dialog */
        var dialogRef = this.loginDialog.open(_login_login_component__WEBPACK_IMPORTED_MODULE_3__["LoginComponent"], dialogConfig);
        /** get data from dialog: only username for now */
        dialogRef.afterClosed().subscribe(function (result) {
            if (result != null) {
                if (result.closeOption == 'login') {
                    _this.username = result.username; // else: username is still 'Guest'
                    _this.userIsLogin = true;
                }
                else if (result.closeOption == 'signup') {
                    _this.openSignUpDialog();
                }
            }
        });
    };
    NavbarComponent.prototype.logout = function () {
        this.username = 'Guest';
        this.userIsLogin = false;
    };
    NavbarComponent.prototype.openSignUpDialog = function () {
        /** config dialog */
        var dialogConfig = new _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogConfig"]();
        dialogConfig.disableClose = true; /** the user will not be able to close the dialog just by clicking outside of it */
        dialogConfig.autoFocus = false; /** the focus will not be set automatically on the first form field of the dialog */
        dialogConfig.height = '500px'; /** size of dialog window */
        dialogConfig.width = '500px';
        dialogConfig.data = {}; /** pass data to dialog - empty for now */
        /** open dialog */
        var dialogRef = this.signUpDialog.open(_sign_up_sign_up_component__WEBPACK_IMPORTED_MODULE_4__["SignUpComponent"], dialogConfig);
        /** get data from dialog - empty for no */
        dialogRef.afterClosed().subscribe(function (result) { });
    };
    NavbarComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-navbar',
            template: __webpack_require__(/*! ./navbar.component.html */ "./src/app/navbar/navbar.component.html"),
            styles: [__webpack_require__(/*! ./navbar.component.css */ "./src/app/navbar/navbar.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialog"], _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialog"]])
    ], NavbarComponent);
    return NavbarComponent;
}());



/***/ }),

/***/ "./src/app/not-found/not-found.component.css":
/*!***************************************************!*\
  !*** ./src/app/not-found/not-found.component.css ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL25vdC1mb3VuZC9ub3QtZm91bmQuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/not-found/not-found.component.html":
/*!****************************************************!*\
  !*** ./src/app/not-found/not-found.component.html ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  not-found works!\n</p>\n"

/***/ }),

/***/ "./src/app/not-found/not-found.component.ts":
/*!**************************************************!*\
  !*** ./src/app/not-found/not-found.component.ts ***!
  \**************************************************/
/*! exports provided: NotFoundComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NotFoundComponent", function() { return NotFoundComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var NotFoundComponent = /** @class */ (function () {
    function NotFoundComponent() {
    }
    NotFoundComponent.prototype.ngOnInit = function () {
    };
    NotFoundComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-not-found',
            template: __webpack_require__(/*! ./not-found.component.html */ "./src/app/not-found/not-found.component.html"),
            styles: [__webpack_require__(/*! ./not-found.component.css */ "./src/app/not-found/not-found.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], NotFoundComponent);
    return NotFoundComponent;
}());



/***/ }),

/***/ "./src/app/rent-spot-form/rent-spot-form.component.css":
/*!*************************************************************!*\
  !*** ./src/app/rent-spot-form/rent-spot-form.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".container{\n    width: 800px; \n    margin-left: unset; \n    margin-top: 10px;\n}\n\n.mat-form {\n    display: flex;\n    flex-direction: column;\n    margin-top: 10px;\n    margin-bottom: 10px;\n}\n\n.btn-primary, .btn-secondary {\n    width:130px;\n    align-self: center;\n}\n\n.button {\n    display: inline-block;\n    margin-left: 20px;\n    margin-right: 20px;\n }\n\n.date-field {\n    width: 50px;\n}\n\n.row {\n    margin-bottom: 20px;\n}\n\n.col-sm-1, .col-sm-2, .col-sm-3, .col-sm-4 {\n    align-self: center;\n}\n\nmat-label {\n    font-size: larger;\n}\n\n.date-input-field {\n    width:130px; \n    text-align: center\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcmVudC1zcG90LWZvcm0vcmVudC1zcG90LWZvcm0uY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtJQUNJLGFBQWE7SUFDYixtQkFBbUI7SUFDbkIsaUJBQWlCO0NBQ3BCOztBQUVEO0lBQ0ksY0FBYztJQUNkLHVCQUF1QjtJQUN2QixpQkFBaUI7SUFDakIsb0JBQW9CO0NBQ3ZCOztBQUVEO0lBQ0ksWUFBWTtJQUNaLG1CQUFtQjtDQUN0Qjs7QUFFRDtJQUNJLHNCQUFzQjtJQUN0QixrQkFBa0I7SUFDbEIsbUJBQW1CO0VBQ3JCOztBQUVGO0lBQ0ksWUFBWTtDQUNmOztBQUVEO0lBQ0ksb0JBQW9CO0NBQ3ZCOztBQUVEO0lBQ0ksbUJBQW1CO0NBQ3RCOztBQUVEO0lBQ0ksa0JBQWtCO0NBQ3JCOztBQUVEO0lBQ0ksWUFBWTtJQUNaLGtCQUFrQjtDQUNyQiIsImZpbGUiOiJzcmMvYXBwL3JlbnQtc3BvdC1mb3JtL3JlbnQtc3BvdC1mb3JtLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuY29udGFpbmVye1xuICAgIHdpZHRoOiA4MDBweDsgXG4gICAgbWFyZ2luLWxlZnQ6IHVuc2V0OyBcbiAgICBtYXJnaW4tdG9wOiAxMHB4O1xufVxuXG4ubWF0LWZvcm0ge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgICBtYXJnaW4tdG9wOiAxMHB4O1xuICAgIG1hcmdpbi1ib3R0b206IDEwcHg7XG59XG5cbi5idG4tcHJpbWFyeSwgLmJ0bi1zZWNvbmRhcnkge1xuICAgIHdpZHRoOjEzMHB4O1xuICAgIGFsaWduLXNlbGY6IGNlbnRlcjtcbn1cblxuLmJ1dHRvbiB7XG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xuICAgIG1hcmdpbi1sZWZ0OiAyMHB4O1xuICAgIG1hcmdpbi1yaWdodDogMjBweDtcbiB9XG5cbi5kYXRlLWZpZWxkIHtcbiAgICB3aWR0aDogNTBweDtcbn1cblxuLnJvdyB7XG4gICAgbWFyZ2luLWJvdHRvbTogMjBweDtcbn1cblxuLmNvbC1zbS0xLCAuY29sLXNtLTIsIC5jb2wtc20tMywgLmNvbC1zbS00IHtcbiAgICBhbGlnbi1zZWxmOiBjZW50ZXI7XG59XG5cbm1hdC1sYWJlbCB7XG4gICAgZm9udC1zaXplOiBsYXJnZXI7XG59XG5cbi5kYXRlLWlucHV0LWZpZWxkIHtcbiAgICB3aWR0aDoxMzBweDsgXG4gICAgdGV4dC1hbGlnbjogY2VudGVyXG59Il19 */"

/***/ }),

/***/ "./src/app/rent-spot-form/rent-spot-form.component.html":
/*!**************************************************************!*\
  !*** ./src/app/rent-spot-form/rent-spot-form.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\" [formGroup]=\"rentSpotForm\">\n\n  <!-- Title -->\n  <h2>Rent your spot</h2>\n\n  <!-- Form -->\n  <div class=\"mat-form\">\n\n\n    <!-- Address: -->\n    <div class=\"row\" formGroupName=\"address\">\n\n      <!-- Label -->\n      <div class=\"col-sm-2\">\n        <mat-label>Address:</mat-label>\n      </div>\n\n      <!-- City -->\n      <div class=\"col-sm-3\">\n        <mat-form-field class=\"form-field\">\n          <input matInput placeholder=\"City\" formControlName=\"city\" required>\n          <mat-error *ngIf=\"rentSpotForm.get('address').controls['city'].hasError('pattern')\">\n            Please enter a valid city name: Letters only\n          </mat-error>\n        </mat-form-field>\n      </div>\n\n      <!-- Street -->\n      <div class=\"col-sm-3\">\n        <mat-form-field class=\"form-field\">\n          <input matInput placeholder=\"Street\" formControlName=\"street\" required>\n          <mat-error *ngIf=\"rentSpotForm.get('address').controls['street'].hasError('pattern')\">\n            Please enter a valid street name: Letters only\n          </mat-error>\n        </mat-form-field>\n      </div>\n\n      <!-- Parking spot number -->\n      <div class=\"col-sm-3\">\n        <mat-form-field class=\"form-field\">\n          <input matInput placeholder=\"Parking spot number\" formControlName=\"spot_num\">\n          <mat-error *ngIf=\"rentSpotForm.get('address').controls['spot_num'].hasError('pattern')\">\n            Please enter a valid parking spot number: Integer number only\n          </mat-error>\n        </mat-form-field>\n      </div>\n\n    </div>\n\n\n    <!-- Start time: -->\n    <div class=\"row\" formGroupName=\"start_time\">\n\n      <!-- Label -->\n      <div class=\"col-sm-2\">\n        <mat-label>Start time:</mat-label>\n      </div>\n\n      <!-- Date: -->\n      <div class=\"col-sm-3\">\n        <div class=\"input-group\">\n          <input formControlName=\"start_date\" placeholder=\"yyyy-mm-dd\" name=\"dpS\" ngbDatepicker #dS=\"ngbDatepicker\"\n            class=\"date-input-field\">\n          <div class=\"input-group-append\">\n            <button type=\"button\" class=\"btn btn-outline-secondary\" (click)=\"dS.toggle()\">\n              <span class=\"fa fa-calendar\"></span>\n            </button>\n          </div>\n        </div>\n      </div>\n\n      <!-- Hour: -->\n      <div class=\"col-sm-3\">\n        <ngb-timepicker formControlName=\"start_hour\" required></ngb-timepicker>\n      </div>\n\n    </div>\n\n\n    <!-- End time: -->\n    <div class=\"row\" formGroupName=\"end_time\">\n\n      <!-- Label -->\n      <div class=\"col-sm-2\">\n        <mat-label>End time:</mat-label>\n      </div>\n\n      <!-- Date: -->\n      <div class=\"col-sm-3\">\n        <div class=\"input-group\">\n          <input formControlName=\"end_date\" placeholder=\"yyyy-mm-dd\" name=\"dpE\" ngbDatepicker #dE=\"ngbDatepicker\"\n            [markDisabled]=\"isDisabled\" class=\"date-input-field\">\n          <div class=\"input-group-append\">\n            <button type=\"button\" class=\"btn btn-outline-secondary\" (click)=\"dE.toggle()\">\n              <span class=\"fa fa-calendar\"></span>\n            </button>\n          </div>\n        </div>\n      </div>\n\n      <!-- Hour: -->\n      <div class=\"col-sm-3\">\n        <ngb-timepicker formControlName=\"end_hour\" required></ngb-timepicker>\n      </div>\n\n    </div>\n\n\n    <!-- Price per hour: -->\n    <div class=\"row\">\n\n      <!-- Label -->\n      <div class=\"col-sm-2\">\n        <mat-label>Price:</mat-label>\n      </div>\n\n      <!-- Price -->\n      <div class=\"col-sm-3\">\n        <mat-form-field class=\"form-field\">\n          <input matInput placeholder=\"Price per hour\" formControlName=\"price\" required>\n          <mat-error *ngIf=\"rentSpotForm.controls['price'].hasError('pattern')\">\n            Please enter a valid price: float number only\n          </mat-error>\n        </mat-form-field>\n      </div>\n\n    </div>\n\n\n  </div>\n\n\n  <!-- Buttons -->\n  <div style=\"width:300px; align-self: center\">\n\n    <button type=\"button\" class=\"btn btn-primary\" (click)=\"addNewSpot()\" [disabled]=\"!rentSpotForm.valid\" style=\"float: left\">Submit</button>\n    <button type=\"button\" class=\"btn btn-secondary\" (click)=\"reset()\" style=\"float: right\">Reset</button>\n\n  </div>\n\n\n</div>"

/***/ }),

/***/ "./src/app/rent-spot-form/rent-spot-form.component.ts":
/*!************************************************************!*\
  !*** ./src/app/rent-spot-form/rent-spot-form.component.ts ***!
  \************************************************************/
/*! exports provided: RentSpotFormComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RentSpotFormComponent", function() { return RentSpotFormComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _rent_spot__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../rent-spot */ "./src/app/rent-spot.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _web_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../web.service */ "./src/app/web.service.ts");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");






var RentSpotFormComponent = /** @class */ (function () {
    function RentSpotFormComponent(fb, datepickerConfig, webService) {
        this.fb = fb;
        this.webService = webService;
        this.rentSpotModel = new _rent_spot__WEBPACK_IMPORTED_MODULE_2__["RentSpotModel"]('', '', null, null, 0);
        // configuration of NgbDatepickerConfig (used for disable dates before today):
        var currentDate = new Date();
        datepickerConfig.minDate = { year: currentDate.getFullYear(), month: currentDate.getMonth() + 1, day: currentDate.getDate() };
        datepickerConfig.outsideDays = 'hidden';
        // init rentSpotForm (fields and validators):
        this.rentSpotForm = fb.group({
            floatLabel: 'auto',
            'address': this.fb.group({
                'city': ["", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].pattern('[a-zA-Z ]*')]],
                'street': ["", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].pattern('[a-zA-Z ]*')]],
                'spot_num': ["", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].pattern('[0-9]*')]],
            }),
            'start_time': this.fb.group({
                'start_date': ["", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]],
                'start_hour': ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]],
            }),
            'end_time': this.fb.group({
                'end_date': ["", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]],
                'end_hour': ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]],
            }),
            'price': ["", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].pattern('[0-9]+((.)[0-9]+)?')]],
        });
    }
    RentSpotFormComponent.prototype.ngOnInit = function () { };
    RentSpotFormComponent.prototype.addNewSpot = function () {
        this.rentSpotModel.city = this.rentSpotForm.value.address.city;
        this.rentSpotModel.street = this.rentSpotForm.value.address.street;
        this.rentSpotModel.spot_num = this.rentSpotForm.value.address.spot_num;
        var startTime = new Date(this.rentSpotForm.value.start_time.start_date.year, this.rentSpotForm.value.start_time.start_date.month - 1, this.rentSpotForm.value.start_time.start_date.day, this.rentSpotForm.value.start_time.start_hour.hour, this.rentSpotForm.value.start_time.start_hour.minute);
        this.rentSpotModel.start_time = startTime;
        var endTime = new Date(this.rentSpotForm.value.end_time.end_date.year, this.rentSpotForm.value.end_time.end_date.month - 1, this.rentSpotForm.value.end_time.end_date.day, this.rentSpotForm.value.end_time.end_hour.hour, this.rentSpotForm.value.end_time.end_hour.minute);
        this.rentSpotModel.end_time = endTime;
        this.rentSpotModel.price = this.rentSpotForm.value.price;
        this.reset();
        console.log("The rent spot form was submitted: " + JSON.stringify(this.rentSpotModel)); // TODO: delete!
        this.webService.addSpot(JSON.stringify(this.rentSpotModel));
        // for tests:
        // var sd = startTime;
        // console.log("sd: ", sd)
        // console.log("time: " + " yyyy=" + sd.getFullYear() + " mm=" + sd.getMonth() + " dd=" + sd.getDate() + " h=" + sd.getHours() + " m=" + sd.getMinutes())
    };
    RentSpotFormComponent.prototype.reset = function () {
        this.rentSpotForm.reset();
    };
    RentSpotFormComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-rent-spot-form',
            template: __webpack_require__(/*! ./rent-spot-form.component.html */ "./src/app/rent-spot-form/rent-spot-form.component.html"),
            styles: [__webpack_require__(/*! ./rent-spot-form.component.css */ "./src/app/rent-spot-form/rent-spot-form.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormBuilder"], _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_5__["NgbDatepickerConfig"], _web_service__WEBPACK_IMPORTED_MODULE_4__["WebService"]])
    ], RentSpotFormComponent);
    return RentSpotFormComponent;
}());



/***/ }),

/***/ "./src/app/rent-spot.ts":
/*!******************************!*\
  !*** ./src/app/rent-spot.ts ***!
  \******************************/
/*! exports provided: RentSpotModel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RentSpotModel", function() { return RentSpotModel; });
var RentSpotModel = /** @class */ (function () {
    function RentSpotModel(city, street, start_time, end_time, price, spot_num) {
        this.city = city;
        this.street = street;
        this.start_time = start_time;
        this.end_time = end_time;
        this.price = price;
        this.spot_num = spot_num;
    }
    return RentSpotModel;
}());



/***/ }),

/***/ "./src/app/sign-up/sign-up.component.css":
/*!***********************************************!*\
  !*** ./src/app/sign-up/sign-up.component.css ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".mat-dialog-content {\n    display: flex;\n    flex-direction: column;\n}\n  \n.mat-dialog-content > * {\n    width: 100%;\n}\n  \n.btn-primary, .btn-secondary {\n  width:130px;\n  margin-left: 20px;\n  margin-right: 20px;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvc2lnbi11cC9zaWduLXVwLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxjQUFjO0lBQ2QsdUJBQXVCO0NBQzFCOztBQUVEO0lBQ0ksWUFBWTtDQUNmOztBQUVEO0VBQ0UsWUFBWTtFQUNaLGtCQUFrQjtFQUNsQixtQkFBbUI7Q0FDcEIiLCJmaWxlIjoic3JjL2FwcC9zaWduLXVwL3NpZ24tdXAuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5tYXQtZGlhbG9nLWNvbnRlbnQge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbn1cbiAgXG4ubWF0LWRpYWxvZy1jb250ZW50ID4gKiB7XG4gICAgd2lkdGg6IDEwMCU7XG59XG5cbi5idG4tcHJpbWFyeSwgLmJ0bi1zZWNvbmRhcnkge1xuICB3aWR0aDoxMzBweDtcbiAgbWFyZ2luLWxlZnQ6IDIwcHg7XG4gIG1hcmdpbi1yaWdodDogMjBweDtcbn0iXX0= */"

/***/ }),

/***/ "./src/app/sign-up/sign-up.component.html":
/*!************************************************!*\
  !*** ./src/app/sign-up/sign-up.component.html ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!-- Title -->\n<h2 style=\"text-align:center\" mat-dialog-title>Sign Up</h2>\n\n<!-- Content -->\n<div mat-dialog-content [formGroup]=\"signUpForm\">\n\n  <!-- First Nmae -->\n  <mat-form-field>\n    <input matInput placeholder=\"First name\" formControlName=\"fname\" required>\n  </mat-form-field>\n\n  <!-- Last Nmae -->\n  <mat-form-field>\n    <input matInput placeholder=\"Last name\" formControlName=\"lname\" required>\n  </mat-form-field>\n\n  <!-- UserName -->\n  <mat-form-field>\n    <input matInput placeholder=\"Username\" formControlName=\"username\" required>\n  </mat-form-field>\n\n  <!-- Password -->\n  <mat-form-field hintLabel=\"{{passwordHintMessage}}\">\n    <input matInput placeholder=\"Password\" formControlName=\"password\" required [type]=\"hidePassword ? 'password' : 'text'\">\n    <mat-icon matSuffix (click)=\"hidePassword = !hidePassword\">{{hidePassword ? 'visibility_off' : 'visibility'}}</mat-icon>\n    <mat-error *ngIf=\"signUpForm.controls['password'].hasError('pattern')\">\n      Please enter a valid password: {{passwordHintMessage}}\n    </mat-error>\n  </mat-form-field>\n\n  <!-- Emaiil -->\n  <mat-form-field style=\"margin-top: 30px\">\n    <input matInput placeholder=\"Email address\" formControlName=\"email\" required>\n    <mat-error *ngIf=\"signUpForm.controls['email'].hasError('email')\">\n      Please enter a valid email address\n    </mat-error>\n  </mat-form-field>\n\n</div>\n\n<!-- Bottons -->\n<div mat-dialog-actions align=\"center\">\n\n  <button type=\"button\" class=\"btn btn-primary\" (click)=\"signUp()\" [disabled]=\"!signUpForm.valid\">Sign Up</button>\n  <button type=\"button\" class=\"btn btn-secondary\" (click)=\"close()\">Close</button>\n\n</div>"

/***/ }),

/***/ "./src/app/sign-up/sign-up.component.ts":
/*!**********************************************!*\
  !*** ./src/app/sign-up/sign-up.component.ts ***!
  \**********************************************/
/*! exports provided: SignUpComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SignUpComponent", function() { return SignUpComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _web_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../web.service */ "./src/app/web.service.ts");





var SignUpComponent = /** @class */ (function () {
    function SignUpComponent(webService, fb, dialogRef, data) {
        this.webService = webService;
        this.fb = fb;
        this.dialogRef = dialogRef;
        this.signUpModel = {
            name: '',
            username: '',
            password: '',
            email: '',
        };
        this.hidePassword = true; /* hide password as default */
        this.passwordHintMessage = "Use at least 8 characters, include at least one digit, one uppercase letter and one lowercase letter";
        this.signUpForm = fb.group({
            hideRequired: true,
            floatLabel: 'auto',
            'fname': ["",
                [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]
            ],
            'lname': ["",
                [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]
            ],
            'username': ["",
                [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]
            ],
            'password': ["",
                [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required,
                    _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].pattern('(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}')]
            ],
            'email': ["",
                [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required,
                    _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].email]
            ]
        });
        /** get the input to dialog - empty for now. use: "var = data.fieldname;" */
    }
    SignUpComponent.prototype.ngOnInit = function () { };
    SignUpComponent.prototype.signUp = function () {
        this.signUpModel.name = this.signUpForm.value.fname + " " + this.signUpForm.value.lname;
        this.signUpModel.username = this.signUpForm.value.username;
        this.signUpModel.password = this.signUpForm.value.password;
        this.signUpModel.email = this.signUpForm.value.email;
        this.dialogRef.close(this.signUpModel);
        console.log("The sign up form was submitted: " + JSON.stringify(this.signUpModel)); // TODO: delete!
        this.webService.PostSignUp(this.signUpModel);
    };
    SignUpComponent.prototype.close = function () {
        this.dialogRef.close();
        console.log("The sign up form closed"); // TODO: delete!
    };
    SignUpComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-sign-up',
            template: __webpack_require__(/*! ./sign-up.component.html */ "./src/app/sign-up/sign-up.component.html"),
            styles: [__webpack_require__(/*! ./sign-up.component.css */ "./src/app/sign-up/sign-up.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__param"](3, Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_2__["MAT_DIALOG_DATA"])),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_web_service__WEBPACK_IMPORTED_MODULE_4__["WebService"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormBuilder"], _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogRef"], Object])
    ], SignUpComponent);
    return SignUpComponent;
}());



/***/ }),

/***/ "./src/app/web.service.ts":
/*!********************************!*\
  !*** ./src/app/web.service.ts ***!
  \********************************/
/*! exports provided: WebService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WebService", function() { return WebService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");



var httpOptions = {
    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpHeaders"]({
        'Access-Control-Allow-Origin': 'http://localhost:8080'
    }),
};
var WebService = /** @class */ (function () {
    function WebService(http) {
        this.http = http;
        this.BASE_URL = 'http://localhost:8080';
        this.ADD_SPOT_URL = '/logged/add/renting_spot';
        this.SIGNUP_URL = 'https://team6a.auth0.com/dbconnections/signup';
        this.LOGIN_URL = '/login';
        this.LOGOUT = '/logged/logout';
        this.GET_SPOT_URL = '/logged/search/all/renting_spots';
        this.GET_SPOT_BY_LOCATION_URL = '/logged/search/some/renting_spots';
        this.client_id = 'BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva';
        this.id_token = null;
        this.access_token = null;
    }
    WebService.prototype.addSpot = function (rent) {
        this.http.post(this.BASE_URL + this.ADD_SPOT_URL, rent).subscribe(function (res) {
            console.log(JSON.stringify(res));
            alert("successfully add a new spot");
        }, function (err) {
            alert("an error occurred. please try again");
        });
    };
    WebService.prototype.PostSignUp = function (form) {
        var signUpHeades = {
            headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpHeaders"]({ 'content-type': 'application/json' }),
        };
        var body = {
            client_id: this.client_id,
            email: form.email,
            password: form.password,
            connection: 'Username-Password-Authentication',
            user_metadata: { name: form.name, username: form.username },
            json: true,
        };
        console.log(body);
        this.http.post(this.SIGNUP_URL, body, signUpHeades).subscribe(function (res) {
            console.log(res); //TODO: delete
        });
    };
    WebService.prototype.PostLogIn = function (user) {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var body, x, error_1;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0:
                        body = {
                            username: user.email,
                            password: user.password
                        };
                        console.log(JSON.stringify(body));
                        console.log(this.BASE_URL + this.LOGIN_URL);
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, 3, , 4]);
                        return [4 /*yield*/, this.http.post(this.BASE_URL + this.LOGIN_URL, body).toPromise()];
                    case 2:
                        x = _a.sent();
                        this.id_token = x['idToken'];
                        this.access_token = x['accessToken'];
                        return [2 /*return*/, x];
                    case 3:
                        error_1 = _a.sent();
                        return [2 /*return*/, 'wrong email or password'];
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    WebService.prototype.getSpots = function () {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var body, res, error_2;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0:
                        body = {
                            accessToken: this.access_token,
                            idToken: this.id_token
                        };
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, 3, , 4]);
                        return [4 /*yield*/, this.http.post(this.BASE_URL + this.GET_SPOT_URL, body).toPromise()];
                    case 2:
                        res = _a.sent();
                        return [2 /*return*/, JSON.stringify(res)];
                    case 3:
                        error_2 = _a.sent();
                        return [2 /*return*/, 'logged out'];
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    WebService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]])
    ], WebService);
    return WebService;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /home/eyal/Documents/school/semester_6/yearly_project/project11/team6/frontend/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map