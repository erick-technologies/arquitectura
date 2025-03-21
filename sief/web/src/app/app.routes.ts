import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { loggedGuard } from './core/guards/logged.guard';

export const routes: Routes = [
{
    path:'login',
    component: LoginComponent
},
{
    path:'register',
    component: RegisterComponent
},

{
    path: 'dashboard',
    component : DashboardComponent,
    canActivate: [loggedGuard]
}

];
