import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  loginpModel: LoginModel = {
    username: 'Guest',
    password: '',
    closeOption: ''
  };

  hidePassword = true;  /* hide password as default */

  constructor(private fb: FormBuilder, private dialogRef: MatDialogRef<LoginComponent>, @Inject(MAT_DIALOG_DATA) data) {
    this.loginForm = fb.group({
      hideRequired: true,
      floatLabel: 'auto',
      'username': ["",
        [Validators.required]
      ],
      'password': ["",
        [Validators.required]]
    });

    /** get the input to dialog - empty for now. use: "var = data.fieldname;" */
  }

  ngOnInit() { }

  login() {
    this.loginpModel.username = this.loginForm.value.username
    this.loginpModel.password = this.loginForm.value.password
    this.loginpModel.closeOption ='login'
    this.dialogRef.close(this.loginpModel);
    console.log("The login form was submitted: " + JSON.stringify(this.loginpModel))  // TODO: delete!
  }

  close() {
    this.dialogRef.close();
    console.log("The login form closed"); // TODO: delete!
  }

  signUp() {
    this.loginpModel.closeOption ='signup'
    this.dialogRef.close(this.loginpModel);
    console.log("The login form was closed and then open sign up form")  // TODO: delete!
  }

}

export interface LoginModel {
  username: string;
  password: string;
  closeOption: string;
}