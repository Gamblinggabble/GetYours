import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MyUser } from '../model/MyUser';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8080/users';
  private loggedInUser?: string = undefined;

  constructor(private http: HttpClient) { }

  registerUser(user: MyUser) : Observable<MyUser> {
    return this.http.post<MyUser>(this.apiUrl + "/add", user);
  }

  getLoggedInUser() {
    return this.loggedInUser;
  }

  loginUser(email: string) : Observable<MyUser> {
    this.http.get<MyUser>(`${this.apiUrl}?email=${email}`).subscribe((user) => {
        if(user != undefined && user != null) {
          this.loggedInUser = user.email;
          console.log("In userService - loginUser func: " + user.email);
        }
    });
    return this.http.get<MyUser>(`${this.apiUrl}?email=${email}`);
  }

  logoutUser() {
    this.loggedInUser = undefined;
  }

}
