import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNoProductPanelComponent } from './add-no-product-panel.component';

describe('AddNoProductPanelComponent', () => {
  let component: AddNoProductPanelComponent;
  let fixture: ComponentFixture<AddNoProductPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNoProductPanelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddNoProductPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
