import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomersComponent } from './customers/customers.component';
import { ProductsComponent } from './products/products.component';
import { BillingComponent } from './billing/billing.component';
import {NgFor, NgIf} from '@angular/common';
import {RouterLink, RouterOutlet} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import Keycloak from 'keycloak-js';
import {KeycloakAngularModule, KeycloakService} from 'keycloak-angular';


function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8085/',
        realm: 'bdcc-realm',
        clientId: 'ecom-client-angular'
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri: `${window.location.origin}/assets/silent-check-sso.html`
      }
    });
}

@NgModule({
  declarations: [
    AppComponent,
    CustomersComponent,
    ProductsComponent,
    BillingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgFor,
    NgIf,
    RouterOutlet,
    RouterLink,
    HttpClientModule,
    KeycloakAngularModule
  ],
  providers: [
    {provide : APP_INITIALIZER, useFactory: initializeKeycloak, multi: true , deps: [KeycloakService]}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
