import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatDialogConfig } from '@angular/material';
import { LoginComponent } from '../login/login.component';
import { SignUpComponent } from '../sign-up/sign-up.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  navbarOpen = false;
  username: string = 'Guest';

  toggleNavbar() {
    this.navbarOpen = !this.navbarOpen;
  }

  constructor(public loginDialog: MatDialog, public signUpDialog: MatDialog) { }

  ngOnInit() {
  }

  openLoginDialog(): void {

    /** config dialog */
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;   /** the user will not be able to close the dialog just by clicking outside of it */
    dialogConfig.autoFocus = false;     /** the focus will not be set automatically on the first form field of the dialog */

    dialogConfig.height = '300px';      /** size of dialog window */
    dialogConfig.width = '500px';

    dialogConfig.data = {};             /** pass data to dialog - empty for now */

    /** open dialog */
    const dialogRef = this.loginDialog.open(LoginComponent, dialogConfig);

    /** get data from dialog: only username for now */
    dialogRef.afterClosed().subscribe(result => {
      if (result != null) this.username = result.username; // else: username is still 'Guest'
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