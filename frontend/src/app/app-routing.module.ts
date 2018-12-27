import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FindParkingComponent } from './find-parking/find-parking.component';
import { BecomeHostComponent } from './become-host/become-host.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'find-parking', component: FindParkingComponent },
  { path: 'become-host', component: BecomeHostComponent },
  { path: 'profile', component: ProfileComponent },
  { path: '**', component: NotFoundComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomeComponent, FindParkingComponent, BecomeHostComponent, NotFoundComponent]