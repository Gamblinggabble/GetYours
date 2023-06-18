import { Component } from '@angular/core';
import { UserService } from '../service/user-service';
import { Router } from '@angular/router';
import { MyUser } from '../model/MyUser';
import { FormBuilder } from "@angular/forms"

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.scss']
})
export class RegisterPageComponent {

  loginData = this.formBuilder.group({
    email: '',
    password: ''
  });

  newUser: MyUser = {
    id: -1,
    email: "",
    password: ""
  }

  constructor(
    private userService: UserService, 
    private router: Router, 
    private formBuilder: FormBuilder
  ) {} 

  onSubmit(): void {
    console.log(this.loginData.value.email);
    console.log(this.loginData.value.password);

    if(this.loginData.value.email != null && this.loginData.value.password != null) {
      this.newUser.email = this.loginData.value.email;
      this.newUser.password = this.loginData.value.password;
    }

    this.userService.registerUser(this.newUser).subscribe();
    this.router.navigateByUrl('login-page-component');
  }
  

}
