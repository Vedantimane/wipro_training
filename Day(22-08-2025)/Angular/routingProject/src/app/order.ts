import { Product } from "./product";

export interface Order {
     id?: string;
  purchasedQty: number;
  orderDate: string;
  product: Product;
}
