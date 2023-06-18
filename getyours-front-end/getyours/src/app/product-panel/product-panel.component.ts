import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-product-panel',
  templateUrl: './product-panel.component.html',
  styleUrls: ['./product-panel.component.scss']
})
export class ProductPanelComponent {
  @Input() itemUrl?: string;
  @Input() websiteUrl?: string;
  @Input() websiteLogoUrl?: string;
  @Input() websiteName?: string;
  @Input() imageUrl?: string;
  @Input() name?: string;
  @Input() initialPrice?: string;
  @Input() newPrice?: string;
}
