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
  };

  hidePassword = true;

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
    this.dialogRef.close(this.loginForm.value);
  }

  close() {
    this.dialogRef.close();
  }

}

export interface LoginModel {
  username: string;
  password: string;
}