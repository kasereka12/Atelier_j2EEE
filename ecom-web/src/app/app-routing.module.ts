import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from './products/products.component';
import {CustomersComponent} from './customers/customers.component';
import {BillingComponent} from './billing/billing.component';
import {AuthGuard} from './guards/auth.guard';

const routes: Routes = [
  {
    path : "products" , component :  ProductsComponent, canActivate:[AuthGuard] , data:{roles : ['ADMIN']}
  },
  {
    path : "customers" , component : CustomersComponent , canActivate:[AuthGuard] , data:{roles : ['ADMIN']}
  },

  {
    path : "billing/:customerId" , component : BillingComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
