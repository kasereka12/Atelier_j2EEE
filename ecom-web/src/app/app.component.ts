import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,  // Changez à true si c'est un composant standalone
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'ecom-web';
  public profile!: KeycloakProfile;

  constructor(public ks: KeycloakService,public router: Router) {
  }

  async handleLogin() {
    await this.ks.login({
      redirectUri: window.location.origin  // window est maintenant l'objet global
    });
  }

  handleLogout() {
    this.ks.logout(window.location.origin);  // window est maintenant l'objet global
  }

  ngOnInit(): void {
    if (this.ks.isLoggedIn()) {
      this.ks.loadUserProfile().then(profile => {
        this.profile = profile;
      });
    }
  }
}
