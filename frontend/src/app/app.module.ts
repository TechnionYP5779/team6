// external imports:

import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NgModule } from '@angular/core';

import { HttpClientModule, HttpHeaders } from '@angular/common/http';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { MatDialogModule, MatButtonModule, MatFormFieldModule, MatInputModule, MatIconModule } from '@angular/material';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';


import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AgmCoreModule } from '@agm/core';

// local imports:

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { BecomeHostComponent } from './become-host/become-host.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import { RentSpotFormComponent } from './rent-spot-form/rent-spot-form.component';
import { WebService } from './web.service';
import { RentSpotDialogComponent } from './rent-spot-dialog/rent-spot-dialog.component';


@NgModule({

  declarations: [
    AppComponent,
    NavbarComponent,
    routingComponents,
    HomeComponent,
    BecomeHostComponent,
    NotFoundComponent,
    SignUpComponent,
    LoginComponent,
    RentSpotFormComponent,
    RentSpotDialogComponent
  ],

  imports: [
    BrowserModule,
    BrowserAnimationsModule,

    HttpClientModule,

    FormsModule,
    ReactiveFormsModule,

    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatSelectModule,
    MatRadioModule,
    MatTableModule,
    MatSortModule,

    NgbModule,

    AppRoutingModule,

    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDQSACUeONioHKwbzWqEmL35YqRAbgnjeQ',
      libraries: ['geometry']
    })
  ],

  exports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,

    FormsModule
  ],

  providers: [WebService],

  bootstrap: [AppComponent],

  entryComponents: [LoginComponent, SignUpComponent, RentSpotDialogComponent]

})

export class AppModule { }
