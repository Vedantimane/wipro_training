// src/app/interface/product.ts

export interface Product {
  productId?: number;            // optional for new products
  productName: string;
  productDesc: string;
  productCat: string;
  make: string;
  productAvailableQty: number;
  productPrice: number;
  productImgUrl: string;
  dateOfManufacture?: string;    // use string for LocalDate from backend
}

// src/app/interface/product.ts
export interface ProductInOrder extends Product {
  quantityOrdered: number;
}

