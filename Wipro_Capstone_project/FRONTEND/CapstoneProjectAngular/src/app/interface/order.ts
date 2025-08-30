// order.model.ts
export interface Order {
  orderId: number;
  userId: number;
  productQuantityMap: { [productId: number]: number }; // Map<Integer, Integer>
  totalAmount: number;
  orderStatus: string;
  orderDate: string; // can use string for LocalDateTime
}

export interface OrderDTO {
  userId: number;
  productQuantityMap: { [productId: number]: number };
  totalAmount: number;
  status?: string; // optional, default PENDING
}
