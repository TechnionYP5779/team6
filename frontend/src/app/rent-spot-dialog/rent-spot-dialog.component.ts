import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatDialogConfig } from '@angular/material';
import { WebService } from '../web.service';
import { LoginComponent } from '../login/login.component';
import { SignUpComponent } from '../sign-up/sign-up.component';

@Component({
  selector: 'app-rent-spot-dialog',
  templateUrl: './rent-spot-dialog.component.html',
  styleUrls: ['./rent-spot-dialog.component.css']
})
export class RentSpotDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<RentSpotDialogComponent>, @Inject(MAT_DIALOG_DATA) public spot: SpotElement, private webService: WebService,
   public loginDialog: MatDialog, public signUpDialog: MatDialog ) { }


  ngOnInit() {
  }

  close(): void {
    this.dialogRef.close('close');
  }

  async rent(spotId) {
    var res = await this.webService.postRent(spotId);
    if (res == null) {
      this.dialogRef.close('rent');
    } else {
      alert('error');
    }

    //this.openLoginDialog();
  }

  openLoginDialog(): void {

    /** config dialog */
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;   /** the user will not be able to close the dialog just by clicking outside of it */
    dialogConfig.autoFocus = false;     /** the focus will not be set automatically on the first form field of the dialog */

    dialogConfig.height = '350px';      /** size of dialog window */
    dialogConfig.width = '500px';

    dialogConfig.data = {};             /** pass data to dialog - empty for now */

    /** open dialog */
    const dialogRef = this.loginDialog.open(LoginComponent, dialogConfig);

    /** get data from dialog: only username for now */
    dialogRef.afterClosed().subscribe(result => {
      if (result != null) {
        if (result.closeOption == 'login') {
          //this.username = result.username; // else: username is still 'Guest'
          //this.userIsLogin = true;
        }
        else if (result.closeOption == 'signup') {
          this.openSignUpDialog();
        }
      }
    });
  }

  openSignUpDialog(): void {

    /** config dialog */
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;   /** the user will not be able to close the dialog just by clicking outside of it */
    dialogConfig.autoFocus = false;     /** the focus will not be set automatically on the first form field of the dialog */

    dialogConfig.height = '500px';      /** size of dialog window */
    dialogConfig.width = '500px';

    dialogConfig.data = {};             /** pass data to dialog - empty for now */

    /** open dialog */
    const dialogRef = this.signUpDialog.open(SignUpComponent, dialogConfig);

    /** get data from dialog - empty for no */
    dialogRef.afterClosed().subscribe(result => { });
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