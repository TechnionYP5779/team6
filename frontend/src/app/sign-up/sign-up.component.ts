import { Component, OnInit } from '@angular/core';
import { ViewportScroller } from '@angular/common';
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
    email: '',
    password: '',
  };

  constructor(private fb: FormBuilder) {
    this.signUpForm = fb.group({
      'username': ["",
        [Validators.required]
      ],
      'email': ["",
        [Validators.required,
        Validators.email]
      ],
      'password': ["",
        [Validators.required,
        Validators.pattern('(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}')]
      ]
    });
  }

  ngOnInit() { }

  onSubmit(form) {
    this.signUpModel.username = form.username
    this.signUpModel.email = form.email
    this.signUpModel.password = form.password
    console.log(JSON.stringify(this.signUpModel))
    alert("The form was submitted"); //TODO: delete
    this.signUpForm.reset();
  }

}

export interface SignUpModel {
  fname: string;
  lname: string;
  username: string;
  email: string;
  password: string;
}