import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-product-page',
  templateUrl: './add-product-page.component.html',
  styleUrls: ['./add-product-page.component.scss']
})
export class AddProductPageComponent {

  constructor(private router: Router) {}
  
  goToMainPage() {
    this.router.navigateByUrl('main-page-component');
  }
}
