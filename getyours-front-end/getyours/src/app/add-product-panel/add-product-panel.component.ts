import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-product-panel',
  templateUrl: './add-product-panel.component.html',
  styleUrls: ['./add-product-panel.component.scss']
})
export class AddProductPanelComponent {

  constructor(private router: Router) {}

  goToAddProductPage() {
    this.router.navigateByUrl('add-product-page-component');
  }
}
