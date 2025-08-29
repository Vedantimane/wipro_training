export interface JwtPayload {
  sub: string;            // userId from backend
  exp: number;            // expiration time
  iat: number;            // issued at time
  authorities?: string[]; // array of roles, e.g., ["ROLE_ADMIN", "ROLE_USER"]
}
