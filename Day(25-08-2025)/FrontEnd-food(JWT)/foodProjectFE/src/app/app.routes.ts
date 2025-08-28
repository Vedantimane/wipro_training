import { Routes } from '@angular/router';
import { Login } from './components/login/login';
import { Food } from './components/food/food';
import { UserRegister } from './components/user-register/user-register';

export const routes: Routes = [
 {path: '' , component : Login},
    {path: 'login', component: Login},
  { path: 'foodList', component: Food },
      {path: 'login/register', component: UserRegister}
];
