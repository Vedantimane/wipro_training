import { Routes } from '@angular/router';
import { Productlist } from './productlist/productlist';
import { ProductAdd } from './product-add/product-add';
import { ProductEdit } from './product-edit/product-edit';
import { ProductDelete } from './product-delete/product-delete';
import { PlaceOrder } from './place-order/place-order';
import { OrderHistory } from './order-history/order-history';

export const routes: Routes = [
    { path: '', component: Productlist },
    { path: 'productList', component: Productlist },
    { path: 'addProduct', component: ProductAdd },
    { path: 'editProduct/:id', component: ProductEdit },
    { path: 'deleteProduct/:id', component: ProductDelete },
    { path: 'placeOrder/:id', component: PlaceOrder },       // Pass product ID
    { path: 'orderHistory', component: OrderHistory }       // All orders
];
