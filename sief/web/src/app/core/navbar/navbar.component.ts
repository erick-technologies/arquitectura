import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  imports: [CommonModule]
})
export class NavbarComponent implements OnInit {
  activeRoute: string = '';

  constructor(private router: Router) { }

  ngOnInit() {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe((event: any) => {
      this.activeRoute = event.urlAfterRedirects;
      this.updateActiveIndicator();
    });
    this.updateActiveIndicator();
  }

  navigateTo(route: string): void {
    this.router.navigate([route]);
  }

  updateActiveIndicator(): void {
    const buttons = document.querySelectorAll('.navbar button');
    const indicator = document.querySelector('.active-indicator') as HTMLElement;

    buttons.forEach((button, index) => {
      if (this.activeRoute.startsWith(button.getAttribute('data-route') || '')) {
        const buttonRect = button.getBoundingClientRect();
        const navbarRect = (document.querySelector('.navbar') as HTMLElement).getBoundingClientRect();

        indicator.style.left = (buttonRect.left - navbarRect.left) + 'px';
        indicator.style.width = buttonRect.width + 'px';
      }
    });
  }
}