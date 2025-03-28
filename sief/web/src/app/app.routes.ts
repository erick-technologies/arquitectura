import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { loggedGuard } from './core/guards/logged.guard';
import { NavbarComponent } from './core/navbar/navbar.component';
import { DashboardComponent } from './mainlayout/dashboard/dashboard.component';
import { MainlayoutComponent } from './mainlayout/mainlayout.component';


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
    //canActivate: [loggedGuard]
},

{
    path: 'navbar',
    component : NavbarComponent,
},

{
    path: 'bim',
    canActivate: [loggedGuard],
    loadChildren: () => import ('./mainlayout/mainlayout.routes').then(m=>m.mainLayoutRoutes)
}

];
