// cart.model.ts
export interface CartModel {
  cartId: number;
  userId: number;
  productQuantityMap: { [productId: number]: number };
  totalAmount: number;
}

export interface CartDTO {
  userId: number;
  productQuantityMap: { [productId: number]: number };
  totalAmount: number;
}
