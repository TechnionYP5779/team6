// external imports:

import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NgModule } from '@angular/core';

import { HttpClientModule, HttpHeaders } from '@angular/common/http';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { MatDialogModule, MatButtonModule, MatFormFieldModule, MatInputModule, MatIconModule } from '@angular/material';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


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

    RentSpotFormComponent
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

    NgbModule,

    AppRoutingModule,
  ],

  exports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,

    FormsModule
  ],

  providers: [WebService],

  bootstrap: [AppComponent],

  entryComponents: [LoginComponent, SignUpComponent]

})

export class AppModule { }
