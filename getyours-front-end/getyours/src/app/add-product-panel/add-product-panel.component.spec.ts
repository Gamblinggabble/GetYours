import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProductPanelComponent } from './add-product-panel.component';

describe('AddProductPanelComponent', () => {
  let component: AddProductPanelComponent;
  let fixture: ComponentFixture<AddProductPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddProductPanelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddProductPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
