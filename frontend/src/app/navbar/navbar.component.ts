import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatDialogConfig } from '@angular/material';
import { LoginComponent } from '../login/login.component';

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

  constructor(public loginDialog: MatDialog) { }

  ngOnInit() {
  }

  openLoginDialog(): void {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;   /** the user will not be able to close the dialog just by clicking outside of it */

    dialogConfig.height = '400px';      /** TODO: change this! */
    dialogConfig.width = '600px';

    dialogConfig.data = {};             /** pass data to dialog - empty for now */
  

    /** open dialog */
    const dialogRef = this.loginDialog.open(LoginComponent, dialogConfig);

    /** get data from dialog */
    dialogRef.afterClosed().subscribe(result => {
      this.username = result.username;
    });
  }

}