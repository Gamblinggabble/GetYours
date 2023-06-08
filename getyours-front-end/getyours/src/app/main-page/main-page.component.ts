import { AfterViewInit, Component } from '@angular/core';
declare var bootstrap: any;

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent implements AfterViewInit {
  ngAfterViewInit() {
    var myOffcanvas = new bootstrap.Offcanvas(document.getElementById('offcanvasRightFilter'), {backdrop: false, scroll: true});

  }
}