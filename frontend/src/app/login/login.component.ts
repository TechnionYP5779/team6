import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { WebService } from '../web.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  loginpModel: LoginModel = {
    email: 'Guest',
    password: '',
    closeOption: ''
  };



  hidePassword = true;  /* hide password as default */
  logged = false;
  error = null;

  constructor(private webService : WebService, private fb: FormBuilder, private dialogRef: MatDialogRef<LoginComponent>, @Inject(MAT_DIALOG_DATA) data) {
    this.loginForm = fb.group({
      hideRequired: true,
      floatLabel: 'auto',
      'email': ["",
        [Validators.required, Validators.email]
      ],
      'password': ["",
        [Validators.required]]
    });

    /** get the input to dialog - empty for now. use: "var = data.fieldname;" */
  }

  ngOnInit() { }

  async login() {
    this.loginpModel.email = this.loginForm.value.email
    this.loginpModel.password = this.loginForm.value.password
    this.loginpModel.closeOption ='login'
    
    console.log("The login form was submitted: " + JSON.stringify(this.loginpModel))  // TODO: delete!
    var res =  await this.webService.PostLogIn(this.loginpModel)
    console.log (res)
    if (res == 'wrong email or password'){
      this.error = res;
      return;
    }
    if(res['name']) {
      this.error = null;
      var result = {closeOption:'login', username: res['name']}
      this.dialogRef.close(result)
    }

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
  email: string;
  password: string;
  closeOption: string;
}
