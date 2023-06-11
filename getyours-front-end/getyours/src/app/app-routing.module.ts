import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { MainPageComponent } from './main-page/main-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { AddProductPageComponent } from './add-product-page/add-product-page.component';
import { AddProductPanelComponent } from './add-product-panel/add-product-panel.component';
import { AddNoProductPanelComponent } from './add-no-product-panel/add-no-product-panel.component';
import {BrandPanelComponent} from './brand-panel/brand-panel.component';

const routes: Routes = [
  {path: 'login-page-component', component: LoginPageComponent},
  {path: 'main-page-component', component: MainPageComponent},
  {path: 'register-page-component', component: RegisterPageComponent},
  {path: 'add-product-page-component', component: AddProductPageComponent},
  {path: 'add-no-product-panel-component', component: AddNoProductPanelComponent},
  {path: 'brand-panel-component', component: BrandPanelComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
