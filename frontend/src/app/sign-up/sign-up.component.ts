import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  signUpForm: FormGroup;

  signUpModel: SignUpModel = {
    fname: '',
    lname: '',
    username: '',
    password: '',
    email: '',
  };

  hidePassword = true;  /* hide password as default */

  passwordHintMessage = "Use at least 8 characters, include at least one digit, one uppercase letter and one lowercase letter";

  constructor(private fb: FormBuilder, private dialogRef: MatDialogRef<SignUpComponent>, @Inject(MAT_DIALOG_DATA) data) {
    this.signUpForm = fb.group({
      hideRequired: true,
      floatLabel: 'auto',
      'fname': ["",
        [Validators.required]
      ],
      'lname': ["",
        [Validators.required]
      ],
      'username': ["",
        [Validators.required]
      ],
      'password': ["",
        [Validators.required,
        Validators.pattern('(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}')]
      ],
      'email': ["",
        [Validators.required,
        Validators.email]
      ]
    });

    /** get the input to dialog - empty for now. use: "var = data.fieldname;" */
  }

  ngOnInit() { }

  signUp() {
    this.signUpModel.fname = this.signUpForm.value.fname
    this.signUpModel.lname = this.signUpForm.value.lname
    this.signUpModel.username = this.signUpForm.value.username
    this.signUpModel.password = this.signUpForm.value.password
    this.signUpModel.email = this.signUpForm.value.email
    this.dialogRef.close(this.signUpModel);
    console.log("The sign up form was submitted: " + JSON.stringify(this.signUpModel))  // TODO: delete!
  }

  close() {
    this.dialogRef.close();
    console.log("The sign up form closed"); // TODO: delete!
  }

}

export interface SignUpModel {
  fname: string;
  lname: string;
  username: string;
  password: string;
  email: string;
}