import { Routes } from '@angular/router';
import { UserLogin } from './components/user-login/user-login';
import { UserRegistration } from './components/user-registration/user-registration';
import { Demo } from './components/demo/demo';
import { Logout } from './components/logout/logout';
import { UserDashboard } from './components/user-dashboard/user-dashboard';
import { AdminDashboard } from './components/admin-dashboard/admin-dashboard';
import { AddProdcuct } from './components/add-prodcuct/add-prodcuct';
import { Cart } from './components/cart/cart';
import { Payment } from './components/payment/payment';
import { OrderList } from './components/order-list/order-list';
import { OrderSuccess } from './components/order-success/order-success';


export const routes: Routes =  [
  { path: 'login', component: UserLogin },
    { path: 'logout', component: Logout },
  { path: 'register', component: UserRegistration },
  { path: 'user-dashboard', component: UserDashboard },
  { path: 'admin-dashboard', component: AdminDashboard },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
 { path: 'admin/product-form/:id', component: AddProdcuct},
 { path: 'admin/product-form', component: AddProdcuct},
 { path: 'cart/:userId', component: Cart},
   { path: 'payment', component: Payment },
   {path:'admin/orders', component:OrderList},
     {path:'demo', component:Demo},
     {path: "ordersuccess",component:OrderSuccess}
];