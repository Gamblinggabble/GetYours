import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { MainPageComponent } from './main-page/main-page.component';
import { AddProductPanelComponent } from './add-product-panel/add-product-panel.component';
import { ProductPanelComponent } from './product-panel/product-panel.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { AddProductPageComponent } from './add-product-page/add-product-page.component';
import { AddNoProductPanelComponent } from './add-no-product-panel/add-no-product-panel.component';
import { BrandPanelComponent } from './brand-panel/brand-panel.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    MainPageComponent,
    AddProductPanelComponent,
    ProductPanelComponent,
    RegisterPageComponent,
    AddProductPageComponent,
    AddNoProductPanelComponent,
    BrandPanelComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
