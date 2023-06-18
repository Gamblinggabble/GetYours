import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Item } from '../model/Item';
import { UserService } from './user-service';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private apiUrl = 'http://localhost:8080/items';

  constructor(private http: HttpClient, private userService: UserService) { }

  public getAllByLoggedInUser() : Observable<Item[]> {
    const email = this.userService.getLoggedInUser();
    console.log("logged in user: " + email);
    return this.http.get<Item[]>(this.apiUrl + "/all/user?email=" + email);
  }
  
}
