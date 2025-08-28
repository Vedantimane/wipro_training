import { Routes } from '@angular/router';
import { Login } from './components/login/login';
import { Food } from './components/food/food';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' }, // default route
  { path: 'login', component: Login },
  { path: 'foodList', component: Food }
];
