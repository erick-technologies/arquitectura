import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MainlayoutComponent } from './mainlayout.component';
import { CrearInstruccionComponent } from './Instrucciones/crear-instruccion/crear-instruccion.component';
import { HistorialInstruccionComponent } from './Instrucciones/historial-instruccion/historial-instruccion.component';

export const mainLayoutRoutes: Routes = [
  {
    path: '',
    component: MainlayoutComponent,
    children: [
      {
        path: 'inicio',
        component: DashboardComponent
      },

      {
        path: 'alta',
        component: CrearInstruccionComponent
      },

      {
        path: 'historial',
        component: HistorialInstruccionComponent
      }
    ]
  }
];

