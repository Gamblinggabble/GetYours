import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { UserService } from '../service/user-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent {

  formData = this.formBuilder.group({
    email: '',
    password: ''
  });

  constructor(
    private formBuilder: FormBuilder, 
    private userService: UserService,
    private router: Router
  ) {}

  onSubmit(): void {
    console.warn('You are trying to log in', this.formData.value);
    this.userService.loginUser(this.formData.value.email?this.formData.value.email:"").subscribe((user) => {
      if(user) {
        console.log("in login component "+ user.email + " loggedInUser: " + this.userService.getLoggedInUser());
        this.router.navigateByUrl('main-page-component');
      }
      else
        this.formData.reset(); 
    });
  }
}
