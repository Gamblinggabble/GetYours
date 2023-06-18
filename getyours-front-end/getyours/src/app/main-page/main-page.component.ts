import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Item } from '../model/Item';
import { ItemService } from '../service/item.service';
import { Observable } from 'rxjs';
declare var bootstrap: any;

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent implements AfterViewInit {

  public items?: Observable<Item[]>;
  public itemsReal: Item[] = [];

  constructor(private itemService: ItemService) {}

  ngAfterViewInit() {
    var myOffcanvasFilter = new bootstrap.Offcanvas(document.getElementById('offcanvasRightFilter'), {backdrop: false, scroll: true});
    var myOffcanvasSearch = new bootstrap.Offcanvas(document.getElementById('offcanvasRightSearch'), {backdrop: false, scroll: true});
    var myOffcanvas = new bootstrap.Offcanvas(document.getElementById('offcanvasRightFilter'), {backdrop: false, scroll: true});
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
}