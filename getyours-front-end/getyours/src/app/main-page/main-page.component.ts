import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Item } from '../model/Item';
import { ItemService } from '../service/item.service';
import { Observable } from 'rxjs';
import { UserService } from '../service/user-service';
import { Router } from '@angular/router';
declare var bootstrap: any;

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent implements AfterViewInit {

  public items?: Observable<Item[]>;
  public itemsReal: Item[] = [];

  public loggedInUser?: string = this.userService.getLoggedInUser();

  constructor(
    private itemService: ItemService, 
    private userService: UserService,
    private router: Router
  ) {}

  ngAfterViewInit() {
    var myOffcanvasFilter = new bootstrap.Offcanvas(document.getElementById('offcanvasRightFilter'), {backdrop: false, scroll: true});
    var myOffcanvasSearch = new bootstrap.Offcanvas(document.getElementById('offcanvasRightSearch'), {backdrop: false, scroll: true});
  }

  ngOnInit() {
    this.items = this.itemService.getAllByLoggedInUser();
    this.items.subscribe(objs => {
      console.log(objs.length);
      for (let index = 0; index < objs.length; index++) {
        console.log(objs[index].website?.name);
        console.log(objs[index].item_url);
        console.log(objs[index].picture_url);
        this.itemsReal[index] = objs[index];
      }
    });
  }

  logOut() {
    console.log("exit!!");
    this.userService.logoutUser();
    this.router.navigateByUrl('login-page-component');
    console.log("after EXIT " + this.userService.getLoggedInUser());
  }
}