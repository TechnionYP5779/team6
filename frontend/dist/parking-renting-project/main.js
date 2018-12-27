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

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAvYXBwLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-navbar></app-navbar>\r\n\r\n<router-outlet></router-outlet>\r\n"

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
/* harmony import */ var _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/material/progress-spinner */ "./node_modules/@angular/material/esm5/progress-spinner.es5.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var _agm_core__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @agm/core */ "./node_modules/@agm/core/index.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _navbar_navbar_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./navbar/navbar.component */ "./src/app/navbar/navbar.component.ts");
/* harmony import */ var _home_home_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./home/home.component */ "./src/app/home/home.component.ts");
/* harmony import */ var _become_host_become_host_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./become-host/become-host.component */ "./src/app/become-host/become-host.component.ts");
/* harmony import */ var _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./not-found/not-found.component */ "./src/app/not-found/not-found.component.ts");
/* harmony import */ var _sign_up_sign_up_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./sign-up/sign-up.component */ "./src/app/sign-up/sign-up.component.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _rent_spot_form_rent_spot_form_component__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./rent-spot-form/rent-spot-form.component */ "./src/app/rent-spot-form/rent-spot-form.component.ts");
/* harmony import */ var _web_service__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ./web.service */ "./src/app/web.service.ts");
/* harmony import */ var _rent_spot_dialog_rent_spot_dialog_component__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! ./rent-spot-dialog/rent-spot-dialog.component */ "./src/app/rent-spot-dialog/rent-spot-dialog.component.ts");
// external imports:














// local imports:











var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_3__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_15__["AppComponent"],
                _navbar_navbar_component__WEBPACK_IMPORTED_MODULE_16__["NavbarComponent"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_14__["routingComponents"],
                _home_home_component__WEBPACK_IMPORTED_MODULE_17__["HomeComponent"],
                _become_host_become_host_component__WEBPACK_IMPORTED_MODULE_18__["BecomeHostComponent"],
                _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_19__["NotFoundComponent"],
                _sign_up_sign_up_component__WEBPACK_IMPORTED_MODULE_20__["SignUpComponent"],
                _login_login_component__WEBPACK_IMPORTED_MODULE_21__["LoginComponent"],
                _rent_spot_form_rent_spot_form_component__WEBPACK_IMPORTED_MODULE_22__["RentSpotFormComponent"],
                _rent_spot_dialog_rent_spot_dialog_component__WEBPACK_IMPORTED_MODULE_24__["RentSpotDialogComponent"]
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
                _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_11__["MatProgressSpinnerModule"],
                _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_12__["NgbModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_14__["AppRoutingModule"],
                _agm_core__WEBPACK_IMPORTED_MODULE_13__["AgmCoreModule"].forRoot({
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
            providers: [_web_service__WEBPACK_IMPORTED_MODULE_23__["WebService"]],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_15__["AppComponent"]],
            entryComponents: [_login_login_component__WEBPACK_IMPORTED_MODULE_21__["LoginComponent"], _sign_up_sign_up_component__WEBPACK_IMPORTED_MODULE_20__["SignUpComponent"], _rent_spot_dialog_rent_spot_dialog_component__WEBPACK_IMPORTED_MODULE_24__["RentSpotDialogComponent"]]
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

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAvYmVjb21lLWhvc3QvYmVjb21lLWhvc3QuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/become-host/become-host.component.html":
/*!********************************************************!*\
  !*** ./src/app/become-host/become-host.component.html ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-rent-spot-form></app-rent-spot-form>\r\n"

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

module.exports = "/** split page to 2 columns */\r\n\r\n.container {\r\n    margin-top: 10px;\r\n    margin-left: unset; \r\n  }\r\n\r\n.row:after {\r\n    content: \"\";\r\n    display: table;\r\n    clear: both;\r\n  \r\n  }\r\n\r\n.column-split {\r\n    float: left;\r\n    width: 50%;\r\n    padding-left: 15px;\r\n    padding-right: 15px;\r\n  }\r\n\r\n/** map */\r\n\r\nagm-map {\r\n    height: 600px;\r\n    width: 600px;\r\n  }\r\n\r\n.example-radio-group {\r\n    display: inline-flex;\r\n    flex-direction: column;\r\n  }\r\n\r\n.example-radio-button {\r\n    margin: 5px;\r\n  }\r\n\r\n.example-selected-value {\r\n    margin: 15px 0;\r\n  }\r\n\r\n/** table */\r\n\r\n.mat-table {\r\n    width: 550px;\r\n  }\r\n\r\n.mat-form-field{\r\n    width:400px;\r\n  }\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9maW5kLXBhcmtpbmcvZmluZC1wYXJraW5nLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsOEJBQThCOztBQUU5QjtJQUNJLGlCQUFpQjtJQUNqQixtQkFBbUI7R0FDcEI7O0FBRUQ7SUFDRSxZQUFZO0lBQ1osZUFBZTtJQUNmLFlBQVk7O0dBRWI7O0FBRUQ7SUFDRSxZQUFZO0lBQ1osV0FBVztJQUNYLG1CQUFtQjtJQUNuQixvQkFBb0I7R0FDckI7O0FBR0QsVUFBVTs7QUFFVjtJQUNFLGNBQWM7SUFDZCxhQUFhO0dBQ2Q7O0FBRUQ7SUFDRSxxQkFBcUI7SUFDckIsdUJBQXVCO0dBQ3hCOztBQUVEO0lBQ0UsWUFBWTtHQUNiOztBQUVEO0lBQ0UsZUFBZTtHQUNoQjs7QUFFRCxZQUFZOztBQUVaO0lBQ0UsYUFBYTtHQUNkOztBQUVEO0lBQ0UsWUFBWTtHQUNiIiwiZmlsZSI6ImFwcC9maW5kLXBhcmtpbmcvZmluZC1wYXJraW5nLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiogc3BsaXQgcGFnZSB0byAyIGNvbHVtbnMgKi9cclxuXHJcbi5jb250YWluZXIge1xyXG4gICAgbWFyZ2luLXRvcDogMTBweDtcclxuICAgIG1hcmdpbi1sZWZ0OiB1bnNldDsgXHJcbiAgfVxyXG4gICBcclxuICAucm93OmFmdGVyIHtcclxuICAgIGNvbnRlbnQ6IFwiXCI7XHJcbiAgICBkaXNwbGF5OiB0YWJsZTtcclxuICAgIGNsZWFyOiBib3RoO1xyXG4gIFxyXG4gIH1cclxuICBcclxuICAuY29sdW1uLXNwbGl0IHtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgd2lkdGg6IDUwJTtcclxuICAgIHBhZGRpbmctbGVmdDogMTVweDtcclxuICAgIHBhZGRpbmctcmlnaHQ6IDE1cHg7XHJcbiAgfVxyXG4gIFxyXG4gIFxyXG4gIC8qKiBtYXAgKi9cclxuICBcclxuICBhZ20tbWFwIHtcclxuICAgIGhlaWdodDogNjAwcHg7XHJcbiAgICB3aWR0aDogNjAwcHg7XHJcbiAgfVxyXG5cclxuICAuZXhhbXBsZS1yYWRpby1ncm91cCB7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtZmxleDtcclxuICAgIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XHJcbiAgfVxyXG4gIFxyXG4gIC5leGFtcGxlLXJhZGlvLWJ1dHRvbiB7XHJcbiAgICBtYXJnaW46IDVweDtcclxuICB9XHJcbiAgXHJcbiAgLmV4YW1wbGUtc2VsZWN0ZWQtdmFsdWUge1xyXG4gICAgbWFyZ2luOiAxNXB4IDA7XHJcbiAgfVxyXG4gIFxyXG4gIC8qKiB0YWJsZSAqL1xyXG4gIFxyXG4gIC5tYXQtdGFibGUge1xyXG4gICAgd2lkdGg6IDU1MHB4O1xyXG4gIH1cclxuXHJcbiAgLm1hdC1mb3JtLWZpZWxke1xyXG4gICAgd2lkdGg6NDAwcHg7XHJcbiAgfSJdfQ== */"

/***/ }),

/***/ "./src/app/find-parking/find-parking.component.html":
/*!**********************************************************!*\
  !*** ./src/app/find-parking/find-parking.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div style=\"width:40%; margin:5% auto;\" *ngIf=\"loading\">\r\n  <mat-progress-spinner mode=\"indeterminate\" value=\"indeterminate\" diameter=\"220\" strokeWidth=\"35\" style=\"width:15%; margin:0 auto;\">\r\n  </mat-progress-spinner>\r\n  <div>\r\n    <img src=\"../../assets/img/get_spot_wait_line1.png\" style=\"width:130%; margin-left:-10%; margin-top:20%;\" align=\"middle\">\r\n  </div>\r\n  <div>\r\n    <img src=\"../../assets/img/get_spot_wait_line2.png\" style=\"width:22%; margin-left:40% ;\" >\r\n  </div>\r\n  \r\n</div> \r\n\r\n<div class=\"container\" *ngIf=\"!loading\">\r\n  <!-- Title -->\r\n  <h2>Find parking spot</h2> \r\n  <!-- split page to 2 columns: table on the left and map on the right -->\r\n  <div class=\"row\">\r\n\r\n    <!-- FEFT -------------------------------------------------------------------------------------->\r\n    <div class=\"column-split\" id=\"table\">\r\n\r\n      <!-- Form (left) ----------------------------------------------------------------------------->\r\n      <div class=\"container\" [formGroup]=\"filterForm\">\r\n\r\n        <div>\r\n          <mat-form-field class=\"form-field\">\r\n            <mat-label>Max distance from your location</mat-label>\r\n            <input matInput placeholder=\"max distance\" formControlName=\"maxDistance\">\r\n          </mat-form-field>\r\n        </div>\r\n\r\n        <div>\r\n          <mat-form-field class=\"form-field\">\r\n            <mat-label>Max price</mat-label>\r\n            <input matInput placeholder=\"max price\" formControlName=\"maxPrice\">\r\n          </mat-form-field>\r\n        </div>\r\n\r\n        <div>\r\n          <mat-form-field>\r\n            <mat-label>Choose how to determine your current location</mat-label>\r\n            <mat-select placeholder=\"location options\" formControlName=\"locationOption\" required>\r\n              <mat-option *ngFor=\"let option of locationOptions\" [value]=\"option\">\r\n                {{option}}\r\n              </mat-option>\r\n            </mat-select>\r\n          </mat-form-field>\r\n        </div>\r\n\r\n      </div>\r\n\r\n      <button type=\"button\" (click)=\"filter()\" [disabled]=\"!filterForm.valid\">Submit</button>\r\n      <button type=\"button\" (click)=\"reset()\">Reset (show all spot)</button>\r\n\r\n\r\n      <!-- Table (left) ---------------------------------------------------------------------------->\r\n      <table mat-table [dataSource]=\"dataSource\" class=\"mat-elevation-z8\" matSort>\r\n\r\n        <!-- ID Column -->\r\n        <ng-container matColumnDef=\"id\">\r\n          <th mat-header-cell *matHeaderCellDef mat-sort-header> ID </th>\r\n          <td mat-cell *matCellDef=\"let element\"> {{element.id}} </td>\r\n        </ng-container>\r\n\r\n        <!-- Addres Column -->\r\n        <ng-container matColumnDef=\"address\">\r\n          <th mat-header-cell *matHeaderCellDef> Address </th>\r\n          <td mat-cell *matCellDef=\"let element\"> {{element.city}} {{element.street}} {{element.building}} </td>\r\n        </ng-container>\r\n\r\n<!--          Distance Column \r\n        <ng-container matColumnDef=\"distance\">\r\n          <th mat-header-cell *matHeaderCellDef mat-sort-header> Distance </th>\r\n          <td mat-cell *matCellDef=\"let element\"> {{element.distance == -1 ? '---' : element.distance}} </td>\r\n        </ng-container> -->\r\n\r\n        <!-- Price Column -->\r\n        <ng-container matColumnDef=\"price\">\r\n          <th mat-header-cell *matHeaderCellDef mat-sort-header> Price </th>\r\n          <td mat-cell *matCellDef=\"let element\"> {{element.price}} </td>\r\n        </ng-container>\r\n\r\n        <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n        <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\r\n      </table>\r\n\r\n    </div>\r\n\r\n    <!-- RIGHT ------------------------------------------------------------------------------------->\r\n    <div class=\"column-split\" id=\"map\">\r\n\r\n      <!-- The map (right) ------------------------------------------------------------------------->\r\n      <agm-map [zoom]='17' [latitude]=\"currlat\" [longitude]=\"currlng\">\r\n\r\n        <!-- Marker for current location -->\r\n        <agm-marker [latitude]=\"currlat\" [longitude]=\"currlng\" [iconUrl]=\"'../../assets/img/blue-dot.png'\">\r\n          <agm-info-window>Your current location</agm-info-window>\r\n        </agm-marker>\r\n\r\n        <!-- Markers for all avaiable spot -->\r\n        <agm-marker *ngFor=\"let spot of ELEMENT_DATA_FILTER; let i=index\" [latitude]=\"+spot.latitude\" [longitude]=\"+spot.longitude\"\r\n          [label]=\"spot.id.toString()\">\r\n          <agm-info-window>\r\n            ID: {{spot.id}}\r\n            <br>\r\n            price: {{spot.price}}\r\n            <br>\r\n            distance: {{spot.distance}}\r\n            <br>\r\n            <button type=\"button\" (click)=\"rentSpot(spot)\">Rent Me!</button>\r\n\r\n          </agm-info-window>\r\n        </agm-marker>\r\n\r\n\r\n      </agm-map>\r\n\r\n    </div>\r\n\r\n\r\n  </div>\r\n\r\n \r\n</div>"

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
/* harmony import */ var _rent_spot_dialog_rent_spot_dialog_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../rent-spot-dialog/rent-spot-dialog.component */ "./src/app/rent-spot-dialog/rent-spot-dialog.component.ts");

/// <reference types="@types/googlemaps" />







var FindParkingComponent = /** @class */ (function () {
    function FindParkingComponent(mapsAPILoader, fb, webService, rentDialog) {
        this.mapsAPILoader = mapsAPILoader;
        this.fb = fb;
        this.webService = webService;
        this.rentDialog = rentDialog;
        //--- INIT LOCATION ----------------------------------------------------------------------------------------
        // let the user to define his current location
        this.defineCurrLocOptions = ['GPS location', 'Technion']; // need to add "choose by address"
        this.selectedCurrLocOption = 'GPS location';
        this.loading = true;
        // technion location (used if browser doesn't support GPS)
        this.thecnionlat = 32.776520;
        this.thecnionlng = 35.022610;
        //--- DATABASE ---------------------------------------------------------------------------------------------
        // fake DB TODO: updete this!!!
        this.displayedColumns = ['id', 'address', 'price'];
        this.ELEMENT_DATA = null;
        this.ELEMENT_DATA_FILTER = null;
        this.dataSource = null;
        this.filterElement = {
            locationOption: 'GPS location',
            maxDistance: -1,
            maxPrice: -1,
        };
        this.locationOptions = ['GPS location', 'Technion']; // need to add "choose by address"
        //--- RENT SPOT -----------------------------------------------------------------------------------
        this.selectedSpot = null;
        // init filterForm (fields and validators):
        this.filterForm = fb.group({
            floatLabel: 'auto',
            'maxPrice': ["", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].pattern('[0-9]*')]],
            'maxDistance': ["", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].pattern('[0-9]*')]],
            'locationOption': ["", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]],
        });
    }
    FindParkingComponent.prototype.ngOnInit = function () {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var res;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0:
                        this.findCurrentLocation();
                        return [4 /*yield*/, this.webService.getSpots()];
                    case 1:
                        res = _a.sent();
                        console.log(res);
                        this.ELEMENT_DATA = JSON.parse('' + res + '');
                        this.ELEMENT_DATA_FILTER = this.ELEMENT_DATA;
                        console.log(this.ELEMENT_DATA_FILTER);
                        this.dataSource = new _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatTableDataSource"](this.ELEMENT_DATA_FILTER);
                        console.log(this.dataSource);
                        this.dataSource.sort = this.sort;
                        this.loading = false;
                        return [2 /*return*/];
                }
            });
        });
    };
    FindParkingComponent.prototype.getAddress = function (lat, lng) {
        if (navigator.geolocation) {
            var geocoder = new google.maps.Geocoder();
            var latlng = new google.maps.LatLng(lat, lng);
            var request = { latLng: latlng };
            var res_1 = '(lat=' + lat + ',lng=' + lng + ')';
            geocoder.geocode(request, function (results, status) {
                if (status == google.maps.GeocoderStatus.OK && results[0]) {
                    //console.log("************ results[0].formatted_address", results[0].formatted_address)
                    res_1 = results[0].formatted_address;
                }
            });
            return res_1;
        }
    };
    //--- UPDATE LOCATION --------------------------------------------------------------------------------------
    FindParkingComponent.prototype.findCurrentLocation = function () {
        var _this = this;
        if (this.selectedCurrLocOption == 'GPS location') {
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
        this.currlat = this.thecnionlat;
        this.currlng = this.thecnionlng;
        //this.getAddress(this.currlat, this.currlng)
    };
    FindParkingComponent.prototype.filter = function () {
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
        this.ELEMENT_DATA_FILTER = [];
        var centerLoc = new google.maps.LatLng(this.currlat, this.currlng);
        for (var _i = 0, _a = this.ELEMENT_DATA; _i < _a.length; _i++) {
            var spot = _a[_i];
            var markerLoc = new google.maps.LatLng(spot.latitude, spot.longitude);
            // spot.distance = Math.round(google.maps.geometry.spherical.computeDistanceBetween(markerLoc, centerLoc));
            // if (((spot.distance <= this.filterElement.maxDistance) || (this.filterElement.maxDistance == -1)) &&
            if (((spot.price <= this.filterElement.maxPrice) || (this.filterElement.maxPrice == -1))) {
                this.ELEMENT_DATA_FILTER.push(spot);
            }
        }
        this.dataSource = new _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatTableDataSource"](this.ELEMENT_DATA_FILTER);
        this.dataSource.sort = this.sort;
    };
    FindParkingComponent.prototype.rentSpot = function (spot) {
        console.log("you choose to rent: ", spot);
        this.selectedSpot = spot;
        this.openRentDialog();
        this.selectedSpot = null;
    };
    FindParkingComponent.prototype.openRentDialog = function () {
        /** config dialog */
        var dialogConfig = new _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatDialogConfig"]();
        dialogConfig.disableClose = true; /** the user will not be able to close the dialog just by clicking outside of it */
        dialogConfig.autoFocus = false; /** the focus will not be set automatically on the first form field of the dialog */
        dialogConfig.height = '500px'; /** size of dialog window */
        dialogConfig.width = '500px';
        dialogConfig.data = {
            id: this.selectedSpot.id,
            building: this.selectedSpot.building,
            city: this.selectedSpot.city,
            street: this.selectedSpot.street,
            end_time: this.selectedSpot.end_time,
            start_time: this.selectedSpot.start_time,
            price: this.selectedSpot.price,
        };
        /** open dialog */
        var dialogRef = this.rentDialog.open(_rent_spot_dialog_rent_spot_dialog_component__WEBPACK_IMPORTED_MODULE_6__["RentSpotDialogComponent"], dialogConfig);
        /** get data from dialog - empty for no */
        dialogRef.afterClosed().subscribe(function (result) {
            if (result != null) {
                if (result == 'rent') {
                    console.log('The rent dialog was closed - *with* renting');
                }
                else if (result == 'close') {
                    console.log('The rent dialog was closed - *without* renting');
                }
            }
        });
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
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_agm_core__WEBPACK_IMPORTED_MODULE_2__["MapsAPILoader"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormBuilder"], _web_service__WEBPACK_IMPORTED_MODULE_5__["WebService"], _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatDialog"]])
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

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAvaG9tZS9ob21lLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/home/home.component.html":
/*!******************************************!*\
  !*** ./src/app/home/home.component.html ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n<html>\r\n<h1 style=\"text-align: center;\"><strong>The world is your parking space</strong></h1>\r\n<h1 style=\"text-align: center;\"><strong style=\"font-size: 14px;\">Remember that time you were trying to find a parking space but all spaces around were private? <span style=\"color: #ff0000;\">Now you may use some of them.</span></strong></h1>\r\n<p style=\"text-align: center;\"><strong>Remember that time your car was in the&nbsp;shop for a week and your own private space was just all empty? <span style=\"color: #ff0000;\">Now you can make money off it.</span></strong></p>\r\n<p style=\"text-align: center;\"><strong>Use our solution to find a parking space close to your location or rent out your own private parking space!</strong></p>\r\n\r\n<div  >\r\n  <div *ngIf=\"loading\">\r\n    <mat-progress-spinner mode=\"indeterminate\" value=\"indeterminate\" style=\"width:15%; margin:0 auto;\"></mat-progress-spinner>\r\n  </div>\r\n</div>  \r\n\r\n<p style=\"text-align: center;\"><span style=\"text-decoration: underline;\">Our statistics</span><br />Total parking spots: {{total}}<br />Total free parking spots for today: {{freetoday}}<br />Total free parking spots: {{totalfree}}</p>\r\n<p>&nbsp;</p>\r\n<p style=\"text-align: center;\"><strong><img src=\"https://i.imgur.com/AsCGHTI.jpg\" alt=\"\" width=\"1280\" height=\"854\" /></strong></p>\r\n</html>\r\n"

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
/* harmony import */ var _web_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../web.service */ "./src/app/web.service.ts");



var HomeComponent = /** @class */ (function () {
    function HomeComponent(webService) {
        this.webService = webService;
        this.loading = true;
    }
    HomeComponent.prototype.ngOnInit = function () {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var res;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.webService.GetDetailRoot()];
                    case 1:
                        res = _a.sent();
                        this.loading = false;
                        this.total = res["total"];
                        this.freetoday = res["free_today"];
                        this.totalfree = res["free_all"];
                        return [2 /*return*/];
                }
            });
        });
    };
    HomeComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-home',
            template: __webpack_require__(/*! ./home.component.html */ "./src/app/home/home.component.html"),
            styles: [__webpack_require__(/*! ./home.component.css */ "./src/app/home/home.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_web_service__WEBPACK_IMPORTED_MODULE_2__["WebService"]])
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

module.exports = ".mat-dialog-content {\r\n    display: flex;\r\n    flex-direction: column;\r\n}\r\n  \r\n.mat-dialog-content > * {\r\n    width: 100%;\r\n}\r\n  \r\n.btn-primary, .btn-secondary {\r\n  width:130px;\r\n  margin-left: 20px;\r\n  margin-right: 20px;\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sb2dpbi9sb2dpbi5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksY0FBYztJQUNkLHVCQUF1QjtDQUMxQjs7QUFFRDtJQUNJLFlBQVk7Q0FDZjs7QUFFRDtFQUNFLFlBQVk7RUFDWixrQkFBa0I7RUFDbEIsbUJBQW1CO0NBQ3BCIiwiZmlsZSI6ImFwcC9sb2dpbi9sb2dpbi5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLm1hdC1kaWFsb2ctY29udGVudCB7XHJcbiAgICBkaXNwbGF5OiBmbGV4O1xyXG4gICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcclxufVxyXG4gIFxyXG4ubWF0LWRpYWxvZy1jb250ZW50ID4gKiB7XHJcbiAgICB3aWR0aDogMTAwJTtcclxufVxyXG5cclxuLmJ0bi1wcmltYXJ5LCAuYnRuLXNlY29uZGFyeSB7XHJcbiAgd2lkdGg6MTMwcHg7XHJcbiAgbWFyZ2luLWxlZnQ6IDIwcHg7XHJcbiAgbWFyZ2luLXJpZ2h0OiAyMHB4O1xyXG59Il19 */"

/***/ }),

/***/ "./src/app/login/login.component.html":
/*!********************************************!*\
  !*** ./src/app/login/login.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!-- Title -->\r\n<h2 style=\"text-align:center\" mat-dialog-title>Login</h2>\r\n<!-- Content -->\r\n<div  >\r\n  <div *ngIf=\"loading\">\r\n    <mat-progress-spinner mode=\"indeterminate\" value=\"indeterminate\" style=\"width:15%; margin:0 auto;\"></mat-progress-spinner>\r\n    <p> {{spacer}} </p>\r\n    <p> {{spacer}} </p>\r\n  </div>\r\n</div>  \r\n<div *ngIf=\"!loading\" mat-dialog-content [formGroup]=\"loginForm\">\r\n  <p style=\"color:red;\" *ngIf=\"error\"> Error: {{error}} </p>\r\n\r\n  <!-- UserName -->\r\n  <mat-form-field>\r\n    <input matInput placeholder=\"email\" formControlName=\"email\" required>\r\n  </mat-form-field>\r\n\r\n  <!-- Password -->\r\n  <mat-form-field>\r\n    <input matInput placeholder=\"Password\" formControlName=\"password\" required [type]=\"hidePassword ? 'password' : 'text'\">\r\n    <mat-icon matSuffix (click)=\"hidePassword = !hidePassword\">{{hidePassword ? 'visibility_off' : 'visibility'}}</mat-icon>\r\n  </mat-form-field>\r\n\r\n</div>\r\n\r\n<!-- Bottons -->\r\n<div mat-dialog-actions align=\"center\">\r\n\r\n  <button type=\"button\" class=\"btn btn-primary\" (click)=\"login()\" [disabled]=\"!loginForm.valid\">Login</button>\r\n\r\n  <button type=\"button\" class=\"btn btn-secondary\" (click)=\"close()\">Close</button>\r\n\r\n  <p> <br>\r\n    Don’t have an account?\r\n    <button type=\"button\" class=\"btn btn-link\" (click)=\"signUp()\">Sign Up</button>\r\n  </p>\r\n\r\n</div>"

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
        this.loading = false;
        this.spacer = '         ';
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
            var res, result, tmp;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0:
                        this.loading = true;
                        this.loginpModel.email = this.loginForm.value.email;
                        this.loginpModel.password = this.loginForm.value.password;
                        this.loginpModel.closeOption = 'login';
                        this.error = '';
                        console.log("The login form was submitted: " + JSON.stringify(this.loginpModel)); // TODO: delete!
                        return [4 /*yield*/, this.webService.PostLogIn(this.loginpModel)];
                    case 1:
                        res = _a.sent();
                        console.log(res);
                        if (res['name']) {
                            this.error = null;
                            result = { closeOption: 'login', username: res['name'] };
                            this.dialogRef.close(result);
                            this.loading = false;
                        }
                        if (res.Desc) {
                            tmp = res.Desc.split(":");
                            this.loading = false;
                            this.error = tmp[tmp.length - 1];
                            return [2 /*return*/];
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

module.exports = ".navbar {\r\n    width: 100%;\r\n    background-color: #555;\r\n    overflow: auto;\r\n}\r\n  \r\n/* Navbar links */\r\n  \r\n.navbar a {\r\n    float: left;\r\n    text-align: center;\r\n    color: white;\r\n}\r\n  \r\n/* Navbar links on mouse-over */\r\n  \r\n.navbar a:hover {\r\n    background-color: #000;\r\n}\r\n  \r\n/* Current/active navbar link */\r\n  \r\n.active {\r\n    font-weight:bold;\r\n}\r\n  \r\n.nav-item{\r\n    align-self: center;\r\n    padding: 8px\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9uYXZiYXIvbmF2YmFyLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxZQUFZO0lBQ1osdUJBQXVCO0lBQ3ZCLGVBQWU7Q0FDbEI7O0FBRUQsa0JBQWtCOztBQUNsQjtJQUNJLFlBQVk7SUFDWixtQkFBbUI7SUFDbkIsYUFBYTtDQUNoQjs7QUFFRCxnQ0FBZ0M7O0FBQ2hDO0lBQ0ksdUJBQXVCO0NBQzFCOztBQUVELGdDQUFnQzs7QUFDaEM7SUFDSSxpQkFBaUI7Q0FDcEI7O0FBRUQ7SUFDSSxtQkFBbUI7SUFDbkIsWUFBWTtDQUNmIiwiZmlsZSI6ImFwcC9uYXZiYXIvbmF2YmFyLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIubmF2YmFyIHtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogIzU1NTtcclxuICAgIG92ZXJmbG93OiBhdXRvO1xyXG59XHJcbiAgXHJcbi8qIE5hdmJhciBsaW5rcyAqL1xyXG4ubmF2YmFyIGEge1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgICBjb2xvcjogd2hpdGU7XHJcbn1cclxuICBcclxuLyogTmF2YmFyIGxpbmtzIG9uIG1vdXNlLW92ZXIgKi9cclxuLm5hdmJhciBhOmhvdmVyIHtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICMwMDA7XHJcbn1cclxuXHJcbi8qIEN1cnJlbnQvYWN0aXZlIG5hdmJhciBsaW5rICovXHJcbi5hY3RpdmUge1xyXG4gICAgZm9udC13ZWlnaHQ6Ym9sZDtcclxufSBcclxuXHJcbi5uYXYtaXRlbXtcclxuICAgIGFsaWduLXNlbGY6IGNlbnRlcjtcclxuICAgIHBhZGRpbmc6IDhweFxyXG59Il19 */"

/***/ }),

/***/ "./src/app/navbar/navbar.component.html":
/*!**********************************************!*\
  !*** ./src/app/navbar/navbar.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\r\n\r\n  <!-- Brand / Logo -->\r\n  <!-- TODO: update name + logo -->\r\n  <a class=\"navbar-brand\" routerLink=\"\" style=\"font-size:x-large\">\r\n    <img src=\"../../assets/img/parking-logo-white.png\" width=\"35\" height=\"35\" alt=\"logo\">\r\n    Parking Renting\r\n  </a>\r\n\r\n  <!-- Collapsing The Navigation Bar -->\r\n  <button class=\"navbar-toggler\" type=\"button\" (click)=\"toggleNavbar()\" data-target=\"#mainNavBar\">\r\n    <span class=\"navbar-toggler-icon\"></span>\r\n  </button>\r\n\r\n  <!-- The NavBar -->\r\n  <div class=\"collapse navbar-collapse show\" [ngClass]=\"{ 'show': navbarOpen }\" id=\"mainNavBar\">\r\n\r\n    <!-- Left: Find Parking, Become a Host -->\r\n    <ul class=\"navbar-nav mr-auto\">\r\n\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link\" routerLink=\"\" routerLinkActive=\"active current\" [routerLinkActiveOptions]=\"{exact: true}\">\r\n          Home\r\n        </a>\r\n      </li>\r\n\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link\" routerLink=\"/find-parking\" routerLinkActive=\"active current\">\r\n          Find Parking\r\n        </a>\r\n      </li>\r\n\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link\" routerLink=\"/become-host\" routerLinkActive=\"active current\">\r\n          Become a Host\r\n        </a>\r\n      </li>\r\n\r\n    </ul>\r\n\r\n    <!-- Right: SignUp, Login -->\r\n    <ul class=\"nav navbar-nav navbar-right\">\r\n\r\n      <li class=\"nav-item\">\r\n        <a *ngIf=\"username\">\r\n          Welcome {{username}}\r\n        </a>\r\n      </li>\r\n\r\n      <li class=\"nav-item\" *ngIf=\"!userIsLogin\">\r\n        <button type=\"button\" class=\"btn btn-light\" (click)=\"openLoginDialog()\" style=\"width: 110px\">\r\n          <span class=\"fa fa-sign-in\"></span>\r\n          Login\r\n        </button>\r\n      </li>\r\n\r\n      <li class=\"nav-item\" *ngIf=\"userIsLogin\">\r\n        <button type=\"button\" class=\"btn btn-light\" (click)=\"logout()\" style=\"width: 110px\">\r\n          <span class=\"fa fa-sign-out\"></span>\r\n          Logout\r\n        </button>\r\n      </li>\r\n\r\n      <li class=\"nav-item\" *ngIf=\"!userIsLogin\">\r\n        <button type=\"button\" class=\"btn btn-light\" (click)=\"openSignUpDialog()\" style=\"width: 110px\">\r\n          <span class=\"fa fa-user\"></span>\r\n          Sign Up\r\n        </button>\r\n      </li>\r\n\r\n    </ul>\r\n\r\n  </div>\r\n\r\n</nav>"

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
/* harmony import */ var _web_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../web.service */ "./src/app/web.service.ts");






var NavbarComponent = /** @class */ (function () {
    function NavbarComponent(loginDialog, signUpDialog, webService) {
        this.loginDialog = loginDialog;
        this.signUpDialog = signUpDialog;
        this.webService = webService;
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
        this.webService.postLogOut();
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
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialog"], _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialog"], _web_service__WEBPACK_IMPORTED_MODULE_5__["WebService"]])
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

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAvbm90LWZvdW5kL25vdC1mb3VuZC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/not-found/not-found.component.html":
/*!****************************************************!*\
  !*** ./src/app/not-found/not-found.component.html ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\r\n  not-found works!\r\n</p>\r\n"

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

/***/ "./src/app/rent-spot-dialog/rent-spot-dialog.component.css":
/*!*****************************************************************!*\
  !*** ./src/app/rent-spot-dialog/rent-spot-dialog.component.css ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAvcmVudC1zcG90LWRpYWxvZy9yZW50LXNwb3QtZGlhbG9nLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/rent-spot-dialog/rent-spot-dialog.component.html":
/*!******************************************************************!*\
  !*** ./src/app/rent-spot-dialog/rent-spot-dialog.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h1 mat-dialog-title>Rent Spot</h1>\r\n\r\n\r\n<div mat-dialog-content>\r\n  <p>You have selected the parking spot with the following characteristics:</p>\r\n\r\n  <p><b>ID: </b>{{spot.id}}</p>\r\n  <p><b>price: </b>{{spot.price}}</p>\r\n  <p><b>address: </b>{{spot.city}} {{spot.street}} {{spot.building}} </p>\r\n  <p><b>start time: </b> {{spot.start_time}} </p>\r\n  <p><b>end time: </b> {{spot.end_time}} </p>\r\n\r\n</div>\r\n\r\n<div mat-dialog-actions>\r\n  <button mat-button (click)=\"rent(spot.id)\">Rent</button>\r\n  <button mat-button (click)=\"close()\">Close</button>\r\n</div> "

/***/ }),

/***/ "./src/app/rent-spot-dialog/rent-spot-dialog.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/rent-spot-dialog/rent-spot-dialog.component.ts ***!
  \****************************************************************/
/*! exports provided: RentSpotDialogComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RentSpotDialogComponent", function() { return RentSpotDialogComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _web_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../web.service */ "./src/app/web.service.ts");




var RentSpotDialogComponent = /** @class */ (function () {
    function RentSpotDialogComponent(dialogRef, spot, webService) {
        this.dialogRef = dialogRef;
        this.spot = spot;
        this.webService = webService;
    }
    RentSpotDialogComponent.prototype.ngOnInit = function () {
    };
    RentSpotDialogComponent.prototype.close = function () {
        this.dialogRef.close('close');
    };
    RentSpotDialogComponent.prototype.rent = function (spotId) {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var res;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.webService.postRent(spotId)];
                    case 1:
                        res = _a.sent();
                        if (res == null) {
                            this.dialogRef.close('rent');
                        }
                        else {
                            alert('error');
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    RentSpotDialogComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-rent-spot-dialog',
            template: __webpack_require__(/*! ./rent-spot-dialog.component.html */ "./src/app/rent-spot-dialog/rent-spot-dialog.component.html"),
            styles: [__webpack_require__(/*! ./rent-spot-dialog.component.css */ "./src/app/rent-spot-dialog/rent-spot-dialog.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__param"](1, Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_2__["MAT_DIALOG_DATA"])),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogRef"], Object, _web_service__WEBPACK_IMPORTED_MODULE_3__["WebService"]])
    ], RentSpotDialogComponent);
    return RentSpotDialogComponent;
}());



/***/ }),

/***/ "./src/app/rent-spot-form/rent-spot-form.component.css":
/*!*************************************************************!*\
  !*** ./src/app/rent-spot-form/rent-spot-form.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".container{\r\n    width: 800px; \r\n    margin-left: unset; \r\n    margin-top: 10px;\r\n}\r\n\r\n.mat-form {\r\n    display: flex;\r\n    flex-direction: column;\r\n    margin-top: 10px;\r\n    margin-bottom: 10px;\r\n}\r\n\r\n.btn-primary, .btn-secondary {\r\n    width:130px;\r\n    align-self: center;\r\n}\r\n\r\n.button {\r\n    display: inline-block;\r\n    margin-left: 20px;\r\n    margin-right: 20px;\r\n }\r\n\r\n.date-field {\r\n    width: 50px;\r\n}\r\n\r\n.row {\r\n    margin-bottom: 20px;\r\n}\r\n\r\n.col-sm-1, .col-sm-2, .col-sm-3, .col-sm-4 {\r\n    align-self: center;\r\n}\r\n\r\nmat-label {\r\n    font-size: larger;\r\n}\r\n\r\n.date-input-field {\r\n    width:130px; \r\n    text-align: center\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9yZW50LXNwb3QtZm9ybS9yZW50LXNwb3QtZm9ybS5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksYUFBYTtJQUNiLG1CQUFtQjtJQUNuQixpQkFBaUI7Q0FDcEI7O0FBRUQ7SUFDSSxjQUFjO0lBQ2QsdUJBQXVCO0lBQ3ZCLGlCQUFpQjtJQUNqQixvQkFBb0I7Q0FDdkI7O0FBRUQ7SUFDSSxZQUFZO0lBQ1osbUJBQW1CO0NBQ3RCOztBQUVEO0lBQ0ksc0JBQXNCO0lBQ3RCLGtCQUFrQjtJQUNsQixtQkFBbUI7RUFDckI7O0FBRUY7SUFDSSxZQUFZO0NBQ2Y7O0FBRUQ7SUFDSSxvQkFBb0I7Q0FDdkI7O0FBRUQ7SUFDSSxtQkFBbUI7Q0FDdEI7O0FBRUQ7SUFDSSxrQkFBa0I7Q0FDckI7O0FBRUQ7SUFDSSxZQUFZO0lBQ1osa0JBQWtCO0NBQ3JCIiwiZmlsZSI6ImFwcC9yZW50LXNwb3QtZm9ybS9yZW50LXNwb3QtZm9ybS5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmNvbnRhaW5lcntcclxuICAgIHdpZHRoOiA4MDBweDsgXHJcbiAgICBtYXJnaW4tbGVmdDogdW5zZXQ7IFxyXG4gICAgbWFyZ2luLXRvcDogMTBweDtcclxufVxyXG5cclxuLm1hdC1mb3JtIHtcclxuICAgIGRpc3BsYXk6IGZsZXg7XHJcbiAgICBmbGV4LWRpcmVjdGlvbjogY29sdW1uO1xyXG4gICAgbWFyZ2luLXRvcDogMTBweDtcclxuICAgIG1hcmdpbi1ib3R0b206IDEwcHg7XHJcbn1cclxuXHJcbi5idG4tcHJpbWFyeSwgLmJ0bi1zZWNvbmRhcnkge1xyXG4gICAgd2lkdGg6MTMwcHg7XHJcbiAgICBhbGlnbi1zZWxmOiBjZW50ZXI7XHJcbn1cclxuXHJcbi5idXR0b24ge1xyXG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xyXG4gICAgbWFyZ2luLWxlZnQ6IDIwcHg7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IDIwcHg7XHJcbiB9XHJcblxyXG4uZGF0ZS1maWVsZCB7XHJcbiAgICB3aWR0aDogNTBweDtcclxufVxyXG5cclxuLnJvdyB7XHJcbiAgICBtYXJnaW4tYm90dG9tOiAyMHB4O1xyXG59XHJcblxyXG4uY29sLXNtLTEsIC5jb2wtc20tMiwgLmNvbC1zbS0zLCAuY29sLXNtLTQge1xyXG4gICAgYWxpZ24tc2VsZjogY2VudGVyO1xyXG59XHJcblxyXG5tYXQtbGFiZWwge1xyXG4gICAgZm9udC1zaXplOiBsYXJnZXI7XHJcbn1cclxuXHJcbi5kYXRlLWlucHV0LWZpZWxkIHtcclxuICAgIHdpZHRoOjEzMHB4OyBcclxuICAgIHRleHQtYWxpZ246IGNlbnRlclxyXG59Il19 */"

/***/ }),

/***/ "./src/app/rent-spot-form/rent-spot-form.component.html":
/*!**************************************************************!*\
  !*** ./src/app/rent-spot-form/rent-spot-form.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\" [formGroup]=\"rentSpotForm\">\r\n\r\n  <!-- Title -->\r\n  <h2>Rent your spot</h2>\r\n\r\n  <!-- Form -->\r\n  <div class=\"mat-form\">\r\n\r\n\r\n    <!-- Address: -->\r\n    <div class=\"row\" formGroupName=\"address\">\r\n\r\n      <!-- Label -->\r\n      <div class=\"col-sm-2\">\r\n        <mat-label>Address:</mat-label>\r\n      </div>\r\n\r\n      <!-- City -->\r\n      <div class=\"col-sm-3\">\r\n        <mat-form-field class=\"form-field\">\r\n          <input matInput placeholder=\"City\" formControlName=\"city\" required>\r\n          <mat-error *ngIf=\"rentSpotForm.get('address').controls['city'].hasError('pattern')\">\r\n            Please enter a valid city name: Letters only\r\n          </mat-error>\r\n        </mat-form-field>\r\n      </div>\r\n\r\n      <!-- Street -->\r\n      <div class=\"col-sm-3\">\r\n        <mat-form-field class=\"form-field\">\r\n          <input matInput placeholder=\"Street\" formControlName=\"street\" required>\r\n          <mat-error *ngIf=\"rentSpotForm.get('address').controls['street'].hasError('pattern')\">\r\n            Please enter a valid street name: Letters only\r\n          </mat-error>\r\n        </mat-form-field>\r\n      </div>\r\n\r\n      <!-- Parking spot number -->\r\n      <div class=\"col-sm-3\">\r\n        <mat-form-field class=\"form-field\">\r\n          <input matInput placeholder=\"Parking spot number\" formControlName=\"spot_num\">\r\n          <mat-error *ngIf=\"rentSpotForm.get('address').controls['spot_num'].hasError('pattern')\">\r\n            Please enter a valid parking spot number: Integer number only\r\n          </mat-error>\r\n        </mat-form-field>\r\n      </div>\r\n\r\n    </div>\r\n\r\n\r\n    <!-- Start time: -->\r\n    <div class=\"row\" formGroupName=\"start_time\">\r\n\r\n      <!-- Label -->\r\n      <div class=\"col-sm-2\">\r\n        <mat-label>Start time:</mat-label>\r\n      </div>\r\n\r\n      <!-- Date: -->\r\n      <div class=\"col-sm-3\">\r\n        <div class=\"input-group\">\r\n          <input formControlName=\"start_date\" placeholder=\"yyyy-mm-dd\" name=\"dpS\" ngbDatepicker #dS=\"ngbDatepicker\"\r\n            class=\"date-input-field\">\r\n          <div class=\"input-group-append\">\r\n            <button type=\"button\" class=\"btn btn-outline-secondary\" (click)=\"dS.toggle()\">\r\n              <span class=\"fa fa-calendar\"></span>\r\n            </button>\r\n          </div>\r\n        </div>\r\n      </div>\r\n\r\n      <!-- Hour: -->\r\n      <div class=\"col-sm-3\">\r\n        <ngb-timepicker formControlName=\"start_hour\" required></ngb-timepicker>\r\n      </div>\r\n\r\n    </div>\r\n\r\n\r\n    <!-- End time: -->\r\n    <div class=\"row\" formGroupName=\"end_time\">\r\n\r\n      <!-- Label -->\r\n      <div class=\"col-sm-2\">\r\n        <mat-label>End time:</mat-label>\r\n      </div>\r\n\r\n      <!-- Date: -->\r\n      <div class=\"col-sm-3\">\r\n        <div class=\"input-group\">\r\n          <input formControlName=\"end_date\" placeholder=\"yyyy-mm-dd\" name=\"dpE\" ngbDatepicker #dE=\"ngbDatepicker\"\r\n            [markDisabled]=\"isDisabled\" class=\"date-input-field\">\r\n          <div class=\"input-group-append\">\r\n            <button type=\"button\" class=\"btn btn-outline-secondary\" (click)=\"dE.toggle()\">\r\n              <span class=\"fa fa-calendar\"></span>\r\n            </button>\r\n          </div>\r\n        </div>\r\n      </div>\r\n\r\n      <!-- Hour: -->\r\n      <div class=\"col-sm-3\">\r\n        <ngb-timepicker formControlName=\"end_hour\" required></ngb-timepicker>\r\n      </div>\r\n\r\n    </div>\r\n\r\n\r\n    <!-- Price per hour: -->\r\n    <div class=\"row\">\r\n\r\n      <!-- Label -->\r\n      <div class=\"col-sm-2\">\r\n        <mat-label>Price:</mat-label>\r\n      </div>\r\n\r\n      <!-- Price -->\r\n      <div class=\"col-sm-3\">\r\n        <mat-form-field class=\"form-field\">\r\n          <input matInput placeholder=\"Price per hour\" formControlName=\"price\" required>\r\n          <mat-error *ngIf=\"rentSpotForm.controls['price'].hasError('pattern')\">\r\n            Please enter a valid price: float number only\r\n          </mat-error>\r\n        </mat-form-field>\r\n      </div>\r\n\r\n    </div>\r\n\r\n\r\n  </div>\r\n\r\n  <p style=\"color:green;\" *ngIf=\"added\">successfully add a new spot</p>\r\n  <p style=\"color:red;\" *ngIf=\"error_msg\">{{error_msg}}</p>\r\n\r\n  <!-- Buttons -->\r\n  <div style=\"width:300px; align-self: center\">\r\n\r\n    <button type=\"button\" class=\"btn btn-primary\" (click)=\"addNewSpot()\" [disabled]=\"!rentSpotForm.valid\" style=\"float: left\">Submit</button>\r\n    <button type=\"button\" class=\"btn btn-secondary\" (click)=\"reset()\" style=\"float: right\">Reset</button>\r\n\r\n  </div>\r\n\r\n\r\n</div>"

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
        this.error_msg = '';
        this.added = false;
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
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var startTime, endTime, res;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0:
                        this.added = false;
                        this.error_msg = '';
                        this.rentSpotModel.city = this.rentSpotForm.value.address.city;
                        this.rentSpotModel.street = this.rentSpotForm.value.address.street;
                        this.rentSpotModel.spot_num = this.rentSpotForm.value.address.spot_num;
                        startTime = new Date(this.rentSpotForm.value.start_time.start_date.year, this.rentSpotForm.value.start_time.start_date.month - 1, this.rentSpotForm.value.start_time.start_date.day, this.rentSpotForm.value.start_time.start_hour.hour, this.rentSpotForm.value.start_time.start_hour.minute);
                        this.rentSpotModel.start_time = startTime;
                        endTime = new Date(this.rentSpotForm.value.end_time.end_date.year, this.rentSpotForm.value.end_time.end_date.month - 1, this.rentSpotForm.value.end_time.end_date.day, this.rentSpotForm.value.end_time.end_hour.hour, this.rentSpotForm.value.end_time.end_hour.minute);
                        this.rentSpotModel.end_time = endTime;
                        this.rentSpotModel.price = this.rentSpotForm.value.price;
                        this.reset();
                        console.log("The rent spot form was submitted: " + JSON.stringify(this.rentSpotModel)); // TODO: delete!
                        return [4 /*yield*/, this.webService.addSpot(this.rentSpotModel)];
                    case 1:
                        res = _a.sent();
                        if (res = "successfully add a new spot") {
                            this.added = true;
                        }
                        else {
                            this.error_msg = res.Desc;
                            // this.error = true
                        }
                        return [2 /*return*/];
                }
            });
        });
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

module.exports = ".mat-dialog-content {\r\n    display: flex;\r\n    flex-direction: column;\r\n}\r\n  \r\n.mat-dialog-content > * {\r\n    width: 100%;\r\n}\r\n  \r\n.btn-primary, .btn-secondary {\r\n  width:130px;\r\n  margin-left: 20px;\r\n  margin-right: 20px;\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9zaWduLXVwL3NpZ24tdXAuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtJQUNJLGNBQWM7SUFDZCx1QkFBdUI7Q0FDMUI7O0FBRUQ7SUFDSSxZQUFZO0NBQ2Y7O0FBRUQ7RUFDRSxZQUFZO0VBQ1osa0JBQWtCO0VBQ2xCLG1CQUFtQjtDQUNwQiIsImZpbGUiOiJhcHAvc2lnbi11cC9zaWduLXVwLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIubWF0LWRpYWxvZy1jb250ZW50IHtcclxuICAgIGRpc3BsYXk6IGZsZXg7XHJcbiAgICBmbGV4LWRpcmVjdGlvbjogY29sdW1uO1xyXG59XHJcbiAgXHJcbi5tYXQtZGlhbG9nLWNvbnRlbnQgPiAqIHtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG59XHJcblxyXG4uYnRuLXByaW1hcnksIC5idG4tc2Vjb25kYXJ5IHtcclxuICB3aWR0aDoxMzBweDtcclxuICBtYXJnaW4tbGVmdDogMjBweDtcclxuICBtYXJnaW4tcmlnaHQ6IDIwcHg7XHJcbn0iXX0= */"

/***/ }),

/***/ "./src/app/sign-up/sign-up.component.html":
/*!************************************************!*\
  !*** ./src/app/sign-up/sign-up.component.html ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!-- Title -->\r\n<h2 style=\"text-align:center\" mat-dialog-title>Sign Up</h2>\r\n\r\n<!-- Content -->\r\n<div mat-dialog-content [formGroup]=\"signUpForm\">\r\n\r\n  <!-- First Nmae -->\r\n  <mat-form-field>\r\n    <input matInput placeholder=\"First name\" formControlName=\"fname\" required>\r\n  </mat-form-field>\r\n\r\n  <!-- Last Nmae -->\r\n  <mat-form-field>\r\n    <input matInput placeholder=\"Last name\" formControlName=\"lname\" required>\r\n  </mat-form-field>\r\n\r\n  <!-- UserName -->\r\n  <mat-form-field>\r\n    <input matInput placeholder=\"Username\" formControlName=\"username\" required>\r\n  </mat-form-field>\r\n\r\n  <!-- Password -->\r\n  <mat-form-field hintLabel=\"{{passwordHintMessage}}\">\r\n    <input matInput placeholder=\"Password\" formControlName=\"password\" required [type]=\"hidePassword ? 'password' : 'text'\">\r\n    <mat-icon matSuffix (click)=\"hidePassword = !hidePassword\">{{hidePassword ? 'visibility_off' : 'visibility'}}</mat-icon>\r\n    <mat-error *ngIf=\"signUpForm.controls['password'].hasError('pattern')\">\r\n      Please enter a valid password: {{passwordHintMessage}}\r\n    </mat-error>\r\n  </mat-form-field>\r\n\r\n  <!-- Emaiil -->\r\n  <mat-form-field style=\"margin-top: 30px\">\r\n    <input matInput placeholder=\"Email address\" formControlName=\"email\" required>\r\n    <mat-error *ngIf=\"signUpForm.controls['email'].hasError('email')\">\r\n      Please enter a valid email address\r\n    </mat-error>\r\n  </mat-form-field>\r\n\r\n</div>\r\n\r\n<!-- Bottons -->\r\n<div mat-dialog-actions align=\"center\">\r\n\r\n  <button type=\"button\" class=\"btn btn-primary\" (click)=\"signUp()\" [disabled]=\"!signUpForm.valid\">Sign Up</button>\r\n  <button type=\"button\" class=\"btn btn-secondary\" (click)=\"close()\">Close</button>\r\n\r\n</div>"

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
        this.RENT_URL = 'logged/rent/renting_spot';
        this.GETDETAILROOT_URL = '/getDetailRoot';
        this.client_id = 'BP5o9rPZ8cTpRu-RTbmSA6eZ3ZbgICva';
        this.id_token = null;
        this.access_token = null;
    }
    WebService.prototype.addSpot = function (rent) {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var body;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0:
                        body = {
                            accessToken: this.access_token,
                            idToken: this.id_token,
                            city: rent.city,
                            street: rent.street,
                            start_time: rent.start_time,
                            end_time: rent.end_time,
                            price: rent.price,
                            spot_num: ''
                        };
                        if (rent.spot_num) {
                            body.spot_num = rent.spot_num.toString();
                        }
                        console.log(JSON.stringify(body));
                        return [4 /*yield*/, this.http.post(this.BASE_URL + this.ADD_SPOT_URL, body).subscribe(function (res) {
                                console.log(JSON.stringify(res));
                                return "successfully add a new spot";
                            }, function (err) {
                                return err;
                            })];
                    case 1:
                        _a.sent();
                        return [2 /*return*/, null];
                }
            });
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
                        return [2 /*return*/, error_1.Desc];
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
                        return [2 /*return*/, JSON.stringify(error_2)];
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    WebService.prototype.postRent = function (spot) {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var body, res, error_3;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0:
                        body = {
                            id: spot,
                            accessToken: this.access_token,
                            idToken: this.id_token
                        };
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, 3, , 4]);
                        return [4 /*yield*/, this.http.post(this.BASE_URL + this.RENT_URL, body).toPromise()];
                    case 2:
                        res = _a.sent();
                        return [2 /*return*/, null];
                    case 3:
                        error_3 = _a.sent();
                        return [2 /*return*/, 'error'];
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    WebService.prototype.postLogOut = function () {
        var body = {
            accessToken: this.access_token,
            idToken: this.id_token
        };
        this.http.post(this.BASE_URL + this.LOGOUT, body);
        this.access_token = null;
        this.id_token = null;
    };
    WebService.prototype.GetDetailRoot = function () {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var x, error_4;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0:
                        _a.trys.push([0, 2, , 3]);
                        return [4 /*yield*/, this.http.get(this.BASE_URL + this.GETDETAILROOT_URL).toPromise()];
                    case 1:
                        x = _a.sent();
                        return [3 /*break*/, 3];
                    case 2:
                        error_4 = _a.sent();
                        return [2 /*return*/, 'error getting stats'];
                    case 3: return [2 /*return*/, x];
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

module.exports = __webpack_require__(/*! C:\Users\micha\Documents\GitHub\team6\frontend\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map