import { Routes } from '@angular/router';
import { UserLogin } from './components/user-login/user-login';
import { UserRegistration } from './components/user-registration/user-registration';
import { Demo } from './components/demo/demo';
import { Logout } from './components/logout/logout';
import { UserDashboard } from './components/user-dashboard/user-dashboard';
import { AdminDashboard } from './components/admin-dashboard/admin-dashboard';

export const routes: Routes =  [
  { path: 'login', component: UserLogin },
    { path: 'logout', component: Logout },
  { path: 'register', component: UserRegistration },
  { path: 'user-dashboard', component: UserDashboard },
  { path: 'admin-dashboard', component: AdminDashboard },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];