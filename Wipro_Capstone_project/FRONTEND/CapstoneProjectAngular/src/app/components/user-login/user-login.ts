import { Component } from '@angular/core';
import { UserLoginService } from '../../services/user-login-service';
import { Router } from '@angular/router';
import { Token } from '../../interface/token';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { JwtPayload } from '../../interface/jwt-payload';
import { jwtDecode } from "jwt-decode";
import { AuthService } from '../../services/auth-service';

@Component({
  selector: 'app-user-login',
  imports: [FormsModule, CommonModule],
  templateUrl: './user-login.html',
  styleUrl: './user-login.css'
})
export class UserLogin {

email: string = '';
  password: string = '';

  constructor(
    private loginService: UserLoginService,
    private authService: AuthService,
    private router: Router
  ) {}

  onLogin() {
    this.loginService.login(this.email, this.password).subscribe({
      next: (res) => {
        console.log('Raw token:', res.token);

        // Save token
        localStorage.setItem('jwt', res.token);

        // Redirect based on role
        if (this.authService.isAdmin()) {
          console.log('Redirecting to admin dashboard');
          this.router.navigate(['/admin-dashboard']);
        } else if (this.authService.isUser()) {
          console.log('Redirecting to user dashboard');
          this.router.navigate(['/user-dashboard']);
        } else {
          alert('Role not recognized');
        }
      },
      error: () => alert('Invalid credentials')
    });
  }

  onLogout() {
    const userId = this.authService.getUserId();
    if (!userId) return alert('No user logged in');

    this.loginService.logout(userId).subscribe({
      next: () => {
        localStorage.removeItem('jwt');
        alert('Logout successful');
        this.router.navigate(['/logout']);
      },
      error: () => alert('Logout failed')
    });
  }

  goToRegistration() {
    this.router.navigate(['/register']);
  }
}
